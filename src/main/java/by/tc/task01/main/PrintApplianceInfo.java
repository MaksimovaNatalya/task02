package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        if (appliances == null) {
            throw new RuntimeException("appliances == null");
        } else if (appliances.isEmpty()) {
            throw new RuntimeException("appliances.isEmpty()");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }
}

