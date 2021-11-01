package by.tc.task01.dao.toxmlparser;

import by.tc.task01.entity.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.util.List;

public class ApplianceChooser {

    public static void saveAsXml(List<Appliance> appliances) throws TransformerConfigurationException, ParserConfigurationException {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Laptop) {
                LaptopSaver.saveAsXML(appliances);
            } else if (appliance instanceof Oven) {
                OvenSaver.saveAsXML(appliances);
            } else if (appliance instanceof Refrigerator) {
                RefrigeratorSaver.saveAsXML(appliances);
            } else if (appliance instanceof Speakers) {
                SpeakersSaver.saveAsXML(appliances);
            } else if (appliance instanceof TabletPC) {
                TabletPcSaver.saveAsXML(appliances);
            } else if (appliance instanceof VacuumCleaner) {
                VacuumCleanerSaver.saveAsXML(appliances);
            }
        }
    }
}

