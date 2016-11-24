package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp;
import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 21-11-16.
 */
public class Main {

    public static void main(String[] args) {

    		DataTimeStmp2 dt = new DataTimeStmp2();
    		
    		List<SensorDataTimestamp> a = dt.getDataTs();
    		
    		for(int i=0;i<a.size();i++){
    			System.out.println(a.get(i).getName());
    			System.out.println(a.get(i).getTempData());
    			System.out.println(a.get(i).getHumData());
    			System.out.println(a.get(i).getCaudalData());
    			
    			
    		}
    		
    		
    	


        }






 }




