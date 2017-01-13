package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.model.Watershed;
import xyz.acmeapps.api.EmuSensor.service.WatershedService;

public class WatershedServiceTest {

	@Test
	public void test() {
		WatershedService testObject = new WatershedService();
		List<Watershed> testInstance = testObject.getAllRivers();
		Watershed river = testInstance.get(0);
		assertEquals(river.getClass(), Watershed.class);
		
	}

}
