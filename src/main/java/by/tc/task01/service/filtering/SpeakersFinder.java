package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class SpeakersFinder {
    public static List<Appliance> findSpeakers(Criteria criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        List<Speakers> speakers = applianceDAO.getSpeakers();
        List<Speakers> matchingSpeakers = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();


            for (Speakers speakers1 : speakers) {

                if (SearchCriteria.Speakers.POWER_CONSUMPTION.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(speakers1.getPowerConsumption())))) {
                    matchingSpeakers.add(speakers1);
                }
                if (SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(speakers1.getNumberOfSpeakers())))) {
                    matchingSpeakers.add(speakers1);
                }
                if (SearchCriteria.Speakers.FREQUENCY_RANGE.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(speakers1.getFrequencyRange())))) {
                    matchingSpeakers.add(speakers1);
                }
                if (SearchCriteria.Speakers.CORD_LENGTH.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(speakers1.getCordLength())))) {
                    matchingSpeakers.add(speakers1);
                }
            }
            speakers = matchingSpeakers;
            matchingSpeakers = new ArrayList<>();
        }
        return new ArrayList<>(speakers);
    }
}