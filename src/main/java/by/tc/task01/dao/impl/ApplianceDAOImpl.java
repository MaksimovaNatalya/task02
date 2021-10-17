package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.xmlParser.DOMParser;

import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO{
	@Override
	public ArrayList<Laptop> getLaptops() {
		return DOMParser.getLaptops();
	}


	// you may add your own code here

}


//you may add your own new classes