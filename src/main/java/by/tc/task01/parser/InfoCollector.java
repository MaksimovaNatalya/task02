package by.tc.task01.parser;

import by.tc.task01.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class InfoCollector {
    public static final String LAPTOP = "Laptop";
    public static final String OVEN = "Oven";
    public static final String REFRIGERATOR = "Refrigerator";
    public static final String SPEAKERS = "Speakers";
    public static final String TABLET_PC = "TabletPC";
    public static final String VACUUM_CLEANER = "VacuumCleaner";

    public static void collectInformation(Document document, final String element) {

        // getting all elements by tag name
        NodeList elements = document.getElementsByTagName(element);

        // iteration through all found elements
        for (int i = 0; i < elements.getLength(); i++) {
            // getting all attributes of the element
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // getting values of the attributes
            switch (element) {
                case LAPTOP: {
                    double batteryCapacity = Double.parseDouble(attributes.getNamedItem("BATTERY_CAPACITY").getNodeValue());
                    String os = attributes.getNamedItem("OS").getNodeValue();
                    int memoryRom = Integer.parseInt(attributes.getNamedItem("MEMORY_ROM").getNodeValue());
                    int systemMemory = Integer.parseInt(attributes.getNamedItem("SYSTEM_MEMORY").getNodeValue());
                    double cpu = Double.parseDouble(attributes.getNamedItem("CPU").getNodeValue());
                    int displayInchs = Integer.parseInt(attributes.getNamedItem("DISPLAY_INCHS").getNodeValue());
                // adding attributes to List
                    DOMParser.getLaptops().add(new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInchs));
                }
                break;
                case OVEN: {
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
                    double weight = Double.parseDouble(attributes.getNamedItem("WEIGHT").getNodeValue());
                    int capacity = Integer.parseInt(attributes.getNamedItem("CAPACITY").getNodeValue());
                    double depth = Double.parseDouble(attributes.getNamedItem("DEPTH").getNodeValue());
                    double height = Double.parseDouble(attributes.getNamedItem("HEIGHT").getNodeValue());
                    double width = Double.parseDouble(attributes.getNamedItem("WIDTH").getNodeValue());

                    DOMParser.getOvens().add(new Oven(powerConsumption, weight, capacity, depth, height, width));
                }
                break;
                case REFRIGERATOR: {
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
                    double weight = Double.parseDouble(attributes.getNamedItem("WEIGHT").getNodeValue());
                    double freezerCapacity = Double.parseDouble(attributes.getNamedItem("FREEZER_CAPACITY").getNodeValue());
                    double overallCapacity = Double.parseDouble(attributes.getNamedItem("OVERALL_CAPACITY").getNodeValue());
                    double height = Double.parseDouble(attributes.getNamedItem("HEIGHT").getNodeValue());
                    double width = Double.parseDouble(attributes.getNamedItem("WIDTH").getNodeValue());

                    DOMParser.getRefrigerators().add(new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width));
                }
                break;
                case SPEAKERS: {
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
                    int numberOfSpeakers = Integer.parseInt(attributes.getNamedItem("NUMBER_OF_SPEAKERS").getNodeValue());
                    String frequencyRange = attributes.getNamedItem("FREQUENCY_RANGE").getNodeValue();
                    int cordLength = Integer.parseInt(attributes.getNamedItem("CORD_LENGTH").getNodeValue());

                    DOMParser.getSpeakers().add(new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength));
                }
                break;
                case TABLET_PC: {
                    double batteryCapacity = Double.parseDouble(attributes.getNamedItem("BATTERY_CAPACITY").getNodeValue());
                    int displayInches = Integer.parseInt(attributes.getNamedItem("DISPLAY_INCHES").getNodeValue());
                    int memoryRom = Integer.parseInt(attributes.getNamedItem("MEMORY_ROM").getNodeValue());
                    int flashMemoryCapacity = Integer.parseInt(attributes.getNamedItem("FLASH_MEMORY_CAPACITY").getNodeValue());
                    String color = attributes.getNamedItem("COLOR").getNodeValue();

                    DOMParser.getTabletPCS().add(new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color));
                }
                break;
                case VACUUM_CLEANER: {
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue());
                    String filterType = attributes.getNamedItem("FILTER_TYPE").getNodeValue();
                    String bagType = attributes.getNamedItem("BAG_TYPE").getNodeValue();
                    String wandType = attributes.getNamedItem("WAND_TYPE").getNodeValue();
                    int motorSpeedRegulation = Integer.parseInt(attributes.getNamedItem("MOTOR_SPEED_REGULATION").getNodeValue());
                    int cleaningWidth = Integer.parseInt(attributes.getNamedItem("CLEANING_WIDTH").getNodeValue());

                    DOMParser.getVacuumCleaners().add(new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth));
                }
                break;
            }
        }
    }
}
