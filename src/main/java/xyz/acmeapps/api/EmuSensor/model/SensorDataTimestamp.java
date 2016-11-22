package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;

/**
 * Created by alvaro on 21-11-16.
 */
public class SensorDataTimestamp {

    private int id;
    private String name;
    private int humData;
    private int caudalData;
    private int tempData;

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





    public int getHumData() {
        return humData;
    }

    public void setHumData(int humData) {
        this.humData = humData;
    }

    public int getCaudalData() {
        return caudalData;
    }

    public void setCaudalData(int caudalData) {
        this.caudalData = caudalData;
    }

    public int getTempData() {
        return tempData;
    }

    public void setTempData(int tempData) {
        this.tempData = tempData;
    }
}
