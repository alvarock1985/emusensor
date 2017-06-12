package xyz.acmeapps.api.EmuSensor.fuzzy;



public class Similarity {
    double similarity;
    double interception;
    Boolean signDrift;
    
    public double getSimilarity() {
        return similarity;
    }
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
    public double getInterception() {
        return interception;
    }
    public void setInterception(double interception) {
        this.interception = interception;
    }
    public Boolean getSignDrift() {
        return signDrift;
    }
    public void setSignDrift(Boolean signDrift) {
        this.signDrift = signDrift;
    }


}
