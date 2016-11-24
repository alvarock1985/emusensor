package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

public class DataTimeStmp2 {
    public Statement statement;
    public DataTimeStmp dataTs= new DataTimeStmp();
    public List<SensorDataTimestamp> stData = dataTs.getDataSt();
    public Time time = new Time();
    public Timestamp now = time.getTime();
    public Calendar cal = Calendar.getInstance();
    public Timestamp target = new Timestamp(new Date().getTime());
    public int num = 0 ;
    
	public List<SensorDataTimestamp> getDataTs(int num){
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, -num);
    	target = new Timestamp(cal.getTime().getTime());
    	DataBase db = new DataBase();
    	System.out.println(target);
    	System.out.println(now);
    	try{
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select station.stationid, station.description, datasensor.sensor_sensorid, sensor.name, to_char(avg(datasensor.data), '99.99') as data \n"
    						+"from datasensor join sensor on datasensor.sensor_sensorid = sensor.sensorid \n"
    						+"join station on sensor.station_stationid = station.stationid \n"
    						+"where timestamp >= to_timestamp('"+target+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and timestamp <= to_timestamp('"+now+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"group by station.stationid, station.description, datasensor.sensor_sensorid, sensor.name \n"
    						+"order by station.stationid, station.description, datasensor.sensor_sensorid, sensor.name";
    		ResultSet rs = statement.executeQuery(query);
    		while(rs.next()){
    			for(int i=0; i<stData.size();i++){
    				if(rs.getString("name").equals("temp")&&stData.get(i).getId() == rs.getInt("stationid")){
    					stData.get(i).setTempData(rs.getFloat("data"));		
    				}
    				else if(rs.getString("name").equals("hum")&&stData.get(i).getId() == rs.getInt("stationid")){
    					stData.get(i).setHumData(rs.getFloat("data"));
    				}
    				else if(rs.getString("name").equals("caudal")&&stData.get(i).getId() == rs.getInt("stationid")){
    					stData.get(i).setCaudalData(rs.getFloat("data"));
    				}
    			}
    		}
    		return stData;		
    	}
		catch(Exception e){
			System.out.println(e);
			return null;
		}	
	}
}

