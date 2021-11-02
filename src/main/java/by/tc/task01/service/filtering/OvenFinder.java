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
        List<Oven> ovens = applianceDAO.getOvens();
        List<Oven> matchingOvens = new ArrayList<>();


        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();

        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();

            for (Oven oven : ovens) {
                if (SearchCriteria.Oven.POWER_CONSUMPTION.toString().equals(key) &&
                        (expectedValue.equals(String.valueOf((oven.getPowerConsumption()))))) {
                    matchingOvens.add(oven);
                }
                if (SearchCriteria.Oven.WEIGHT.toString().equals(key)
                        && (expectedValue.equals(String.valueOf((oven.getWeight()))))) {
                    matchingOvens.add(oven);
                }
                if (SearchCriteria.Oven.CAPACITY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf((oven.getCapacity()))))) {
                    matchingOvens.add(oven);
                }
                if (SearchCriteria.Oven.DEPTH.toString().equals(key)
                        && (expectedValue.equals(String.valueOf((oven.getDepth()))))) {
                    matchingOvens.add(oven);
                }
                if (SearchCriteria.Oven.HEIGHT.toString().equals(key)
                        && (expectedValue.equals(String.valueOf((oven.getHeight()))))) {
                    matchingOvens.add(oven);
                }
                if (SearchCriteria.Oven.WIDTH.toString().equals(key)
                        && (expectedValue.equals(String.valueOf((oven.getWidth()))))) {
                    matchingOvens.add(oven);
                }
            }
            ovens = matchingOvens;
            matchingOvens = new ArrayList<>();
        }
        return new ArrayList<>(ovens);
    }
}

