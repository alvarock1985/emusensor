package xyz.acmeapps.api.EmuSensor;


import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.data.StationData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.model.Station;
import xyz.acmeapps.api.EmuSensor.service.DataTimestampService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 21-11-16.
 */
public class Main {

    public static void main(String[] args) {

    	DataTimeStmp2 s = new DataTimeStmp2();
    	
    	List<SensorDataTimestamp> a = s.getDataArrayTs(5);
    	
     	
    	System.out.println(a.get(1).dataArrayCau);
    	
    	
    	
    		
    }

 }




