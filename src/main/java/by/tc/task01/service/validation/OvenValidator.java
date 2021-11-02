package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven.*;

public class OvenValidator {
    public static boolean validateOvenCriteria(Criteria criteria) {
        Map<String, Object> ovenParameters = criteria.getCriteria();
        Set<String> keys = ovenParameters.keySet();

        for (String key : keys) {
            SearchCriteria.Oven parameter = SearchCriteria.Oven.valueOf(key);
            switch (parameter) {
                case POWER_CONSUMPTION:
                    int powerConsumption = Integer.parseInt(String.valueOf(ovenParameters.get(POWER_CONSUMPTION.toString())));
                    if (!(powerConsumption >= 1000 && powerConsumption <= 3000)) {
                        return false;
                    }
                    break;
                case WEIGHT:
                    double weight = Double.parseDouble(String.valueOf(ovenParameters.get(WEIGHT.toString())));
                    if (!(weight >= 10 && weight <= 15)) {
                        return false;
                    }
                    break;
                case CAPACITY:
                    int capacity = Integer.parseInt(String.valueOf(ovenParameters.get(CAPACITY.toString())));
                    if (!(capacity >= 30 && capacity <= 35)) {
                        return false;
                    }
                    break;
                case DEPTH:
                    double depth = Double.parseDouble(String.valueOf(ovenParameters.get(DEPTH.toString())));
                    if (!(depth >= 50 && depth <= 60)) {
                        return false;
                    }
                    break;
                case HEIGHT:
                    double height = Double.parseDouble(String.valueOf(ovenParameters.get(HEIGHT.toString())));
                    if (!(height >= 40 && height <= 50)) {
                        return false;
                    }
                    break;
                case WIDTH:
                    double width = Double.parseDouble(String.valueOf(ovenParameters.get(WIDTH.toString())));
                    if (!(width >= 55 && width <= 70)) {
                        return false;
                    }
                    break;
                default:
                    throw new RuntimeException("Parameter is not valid");
            }
        }
        return true;
    }
}
