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

		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////
        Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
        laptopCriteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), "3");
     //   laptopCriteria.save(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), "3");

        appliance = service.find(laptopCriteria);


        //////////////////////////////////////////////////////////////////

//		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
//		criteriaOven.add(SearchCriteria.Oven.CAPACITY.toString(), 3);
//
//		appliance = service.find(criteriaOven);
//
		PrintApplianceInfo.print(appliance);

//		//////////////////////////////////////////////////////////////////
//
//		criteriaOven = new Criteria(Oven.class.getSimpleName());
//		criteriaOven.add(Oven.HEIGHT.toString(), 200);
//		criteriaOven.add(Oven.DEPTH.toString(), 300);
//
//		appliance = service.find(criteriaOven);
//
//		PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

//		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
//		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
//		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
//		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);
//
//		appliance = service.find(criteriaOven);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliance);

    }
}

