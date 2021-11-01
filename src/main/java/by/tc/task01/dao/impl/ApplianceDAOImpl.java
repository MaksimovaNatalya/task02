package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.dao.fromxmlparsing.ParsedAppliances;

import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO {
    @Override
    public ArrayList<Laptop> getLaptops() {
        return ParsedAppliances.getLaptops();
    }

    @Override
    public ArrayList<Oven> getOvens() { return ParsedAppliances.getOvens(); }

    @Override
    public ArrayList<Refrigerator> getRefrigerators() {
        return ParsedAppliances.getRefrigerators();
    }

    @Override
    public ArrayList<Speakers> getSpeakers() {
        return ParsedAppliances.getSpeakers();
    }

    @Override
    public ArrayList<TabletPC> getTabletPCs() {
        return ParsedAppliances.getTabletPCS();
    }

    @Override
    public ArrayList<VacuumCleaner> getVacuumCleaners() {
        return ParsedAppliances.getVacuumCleaners();
    }


    // you may add your own code here

}


//you may add your own new classes