package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.model.Sensor;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.service.SensorService;

@Path ("/sensors")
public class SensorResource {
	
	SensorService data = new SensorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sensor> getSensors(){
		return data.getAllSensors();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addSensor(Sensor sensor){
		data.addSensor(sensor);
	}
	
	@POST
	@Path("/updateStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSensorStatus(Sensor sensor){
		data.updateSensorStatus(sensor);
	}
	
	@GET
	@Path("/{sensorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sensor> getSensor(@PathParam("sensorId") int sensorId){
		return data.getSensor(sensorId);
	}
}
