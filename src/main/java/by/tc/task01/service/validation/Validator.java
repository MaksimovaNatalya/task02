package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import static by.tc.task01.parser.InfoCollector.*;

public class Validator {


	public static boolean criteriaValidator(Criteria criteria) {

			switch (criteria.getGroupSearchName()) {
				case LAPTOP:
					LaptopValidator.validate(criteria);
					break;
				case OVEN:
					OvenValidator.validate(criteria);
					break;
				case REFRIGERATOR:
					RefrigeratorValidator.validate(criteria);
					break;
				case SPEAKERS:
					SpeakersValidator.validate(criteria);
					break;
				case TABLET_PC:
					TabletPCValidator.validate(criteria);
					break;
				case VACUUM_CLEANER:
					VacuumCleanerValidator.validate(criteria);
					break;
				default:
					throw new RuntimeException("Invalid groupSearchName: " + criteria.getGroupSearchName());
			}
		return true;
	}
}

