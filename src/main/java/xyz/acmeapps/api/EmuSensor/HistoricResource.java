package xyz.acmeapps.api.EmuSensor;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.acmeapps.api.EmuSensor.data.DataHistoric;
import xyz.acmeapps.api.EmuSensor.model.DataSensor;
import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.service.HistoricService;

@Path("/historic")
public class HistoricResource {
	HistoricService datahistoric = new HistoricService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SensorData> getHistoric(){
		return datahistoric.getHistoricData();
	}
	

}
