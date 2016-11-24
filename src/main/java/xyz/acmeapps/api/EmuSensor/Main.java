package xyz.acmeapps.api.EmuSensor;


import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.data.StationData;
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

    	StationData s = new StationData();
    	
    	
    	s.insertStationData("name", "test", "failed", -11.222222, -22.2222222);
    	
    		
    }

 }




