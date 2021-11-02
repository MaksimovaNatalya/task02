package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.*;


public class VacuumCleanerValidator {
    public static boolean validate(Criteria criteria) {
        Map<String, Object> vacuumCleanerParameters = criteria.getCriteria();

        if (vacuumCleanerParameters.containsKey(POWER_CONSUMPTION.toString())) {
            int powerConsumption = Integer.parseInt(String.valueOf(vacuumCleanerParameters.get(POWER_CONSUMPTION.toString())));
            return powerConsumption >= 90 && powerConsumption <= 120;
        } else if (vacuumCleanerParameters.containsKey(FILTER_TYPE.toString())) {
            String filterType = String.valueOf(vacuumCleanerParameters.get(FILTER_TYPE.toString()));
            return filterType.equals("A") || filterType.equals("B") || filterType.equals("C");
        } else if (vacuumCleanerParameters.containsKey(BAG_TYPE.toString())) {
            String bagType = String.valueOf(vacuumCleanerParameters.get(BAG_TYPE.toString()));
            return bagType.equals("A2") || bagType.equals("AA-89") || bagType.equals("XX00");
        } else if (vacuumCleanerParameters.containsKey(WAND_TYPE.toString())) {
            String wandType = String.valueOf(vacuumCleanerParameters.get(WAND_TYPE.toString()));
            return wandType.equals("all-in-one");
        } else if (vacuumCleanerParameters.containsKey(MOTOR_SPEED_REGULATION.toString())) {
            int motorSpeedRegulation = Integer.parseInt(String.valueOf
                    (vacuumCleanerParameters.get(MOTOR_SPEED_REGULATION.toString())));
            return motorSpeedRegulation >= 2900 && motorSpeedRegulation <= 3000;
        } else if (vacuumCleanerParameters.containsKey(CLEANING_WIDTH.toString())) {
            int cleaningWidth = Integer.parseInt(String.valueOf(vacuumCleanerParameters.get(CLEANING_WIDTH.toString())));
            return cleaningWidth >= 20 && cleaningWidth <= 30;
        } else {
            return false;
        }
    }
}