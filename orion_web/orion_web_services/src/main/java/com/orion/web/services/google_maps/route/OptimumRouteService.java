package com.orion.web.services.google_maps.route;

import com.orion.core.abstraction.OrionService;
import com.orion.core.math.MathService;
import com.orion.data.geodata.GeodataService;
import com.orion.data.geodata.postcode.model.DistanceBetweenPostcodesModel;
import com.orion.web.services.google_maps.GoogleMapsService;
import com.orion.web.services.google_maps.model.DistanceAndTravelDurationModel;
import com.orion.web.services.google_maps.tasks.GetOptimumRouteForPostcodesTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimumRouteService extends OrionService
{
    public static OptimumRouteVO getOptimumRouteForPostcodes(String actualStartPostcode, String startPostcodeToUse, String endPostcode, List<String> waypoints, Float distanceBetweenHighPriorityAndCollectionPostcode)
    {

        if(waypoints.size() <= 25)
        {
            List<String> invalidPostcodes = new ArrayList<>();
            List<String> route = createRouteForUpTo25Waypoints(startPostcodeToUse, endPostcode, waypoints);
            List<RecipientPostcodeVO> recipientPostcodes = new ArrayList<>();
            int index = 0;
            float totalDistance = 0.0f;

            if(distanceBetweenHighPriorityAndCollectionPostcode != null)
            {
                totalDistance = distanceBetweenHighPriorityAndCollectionPostcode;
            }

            long totalTravelDuration = 0L;

            for(String waypoint : route)
            {
                float distanceFromStartingPostcodeOfRouteInMiles = 2.0f;

                if(index != 0 && index != route.size() - 1)
                {
                    DistanceAndTravelDurationModel distanceAndTravel = null;
                    DistanceBetweenPostcodesModel distanceRecord = GeodataService.getDistanceBetweenPostcodesByPostcodes(actualStartPostcode, waypoint);

                    if(distanceRecord != null)
                    {

                        if(distanceRecord.getIsPostcode2Valid())
                        {
                            totalDistance += distanceRecord.getDistance();
                            totalTravelDuration += distanceRecord.getTravelDurationInSeconds();
                        }

                        distanceFromStartingPostcodeOfRouteInMiles = distanceRecord.getDistance();
                        distanceAndTravel = DistanceAndTravelDurationModel.builder()
                                        .distance(distanceRecord.getDistance())
                                        .travelDurationInSeconds(distanceRecord.getTravelDurationInSeconds())
                                        .build();

                        if(!distanceRecord.getIsPostcode2Valid()
                                        && distanceRecord.getPostcode2().equals(waypoint.replace(" ", "")))
                        {
                            invalidPostcodes.add(waypoint);
                        }

                    }
                    else
                    {
                        distanceAndTravel = GoogleMapsService.getDistanceAndTravelDuration(actualStartPostcode, waypoint);
                        boolean isWaypointValid = true;
                        long travelDurationInSeconds = 0L;

                        if(distanceAndTravel != null)
                        {
                            distanceFromStartingPostcodeOfRouteInMiles = MathService.round(distanceAndTravel.getDistance(), 1);

                            if(distanceFromStartingPostcodeOfRouteInMiles < 0.1f)
                            {
                                distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                            }

                            totalDistance += distanceFromStartingPostcodeOfRouteInMiles;
                            totalTravelDuration += distanceAndTravel.getTravelDurationInSeconds();
                        }
                        else
                        {
                            isWaypointValid = false;
                            invalidPostcodes.add(waypoint);
                        }

                        GeodataService.saveDistanceBetweenPostcodes(DistanceBetweenPostcodesModel.builder()
                                        .postcode1(actualStartPostcode.replace(" ", "").toUpperCase())
                                        .postcode2(waypoint.replace(" ", "").toUpperCase())
                                        .distance(distanceFromStartingPostcodeOfRouteInMiles)
                                        .travelDurationInSeconds(travelDurationInSeconds)
                                        .isPostcode1Valid(Boolean.TRUE)
                                        .isPostcode2Valid(isWaypointValid)
                                        .build());
                    }

                }
                else
                {
                    distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                }

                String postcodePrefix = "";
                int indexOfSpaceInPostcode = waypoint.indexOf(" ");

                if(indexOfSpaceInPostcode != -1)
                {
                    postcodePrefix = waypoint.substring(0, indexOfSpaceInPostcode);
                }

                recipientPostcodes.add(RecipientPostcodeVO.builder()
                                .postcode(waypoint)
                                .postcodeWithoutSpace(waypoint.replace(" ", ""))
                                .postcodePrefix(postcodePrefix)
                                .distanceFromStartPoint(distanceFromStartingPostcodeOfRouteInMiles)
                                .build());
                index++;
            }

            float averageDistance = 0.0f;

            if(distanceBetweenHighPriorityAndCollectionPostcode != null)
            {
                averageDistance = totalDistance / (route.size() - 1 - invalidPostcodes.size());
            }
            else
            {
                averageDistance = totalDistance / (route.size() - 2 - invalidPostcodes.size());
            }

            long averageTravelDuration = totalTravelDuration / (route.size() - 2 - invalidPostcodes.size());

            for(String invalidWaypoint : invalidPostcodes)
            {
                DistanceBetweenPostcodesModel record = GeodataService.getDistanceBetweenPostcodesByPostcodes(actualStartPostcode.replace(" ", "").toUpperCase(), invalidWaypoint.replace(" ", "").toUpperCase());

                if(record != null)
                {
                    record.setDistance(averageDistance);
                    record.setTravelDurationInSeconds(averageTravelDuration);
                    GeodataService.updateDistanceBetweenPostcodes(record);
                }

                for(RecipientPostcodeVO waypoint : recipientPostcodes)
                {

                    if(waypoint.getPostcodeWithoutSpace().equals(invalidWaypoint.replace(" ", "").toUpperCase()))
                    {
                        waypoint.setDistanceFromStartPoint(averageDistance);
                    }

                }

            }

            return OptimumRouteVO.builder()
                            .route(route)
                            .recipients(recipientPostcodes)
                            .invalidPostcodes(invalidPostcodes)
                            .build();
        }
        else
        {
            return createRouteForMoreThan25Waypoints(startPostcodeToUse, endPostcode, waypoints, distanceBetweenHighPriorityAndCollectionPostcode);
        }

    }


    private static List<String> createRouteForUpTo25Waypoints(String startPostcodeToUse, String endPostcode, List<String> waypoints)
    {
        List<String> route = new LinkedList<>();
        List<String> invalidWaypointPostcodes = new ArrayList<>();
        List<String> formattedWaypointPostcodes = new ArrayList<>();

        for(String waypoint : waypoints)
        {

            if(waypoint.indexOf(" ") > 0)
            {
                formattedWaypointPostcodes.add(waypoint);
            }
            else
            {
                invalidWaypointPostcodes.add(waypoint.trim().toUpperCase());
            }

        }

        if(invalidWaypointPostcodes.size() == waypoints.size())
        {
            route.add(startPostcodeToUse);
            Collections.sort(waypoints);
            route.addAll(waypoints);
            route.add(endPostcode);
        }
        else
        {
            route = new GetOptimumRouteForPostcodesTask().run(startPostcodeToUse, endPostcode, formattedWaypointPostcodes);

            if(!invalidWaypointPostcodes.isEmpty())
            {
                processInvalidPostcodesWithinRoute(waypoints, invalidWaypointPostcodes, route);
            }

        }

        return route;
    }


    private static void processInvalidPostcodesWithinRoute(List<String> waypoints, List<String> invalidWaypointPostcodes, List<String> route)
    {
        Collections.sort(waypoints);

        for(String invalidPostcode : invalidWaypointPostcodes)
        {
            int indexOfInvalidPostcodeInWaypoints = waypoints.indexOf(invalidPostcode);
            String nextValidPostcode = null;

            if(indexOfInvalidPostcodeInWaypoints == 0)
            {
                int tempI = indexOfInvalidPostcodeInWaypoints + 1;
                nextValidPostcode = waypoints.get(tempI);
                boolean wrappedAround = false;

                while(nextValidPostcode.indexOf(" ") < 0)
                {
                    tempI++;

                    if(tempI == waypoints.size() - 1 && !wrappedAround)
                    {
                        tempI = 0;
                        wrappedAround = true;
                    }

                    nextValidPostcode = waypoints.get(tempI);
                }

                route.add(route.indexOf(nextValidPostcode), invalidPostcode);
            }
            else
            {
                int tempI = indexOfInvalidPostcodeInWaypoints - 1;
                nextValidPostcode = waypoints.get(tempI);
                boolean wrappedAround = false;

                while(nextValidPostcode.indexOf(" ") < 0)
                {
                    tempI--;

                    if(tempI == -1 && !wrappedAround)
                    {
                        tempI = waypoints.size() - 1;
                        wrappedAround = true;
                    }

                    nextValidPostcode = waypoints.get(tempI);
                }

                int oldIndexOfNextValidPostcode = route.indexOf(nextValidPostcode);
                route.add(route.indexOf(nextValidPostcode), invalidPostcode);
                route.set(oldIndexOfNextValidPostcode, nextValidPostcode);
                route.set(oldIndexOfNextValidPostcode + 1, invalidPostcode);
            }

        }

    }


    private static OptimumRouteVO createRouteForMoreThan25Waypoints(String startPostcode, String endPostcode, List<String> waypoints, Float distanceBetweenHighPriorityAndCollectionPostcode)
    {
        List<String> route = new LinkedList<>();
        List<String> invalidPostcodes = new ArrayList<>();
        List<RecipientPostcodeVO> recipientPostcodes = new ArrayList<>();
        float totalDistance = 0.0f;

        if(distanceBetweenHighPriorityAndCollectionPostcode != null)
        {
            totalDistance = distanceBetweenHighPriorityAndCollectionPostcode;
        }

        long totalTravelDuration = 0L;

        for(String waypoint : waypoints)
        {

            if(waypoint.indexOf(" ") > 0)
            {
                DistanceAndTravelDurationModel distanceAndTravel = null;
                DistanceBetweenPostcodesModel distanceRecord = GeodataService.getDistanceBetweenPostcodesByPostcodes(startPostcode, waypoint);
                float distanceFromStartingPostcodeOfRouteInMiles = 2.0f;

                if(distanceRecord != null)
                {
                    totalDistance += distanceRecord.getDistance();
                    totalTravelDuration += distanceRecord.getTravelDurationInSeconds();
                    distanceFromStartingPostcodeOfRouteInMiles = distanceRecord.getDistance();
                    distanceAndTravel = DistanceAndTravelDurationModel.builder()
                                    .distance(distanceRecord.getDistance())
                                    .travelDurationInSeconds(distanceRecord.getTravelDurationInSeconds())
                                    .build();
                }
                else
                {
                    distanceAndTravel = GoogleMapsService.getDistanceAndTravelDuration(startPostcode, waypoint);

                    if(distanceAndTravel != null)
                    {
                        distanceFromStartingPostcodeOfRouteInMiles = MathService.round(distanceAndTravel.getDistance(), 1);

                        if(distanceFromStartingPostcodeOfRouteInMiles < 0.1f)
                        {
                            distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                        }

                        totalDistance += distanceFromStartingPostcodeOfRouteInMiles;
                        totalTravelDuration += distanceAndTravel.getTravelDurationInSeconds();
                    }

                    GeodataService.saveDistanceBetweenPostcodes(DistanceBetweenPostcodesModel.builder()
                                    .postcode1(startPostcode.replace(" ", "").toUpperCase())
                                    .postcode2(waypoint.replace(" ", "").toUpperCase())
                                    .distance(distanceFromStartingPostcodeOfRouteInMiles)
                                    .travelDurationInSeconds(0L)
                                    .isPostcode1Valid(Boolean.TRUE)
                                    .isPostcode2Valid(true)
                                    .build());
                }

                recipientPostcodes.add(RecipientPostcodeVO.builder()
                                .postcode(waypoint)
                                .postcodeWithoutSpace(waypoint.replace(" ", ""))
                                .postcodePrefix(waypoint.substring(0, waypoint.indexOf(" ")))
                                .distanceFromStartPoint(distanceFromStartingPostcodeOfRouteInMiles)
                                .build());
            }
            else
            {
                String waypointTemp = waypoint.trim().toUpperCase();
                invalidPostcodes.add(waypointTemp);
            }

        }

        if(invalidPostcodes.size() == waypoints.size())
        {
            route.add(startPostcode);
            Collections.sort(waypoints);
            route.addAll(waypoints);
            route.add(endPostcode);
        }
        else
        {
            Map<String, List<RecipientPostcodeVO>> postcodePrefixToRecipientMapper = new HashMap<>();

            for(RecipientPostcodeVO recipient : recipientPostcodes)
            {

                if(postcodePrefixToRecipientMapper.get(recipient.getPostcodePrefix()) != null)
                {
                    postcodePrefixToRecipientMapper.get(recipient.getPostcodePrefix()).add(recipient);
                }
                else
                {
                    List<RecipientPostcodeVO> temp = new ArrayList<>();
                    temp.add(recipient);
                    postcodePrefixToRecipientMapper.put(recipient.getPostcodePrefix(), temp);
                }

            }

            List<RecipientPostcodeGroupByPrefixBO> groups = new ArrayList<>();

            for(Map.Entry<String, List<RecipientPostcodeVO>> entry : postcodePrefixToRecipientMapper.entrySet())
            {
                Collections.sort(entry.getValue(), new RecipientPostcodeComparator());
                groups.add(RecipientPostcodeGroupByPrefixBO.builder()
                                .postcodes(entry.getValue())
                                .postcodePrefix(entry.getKey())
                                .build());
            }

            if(groups.size() == 1)
            {
                List<List<RecipientPostcodeVO>> subgroups = new ArrayList<>();

                for(int i = 0; i < groups.get(0).getPostcodes().size(); i++)
                {

                    if(i % 25 == 0)
                    {
                        subgroups.add(new ArrayList<RecipientPostcodeVO>());
                    }

                    subgroups.get(subgroups.size() - 1).add(groups.get(0).getPostcodes().get(i));
                }

                for(int i = 0; i < subgroups.size(); i++)
                {
                    List<String> ithWaypoints = subgroups.get(i)
                                    .stream()
                                    .map(e -> e.getPostcode())
                                    .collect(Collectors.toList());
                    List<String> ithRoute = new ArrayList<>();

                    if(subgroups.size() == 1)
                    {
                        ithRoute = createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints);
                        route.addAll(ithRoute);
                    }
                    else
                    {

                        if(i == 0)
                        {

                            if(i == subgroups.size() - 1)
                            {
                                ithRoute = createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints);
                            }
                            else
                            {
                                ithRoute = createRouteForUpTo25Waypoints(startPostcode, subgroups.get(i + 1).get(0).getPostcode(), ithWaypoints);
                            }

                            route.addAll(ithRoute);
                        }
                        else if(i < subgroups.size() - 1)
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(subgroups.get(i).get(0).getPostcode(), subgroups.get(i + 1).get(0).getPostcode(), ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }
                        else
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(subgroups.get(i).get(0).getPostcode(), endPostcode, ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }

                    }

                }

            }
            else
            {

                for(RecipientPostcodeGroupByPrefixBO group : groups)
                {
                    float sumOfDistancesWithinGroup = group.getPostcodes()
                                    .stream()
                                    .map(postcode -> postcode.getDistanceFromStartPoint())
                                    .reduce(0.0f, (d1, d2) -> d1 + d2);
                    group.setSumOfDistancesWithinGroup(sumOfDistancesWithinGroup);
                }

                Collections.sort(groups, new RecipientGroupSumOfDistancesFromStartPointComparator());

                for(int i = 0; i < groups.size(); i++)
                {
                    List<String> ithWaypoints = groups.get(i).getPostcodes()
                                    .stream()
                                    .map(p -> p.getPostcode())
                                    .collect(Collectors.toList());
                    List<String> ithRoute = new ArrayList<>();

                    if(groups.size() == 1)
                    {
                        route.addAll(createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints));
                    }
                    else
                    {

                        if(i == 0)
                        {

                            if(i == groups.size() - 1)
                            {
                                route.addAll(createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints));
                            }
                            else
                            {
                                route.addAll(createRouteForUpTo25Waypoints(startPostcode, groups.get(i + 1).getPostcodes().get(0).getPostcode(), ithWaypoints));
                            }

                        }
                        else if(i < groups.size() - 1)
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(groups.get(i).getPostcodes().get(0).getPostcode(), groups.get(i + 1).getPostcodes().get(0).getPostcode(), ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }
                        else
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(groups.get(i).getPostcodes().get(0).getPostcode(), endPostcode, ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }

                    }

                }

            }

            processInvalidPostcodesWithinRoute(waypoints, invalidPostcodes, route);
        }

        float averageDistance = 0.0f;

        if(distanceBetweenHighPriorityAndCollectionPostcode != null)
        {
            averageDistance = totalDistance / (route.size() - 1 - invalidPostcodes.size());
        }
        else
        {
            averageDistance = totalDistance / (route.size() - 2 - invalidPostcodes.size());
        }

        long averageTravelDuration = totalTravelDuration / (route.size() - 2 - invalidPostcodes.size());

        for(String invalidWaypoint : invalidPostcodes)
        {
            DistanceBetweenPostcodesModel record = GeodataService.getDistanceBetweenPostcodesByPostcodes(startPostcode.replace(" ", "").toUpperCase(), invalidWaypoint.replace(" ", "").toUpperCase());

            if(record != null)
            {
                record.setDistance(averageDistance);
                record.setTravelDurationInSeconds(averageTravelDuration);
                GeodataService.updateDistanceBetweenPostcodes(record);
            }

            for(RecipientPostcodeVO waypoint : recipientPostcodes)
            {

                if(waypoint.getPostcodeWithoutSpace().equals(invalidWaypoint.replace(" ", "").toUpperCase()))
                {
                    waypoint.setDistanceFromStartPoint(averageDistance);
                }

            }

        }

        return OptimumRouteVO.builder()
                        .route(route)
                        .recipients(recipientPostcodes)
                        .invalidPostcodes(invalidPostcodes)
                        .build();
    }
}