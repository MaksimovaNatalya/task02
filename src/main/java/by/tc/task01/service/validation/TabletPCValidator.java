package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.BATTERY_CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.*;

public class TabletPCValidator {
    public static boolean validateTabletPCCriteria(Criteria criteria) {
        Map<String, Object> tabletParameters = criteria.getCriteria();
        Set<String> keys = tabletParameters.keySet();

        for (String key : keys) {
            SearchCriteria.TabletPC parameter = SearchCriteria.TabletPC.valueOf(key);
            switch (parameter) {
                case BATTERY_CAPACITY:
                    double batteryCapacity = Double.parseDouble(String.valueOf(tabletParameters.get(BATTERY_CAPACITY.toString())));
                    if (!(batteryCapacity >= 3 && batteryCapacity <= 5)) {
                        return false;
                    }
                    break;
                case DISPLAY_INCHES:
                    int displayInches = Integer.parseInt(String.valueOf(tabletParameters.get(DISPLAY_INCHES.toString())));
                    if (!(displayInches >= 14 && displayInches <= 16)) {
                        return false;
                    }
                    break;
                case MEMORY_ROM:
                    int memoryRom = Integer.parseInt(String.valueOf(tabletParameters.get(MEMORY_ROM.toString())));
                    if (!(memoryRom >= 8000 && memoryRom <= 20000)) {
                        return false;
                    }
                    break;
                case FLASH_MEMORY_CAPACITY:
                    int flashMemoryCapacity = Integer.parseInt(String.valueOf(tabletParameters.get(FLASH_MEMORY_CAPACITY.toString())));
                    if (!(flashMemoryCapacity >= 2 && flashMemoryCapacity <= 10)) {
                        return false;
                    }
                    break;
                case COLOR:
                    String color = String.valueOf(tabletParameters.get(COLOR.toString()));
                    if (!(color.equals("blue") || color.equals("red") || color.equals("green"))) {
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
