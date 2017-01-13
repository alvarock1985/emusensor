package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class QuartileDataModelTest {

	@Test
	public void test() {
		QuartileDataModel testModel = new QuartileDataModel();
		testModel.setCauHigh(20);
		double value = testModel.getCauHigh();
		
		assertEquals(20, value, 20);
		
	}

}
