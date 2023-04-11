package com.orion.machine_learning.classification.k_nearest_neighbours.tasks;

import com.orion.core.data.structure.map.MapService;
import com.orion.core.data.structure.sorting.SortingService;
import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursRules;
import com.orion.machine_learning.hypothesis.Hypothesis;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RunKNearestNeighboursTask<LABEL_TYPE> extends Hypothesis<LABEL_TYPE>
{
    private LABEL_TYPE label;


    public RunKNearestNeighboursTask(Element<ANumber, LABEL_TYPE> elementToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        Function3x1IF<Element<ANumber, LABEL_TYPE>, TrainingSet<ANumber, LABEL_TYPE>, Integer, LABEL_TYPE> f = (Element<ANumber, LABEL_TYPE> element, TrainingSet<ANumber, LABEL_TYPE> training, Integer k1) -> (run(element, training, k1));
        setFormula(f);
        this.label = f.run(elementToClassify, trainingSet, k);
    }


    private LABEL_TYPE run(Element<ANumber, LABEL_TYPE> elementToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        KNearestNeighboursRules.isValid(trainingSet, k);
        Map<ANumber, LABEL_TYPE> distancesAndLabelsMapper = calculateDistancesBetweenClassifiableAndDataSet(elementToClassify, trainingSet);
        List<Entry<?, ?>> sortedDistancesAndLabels = SortingService.sortMapByKey(distancesAndLabelsMapper);
        List<Entry<?, ?>> kLowestDistancesAndLabels = sortedDistancesAndLabels.subList(0, k);
        List<Map.Entry<ANumber, LABEL_TYPE>> kLowestDistancesAndLabels1 = new ArrayList<>();
        kLowestDistancesAndLabels.forEach(entry -> kLowestDistancesAndLabels1.add(MapService.<ANumber, LABEL_TYPE>createMapEntry(entry)));
        return getClassOfElementToClassify(kLowestDistancesAndLabels1);
    }


    private Map<ANumber, LABEL_TYPE> calculateDistancesBetweenClassifiableAndDataSet(Element<ANumber, LABEL_TYPE> elementToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet)
    {
        Map<ANumber, LABEL_TYPE> distanceAndLabelsMapper = new HashMap<>();

        for(int i = 0; i < trainingSet.getNumberOfElements(); i++)
        {
            Element<ANumber, LABEL_TYPE> elementI = trainingSet.get(i);
            Vector v1 = Vector.of(elementToClassify.getFeatureValue(0), elementToClassify.getFeatureValue(1));
            Vector v2 = Vector.of(elementI.getFeatureValue(0), elementI.getFeatureValue(1));
            distanceAndLabelsMapper.put(v1.getDistanceFrom(v2), elementI.getLabelValue(0));
        }

        return distanceAndLabelsMapper;
    }


    @SuppressWarnings("unchecked")
    private LABEL_TYPE getClassOfElementToClassify(List<Map.Entry<ANumber, LABEL_TYPE>> kLowestDistancesAndLabels)
    {
        Map<LABEL_TYPE, Integer> classCountMapper = new HashMap<>();

        for(Map.Entry<ANumber, LABEL_TYPE> distancesAndLabel : kLowestDistancesAndLabels)
        {
            int counter = 1;

            if(classCountMapper.get(distancesAndLabel.getValue()) != null)
            {
                counter += classCountMapper.get(distancesAndLabel.getValue());
            }

            classCountMapper.put(distancesAndLabel.getValue(), counter);
        }

        List<Entry<?, ?>> sortedClassCountMapper = SortingService.sortMapByValueDescending(classCountMapper);
        return (LABEL_TYPE)sortedClassCountMapper.get(0).getKey();
    }


    public LABEL_TYPE get()
    {
        return this.label;
    }
}