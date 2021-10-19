package by.tc.task01.parser;

import by.tc.task01.entity.*;

import java.util.ArrayList;

public class DOMParser {

    // collections for appliances information after parsing
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static ArrayList<Oven> ovens = new ArrayList<>();
    private static ArrayList<Refrigerator> refrigerators = new ArrayList<>();
    private static ArrayList<Speakers> speakers = new ArrayList<>();
    private static ArrayList<TabletPC> tabletPCS = new ArrayList<>();
    private static ArrayList<VacuumCleaner> vacuumCleaners = new ArrayList<>();

    public static ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public static ArrayList<Oven> getOvens() {
        return ovens;
    }

    public static ArrayList<Refrigerator> getRefrigerators() {
        return refrigerators;
    }

    public static ArrayList<Speakers> getSpeakers() {
        return speakers;
    }

    public static ArrayList<TabletPC> getTabletPCS() { return tabletPCS; }

    public static ArrayList<VacuumCleaner> getVacuumCleaners() {
        return vacuumCleaners;
    }

}
