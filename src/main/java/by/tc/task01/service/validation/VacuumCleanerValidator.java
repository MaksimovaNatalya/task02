package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.*;


public class VacuumCleanerValidator {
    public static boolean validateVacuumCleanerCriteria(Criteria criteria) {
        Map<String, Object> vacuumCleanerParameters = criteria.getCriteria();
        Set<String> keys = vacuumCleanerParameters.keySet();

        for (String key : keys) {
            SearchCriteria.VacuumCleaner parameter = SearchCriteria.VacuumCleaner.valueOf(key);
            switch (parameter) {
                case POWER_CONSUMPTION:
                    int powerConsumption = Integer.parseInt(String.valueOf(vacuumCleanerParameters.get(POWER_CONSUMPTION.toString())));
                    if (!(powerConsumption >= 90 && powerConsumption <= 120)) {
                        return false;
                    }
                    break;
                case FILTER_TYPE:
                    String filterType = String.valueOf(vacuumCleanerParameters.get(FILTER_TYPE.toString()));
                    if (!(filterType.equals("A") || filterType.equals("B") || filterType.equals("C"))) {
                        return false;
                    }
                    break;
                case BAG_TYPE:
                    String bagType = String.valueOf(vacuumCleanerParameters.get(BAG_TYPE.toString()));
                    if (!(bagType.equals("A2") || bagType.equals("AA-89") || bagType.equals("XX00"))) {
                        return false;
                    }
                    break;
                case WAND_TYPE:
                    String wandType = String.valueOf(vacuumCleanerParameters.get(WAND_TYPE.toString()));
                    if (!(wandType.equals("all-in-one"))) {
                        return false;
                    }
                    break;
                case MOTOR_SPEED_REGULATION:
                    int motorSpeedRegulation = Integer.parseInt(String.valueOf
                            (vacuumCleanerParameters.get(MOTOR_SPEED_REGULATION.toString())));
                    if (!(motorSpeedRegulation >= 2900 && motorSpeedRegulation <= 3000)) {
                        return false;
                    }
                    break;
                case CLEANING_WIDTH:
                    int cleaningWidth = Integer.parseInt(String.valueOf(vacuumCleanerParameters.get(CLEANING_WIDTH.toString())));
                    if (!(cleaningWidth >= 20 && cleaningWidth <= 30)) {
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

