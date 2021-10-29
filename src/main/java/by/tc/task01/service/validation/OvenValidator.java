package by.tc.task01.service.validation;

import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven.*;

public class OvenValidator {
    public static boolean validate(Criteria criteria) {
        Map<String, Object> ovenParameters = criteria.getCriteria();

        if (ovenParameters.containsKey(POWER_CONSUMPTION.toString())) {
            int powerConsumption = (int) ovenParameters.get(POWER_CONSUMPTION.toString());
            return powerConsumption >= 1000 && powerConsumption <= 3000;
        } else if (ovenParameters.containsKey(WEIGHT.toString())) {
            double weight = (double) ovenParameters.get(WEIGHT.toString());
            return weight>= 10 && weight <= 15;
        } else if (ovenParameters.containsKey(CAPACITY.toString())) {
            int capacity = (int) ovenParameters.get(CAPACITY.toString());
            return capacity >= 30 && capacity <= 35;
        } else if (ovenParameters.containsKey(DEPTH.toString())) {
            double depth = (double) ovenParameters.get(DEPTH.toString());
            return depth >= 50 && depth <= 60;
        } else if (ovenParameters.containsKey(HEIGHT.toString())) {
            double height = (double) ovenParameters.get(HEIGHT.toString());
            return height >= 40 && height <= 50;
        } else if (ovenParameters.containsKey(WIDTH.toString())) {
            double width = (double) ovenParameters.get(WIDTH.toString());
            return width >= 55 && width <= 70;
        } else {
            return false;
        }
    }
}
