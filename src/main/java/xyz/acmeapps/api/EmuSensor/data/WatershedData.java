package xyz.acmeapps.api.EmuSensor.data;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import xyz.acmeapps.api.EmuSensor.model.Watershed;

public class WatershedData {
	public DataBase db = new DataBase();
	public Statement statement;
	public List<Watershed> getAllRivers(){
		
		try{
			List<Watershed> riverList = new ArrayList<Watershed>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from watershed";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Watershed river = new Watershed();
				river.setId(rs.getInt("id"));
				river.setName(rs.getString("name"));
				riverList.add(river);
			}
			
			return riverList;
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
		
		
		
	}

}
