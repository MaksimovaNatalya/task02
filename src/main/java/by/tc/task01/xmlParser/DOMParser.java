package by.tc.task01.xmlParser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

import java.util.ArrayList;

public class DOMParser {

    // Коллекция для хранения всех людей
    private static ArrayList<Appliance> appliances = new ArrayList<>();
    private static ArrayList<Laptop> laptops = new ArrayList<>();

    public static ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public static ArrayList<Appliance> getAppliances() {
        return appliances;
    }

    public static void setAppliances(ArrayList<Appliance> appliances) {
        DOMParser.appliances = appliances;
    }

}
