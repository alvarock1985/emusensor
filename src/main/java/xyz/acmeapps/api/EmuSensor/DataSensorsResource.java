package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.service.DataSensorService;
import xyz.acmeapps.api.EmuSensor.model.DataSensorDb;
import xyz.acmeapps.api.EmuSensor.model.DataSensorProto;
import xyz.acmeapps.api.EmuSensor.model.SensorData;
@Path("/datasensors")
public class DataSensorsResource {
	
	DataSensorService data = new DataSensorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DataSensorDb> getSensorData(){
		return data.getDataSensor();
	}
	
	@GET
	@Path("/last/{rowNum}/{sensorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DataSensorDb> getLastRows(@PathParam("rowNum") int rowNum, @PathParam("sensorId") int sensorId){
		return data.getLastRows(rowNum, sensorId);
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addDataSensor(DataSensorDb dataSensor){
		data.addDataSensor(dataSensor);
	}
	
	@POST
	@Path("/add/proto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addDataSensorProto(DataSensorProto dataSensor){
		data.addDataSensorProto(dataSensor);
	}

}
