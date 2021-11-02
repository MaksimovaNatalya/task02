package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class LaptopFinder {

    public static List<Appliance> findLaptop(Criteria criteria) {

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        List<Laptop> laptops = applianceDAO.getLaptops();
        List<Laptop> matchingLaptops = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();


            for (Laptop laptop : laptops) {

                if (SearchCriteria.Laptop.OS.toString().equals(key) && (expectedValue.equals(laptop.getOs()))) {
                    matchingLaptops.add(laptop);
                }
                if (SearchCriteria.Laptop.DISPLAY_INCHS.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(laptop.getDisplayInchs())))) {
                    matchingLaptops.add(laptop);
                }
                if (SearchCriteria.Laptop.SYSTEM_MEMORY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(laptop.getSystemMemory())))) {
                    matchingLaptops.add(laptop);
                }
                if (SearchCriteria.Laptop.BATTERY_CAPACITY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(laptop.getBatteryCapacity())))) {
                    matchingLaptops.add(laptop);
                }
                if (SearchCriteria.Laptop.CPU.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(laptop.getCpu())))) {
                    matchingLaptops.add(laptop);
                }
                if (SearchCriteria.Laptop.MEMORY_ROM.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(laptop.getMemoryRom())))) {
                    matchingLaptops.add(laptop);
                }
            }
            laptops = matchingLaptops;
            matchingLaptops = new ArrayList<>();
        }
        return new ArrayList<>(laptops);
    }
}
