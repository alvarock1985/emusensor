package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;

public class DriftModel {
	
	private double[] t1 = {1,10,30};
	private double[] t2 = new double[3];
	private double[] t3 = new double[3];
	private double[] t4 = new double[3];
	private double[] t5 = new double[3];
	
	private ArrayList<double[]> lV = new ArrayList<>();
	
	
	public ArrayList<double[]> getlV() {
		return lV;
	}
	public void setlV(ArrayList<double[]> lV) {
		this.lV = lV;
	}
	public double[] getT2() {
		return t2;
	}
	public void setT2(double[] t2) {
		this.t2 = t2;
	}
	public double[] getT3() {
		return t3;
	}
	public void setT3(double[] t3) {
		this.t3 = t3;
	}
	public double[] getT4() {
		return t4;
	}
	public void setT4(double[] t4) {
		this.t4 = t4;
	}
	public double[] getT5() {
		return t5;
	}
	public void setT5(double[] t5) {
		this.t5 = t5;
	}
	
	public double[] getT1() {
		return t1;
	}
	
	
}
