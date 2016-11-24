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
    public List<SensorDataTimestamp> getDataSt(){
    	DataBase db = new DataBase();
    	try {
    		List<SensorDataTimestamp> data2 = new ArrayList<>();
    		Connection con = db.connectToDb();
    		statement = con.createStatement();
    		String query = "select * from station";
    		ResultSet rs = statement.executeQuery(query);
    		while(rs.next()){
    			SensorDataTimestamp sd = new SensorDataTimestamp();
    			sd.setId(rs.getInt("stationid"));
    			sd.setName(rs.getString("description"));
    			data2.add(sd);
    		}return data2;
    	}
    	catch(Exception e){
    		System.out.println(e);
    		return null;
    	}
    }













}
