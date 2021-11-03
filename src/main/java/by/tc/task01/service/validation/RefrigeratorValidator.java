package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.*;


public class RefrigeratorValidator {
    public static boolean validateRefrigeratorCriteria(Criteria criteria) {
        Map<String, Object> refrigeratorParameters = criteria.getCriteria();
        Set<String> keys = refrigeratorParameters.keySet();

        for (String key : keys) {
            SearchCriteria.Refrigerator parameter = SearchCriteria.Refrigerator.valueOf(key);
            switch (parameter) {
                case POWER_CONSUMPTION:
                    int powerConsumption = Integer.parseInt(String.valueOf(refrigeratorParameters.get(POWER_CONSUMPTION.toString())));
                    if (!(powerConsumption >= 100 && powerConsumption <= 300)) {
                        return false;
                    }
                    break;
                case WEIGHT:
                    double weight = Double.parseDouble(String.valueOf(refrigeratorParameters.get(WEIGHT.toString())));
                    if (!(weight >= 20 && weight <= 40)) {
                        return false;
                    }
                    break;
                case FREEZER_CAPACITY:
                    double freezerCapacity = Double.parseDouble(String.valueOf(refrigeratorParameters.get(FREEZER_CAPACITY.toString())));
                    if (!(freezerCapacity >= 10 && freezerCapacity <= 20)) {
                        return false;
                    }
                    break;
                case OVERALL_CAPACITY:
                    double overallCapacity = Double.parseDouble(String.valueOf(refrigeratorParameters.get(OVERALL_CAPACITY.toString())));
                    if (!(overallCapacity >= 300 && overallCapacity <= 400)) {
                        return false;
                    }
                    break;
                case HEIGHT:
                    double height = Double.parseDouble(String.valueOf(refrigeratorParameters.get(HEIGHT.toString())));
                    if (!(height >= 150 && height <= 250)) {
                        return false;
                    }
                    break;
                case WIDTH:
                    double width = Double.parseDouble(String.valueOf(refrigeratorParameters.get(WIDTH.toString())));
                    if (!(width >= 70 && width <= 100)) {
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
