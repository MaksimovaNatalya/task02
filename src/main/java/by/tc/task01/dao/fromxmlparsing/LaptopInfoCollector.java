package by.tc.task01.dao.fromxmlparsing;

import by.tc.task01.entity.Laptop;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class LaptopInfoCollector {

    public static void collectLaptopInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);


        for (int i = 0; i < elements.getLength(); i++) {
            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // getting values of the attributes

                    String id = attributes.getNamedItem("ID").getNodeValue();
                    double batteryCapacity = Double.parseDouble(attributes.getNamedItem("BATTERY_CAPACITY").getNodeValue());
                    String os = attributes.getNamedItem("OS").getNodeValue();
                    int memoryRom = Integer.parseInt(attributes.getNamedItem("MEMORY_ROM").getNodeValue());
                    int systemMemory = Integer.parseInt(attributes.getNamedItem("SYSTEM_MEMORY").getNodeValue());
                    double cpu = Double.parseDouble(attributes.getNamedItem("CPU").getNodeValue());
                    int displayInchs = Integer.parseInt(attributes.getNamedItem("DISPLAY_INCHS").getNodeValue());
                    // adding attributes to List
                    ParsedAppliances.getLaptops().add(new Laptop(id, batteryCapacity, os, memoryRom, systemMemory, cpu, displayInchs));


        }
    }
}
