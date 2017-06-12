package xyz.acmeapps.api.EmuSensor.fuzzy;

public class DriftSympthom {

    private double bbool;
    private double[] drift;
    private double driftSingle;

    public double getDriftSingle() {
		return driftSingle;
	}
	public void setDriftSingle(double driftSingle) {
		this.driftSingle = driftSingle;
	}
	public double getBbool() {
        return bbool;
    }
    public void setBbool(double bbool) {
        this.bbool = bbool;
    }
    public double[] getDrift() {
        return drift;
    }
    public void setDrift(double[] drift) {
        this.drift = drift;
    }

}
