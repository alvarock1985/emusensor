package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.service.DataSensorService;
import xyz.acmeapps.api.EmuSensor.model.SensorData;
@Path("/datasensors")
public class DataSensorsResource {
	
	DataSensorService data = new DataSensorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SensorData> getSensorData(){
		return data.getDataSensor();
	}

}
