package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.*;

public class LaptopValidator {


  public static boolean validate(Criteria criteria) {

        Map<String, Object> laptopParameters = criteria.getCriteria();

        if (laptopParameters.containsKey(BATTERY_CAPACITY.toString())) {
            double batteryCapacity = (double) laptopParameters.get(BATTERY_CAPACITY.toString());
            return batteryCapacity >= 1 && batteryCapacity <= 3;
        } else if (laptopParameters.containsKey(OS.toString())) {
            String os = (String) laptopParameters.get(OS.toString());
            return os.equals("Windows") || os.equals("Linux");
        } else if (laptopParameters.containsKey(MEMORY_ROM.toString())) {
            int memoryRom = (int) laptopParameters.get(MEMORY_ROM.toString());
            return memoryRom >= 4000 && memoryRom <= 8000;
        } else if (laptopParameters.containsKey(SYSTEM_MEMORY.toString())) {
            int systemMemory = Integer.parseInt(String.valueOf(laptopParameters.get(SYSTEM_MEMORY.toString())));
            return systemMemory >= 1000 && systemMemory <= 1500;
        } else if (laptopParameters.containsKey(CPU.toString())) {
            double cpu = (double) laptopParameters.get(CPU.toString());
            return cpu >= 1 && cpu <= 3.5;
        } else if (laptopParameters.containsKey(DISPLAY_INCHS.toString())) {
            int displayInches = Integer.parseInt(String.valueOf(laptopParameters.get(DISPLAY_INCHS.toString())));
            return displayInches >= 15 && displayInches <= 24;
        } else {
            return false;
        }//throw new RuntimeException("Parameter is not valid");

    }
}

