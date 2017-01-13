package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.WatershedResource;
import xyz.acmeapps.api.EmuSensor.model.Watershed;

public class WatershedResourceTest {

	@Test
	public void test() {
		WatershedResource testObject = new WatershedResource();
		List<Watershed> testInstance = testObject.getAllRivers();
		assertEquals(1, testInstance.get(0).getId());
	}

}
