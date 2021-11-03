package by.tc.task01.dao.fromxmlparsing;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {


    public static final String LAPTOP = "Laptop";
    public static final String OVEN = "Oven";
    public static final String REFRIGERATOR = "Refrigerator";
    public static final String SPEAKERS = "Speakers";
    public static final String TABLET_PC = "TabletPC";
    public static final String VACUUM_CLEANER = "VacuumCleaner";
    public static final String XML_FILE_PATH = "src/main/resources/XMLFile.xml";

    public static void parseFromXML() throws ParserConfigurationException, IOException, SAXException {

        // getting a factory to get a document builder afterwards.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        // getting a builder that parses XML, creates a Document structure in the form of a hierarchical tree.
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

        // getting a parsed document. We now have access to all the elements we need.
        Document document = builder.parse(new File(XML_FILE_PATH));


        LaptopInfoCollector.collectLaptopInformation(document, LAPTOP);
        OvenInfoCollector.collectOvenInformation(document, OVEN);
        RefrigeratorInfoCollector.collectRefrigeratorInformation(document, REFRIGERATOR);
        SpeakersInfoCollector.collectSpeakersInformation(document, SPEAKERS);
        TabletPcInfoCollector.collectTabletPcInformation(document, TABLET_PC);
        VacuumCleanerInfoCollector.collectVacuumCleanerInformation(document, VACUUM_CLEANER);
    }
}
