package by.tc.task01.service.impl;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.*;
import by.tc.task01.service.filtering.*;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {


    @Override
    public List<Appliance> find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            throw new RuntimeException("Invalid criteria");
        }

        List<Appliance> matchingAppliances = new ArrayList<>();

        if (Laptop.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = LaptopFinder.findLaptop(criteria);
        }
        if (Oven.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = OvenFinder.findOven(criteria);
        }
        if (Refrigerator.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = RefrigeratorFinder.findRefrigerator(criteria);
        }
        if (Speakers.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = SpeakersFinder.findSpeakers(criteria);
        }
        if (TabletPC.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = TabletPCFinder.findTabletPC(criteria);
        }
        if (VacuumCleaner.class.getSimpleName().equals(criteria.getGroupSearchName())) {
            matchingAppliances = VacuumCleanerFinder.findVacuumCleaner(criteria);
        }

        return matchingAppliances;
    }
}


