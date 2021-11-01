package by.tc.task01.dao.fromxmlparser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {


    public static void parseFromXML() throws ParserConfigurationException, IOException, SAXException {
        // getting a factory to get a document builder afterwards.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // getting a builder that parses XML, creates a Document structure in the form of a hierarchical tree.
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        // getting a parsed document. We now have access to all the elements we need.
        Document document = builder.parse(new File("src/main/resources/XMLFile.xml"));

        InfoCollector.collectInformation(document, InfoCollector.LAPTOP);
        InfoCollector.collectInformation(document, InfoCollector.OVEN);
        InfoCollector.collectInformation(document, InfoCollector.REFRIGERATOR);
        InfoCollector.collectInformation(document, InfoCollector.SPEAKERS);
        InfoCollector.collectInformation(document, InfoCollector.TABLET_PC);
        InfoCollector.collectInformation(document, InfoCollector.VACUUM_CLEANER);
    }
    //  Document document = builder.parse(new File("src/main/resources/XMLFile.xml"));
}
