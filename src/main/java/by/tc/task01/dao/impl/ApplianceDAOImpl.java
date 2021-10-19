package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.parser.DOMParser;

import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO {
    @Override
    public ArrayList<Laptop> getLaptops() {
        return DOMParser.getLaptops();
    }

    @Override
    public ArrayList<Oven> getOvens() { return DOMParser.getOvens(); }

    @Override
    public ArrayList<Refrigerator> getRefrigerators() {
        return DOMParser.getRefrigerators();
    }

    @Override
    public ArrayList<Speakers> getSpeakers() {
        return DOMParser.getSpeakers();
    }

    @Override
    public ArrayList<TabletPC> getTabletPCs() {
        return DOMParser.getTabletPCS();
    }

    @Override
    public ArrayList<VacuumCleaner> getVacuumCleaners() {
        return DOMParser.getVacuumCleaners();
    }


    // you may add your own code here

}


//you may add your own new classes