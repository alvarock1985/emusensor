package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
	
	public Connection connection;
	public Statement statement;
	
	public Connection connectToDb(){
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			String dataBase = "jdbc:oracle:thin:@168.232.165.95:1521:xe";
			connection = DriverManager.getConnection(dataBase, "emuapi","oracle");
			statement = connection.createStatement();
			if (connection != null){
				System.out.println("Connection succesful");
				return connection;
			}else{
				System.out.print("Connection error");
				return null;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			return connection;
		}
	}
	
	public void disconnectFromDb(){
		
		try{
			connection.close();
			System.out.println("Disconnected from db");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
