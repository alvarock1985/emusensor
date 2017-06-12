package xyz.acmeapps.api.EmuSensor;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.fuzzy.DriftSympthom;

import xyz.acmeapps.api.EmuSensor.service.DriftService;

@Path("/drift")
public class DriftResource {
	
	DriftService data = new DriftService();
	
	@GET
	@Path("/{sensorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public DriftSympthom getStation(@PathParam("sensorId") int sensorId){
		return data.getDriftObj(sensorId);
	}

}


