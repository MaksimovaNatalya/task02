package by.tc.task01.main;

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
        final String FILE_PATH = "resources/saved_catalog.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("LAPTOP");
        document.appendChild(root);

        Element parameters = document.createElement("PARAMETERS");
        root.appendChild(parameters);


        for (Appliance appliance : appliances) {

            Element id = document.createElement("ID");
            Element batteryCapacity = document.createElement("BATTERY_CAPACITY");
            Element os = document.createElement("OS");
            Element memoryRom = document.createElement("MEMORY_ROM");
            Element systemMemory = document.createElement("SYSTEM_MEMORY");
            Element cpu = document.createElement("CPU");
            Element displayInches = document.createElement("DISPLAY_INCHES");

            id.setTextContent(appliance.getId());

            parameters.appendChild(id);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = null;
        try {
            result = new StreamResult(new FileWriter(FILE_PATH));
            transformer.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}
