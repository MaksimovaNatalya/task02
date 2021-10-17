package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceDAO {

	ArrayList<Laptop> getLaptops ();

}
