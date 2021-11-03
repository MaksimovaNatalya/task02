package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import static by.tc.task01.dao.fromxmlparsing.DomParser.*;

public class Validator {


    public static boolean criteriaValidator(Criteria criteria) {

        switch (criteria.getGroupSearchName()) {
            case LAPTOP:
                LaptopValidator.validateLaptopCriteria(criteria);
                break;
            case OVEN:
                OvenValidator.validateOvenCriteria(criteria);
                break;
            case REFRIGERATOR:
                RefrigeratorValidator.validateRefrigeratorCriteria(criteria);
                break;
            case SPEAKERS:
                SpeakersValidator.validateSpeakersCriteria(criteria);
                break;
            case TABLET_PC:
                TabletPCValidator.validateTabletPCCriteria(criteria);
                break;
            case VACUUM_CLEANER:
                VacuumCleanerValidator.validateVacuumCleanerCriteria(criteria);
                break;
            default:
                throw new RuntimeException("Invalid groupSearchName: " + criteria.getGroupSearchName());
        }
        return true;
    }
}

