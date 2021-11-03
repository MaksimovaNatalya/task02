package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class VacuumCleanerFinder {
    public static List<Appliance> findVacuumCleaner(Criteria criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        List<VacuumCleaner> vacuumCleaners = applianceDAO.getVacuumCleaners();
        List<VacuumCleaner> matchingVacuumCleaners = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();

            for (VacuumCleaner vacuumCleaner : vacuumCleaners) {

                if (SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getPowerConsumption())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
                if (SearchCriteria.VacuumCleaner.FILTER_TYPE.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getFilterType())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
                if (SearchCriteria.VacuumCleaner.BAG_TYPE.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getBagType())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
                if (SearchCriteria.VacuumCleaner.WAND_TYPE.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getWandType())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
                if (SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getMotorSpeedRegulation())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
                if (SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(vacuumCleaner.getCleaningWidth())))) {
                    matchingVacuumCleaners.add(vacuumCleaner);
                }
            }
            vacuumCleaners = matchingVacuumCleaners;
            matchingVacuumCleaners = new ArrayList<>();
        }
        return new ArrayList<>(vacuumCleaners);
    }
}