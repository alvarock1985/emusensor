package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.service.DataTimestampService;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

@Path("/dataonhours")
public class DataTimestampResource {
	
	DataTimestampService data = new  DataTimestampService();
	
	
	@GET
	@Path("/{num}/{riverId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SensorDataTimestamp> getDataTimestmpAll(@PathParam("num") int num, @PathParam("riverId") int riverId){
		return data.getDataTs(num, riverId);
	}
	
	
	@GET
	@Path("/{num}/{id}/{riverId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SensorDataTimestamp  getDataArray(@PathParam("num") int num, @PathParam("id") int id, @PathParam("riverId") int riverId){
		return data.getDataArray(id, num, riverId);
	}
	
	
	
	
	
	
	
	

}
