package xyz.acmeapps.api.EmuSensor.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.acmeapps.api.EmuSensor.model.Watershed;

public class WatershedTest {

	@Test
	public void test() {
		Watershed river = new Watershed();
		river.setId(99);
		assertEquals(99, river.getId());
	}

}
