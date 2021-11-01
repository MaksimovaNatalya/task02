package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class RefrigeratorFinder {
    public static List<Appliance> findRefrigerator(Criteria criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        ArrayList<Refrigerator> refrigerators = applianceDAO.getRefrigerators();
        List<Appliance> matchingRefrigerators = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();


            for (Refrigerator refrigerator : refrigerators) {

                if (SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString().equals(key)
                        && (expectedValue.equals(refrigerator.getPowerConsumption()))) {
                    matchingRefrigerators.add(refrigerator);
                }
                if (SearchCriteria.Refrigerator.WEIGHT.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(refrigerator.getWeight())))) {
                    matchingRefrigerators.add(refrigerator);
                }
                if (SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(refrigerator.getFreezerCapacity())))) {
                    matchingRefrigerators.add(refrigerator);
                }
                if (SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(refrigerator.getOverallCapacity())))) {
                    matchingRefrigerators.add(refrigerator);
                }
                if (SearchCriteria.Refrigerator.HEIGHT.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(refrigerator.getHeight())))) {
                    matchingRefrigerators.add(refrigerator);
                }
                if (SearchCriteria.Refrigerator.WIDTH.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(refrigerator.getWidth())))) {
                    matchingRefrigerators.add(refrigerator);
                }

            }
            return matchingRefrigerators;

        }
        return matchingRefrigerators;
    }
}