package by.tc.task01.dao.toxmlparsing;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
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

public class OvenSaver {


    public static void saveAsXML(List<Appliance> appliances) throws TransformerConfigurationException, ParserConfigurationException {
        final String FILE_PATH = "./result.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("OVEN");
        document.appendChild(root);


        for (Appliance appliance : appliances) {
            if (appliance instanceof Oven) {
                Element parameters = document.createElement("PARAMETERS");
                root.appendChild(parameters);

                Element id = document.createElement("ID");
                Element powerConsumption = document.createElement("POWER_CONSUMPTION");
                Element weight = document.createElement("WEIGHT");
                Element capacity = document.createElement("CAPACITY");
                Element depth = document.createElement("DEPTH");
                Element height = document.createElement("HEIGHT");
                Element width = document.createElement("WIDTH");

                id.setTextContent(appliance.getId());
                powerConsumption.setTextContent(String.valueOf(((Oven) appliance).getPowerConsumption()));
                weight.setTextContent(String.valueOf(((Oven) appliance).getWeight()));
                capacity.setTextContent(String.valueOf(((Oven) appliance).getCapacity()));
                depth.setTextContent(String.valueOf(((Oven) appliance).getDepth()));
                height.setTextContent(String.valueOf(((Oven) appliance).getHeight()));
                width.setTextContent(String.valueOf(((Oven) appliance).getWidth()));

                parameters.appendChild(id);
                parameters.appendChild(powerConsumption);
                parameters.appendChild(weight);
                parameters.appendChild(capacity);
                parameters.appendChild(depth);
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
