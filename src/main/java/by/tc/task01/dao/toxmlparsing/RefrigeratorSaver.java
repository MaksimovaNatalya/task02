package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
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

public class RefrigeratorSaver {

    public static void saveAsXML(List<Appliance> appliances) throws ParserConfigurationException, TransformerConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("REFRIGERATOR");
        document.appendChild(root);


        for (Appliance appliance : appliances) {
            if (appliance instanceof Refrigerator) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element powerConsumption = document.createElement("POWER_CONSUMPTION");
                Element weight = document.createElement("WEIGHT");
                Element freezerCapacity = document.createElement("FREEZER_CAPACITY");
                Element overallCapacity = document.createElement("OVERALL_CAPACITY");
                Element height = document.createElement("HEIGHT");
                Element width = document.createElement("WIDTH");

                id.setTextContent(appliance.getId());
                powerConsumption.setTextContent(String.valueOf(((Refrigerator) appliance).getPowerConsumption()));
                weight.setTextContent(String.valueOf(((Refrigerator) appliance).getWeight()));
                freezerCapacity.setTextContent(String.valueOf(((Refrigerator) appliance).getFreezerCapacity()));
                overallCapacity.setTextContent(String.valueOf(((Refrigerator) appliance).getOverallCapacity()));
                height.setTextContent(String.valueOf(((Refrigerator) appliance).getHeight()));
                width.setTextContent(String.valueOf(((Refrigerator) appliance).getWidth()));


                parameters.appendChild(id);
                parameters.appendChild(powerConsumption);
                parameters.appendChild(weight);
                parameters.appendChild(freezerCapacity);
                parameters.appendChild(overallCapacity);
                parameters.appendChild(height);
                parameters.appendChild(width);
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
