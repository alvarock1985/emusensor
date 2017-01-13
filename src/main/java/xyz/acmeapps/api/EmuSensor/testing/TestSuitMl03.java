package xyz.acmeapps.api.EmuSensor.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//Test suite for Milestone 03
@RunWith(Suite.class)
@SuiteClasses({ quartileCalcTest.class, QuartileDataModelTest.class, QuartileResourceTest.class,
		QuartileServiceTest.class, WatershedDataTest.class, WatershedResourceTest.class, WatershedServiceTest.class,
		WatershedTest.class })
public class TestSuitMl03 {

	
}
