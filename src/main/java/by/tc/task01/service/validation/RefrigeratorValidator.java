package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.*;


public class RefrigeratorValidator {
    public static boolean validate(Criteria criteria) {
        Map<String, Object> refrigeratorParameters = criteria.getCriteria();

        if (refrigeratorParameters.containsKey(POWER_CONSUMPTION.toString())) {
            int powerConsumption = Integer.parseInt(String.valueOf(refrigeratorParameters.get(POWER_CONSUMPTION.toString())));
            return powerConsumption >= 100 && powerConsumption <= 300;
        } else if (refrigeratorParameters.containsKey(WEIGHT.toString())) {
            double weight = Double.parseDouble(String.valueOf(refrigeratorParameters.get(WEIGHT.toString())));
            return weight>= 20 && weight <= 40;
        } else if (refrigeratorParameters.containsKey(FREEZER_CAPACITY.toString())) {
            double freezerCapacity = Double.parseDouble(String.valueOf(refrigeratorParameters.get(FREEZER_CAPACITY.toString())));
            return freezerCapacity >= 10 && freezerCapacity <= 20;
        } else if (refrigeratorParameters.containsKey(OVERALL_CAPACITY.toString())) {
            double overallCapacity = Double.parseDouble(String.valueOf(refrigeratorParameters.get(OVERALL_CAPACITY.toString())));
            return overallCapacity >= 300 && overallCapacity <= 400;
        } else if (refrigeratorParameters.containsKey(HEIGHT.toString())) {
            double height = Double.parseDouble(String.valueOf(refrigeratorParameters.get(HEIGHT.toString())));
            return height >= 150 && height <= 250;
        } else if (refrigeratorParameters.containsKey(WIDTH.toString())) {
            double width = Double.parseDouble(String.valueOf(refrigeratorParameters.get(WIDTH.toString())));
            return width >= 70 && width <= 100;
        } else {
            return false;
        }
    }
}