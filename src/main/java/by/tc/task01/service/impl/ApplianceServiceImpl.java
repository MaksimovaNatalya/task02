package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.*;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            throw new RuntimeException("Invalid criteria");
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        ArrayList<Laptop> laptops = applianceDAO.getLaptops();
        ArrayList<Oven> ovens = applianceDAO.getOvens();
        ArrayList<Refrigerator> refrigerators = applianceDAO.getRefrigerators();
        ArrayList<Speakers> speakers = applianceDAO.getSpeakers();
        ArrayList<TabletPC> tabletPCs = applianceDAO.getTabletPCs();
        ArrayList<VacuumCleaner> vacuumCleaners = applianceDAO.getVacuumCleaners();


        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();

            List<Appliance> matchingAppliances = new ArrayList<>();

            if (Laptop.class.getSimpleName().equals(criteria.getGroupSearchName())) {

                for (Laptop laptop : laptops) {

                    if (SearchCriteria.Laptop.OS.toString().equals(key) && (expectedValue.equals(laptop.getOs()))) {
                        matchingAppliances.add(laptop);
                    }
                    else if (SearchCriteria.Laptop.DISPLAY_INCHS.toString().equals(key)
                            && (expectedValue.equals(laptop.getDisplayInchs()))) {
                        matchingAppliances.add(laptop);
                    }
                }
                return matchingAppliances;
            }

            if (Oven.class.getSimpleName().equals(criteria.getGroupSearchName())) {
                for (Oven oven : ovens) {
                    if (SearchCriteria.Oven.POWER_CONSUMPTION.toString().equals(key) &&
                            (expectedValue.equals(oven.getPowerConsumption()))) {
                        matchingAppliances.add(oven);
                    }
                    else if (SearchCriteria.Oven.WEIGHT.toString().equals(key) && (expectedValue.equals(oven.getWeight()))) {
                        matchingAppliances.add(oven);
                    }
                }
                return matchingAppliances;
            }
        }


        return null;
    }


}

//you may add your own new classes
