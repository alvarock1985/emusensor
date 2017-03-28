package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.model.Station;

public class StationData {
	public Statement statement;
	public DataBase db = new DataBase();
    public Time time = new Time();
    public Timestamp now = time.getTime();
    public Calendar cal = Calendar.getInstance();
    public Timestamp target = new Timestamp(new Date().getTime());
    public int num = 0 ;
    
	public List<Station> getStationData(int watershedId){

		try{
			List<Station> stations = new ArrayList<Station>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select station.stationid, station.name, station.description, station.status, \n"
						+"station.latitude, station.longitude, station.type, watershed.id as watershedid, watershed.name as river \n"
						+"from station join watershed on station.watershed_id = watershed.id \n"
						+"where watershed.id = "+watershedId;
			
			ResultSet rs = statement.executeQuery(query);
			
			
			
			while(rs.next()){
				Station station = new Station();
				station.setId(rs.getInt("stationid"));
				station.setName(rs.getString("name"));
				station.setDescription(rs.getString("description"));
				station.setLatitude(rs.getFloat("latitude"));
				station.setLongitude(rs.getFloat("longitude"));
				station.setWatershedId(rs.getInt("watershedid"));
				station.setType(rs.getString("type"));
				station.setWatershedName(rs.getString("river"));
				stations.add(station);
			}
			rs.close();
			statement.close();
			con.close();
			System.out.println(stations);
			return stations;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<Station> getAllStationsData(){
		try{
			List<Station> stations = new ArrayList<Station>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from station";
			
			ResultSet rs = statement.executeQuery(query);
			
			
			
			while(rs.next()){
				Station station = new Station();
				station.setId(rs.getInt("stationid"));
				station.setName(rs.getString("name"));
				station.setDescription(rs.getString("description"));
				station.setLatitude(rs.getFloat("latitude"));
				station.setLongitude(rs.getFloat("longitude"));
				station.setWatershedId(rs.getInt("watershed_id"));
				station.setType(rs.getString("type"));
				//station.setWatershedName(rs.getString("river"));
				stations.add(station);
			}
			rs.close();
			statement.close();
			con.close();
			System.out.println(stations);
			return stations;
		}
		catch(Exception e){
			return null;
		}
		
		
		
	}
	
	
	public List<SensorDataTimestamp> getStation(int id){
		try{
			
			List<SensorDataTimestamp> data = new ArrayList<>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from station where stationid ="+id;
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()){
				SensorDataTimestamp sd = new SensorDataTimestamp();
				sd.setId(rs.getInt("stationid"));
				sd.setName(rs.getString("description"));
				data.add(sd);
			}
			rs.close();
			statement.close();
			con.close();
			return data;
			
		}catch(Exception e){
			return null;
		}		
	}
	
    public List<SensorDataTimestamp> getStationTime(int stationId){
    	int num = 5;
    	List<SensorDataTimestamp> stationData = this.getStation(stationId);
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target = new Timestamp(cal.getTime().getTime());
    	try{
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select station.stationid, station.description, datasensor.sensor_sensorid, sensor.name, to_char(avg(datasensor.data), '99.99') as data \n"
    						+"from datasensor join sensor on datasensor.sensor_sensorid = sensor.sensorid \n"
    						+"join station on sensor.station_stationid = station.stationid \n"
    						+"join watershed on station.watershed_id = watershed.id \n"
    						+"where timestamp >= to_timestamp('"+target+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and timestamp <= to_timestamp('"+now+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and station.stationid = "+stationId+" \n"
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

	
    public List<SensorDataTimestamp> getDataArrayTime(int stationId){
    	int num = 5;
		Timestamp target2 = new Timestamp(new Date().getTime());
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target2 = new Timestamp(cal.getTime().getTime());
    	List<SensorDataTimestamp> dataTs = this.getStationTime(stationId);
    	List<SensorDataTimestamp> stationData = this.getStation(stationId);
    	
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
    
    
    public List<SensorDataTimestamp> getStationTimeRange(int stationId, int num){
    	
    	List<SensorDataTimestamp> stationData = this.getStation(stationId);
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target = new Timestamp(cal.getTime().getTime());
    	try{
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select station.stationid, station.description, datasensor.sensor_sensorid, sensor.name, to_char(avg(datasensor.data), '99.99') as data \n"
    						+"from datasensor join sensor on datasensor.sensor_sensorid = sensor.sensorid \n"
    						+"join station on sensor.station_stationid = station.stationid \n"
    						+"join watershed on station.watershed_id = watershed.id \n"
    						+"where timestamp >= to_timestamp('"+target+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and timestamp <= to_timestamp('"+now+"', 'yyyy-mm-dd hh24:mi:ss.ff') \n"
    						+"and station.stationid = "+stationId+" \n"
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

	
    public List<SensorDataTimestamp> getDataArrayTimeRange(int stationId, int num){
    	
		Timestamp target2 = new Timestamp(new Date().getTime());
    	cal.setTime(target);
    	cal.add(Calendar.HOUR, - (num+1));
    	target2 = new Timestamp(cal.getTime().getTime());
    	List<SensorDataTimestamp> dataTs = this.getStationTime(stationId);
    	List<SensorDataTimestamp> stationData = this.getStation(stationId);
    	
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
	
	public void insertStationData(Station station){
		
		List<Station> data = this.getAllStationsData();
		int id;
		id = data.size()+1;
		System.out.println(id);
		
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String insert = "insert into station (stationid, name, description, status, latitude, longitude) \n"
							+"values ('"+id+"','"+station.getName()+"','"+station.getDescription()+"','"+station.getStatus()+"','"+station.getLatitude()+"','"+station.getLongitude()+"')";
			statement.executeUpdate(insert);
			statement.close();
			con.close();
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}