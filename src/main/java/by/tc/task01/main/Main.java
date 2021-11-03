package by.tc.task01.main;

import by.tc.task01.dao.fromxmlparsing.DomParser;
import by.tc.task01.dao.toxmlparsing.ApplianceChooser;
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

        DomParser.parseFromXML();

        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //laptop criteria
        Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
        laptopCriteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), "18");
        laptopCriteria.add(SearchCriteria.Laptop.OS.toString(), "Windows");

        //     appliances = service.find(laptopCriteria);

        //oven criteria
        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        ovenCriteria.add(SearchCriteria.Oven.CAPACITY.toString(), "33");
        ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), "2000");

        //    appliances = service.find(ovenCriteria);

        //refrigerator criteria
        Criteria refrigeratorCriteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
        refrigeratorCriteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), "15.0");
        refrigeratorCriteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), "200");

        //       appliances = service.find(refrigeratorCriteria);

        //speakers criteria
        Criteria speakersCriteria = new Criteria(SearchCriteria.Speakers.class.getSimpleName());
        speakersCriteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), "3");
        speakersCriteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), "20");

        appliances = service.find(speakersCriteria);

        //tabletPC criteria
        Criteria tabletPCCriteria = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
        tabletPCCriteria.add(SearchCriteria.TabletPC.COLOR.toString(), "blue");
        tabletPCCriteria.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), "8");

        //         appliances = service.find(tabletPCCriteria);

        //vacuumCleaner criteria
        Criteria vacuumCleanerCriteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
        vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), "20");
        vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), "3000");

        //              appliances = service.find(vacuumCleanerCriteria);


        PrintApplianceInfo.print(appliances);

        try {
            ApplianceChooser.saveAsXml(appliances);
        } catch (TransformerConfigurationException | ParserConfigurationException e) {
            throw new RuntimeException("TransformerConfigurationException | ParserConfigurationException");
        }


    }
}

