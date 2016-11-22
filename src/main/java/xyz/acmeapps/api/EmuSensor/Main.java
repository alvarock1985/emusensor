package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by alvaro on 21-11-16.
 */
public class Main {

    public static void main(String[] args) {


        DataTimeStmp d = new DataTimeStmp();

        for(int i=0;i<d.getDataTs().size();i++){
            System.out.println(d.getDataTs().get(i));


        }






    }



}
