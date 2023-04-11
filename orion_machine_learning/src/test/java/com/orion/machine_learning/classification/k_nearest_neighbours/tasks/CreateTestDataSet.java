package com.orion.machine_learning.classification.k_nearest_neighbours.tasks;

import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;

public class CreateTestDataSet
{
    @SuppressWarnings("unchecked")
    public static TrainingSet<ANumber, String> run()
    {
        TrainingDataPoint<ANumber> element1Feature1 = TrainingDataPoint.of(ANumber.of(1));
        TrainingDataPoint<ANumber> element1Feature2 = TrainingDataPoint.of(ANumber.of(1));
        TrainingData<ANumber> element1Features = TrainingData.of(element1Feature1, element1Feature2);
        DomainSet<ANumber> domainSet1 = DomainSet.of(element1Features);
        Labels<String> labels1 = Labels.of(Label.of("A"));
        Element<ANumber, String> element1 = Element.of(domainSet1, labels1);
        TrainingDataPoint<ANumber> element2Feature1 = TrainingDataPoint.of(ANumber.of(1));
        TrainingDataPoint<ANumber> element2Feature2 = TrainingDataPoint.of(ANumber.of(1.1));
        TrainingData<ANumber> element2Features = TrainingData.of(element2Feature1, element2Feature2);
        DomainSet<ANumber> domainSet2 = DomainSet.of(element2Features);
        Labels<String> labels2 = Labels.of(Label.of("A"));
        Element<ANumber, String> element2 = Element.of(domainSet2, labels2);
        TrainingDataPoint<ANumber> element3Feature1 = TrainingDataPoint.of(ANumber.of(0));
        TrainingDataPoint<ANumber> element3Feature2 = TrainingDataPoint.of(ANumber.of(0));
        TrainingData<ANumber> element3Features = TrainingData.of(element3Feature1, element3Feature2);
        DomainSet<ANumber> domainSet3 = DomainSet.of(element3Features);
        Labels<String> labels3 = Labels.of(Label.of("B"));
        Element<ANumber, String> element3 = Element.of(domainSet3, labels3);
        TrainingDataPoint<ANumber> element4Feature1 = TrainingDataPoint.of(ANumber.of(0));
        TrainingDataPoint<ANumber> element4Feature2 = TrainingDataPoint.of(ANumber.of(0.1));
        TrainingData<ANumber> element4Features = TrainingData.of(element4Feature1, element4Feature2);
        DomainSet<ANumber> domainSet4 = DomainSet.of(element4Features);
        Labels<String> labels4 = Labels.of(Label.of("B"));
        Element<ANumber, String> element4 = Element.of(domainSet4, labels4);
        return TrainingSet.of(element1, element2, element3, element4);
    }
}