package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class quartileCalcTest {

	@Test
	public void test() {
		
		
		QuartileCalc quartileTest = new QuartileCalc();
		QuartileDataModel modelTest = quartileTest.quartileCalcLastData(1);
		String riverName = modelTest.getStationName();
		boolean correctClass;
		if(modelTest.getClass()==QuartileDataModel.class){
			correctClass =  true;
		}else{
			correctClass = false;
		}
		assertEquals("Rio Copiapo", riverName);
		assertTrue(correctClass);
		
	}

}
