package by.tc.task01.main;

import by.tc.task01.dao.fromxmlparser.DomParser;
import by.tc.task01.dao.toxmlparser.ToXmlSaver;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerConfigurationException {

//        // getting a factory to get a document builder afterwards.
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        // getting a builder that parses XML, creates a Document structure in the form of a hierarchical tree.
//        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
//        // getting a parsed document. We now have access to all the elements we need.
//        Document document = builder.parse(new File("src/main/resources/XMLFile.xml"));
//      //  Document document = builder.parse(new File("src/main/resources/XMLFile.xml"));
//
//        // collecting information about each appliance
//        InfoCollector.collectInformation(document, InfoCollector.LAPTOP);
//        InfoCollector.collectInformation(document, InfoCollector.OVEN);
//        InfoCollector.collectInformation(document, InfoCollector.REFRIGERATOR);
//        InfoCollector.collectInformation(document, InfoCollector.SPEAKERS);
//        InfoCollector.collectInformation(document, InfoCollector.TABLET_PC);
//        InfoCollector.collectInformation(document, InfoCollector.VACUUM_CLEANER);


        DomParser.parseFromXML();

		List <Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();


       Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
    laptopCriteria.add(SearchCriteria.Laptop.OS.toString(), "Windows");
//    laptopCriteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), "18");
 //    laptopCriteria.add(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), "1500");
        appliances = service.find(laptopCriteria);

//        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
//        ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1000);
//
//       appliances = service.find(ovenCriteria);

        PrintApplianceInfo.print(appliances);

        try {
            ToXmlSaver.saveAsXml(appliances);
        } catch (TransformerConfigurationException | ParserConfigurationException e) {
            throw new RuntimeException("TransformerConfigurationException | ParserConfigurationException");
        }


    }
}

