package com.orion.core.data.structure.list.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.ListService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import java.util.List;

public class GetIntersectionTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public OrionList<T> run(List<OrionList<T>> lists)
    {

        if((lists != null && !lists.isEmpty()))
        {
            return run(lists.toArray(new OrionArrayList[0]));
        }

        return null;
    }


    @SuppressWarnings("unchecked")
    public OrionList<T> run(OrionList<T>... lists)
    {

        if((lists != null))
        {

            if(lists.length == 1)
            {
                return OrionArrayList.<T>of(lists[0]);
            }
            else if(lists.length > 1)
            {
                OrionList<T> result = OrionArrayList.of();
                lists[0].stream()
                                .filter(element -> ListService.doesElementExistInAllLists(element, lists))
                                .forEach(element -> result.append(element));
                return result;
            }

        }

        return null;
    }
}