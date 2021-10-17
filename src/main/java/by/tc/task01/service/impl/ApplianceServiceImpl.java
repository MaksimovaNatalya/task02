package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.Locale;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public Appliance find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		ArrayList<Laptop> laptops = applianceDAO.getLaptops();

//		String text = "macaca";
//		Object smth = text;
//
//		text = text.toUpperCase(Locale.ROOT);
//		System.out.println(text);

		// you may add your own code here
		//for (int i=0; i<laptops.size(); i++) {
		for (Laptop laptop : laptops) {
			if ("Linux".equals(laptop.getOs())) {
				return laptop;
			}

		}
		return null;
	}

}

//you may add your own new classes
