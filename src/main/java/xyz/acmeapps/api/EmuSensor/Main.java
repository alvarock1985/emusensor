package xyz.acmeapps.api.EmuSensor;


import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.data.SenDataDB;
import xyz.acmeapps.api.EmuSensor.data.StationData;
import xyz.acmeapps.api.EmuSensor.data.Time;
import xyz.acmeapps.api.EmuSensor.model.DataSensorDb;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.model.Station;
import xyz.acmeapps.api.EmuSensor.service.DataSensorService;
import xyz.acmeapps.api.EmuSensor.service.DataTimestampService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.crypto.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 21-11-16.
 */
public class Main {

    public static void main(String[] args) {
    	
    	DataSensorService dss = new DataSensorService();
    	DataSensorDb ds = new DataSensorDb();
    	ds.setData(20);
    	ds.setSensorid(1);
    	Time time = new Time();
    	Timestamp tstmp = time.getTime();
    	//ds.setTimestamp(tstmp);
    	dss.getDataSensor();
    	//dss.addDataSensor(ds);
    	
    	
    	

    	
    }

 }




