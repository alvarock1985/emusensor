package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import xyz.acmeapps.api.EmuSensor.model.HistoricDataModel;

public class HistoricData {
	public DataBase db = new DataBase();
	public Statement statement;
	
	public HistoricDataModel getHistoricData(int sensorId){
	HistoricDataModel historicModel = new HistoricDataModel();
	ArrayList<Double>	dataList = historicModel.dataList;
	ArrayList <Timestamp> timeList = historicModel.timeStampList;
		try{
			double dataValue;
			Timestamp timeValue;
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select data, timestamp from datasensor where sensor_sensorid="+sensorId+" order by timestamp desc";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				historicModel.setSensorId(sensorId);
				dataValue = rs.getDouble("data");
				timeValue = rs.getTimestamp("timestamp");
				dataList.add(dataValue);
				timeList.add(timeValue);

			}
			return historicModel;
			
		}catch(Exception e){
			return null;
		}
		
		
		
		
		
	}

}
