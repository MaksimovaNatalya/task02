package by.tc.task01.service.filtering;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class TabletPCFinder {
    public static List<Appliance> findTabletPC(Criteria criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        List<TabletPC> tabletPCs = applianceDAO.getTabletPCs();
        List<TabletPC> matchingTabletPCs = new ArrayList<>();

        Set entrySet = criteria.entrySet();
        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            String key = (String) mapEntry.getKey();
            Object expectedValue = mapEntry.getValue();


            for (TabletPC tabletPC : tabletPCs) {

                if (SearchCriteria.TabletPC.BATTERY_CAPACITY.toString().equals(key)
                        && (expectedValue.equals(tabletPC.getBatteryCapacity()))) {
                    matchingTabletPCs.add(tabletPC);
                }
                if (SearchCriteria.TabletPC.DISPLAY_INCHES.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(tabletPC.getDisplayInches())))) {
                    matchingTabletPCs.add(tabletPC);
                }
                if (SearchCriteria.TabletPC.MEMORY_ROM.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(tabletPC.getMemoryRom())))) {
                    matchingTabletPCs.add(tabletPC);
                }
                if (SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(tabletPC.getFlashMemoryCapacity())))) {
                    matchingTabletPCs.add(tabletPC);
                }
                if (SearchCriteria.TabletPC.COLOR.toString().equals(key)
                        && (expectedValue.equals(String.valueOf(tabletPC.getColor())))) {
                    matchingTabletPCs.add(tabletPC);
                }
            }
            tabletPCs = matchingTabletPCs;
            matchingTabletPCs = new ArrayList<>();
        }
        return new ArrayList<>(tabletPCs);
    }
}
