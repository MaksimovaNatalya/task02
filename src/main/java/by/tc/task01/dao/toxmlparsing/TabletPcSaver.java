package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
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

public class TabletPcSaver {
    public static void saveAsXML(List<Appliance> appliances) throws ParserConfigurationException, TransformerConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("TABLET_PC");
        document.appendChild(root);


        for (Appliance appliance : appliances) {
            if (appliance instanceof TabletPC) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element batteryCapacity = document.createElement("BATTERY_CAPACITY");
                Element displayInches = document.createElement("DISPLAY_INCHES");
                Element memoryRom = document.createElement("MEMORY_ROM");
                Element flashMemoryCapacity = document.createElement("FLASH_MEMORY_CAPACITY");
                Element color = document.createElement("COLOR");

                id.setTextContent(appliance.getId());
                batteryCapacity.setTextContent(String.valueOf(((TabletPC) appliance).getBatteryCapacity()));
                displayInches.setTextContent(String.valueOf(((TabletPC) appliance).getDisplayInches()));
                memoryRom.setTextContent(String.valueOf(((TabletPC) appliance).getMemoryRom()));
                flashMemoryCapacity.setTextContent(String.valueOf(((TabletPC) appliance).getFlashMemoryCapacity()));
                color.setTextContent(String.valueOf(((TabletPC) appliance).getColor()));

                parameters.appendChild(id);
                parameters.appendChild(batteryCapacity);
                parameters.appendChild(displayInches);
                parameters.appendChild(memoryRom);
                parameters.appendChild(flashMemoryCapacity);
                parameters.appendChild(color);
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
