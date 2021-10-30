package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OvenSaver {
    public static void saveAsXML(List<Appliance> appliances) throws TransformerConfigurationException, ParserConfigurationException {
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
            Element powerConsumption = document.createElement("POWER_CONSUMPTION");
            Element weight = document.createElement("WEIGHT");
            Element capacity = document.createElement("CAPACITY");
            Element depth = document.createElement("DEPTH");
            Element height = document.createElement("HEIGHT");
            Element width = document.createElement("WIDTH");

            id.setTextContent(appliance.getId());

            parameters.appendChild(id);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = null;
        try {
            result = new StreamResult(new FileWriter("./result.xml"));
            transformer.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}
