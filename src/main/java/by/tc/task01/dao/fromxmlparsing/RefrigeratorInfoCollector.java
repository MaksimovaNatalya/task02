package by.tc.task01.dao.fromxmlparsing;

import by.tc.task01.entity.Refrigerator;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class RefrigeratorInfoCollector {
    public static void collectRefrigeratorInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);


        for (int i = 0; i < elements.getLength(); i++) {
            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // getting values of the attributes
            String id = attributes.getNamedItem("ID").getNodeValue();
            int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
            double weight = Double.parseDouble(attributes.getNamedItem("WEIGHT").getNodeValue());
            double freezerCapacity = Double.parseDouble(attributes.getNamedItem("FREEZER_CAPACITY").getNodeValue());
            double overallCapacity = Double.parseDouble(attributes.getNamedItem("OVERALL_CAPACITY").getNodeValue());
            double height = Double.parseDouble(attributes.getNamedItem("HEIGHT").getNodeValue());
            double width = Double.parseDouble(attributes.getNamedItem("WIDTH").getNodeValue());

            ParsedAppliances.getRefrigerators().add(new Refrigerator(id, powerConsumption, weight, freezerCapacity,
                    overallCapacity, height, width));
        }
    }
}
