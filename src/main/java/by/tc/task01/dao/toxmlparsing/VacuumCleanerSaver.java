package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
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

public class VacuumCleanerSaver {
    public static void saveAsXML(List<Appliance> appliances) throws ParserConfigurationException, TransformerConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("VACUUM_CLEANER");
        document.appendChild(root);


        for (Appliance appliance : appliances) {
            if (appliance instanceof VacuumCleaner) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element powerConsumption = document.createElement("POWER_CONSUMPTION");
                Element filterType = document.createElement("FILTER_TYPE");
                Element bagType = document.createElement("BAG_TYPE");
                Element wandType = document.createElement("WAND_TYPE");
                Element motorSpeedRegulation = document.createElement("MOTOR_SPEED_REGULATION");
                Element cleaningWidth = document.createElement("CLEANING_WIDTH");

                id.setTextContent(appliance.getId());
                powerConsumption.setTextContent(String.valueOf(((VacuumCleaner) appliance).getPowerConsumption()));
                filterType.setTextContent(String.valueOf(((VacuumCleaner) appliance).getFilterType()));
                bagType.setTextContent(String.valueOf(((VacuumCleaner) appliance).getBagType()));
                wandType.setTextContent(String.valueOf(((VacuumCleaner) appliance).getWandType()));
                motorSpeedRegulation.setTextContent(String.valueOf(((VacuumCleaner) appliance).getMotorSpeedRegulation()));
                cleaningWidth.setTextContent(String.valueOf(((VacuumCleaner) appliance).getCleaningWidth()));

                parameters.appendChild(id);
                parameters.appendChild(powerConsumption);
                parameters.appendChild(filterType);
                parameters.appendChild(bagType);
                parameters.appendChild(wandType);
                parameters.appendChild(motorSpeedRegulation);
                parameters.appendChild(cleaningWidth);
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
