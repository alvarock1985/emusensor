package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.QuartileCalcResource;
import xyz.acmeapps.api.EmuSensor.calc.Quartile;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class QuartileResourceTest {

	@Test
	public void test() {
		QuartileCalcResource testObject = new QuartileCalcResource();
		QuartileDataModel testInstance = testObject.getQuartileLastData(1);
		boolean correctClass;
		
		if(testInstance.getClass() == QuartileDataModel.class){
			correctClass = true;
		}else{
			correctClass = false;
		}
		
		assertTrue(correctClass);
		
		
		
	}

}
