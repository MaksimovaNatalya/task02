package by.tc.task01.dao.fromxmlparser;

import by.tc.task01.entity.Oven;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class OvenInfoCollector {


    public static void collectOvenInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);

        // iteration through all found elements
        for (int i = 0; i < elements.getLength(); i++) {
            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // getting values of the attributes
            String id = attributes.getNamedItem("ID").getNodeValue();
            int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
            double weight = Double.parseDouble(attributes.getNamedItem("WEIGHT").getNodeValue());
            int capacity = Integer.parseInt(attributes.getNamedItem("CAPACITY").getNodeValue());
            double depth = Double.parseDouble(attributes.getNamedItem("DEPTH").getNodeValue());
            double height = Double.parseDouble(attributes.getNamedItem("HEIGHT").getNodeValue());
            double width = Double.parseDouble(attributes.getNamedItem("WIDTH").getNodeValue());

            ParsedAppliances.getOvens().add(new Oven(id, powerConsumption, weight, capacity, depth, height, width));
        }
    }
}