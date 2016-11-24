package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp;
import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.service.DataTimestampService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 21-11-16.
 */
public class Main {

    public static void main(String[] args) {

    		DataTimestampService d = new DataTimestampService();
    		
    		SensorDataTimestamp a = d.getStationTs(1, 5);
    		
    		List<SensorDataTimestamp> b = d.getDataTs(5);
    		
 		
    		
    		
    		SensorDataTimestamp aaa = d.getStationTs(1, 5);
    		
    		System.out.println(aaa.getName());
    		
    }

 }




