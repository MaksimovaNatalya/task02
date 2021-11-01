package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class OvenFinder {
    public static List<Appliance> findOven(Criteria criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        ArrayList<Oven> ovens = applianceDAO.getOvens();
        List<Appliance> matchingOvens = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();

            if (Oven.class.getSimpleName().equals(criteria.getGroupSearchName())) {
                for (Oven oven : ovens) {
                    if (SearchCriteria.Oven.POWER_CONSUMPTION.toString().equals(key) &&
                            (expectedValue.equals(oven.getPowerConsumption()))) {
                        matchingOvens.add(oven);
                    }
                    if (SearchCriteria.Oven.WEIGHT.toString().equals(key)
                            && (expectedValue.equals(oven.getWeight()))) {
                        matchingOvens.add(oven);
                    }
                    if (SearchCriteria.Oven.CAPACITY.toString().equals(key)
                            && (expectedValue.equals(oven.getCapacity()))) {
                        matchingOvens.add(oven);
                    }
                    if (SearchCriteria.Oven.DEPTH.toString().equals(key)
                            && (expectedValue.equals(oven.getDepth()))) {
                        matchingOvens.add(oven);
                    }
                    if (SearchCriteria.Oven.HEIGHT.toString().equals(key)
                            && (expectedValue.equals(oven.getHeight()))) {
                        matchingOvens.add(oven);
                    }
                    if (SearchCriteria.Oven.WIDTH.toString().equals(key)
                            && (expectedValue.equals(oven.getWidth()))) {
                        matchingOvens.add(oven);
                    }
                }
                return matchingOvens;
            }
        }
        return matchingOvens;
    }
}
