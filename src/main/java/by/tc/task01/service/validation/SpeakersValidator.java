package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.*;


public class SpeakersValidator {
    public static boolean validateSpeakersCriteria(Criteria criteria) {
        Map<String, Object> speakersParameters = criteria.getCriteria();
        Set<String> keys = speakersParameters.keySet();

        for (String key : keys) {
            SearchCriteria.Speakers parameter = SearchCriteria.Speakers.valueOf(key);
            switch (parameter) {
                case POWER_CONSUMPTION:
                    int powerConsumption = Integer.parseInt(String.valueOf(speakersParameters.get(POWER_CONSUMPTION.toString())));
                    if (!(powerConsumption >= 15 && powerConsumption <= 20)) {
                        return false;
                    }
                    break;
                case NUMBER_OF_SPEAKERS:
                    int numberOfSpeakers = Integer.parseInt(String.valueOf(speakersParameters.get(NUMBER_OF_SPEAKERS.toString())));
                    if (!(numberOfSpeakers >= 2 && numberOfSpeakers <= 5)) {
                        return false;
                    }
                    break;
                case FREQUENCY_RANGE:
                    String frequencyRange = String.valueOf(speakersParameters.get(FREQUENCY_RANGE.toString()));
                    if (!(frequencyRange.equals("2-4") || frequencyRange.equals("3-4") || frequencyRange.equals("2-3.5"))) {
                        return false;
                    }
                    break;
                case CORD_LENGTH:
                    int cordLength = Integer.parseInt(String.valueOf(speakersParameters.get(CORD_LENGTH.toString())));
                    if (!(cordLength >= 2 && cordLength <= 4)) {
                        return false;
                    }
                    break;
                default:
                    throw new RuntimeException("Parameter is not valid");
            }
        }
        return true;
    }
}

