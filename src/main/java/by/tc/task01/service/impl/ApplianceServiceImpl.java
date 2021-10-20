package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.*;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public Appliance find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		ArrayList<Laptop> laptops = applianceDAO.getLaptops();
		ArrayList<Oven> ovens = applianceDAO.getOvens();
		ArrayList<Refrigerator> refrigerators = applianceDAO.getRefrigerators();
		ArrayList<Speakers> speakers = applianceDAO.getSpeakers();
		ArrayList<TabletPC> tabletPCs = applianceDAO.getTabletPCs();
		ArrayList<VacuumCleaner> vacuumCleaners = applianceDAO.getVacuumCleaners();


		// you may add your own code here

		//for (int i=0; i<laptops.size(); i++) {

		Set s=criteria.entrySet();
		Iterator itr=s.iterator();
		while(itr.hasNext())
		{
			Map.Entry m=(Map.Entry)itr.next();
			Object value =  m.getValue();

			for (Laptop laptop : laptops) {

				if (value.equals(laptop.getOs())) {
					//if ("Linux".equals(laptop.getOs())) {
					return laptop;
				}

			}
		}


		return null;
	}


}

//you may add your own new classes
