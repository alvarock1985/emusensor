package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.service.DataTimestampService;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

@Path("/datatimestamp")
public class DataTimestampResource {
	
	DataTimestampService data = new  DataTimestampService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SensorDataTimestamp> getDataTimestmp(){
		return data.getDataTs();
		
		
		
	}
	
	
	
	
	

}
