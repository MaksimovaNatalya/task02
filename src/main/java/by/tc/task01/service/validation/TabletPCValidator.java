package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;


import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.*;

public class TabletPCValidator {
    public static boolean validate(Criteria criteria) {
        Map<String, Object> tabletParameters = criteria.getCriteria();

        if (tabletParameters.containsKey(BATTERY_CAPACITY.toString())) {
            double batteryCapacity = Double.parseDouble(String.valueOf(tabletParameters.get(BATTERY_CAPACITY.toString())));
            return batteryCapacity >= 3 && batteryCapacity <= 5;
        } else if (tabletParameters.containsKey(DISPLAY_INCHES.toString())) {
            int displayInches = Integer.parseInt(String.valueOf(tabletParameters.get(DISPLAY_INCHES.toString())));
            return displayInches>= 14 && displayInches <= 16;
        } else if (tabletParameters.containsKey(MEMORY_ROM.toString())) {
            int memoryRom = Integer.parseInt(String.valueOf(tabletParameters.get(MEMORY_ROM.toString())));
            return memoryRom >= 8000 && memoryRom <= 20000;
        } else if (tabletParameters.containsKey(FLASH_MEMORY_CAPACITY.toString())) {
            int flashMemoryCapacity = Integer.parseInt(String.valueOf(tabletParameters.get(FLASH_MEMORY_CAPACITY.toString())));
            return flashMemoryCapacity >= 2 && flashMemoryCapacity <= 10;
        } else if (tabletParameters.containsKey(COLOR.toString())) {
            String color = String.valueOf(tabletParameters.get(COLOR.toString()));
            return color.equals("blue") || color.equals("red") || color.equals("green");
        } else {
            return false;
        }
    }
}