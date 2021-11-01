package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
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

public class SpeakersSaver {
    public static void saveAsXML(List<Appliance> appliances) throws ParserConfigurationException, TransformerConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("SPEAKERS");
        document.appendChild(root);


        for (Appliance appliance : appliances) {
            if (appliance instanceof Speakers) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element powerConsumption = document.createElement("POWER_CONSUMPTION");
                Element numberOfSpeakers = document.createElement("NUMBER_OF_SPEAKERS");
                Element frequencyRange = document.createElement("FREQUENCY_RANGE");
                Element cordLength = document.createElement("CORD_LENGTH");

                id.setTextContent(appliance.getId());
                powerConsumption.setTextContent(String.valueOf(((Speakers) appliance).getPowerConsumption()));
                numberOfSpeakers.setTextContent(String.valueOf(((Speakers) appliance).getNumberOfSpeakers()));
                frequencyRange.setTextContent(String.valueOf(((Speakers) appliance).getFrequencyRange()));
                cordLength.setTextContent(String.valueOf(((Speakers) appliance).getCordLength()));

                parameters.appendChild(id);
                parameters.appendChild(powerConsumption);
                parameters.appendChild(numberOfSpeakers);
                parameters.appendChild(frequencyRange);
                parameters.appendChild(cordLength);
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
