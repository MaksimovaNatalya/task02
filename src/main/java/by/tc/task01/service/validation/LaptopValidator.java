package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.*;

public class LaptopValidator {


    public static boolean validateLaptopCriteria(Criteria criteria) {

        Map<String, Object> laptopParameters = criteria.getCriteria();
        Set<String> keys = laptopParameters.keySet();

        for (String key : keys) {
            SearchCriteria.Laptop parameter = SearchCriteria.Laptop.valueOf(key);
            switch (parameter) {
                case BATTERY_CAPACITY:
                    double batteryCapacity = Double.parseDouble(String.valueOf(laptopParameters.get(BATTERY_CAPACITY.toString())));
                    if (!(batteryCapacity >= 1 && batteryCapacity <= 3)) {
                        return false;
                    }
                    break;
                case OS:
                    String os = String.valueOf(laptopParameters.get(OS.toString()));
                    if (!(os.equals("Windows") || os.equals("Linux"))) {
                        return false;
                    }
                    break;
                case MEMORY_ROM:
                    int memoryRom = Integer.parseInt(String.valueOf(laptopParameters.get(MEMORY_ROM.toString())));
                    if (!(memoryRom >= 4000 && memoryRom <= 8000)) {
                        return false;
                    }
                    break;
                case SYSTEM_MEMORY:
                    int systemMemory = Integer.parseInt(String.valueOf(laptopParameters.get(SYSTEM_MEMORY.toString())));
                    if (!(systemMemory >= 1000 && systemMemory <= 1500)) {
                        return false;
                    }
                    break;
                case CPU:
                    double cpu = Double.parseDouble(String.valueOf(laptopParameters.get(CPU.toString())));
                    if (!(cpu >= 1 && cpu <= 3.5)) {
                        return false;
                    }
                    break;
                case DISPLAY_INCHS:
                    int displayInches = Integer.parseInt(String.valueOf(laptopParameters.get(DISPLAY_INCHS.toString())));
                    if (!(displayInches >= 15 && displayInches <= 24)) {
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

