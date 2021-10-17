package by.tc.task01.xmlParser;

import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class InfoCollector {
    public static final String LAPTOP = "Laptop";

    public static final String OVEN = "Oven";


    public static final String REFRIGERATOR = "refrigerator";


    static final String SPEAKERS = "speakers";
    static final String TABLET_PC = "tabletPC";
    static final String VACUUM_CLEANER = "vacuumCleaner";

    public static void collectInformation(Document document, final String element) {

        // Получение всех элементов по имени тега.
        NodeList elements = document.getElementsByTagName(element);

        // Перебор всех найденных элементов
        for (int i = 0; i < elements.getLength(); i++) {
            // Получение всех атрибутов элемента
            NamedNodeMap attributes = elements.item(i).getAttributes();
            // В зависимости от типа элемента, нам нужно собрать свою дополнительну информацию про каждый подкласс, а после добавить нужные образцы в коллекцию.
            switch (element) {
                case LAPTOP: {
                    String batteryCapacity = attributes.getNamedItem("BATTERY_CAPACITY").getNodeValue();
                    String os = attributes.getNamedItem("OS").getNodeValue();
                    String memoryRom = attributes.getNamedItem("MEMORY_ROM").getNodeValue();
                    String systemMemory = attributes.getNamedItem("SYSTEM_MEMORY").getNodeValue();
                    String cpu = attributes.getNamedItem("CPU").getNodeValue();
                    String displayInchs = attributes.getNamedItem("DISPLAY_INCHS").getNodeValue();

                    DOMParser.getLaptops().add(new Laptop(batteryCapacity,os,memoryRom,systemMemory,cpu,displayInchs));
                }
                break;
                case OVEN: {
                    String powerConsumption = attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue();
                    String weight = attributes.getNamedItem("WEIGHT").getNodeValue();
                    String capacity = attributes.getNamedItem("CAPACITY").getNodeValue();
                    String depth = attributes.getNamedItem("DEPTH").getNodeValue();
                    String height = attributes.getNamedItem("HEIGHT").getNodeValue();
                    String width = attributes.getNamedItem("WIDTH").getNodeValue();

                    DOMParser.getAppliances().add(new Oven(powerConsumption, weight, capacity, depth, height, width));
                }
                break;
//                case REFRIGERATOR: {
//                    String position = attributes.getNamedItem("POWER_CONSUMPTION").getNodeValue();
//
//                    DOMParser.getAppliances().add(new Refrigerator());
//                }
//                break;
            }
        }
    }
}
