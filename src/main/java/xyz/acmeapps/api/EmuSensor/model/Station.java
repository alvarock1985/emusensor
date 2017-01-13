package xyz.acmeapps.api.EmuSensor.model;

public class Station {
	
	private int id;
	private String name;
	private String description;
	private String status;
	private float latitude;
	private float longitude;
	private int watershedId;
	private String type;
	private String watershedName;
	

	public String getWatershedName() {
		return watershedName;
	}
	public void setWatershedName(String watershedName) {
		this.watershedName = watershedName;
	}
	public int getWatershedId() {
		return watershedId;
	}
	public void setWatershedId(int watershedId) {
		this.watershedId = watershedId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	

}
