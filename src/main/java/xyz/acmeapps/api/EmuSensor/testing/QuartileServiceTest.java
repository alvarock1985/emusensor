package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;
import xyz.acmeapps.api.EmuSensor.service.QuartileService;

public class QuartileServiceTest {

	@Test
	public void test() {
		QuartileService testObject = new QuartileService();
		QuartileDataModel testInstance = testObject.getQuartileLastData(1);
		String testString = testInstance.getStationName();
		assertEquals("Rio Copiapo", testString);
	}

}
