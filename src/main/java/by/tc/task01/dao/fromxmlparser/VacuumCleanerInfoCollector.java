package by.tc.task01.dao.fromxmlparser;

import by.tc.task01.entity.VacuumCleaner;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class VacuumCleanerInfoCollector {
    public static void collectVacuumCleanerInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);


        for (int i = 0; i < elements.getLength(); i++) {


            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();

            // getting values of the attributes

            String id = attributes.getNamedItem("ID").getNodeValue();
            int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
            String filterType = attributes.getNamedItem("FILTER_TYPE").getNodeValue();
            String bagType = attributes.getNamedItem("BAG_TYPE").getNodeValue();
            String wandType = attributes.getNamedItem("WAND_TYPE").getNodeValue();
            int motorSpeedRegulation = Integer.parseInt(attributes.getNamedItem("MOTOR_SPEED_REGULATION").getNodeValue());
            int cleaningWidth = Integer.parseInt(attributes.getNamedItem("CLEANING_WIDTH").getNodeValue());

            ParsedAppliances.getVacuumCleaners().add(new VacuumCleaner(id, powerConsumption, filterType, bagType, wandType,
                    motorSpeedRegulation, cleaningWidth));
        }
    }
}