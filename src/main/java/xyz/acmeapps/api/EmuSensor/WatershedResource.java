package xyz.acmeapps.api.EmuSensor;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.model.Watershed;
import xyz.acmeapps.api.EmuSensor.service.WatershedService;

@Path("/rivers")
public class WatershedResource {
	public WatershedService data = new WatershedService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Watershed> getAllRivers(){
		return data.getAllRivers();
	}
}
