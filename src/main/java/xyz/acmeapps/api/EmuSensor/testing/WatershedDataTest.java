package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.data.WatershedData;

import xyz.acmeapps.api.EmuSensor.model.Watershed;

public class WatershedDataTest {

	@Test
	public void test() {
		WatershedData testObject = new WatershedData();
		List<Watershed> testInstance = testObject.getAllRivers();
		assertFalse(testInstance.isEmpty());
	}

}
