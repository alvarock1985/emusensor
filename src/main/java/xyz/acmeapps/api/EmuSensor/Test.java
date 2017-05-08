package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import xyz.acmeapps.api.EmuSensor.model.DataSensor;
import xyz.acmeapps.api.EmuSensor.model.Sensor;
import xyz.acmeapps.api.EmuSensor.data.DataBase;
import xyz.acmeapps.api.EmuSensor.data.HistoricData;
import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;
import xyz.acmeapps.api.EmuSensor.data.SenDataDB;
import xyz.acmeapps.api.EmuSensor.data.SensorDataDb;

public class Test {

	public static void main(String[] args) {
		
		Statement statement;
		SensorDataDb sd = new SensorDataDb();
		List<Sensor> sensors = sd.getSensorData();
		
		Random randomGen = new Random();
		SenDataDB datai = new SenDataDB();
		
		for(int x = 10;x<=23;x++){
			for(int i=0; i<sensors.size(); i++){
				int data = randomGen.nextInt(15);
				DataSensor ds = new DataSensor();
				int dataId = datai.getMaxSensorId();
				int sensorId = sensors.get(i).getId();
				try{
					DataBase db = new DataBase();
					Connection con = db.connectToDb();
					statement = con.createStatement();
					String insert = "insert into datasensor (dataid, sensor_sensorid, data, timestamp) \n "
						+"values ('"+dataId+"','"+sensorId+"','"+data+"',to_timestamp(' 2017/04/28 "+x+":00:00.0000','YYYY/MM/DD HH24:MI:SS.FF'))";

					System.out.println(insert);
					statement.executeUpdate(insert);
					
					statement.close();
					con.close();
				}
				catch(Exception e){
					System.out.println(e);
				}
			
		}

		}
		
		
		
		
		
	}

}
