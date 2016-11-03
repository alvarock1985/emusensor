package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.model.Sensor;
import xyz.acmeapps.api.EmuSensor.service.SensorService;

@Path ("/sensors")
public class SensorResource {
	
	SensorService sensor = new SensorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sensor> getSensors(){
		return sensor.getAllSensors();
	}
	
	

}
