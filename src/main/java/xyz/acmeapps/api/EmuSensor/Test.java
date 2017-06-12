package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;


import xyz.acmeapps.api.EmuSensor.model.DataSensor;
import xyz.acmeapps.api.EmuSensor.model.DataSensorDb;
import xyz.acmeapps.api.EmuSensor.model.DriftModel;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;
import xyz.acmeapps.api.EmuSensor.model.Sensor;
import xyz.acmeapps.api.EmuSensor.data.DataBase;
import xyz.acmeapps.api.EmuSensor.data.HistoricData;
import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;
import xyz.acmeapps.api.EmuSensor.data.SenDataDB;
import xyz.acmeapps.api.EmuSensor.data.SensorDataDb;
import xyz.acmeapps.api.EmuSensor.fuzzy.Config;
import xyz.acmeapps.api.EmuSensor.fuzzy.DataProcess;
import xyz.acmeapps.api.EmuSensor.fuzzy.DataProcessDrift;
import xyz.acmeapps.api.EmuSensor.fuzzy.DriftSympthom;
import xyz.acmeapps.api.EmuSensor.fuzzy.Methods;

public class Test {

	public static void main(String[] args) {
		
		Methods met = new Methods();


        double[][] x1 = {{0.75,0.85,0.50 },{0.80,0.90,0.45},{0.90,0.85,0.30}};
        double[][] x2 = {{0.95,0.70,0.45},{0.90,0.85,0.40},{0.85,0.90,0.35}};
        double[][] x3 = {{0.80,0.90,0.35},{0.85,0.80,0.40},{0.95,0.85,0.45}};
        double[][] x4 = {{0.90,0.80,0.40},{0.85,0.75,0.50},{0.90,0.80,0.45}};
        double[][] x5 = {{0.85,0.85,0.55},{0.90,0.90,0.60},{0.95,0.85,0.50}};
        
        //estacion X cada llave en un periodo de tiempo, cada elemento es un atributo
        double[][] stationA = {{5,4,1},{10,7,8},{9,5,6}};
        ArrayList<double[][]> allData2 = new ArrayList<>();
        allData2.add(stationA);
        double rho = 0.05;
        int tolerance =3;
        ArrayList<double[][]> allData = new ArrayList<>();
        allData.add(x1);
        allData.add(x2);
        allData.add(x3);
        allData.add(x4);
        allData.add(x5);

        double[] t1 = {1, 2, 3};
        double[] t2 = {2.0,4.0,6.0};
        double[] t3 = {0.0,2.0,8.0};
        double[] t4 = {1.0,1.0,2.0};
        double[] t5 = {0.0,3.0,4.0};
        
        ArrayList<double[]> lV = new ArrayList<>();
        lV.add(t1);
        lV.add(t2);
        lV.add(t3);
        lV.add(t4);
        lV.add(t5);
        
        
		//DriftSympthom ds = met.driftSympthomSimple(lV, rho, tolerance);

		//System.out.println(ds.getBbool());
		//System.out.println(Arrays.toString(ds.getDrift()));
		
		
		QuartileCalc qc =  new QuartileCalc();
		
		DriftModel q = qc.qCalcLast(1);
		DriftSympthom ds = met.driftSympthomSimple(q.getlV(), rho, tolerance);
		System.out.println(ds.getBbool());
		
		
	}

}
