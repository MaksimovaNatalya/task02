package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import junit.framework.TestCase;
import org.junit.Test;

public class CriteriaValidatorTest extends TestCase {
    @Test
    public void testValidateLaptopCriteria() {
        Criteria criteria = new Criteria("Laptop");
        criteria.add(SearchCriteria.Laptop.OS.name(), "Windows");
        criteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY.name(), 2);
        criteria.add(SearchCriteria.Laptop.MEMORY_ROM.name(), 5000);
        criteria.add(SearchCriteria.Laptop.SYSTEM_MEMORY.name(), 1300);
        criteria.add(SearchCriteria.Laptop.CPU.name(), 1.5);
        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.name(), 19);

        boolean actualResult = LaptopValidator.validateLaptopCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("Laptop");
        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.name(), 55);
        actualResult = LaptopValidator.validateLaptopCriteria(criteria);
        assertFalse(actualResult);

        criteria = new Criteria("Laptop");
        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.name(), -55);
        actualResult = LaptopValidator.validateLaptopCriteria(criteria);
        assertFalse(actualResult);
    }

    @Test
    public void testValidateOvenCriteria() {
        Criteria criteria = new Criteria("Oven");
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.name(), 1500);
        criteria.add(SearchCriteria.Oven.WEIGHT.name(), 11);
        criteria.add(SearchCriteria.Oven.CAPACITY.name(), 33);
        criteria.add(SearchCriteria.Oven.DEPTH.name(), 60);
        criteria.add(SearchCriteria.Oven.HEIGHT.name(), 40);
        criteria.add(SearchCriteria.Oven.WIDTH.name(), 70);

        boolean actualResult = OvenValidator.validateOvenCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("Oven");
        criteria.add(SearchCriteria.Oven.WEIGHT.name(), -22);
        actualResult = OvenValidator.validateOvenCriteria(criteria);
        assertFalse(actualResult);

        criteria = new Criteria("Oven");
        criteria.add(SearchCriteria.Oven.WEIGHT.name(), 2222);
        actualResult = OvenValidator.validateOvenCriteria(criteria);
        assertFalse(actualResult);

    }
    @Test
    public void testValidateRefrigeratorCriteria() {
        Criteria criteria = new Criteria("Refrigerator");
        criteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.name(), 100);
        criteria.add(SearchCriteria.Refrigerator.WEIGHT.name(), 20);
        criteria.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY.name(), 300);
        criteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.name(), 10);
        criteria.add(SearchCriteria.Refrigerator.HEIGHT.name(), 200);
        criteria.add(SearchCriteria.Refrigerator.WIDTH.name(), 70);

        boolean actualResult = RefrigeratorValidator.validateRefrigeratorCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("Refrigerator");
        criteria.add(SearchCriteria.Refrigerator.WEIGHT.name(), -22);
        actualResult = RefrigeratorValidator.validateRefrigeratorCriteria(criteria);
        assertFalse(actualResult);

        criteria = new Criteria("Refrigerator");
        criteria.add(SearchCriteria.Refrigerator.WEIGHT.name(), 2222);
        actualResult = RefrigeratorValidator.validateRefrigeratorCriteria(criteria);
        assertFalse(actualResult);

    }
    @Test
    public void testValidateSpeakersCriteria() {
        Criteria criteria = new Criteria("Speakers");
        criteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION.name(), 15);
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name(), 3);
        criteria.add(SearchCriteria.Speakers.CORD_LENGTH.name(), 2);
        criteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE.name(), "2-4");

        boolean actualResult = SpeakersValidator.validateSpeakersCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("Speakers");
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name(), -3);
        actualResult = SpeakersValidator.validateSpeakersCriteria(criteria);
        assertFalse(actualResult);

        criteria = new Criteria("Speakers");
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name(), 33333);
        actualResult = SpeakersValidator.validateSpeakersCriteria(criteria);
        assertFalse(actualResult);
    }
    @Test
    public void testValidateTabletPCCriteria() {
        Criteria criteria = new Criteria("TabletPC");
        criteria.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.name(), 2);
        criteria.add(SearchCriteria.TabletPC.COLOR.name(), "blue");
        criteria.add(SearchCriteria.TabletPC.MEMORY_ROM.name(), 8000);
        criteria.add(SearchCriteria.TabletPC.DISPLAY_INCHES.name(), 14);
        criteria.add(SearchCriteria.TabletPC.BATTERY_CAPACITY.name(), 3);

        boolean actualResult = TabletPCValidator.validateTabletPCCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("TabletPC");
        criteria.add(SearchCriteria.TabletPC.DISPLAY_INCHES.name(), -2);
        actualResult = TabletPCValidator.validateTabletPCCriteria(criteria);
        assertFalse(actualResult);

        criteria = new Criteria("TabletPC");
        criteria.add(SearchCriteria.TabletPC.DISPLAY_INCHES.name(), 2222);
        actualResult = TabletPCValidator.validateTabletPCCriteria(criteria);
        assertFalse(actualResult);
    }
    @Test
    public void testValidateVacuumCleanerCriteria() {
        Criteria criteria = new Criteria("VacuumCleaner");
        criteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.name(), 3000);
        criteria.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.name(), 20);
        criteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE.name(), "all-in-one");
        criteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE.name(), "A2");
        criteria.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.name(), 100);
        criteria.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.name(), "A");

        boolean actualResult = VacuumCleanerValidator.validateVacuumCleanerCriteria(criteria);

        assertTrue(actualResult);

        criteria = new Criteria("VacuumCleaner");
        criteria.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.name(), "A2s2s2");
        actualResult = VacuumCleanerValidator.validateVacuumCleanerCriteria(criteria);
        assertFalse(actualResult);

    }
}