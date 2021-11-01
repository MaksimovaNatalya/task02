package by.tc.task01.dao.fromxmlparsing;

import by.tc.task01.entity.Speakers;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class SpeakersInfoCollector {
    public static void collectSpeakersInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);


        for (int i = 0; i < elements.getLength(); i++) {
            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // getting values of the attributes

            String id = attributes.getNamedItem("ID").getNodeValue();
            int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
            int numberOfSpeakers = Integer.parseInt(attributes.getNamedItem("NUMBER_OF_SPEAKERS").getNodeValue());
            String frequencyRange = attributes.getNamedItem("FREQUENCY_RANGE").getNodeValue();
            int cordLength = Integer.parseInt(attributes.getNamedItem("CORD_LENGTH").getNodeValue());

            ParsedAppliances.getSpeakers().add(new Speakers(id, powerConsumption, numberOfSpeakers, frequencyRange, cordLength));
        }
    }
}
