package by.tc.task01.dao;

import by.tc.task01.entity.*;

import java.util.ArrayList;

public interface ApplianceDAO {

    ArrayList<Laptop> getLaptops();

    ArrayList<Oven> getOvens();

    ArrayList<Refrigerator> getRefrigerators();

    ArrayList<Speakers> getSpeakers();

    ArrayList<TabletPC> getTabletPCs();

    ArrayList<VacuumCleaner> getVacuumCleaners();

}
