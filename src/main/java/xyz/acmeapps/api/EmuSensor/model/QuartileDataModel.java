package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;

public class QuartileDataModel {
	
	private String stationName;
	private double tempMin;
	private double tempLow;
	private double tempMid;
	private double tempHigh;
	private double tempMax;
	private double humMin;
	private double humLow;
	private double humMid;
	private double humHigh;
	private double humMax;
	private double cauMin;
	
	public ArrayList<Double> tempArray = new ArrayList<>();
	public ArrayList<Double> cauArray = new ArrayList<>();
	public ArrayList<Double> humArray = new ArrayList<>();
	public ArrayList<Double> prepArray = new ArrayList<>();
	public ArrayList<Double> otherArray = new ArrayList<>();
	
	public double getHumMid() {
		return humMid;
	}
	public void setHumMid(double humMid) {
		this.humMid = humMid;
	}
	private double cauLow;
	private double cauMid;
	private double cauHigh;
	private double cauMax;
	private double prepMin;
	private double prepLow;
	private double prepMid;
	private double prepHigh;
	private double prepMax;
	private double otherMin;
	private double otherLow;
	private double otherMid;
	private double otherHigh;
	private double otherMax;
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public double getTempMin() {
		return tempMin;
	}
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}
	public double getTempLow() {
		return tempLow;
	}
	public void setTempLow(double tempLow) {
		this.tempLow = tempLow;
	}
	public double getTempMid() {
		return tempMid;
	}
	public void setTempMid(double tempMid) {
		this.tempMid = tempMid;
	}
	public double getTempHigh() {
		return tempHigh;
	}
	public void setTempHigh(double tempHigh) {
		this.tempHigh = tempHigh;
	}
	public double getTempMax() {
		return tempMax;
	}
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}
	public double getHumMin() {
		return humMin;
	}
	public void setHumMin(double humMin) {
		this.humMin = humMin;
	}
	public double getHumLow() {
		return humLow;
	}
	public void setHumLow(double humLow) {
		this.humLow = humLow;
	}
	public double getHumHigh() {
		return humHigh;
	}
	public void setHumHigh(double humHigh) {
		this.humHigh = humHigh;
	}
	public double getHumMax() {
		return humMax;
	}
	public void setHumMax(double humMax) {
		this.humMax = humMax;
	}
	public double getCauMin() {
		return cauMin;
	}
	public void setCauMin(double cauMin) {
		this.cauMin = cauMin;
	}
	public double getCauLow() {
		return cauLow;
	}
	public void setCauLow(double cauLow) {
		this.cauLow = cauLow;
	}
	public double getCauMid() {
		return cauMid;
	}
	public void setCauMid(double cauMid) {
		this.cauMid = cauMid;
	}
	public double getCauHigh() {
		return cauHigh;
	}
	public void setCauHigh(double cauHigh) {
		this.cauHigh = cauHigh;
	}
	public double getCauMax() {
		return cauMax;
	}
	public void setCauMax(double cauMax) {
		this.cauMax = cauMax;
	}
	public double getPrepMin() {
		return prepMin;
	}
	public void setPrepMin(double prepMin) {
		this.prepMin = prepMin;
	}
	public double getPrepLow() {
		return prepLow;
	}
	public void setPrepLow(double prepLow) {
		this.prepLow = prepLow;
	}
	public double getPrepMid() {
		return prepMid;
	}
	public void setPrepMid(double prepMid) {
		this.prepMid = prepMid;
	}
	public double getPrepHigh() {
		return prepHigh;
	}
	public void setPrepHigh(double prepHigh) {
		this.prepHigh = prepHigh;
	}
	public double getPrepMax() {
		return prepMax;
	}
	public void setPrepMax(double prepMax) {
		this.prepMax = prepMax;
	}
	public double getOtherMin() {
		return otherMin;
	}
	public void setOtherMin(double otherMin) {
		this.otherMin = otherMin;
	}
	public double getOtherLow() {
		return otherLow;
	}
	public void setOtherLow(double otherLow) {
		this.otherLow = otherLow;
	}
	public double getOtherMid() {
		return otherMid;
	}
	public void setOtherMid(double otherMid) {
		this.otherMid = otherMid;
	}
	public double getOtherHigh() {
		return otherHigh;
	}
	public void setOtherHigh(double otherHigh) {
		this.otherHigh = otherHigh;
	}
	public double getOtherMax() {
		return otherMax;
	}
	public void setOtherMax(double otherMax) {
		this.otherMax = otherMax;
	}
	
	
	

}
