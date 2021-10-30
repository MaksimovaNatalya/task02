package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliances)  {

		System.out.println(appliances);

		for (Appliance appliance : appliances) {
		if (appliance instanceof Laptop) {
			try {
				LaptopSaver.saveAsXML(appliances);
			} catch (ParserConfigurationException | TransformerConfigurationException e) {
				throw new RuntimeException("ParserConfigurationException | TransformerConfigurationException");
			}
		} else if (appliance instanceof Oven) {
			try {
				OvenSaver.saveAsXML(appliances);
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				throw new RuntimeException("ParserConfigurationException | TransformerConfigurationException");
			}
		}
		}
		//save as txt-file
//		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("note.txt")));
//		writer.write(String.valueOf(appliance));
//		writer.close();
	}
	
	// you may add your own code here

}
