package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.parser.InfoCollector;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        // getting a factory to get a document builder afterwards.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // getting a builder that parses XML, creates a Document structure in the form of a hierarchical tree.
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        // getting a parsed document. We now have access to all the elements we need.
        Document document = builder.parse(new File("src/main/resources/XMLFile.xml"));

        // collecting information about each appliance
        InfoCollector.collectInformation(document, InfoCollector.LAPTOP);
        InfoCollector.collectInformation(document, InfoCollector.OVEN);
        InfoCollector.collectInformation(document, InfoCollector.REFRIGERATOR);
        InfoCollector.collectInformation(document, InfoCollector.SPEAKERS);
        InfoCollector.collectInformation(document, InfoCollector.TABLET_PC);
        InfoCollector.collectInformation(document, InfoCollector.VACUUM_CLEANER);

        // Вывод информации
      //  DOMParser.getLaptops().forEach(System.out::println);

		List <Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

       Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
        laptopCriteria.add(SearchCriteria.Laptop.OS.toString(), "Windows");
      laptopCriteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), "18");
     //  laptopCriteria.save(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), "3");

        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1000);

      appliances = service.find(laptopCriteria);
        appliances = service.find(ovenCriteria);
        PrintApplianceInfo.print(appliances);


    }
}

