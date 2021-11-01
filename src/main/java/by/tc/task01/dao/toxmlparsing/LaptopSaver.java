package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LaptopSaver {
    public static void saveAsXML(List<Appliance> appliances) throws ParserConfigurationException, TransformerConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("LAPTOP");
        document.appendChild(root);

        for (Appliance appliance : appliances) {
            if (appliance instanceof Laptop) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element batteryCapacity = document.createElement("BATTERY_CAPACITY");
                Element os = document.createElement("OS");
                Element memoryRom = document.createElement("MEMORY_ROM");
                Element systemMemory = document.createElement("SYSTEM_MEMORY");
                Element cpu = document.createElement("CPU");
                Element displayInches = document.createElement("DISPLAY_INCHES");

                id.setTextContent(appliance.getId());
                batteryCapacity.setTextContent(String.valueOf(((Laptop) appliance).getBatteryCapacity()));
                os.setTextContent(((Laptop) appliance).getOs());
                memoryRom.setTextContent(String.valueOf(((Laptop) appliance).getMemoryRom()));
                systemMemory.setTextContent(String.valueOf(((Laptop) appliance).getSystemMemory()));
                cpu.setTextContent(String.valueOf(((Laptop) appliance).getCpu()));
                displayInches.setTextContent(String.valueOf(((Laptop) appliance).getDisplayInchs()));


                parameters.appendChild(id);
                parameters.appendChild(batteryCapacity);
                parameters.appendChild(os);
                parameters.appendChild(memoryRom);
                parameters.appendChild(systemMemory);
                parameters.appendChild(cpu);
                parameters.appendChild(displayInches);
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        try {
            StreamResult result = new StreamResult(new FileWriter(FILE_PATH));
            transformer.transform(source, result);
        } catch (TransformerException | IOException e) {
            throw new RuntimeException("Exception in writing the file");
        }
    }
}
