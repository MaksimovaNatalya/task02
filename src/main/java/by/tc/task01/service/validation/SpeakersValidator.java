package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.*;


public class SpeakersValidator {
    public static boolean validate(Criteria criteria) {
        Map<String, Object> speakersParameters = criteria.getCriteria();

        if (speakersParameters.containsKey(POWER_CONSUMPTION.toString())) {
            int powerConsumption = (int) speakersParameters.get(POWER_CONSUMPTION.toString());
            return powerConsumption >= 15 && powerConsumption <= 20;
        } else if (speakersParameters.containsKey(NUMBER_OF_SPEAKERS.toString())) {
            int numberOfSpeakers = (int) speakersParameters.get(NUMBER_OF_SPEAKERS.toString());
            return numberOfSpeakers>= 2 && numberOfSpeakers <= 5;
        } else if (speakersParameters.containsKey(FREQUENCY_RANGE.toString())) {
            String frequencyRange = (String) speakersParameters.get(FREQUENCY_RANGE.toString());
            return frequencyRange.equals("2-4") || frequencyRange.equals("3-4") || frequencyRange.equals("2-3.5");
        } else if (speakersParameters.containsKey(CORD_LENGTH.toString())) {
            int cordLength = (int) speakersParameters.get(CORD_LENGTH.toString());
            return cordLength >= 2 && cordLength <= 4;
        } else {
            return false;
        }
    }
}