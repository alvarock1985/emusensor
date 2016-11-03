package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.service.StationService;
import xyz.acmeapps.api.EmuSensor.model.Station;

@Path("/stations")
public class StationResource {
	StationService data = new StationService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Station> getStation(){
		return data.getAllStations();
	}
	

}
