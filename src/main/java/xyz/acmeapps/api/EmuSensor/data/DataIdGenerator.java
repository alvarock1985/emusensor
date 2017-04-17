package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataIdGenerator {

	DataBase db = new DataBase();
	public Statement statement;
	public ArrayList<Integer> dataIdList = new ArrayList<>();
	
	public int getDataId(){
		int dataId = 0;
		try{
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select max(dataid) as data from datasensor";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				dataId = rs.getInt("data")+1;
			}
			con.close();
			statement.close();
			rs.close();
			return dataId;
		}catch(Exception e){
			System.out.println("Error");
			return 0;
		}
		
	}
}
