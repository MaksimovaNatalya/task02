package by.tc.task01.dao.fromxmlparsing;

import by.tc.task01.entity.TabletPC;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class TabletPcInfoCollector {
    public static void collectTabletPcInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);


        for (int i = 0; i < elements.getLength(); i++) {

            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();

            // getting values of the attributes
            String id = attributes.getNamedItem("ID").getNodeValue();
            double batteryCapacity = Double.parseDouble(attributes.getNamedItem("BATTERY_CAPACITY").getNodeValue());
            int displayInches = Integer.parseInt(attributes.getNamedItem("DISPLAY_INCHES").getNodeValue());
            int memoryRom = Integer.parseInt(attributes.getNamedItem("MEMORY_ROM").getNodeValue());
            int flashMemoryCapacity = Integer.parseInt(attributes.getNamedItem("FLASH_MEMORY_CAPACITY").getNodeValue());
            String color = attributes.getNamedItem("COLOR").getNodeValue();

            ParsedAppliances.getTabletPCS().add(new TabletPC(id, batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color));
        }
    }
}