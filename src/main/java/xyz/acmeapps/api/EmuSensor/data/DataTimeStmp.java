package xyz.acmeapps.api.EmuSensor.data;

import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 * Created by alvaro on 21-11-16.
 */
public class DataTimeStmp {
    public Statement statement;
    public DataBase db = new DataBase();
    public Time time = new Time();
    public Timestamp now = time.getTime();
    public Calendar cal = Calendar.getInstance();
    public Timestamp target = new Timestamp(new Date().getTime());
    public int num = 0 ;
    
    
    public List<SensorDataTimestamp> getDataSt(int riverId){
    	
    	try {
    		List<SensorDataTimestamp> data2 = new ArrayList<>();
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select * from station \n"
    				+ "join watershed on station.watershedid = watershed.id \n"
    				+ "where watershed.id = "+riverId;
    		ResultSet rs = statement.executeQuery(query);
    		while(rs.next()){
    			SensorDataTimestamp sd = new SensorDataTimestamp();
    			sd.setId(rs.getInt("stationid"));
    			sd.setName(rs.getString("description"));
    			data2.add(sd);
    		}
    		rs.close();
    		statement.close();
    		con.close();
    		return data2;
    	}
    	catch(Exception e){
    		System.out.println(e);
    		return null;
    	}
    }
    public List<SensorDataTimestamp> getDataTimestamp(int num, int riverId){
    	
    	List<SensorDataTimestamp> stationData = this.getDataSt(riverId);
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target = new Timestamp(cal.getTime().getTime());
    	try{
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select station.stationid, station.description, datasensor.sensor_sensorid, sensor.name, to_char(avg(datasensor.data), '99.99') as data \n"
    						+"from datasensor join sensor on datasensor.sensor_sensorid = sensor.sensorid \n"
    						+"join station on sensor.station_stationid = station.stationid \n"
    						+"join watershed on station.watershedid = watershed.id \n"
    						+"where timestamp >= to_timestamp('"+target+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and timestamp <= to_timestamp('"+now+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and watershed.id = "+riverId+" \n"
    						+"group by station.stationid, station.description, datasensor.sensor_sensorid, sensor.name \n"
    						+"order by station.stationid, station.description, datasensor.sensor_sensorid, sensor.name";
    		ResultSet rs = statement.executeQuery(query);
    		System.out.println(query);
    		while(rs.next()){
    			for(int i=0; i<stationData.size();i++){
    				if(rs.getString("name").equals("temp")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					stationData.get(i).setTempData(rs.getFloat("data"));		
    				}
    				else if(rs.getString("name").equals("hum")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					stationData.get(i).setHumData(rs.getFloat("data"));
    				}
    				else if(rs.getString("name").equals("caudal")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					stationData.get(i).setCaudalData(rs.getFloat("data"));
    				}
    			}
    		}
    		rs.close();
    		statement.close();
    		con.close();
    		return stationData;		
    	}
		catch(Exception e){
			System.out.println(e);
			return null;
		}	
    }

    public List<SensorDataTimestamp> getDataArrayTimestamp(int num, int riverId){
		Timestamp target2 = new Timestamp(new Date().getTime());
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target2 = new Timestamp(cal.getTime().getTime());
    	List<SensorDataTimestamp> dataTs = this.getDataTimestamp(num, riverId);
    	List<SensorDataTimestamp> stationData = this.getDataSt(riverId);
    	
    	try{
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select sensor.name, SENSOR.STATION_STATIONID as stationid, datasensor.data, datasensor.timestamp  from datasensor \n"
    				+"join sensor on DATASENSOR.SENSOR_SENSORID = SENSOR.SENSORID \n"
    				+"where datasensor.timestamp >= to_timestamp('"+target2+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    				+"and datasensor.timestamp <= to_timestamp('"+now+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    				+"order by datasensor.timestamp";
    		ResultSet rs = statement.executeQuery(query);
    		System.out.println(query);
    		while(rs.next()){
    			for(int i=0;i<dataTs.size();i++){
    				if(rs.getString("name").equals("temp")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					dataTs.get(i).dataArrayTemp.add(rs.getInt("data"));
    					dataTs.get(i).dataTimestamp.add(rs.getTime("timestamp"));
    				}
    				else if(rs.getString("name").equals("caudal")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					dataTs.get(i).dataArrayCau.add(rs.getInt("data"));
    				}
    				else if(rs.getString("name").equals("hum")&&stationData.get(i).getId() == rs.getInt("stationid")){
    					dataTs.get(i).dataArrayHum.add(rs.getInt("data"));
    				}
    			}
    			
    		}
    		rs.close();
    		statement.close();
    		con.close();
    		return dataTs;	
    	}
		catch(Exception e){
			System.out.println(e);
			return null;
		}	
	}    	
}












