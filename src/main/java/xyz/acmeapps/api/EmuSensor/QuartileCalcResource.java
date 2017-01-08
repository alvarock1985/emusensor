package xyz.acmeapps.api.EmuSensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;


import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;
import xyz.acmeapps.api.EmuSensor.service.QuartileService;

@Path("/quartile")
public class QuartileCalcResource {
	
	public QuartileService data = new QuartileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public QuartileDataModel getQuartileData(){
		return data.getQuartileCalc();
		
		
	}
	
	
	

}
