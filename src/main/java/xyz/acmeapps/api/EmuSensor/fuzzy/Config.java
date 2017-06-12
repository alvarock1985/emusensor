package xyz.acmeapps.api.EmuSensor.fuzzy;

public class Config {
	
	Methods met = new Methods();
	
    private int alphaIni = 10;
    private double rho = 0.05;
    private int tolerance = 5;
    private int maxVlCambian =1;
    private double[] delta = {1.0,1.0,1.0};
    private int[] delta2 = {1,1,1};
    private int[] driftDetectado = {0,0,0};
    private Support xu = new Support();
    private double[] alphaIniL = {alphaIni};
    private double[] alpha = met.multScalar(delta, alphaIniL);
    private int linguisticVarNumber = 5;
    //int nAtt = 3;
    private double[] wUser = {0.4,0.3,0.3};
    private String[] criteria = {"most", "most" ,"least"};
    private int[] userRequiredLevel = {4,4,2}; //level

    private String[] resources = {"stationA"};
    private String[] attributes = {"caudal", "precip", "hum"};
    //private String[] resources = {"x1","x2","x3","x4","x5"};
    //private String[] attributes = {"benefit", "benefit", "cost"};
    private int horizonTime = 3;
    private int nResources = resources.length;
    private int nAtt = attributes.length;
    

    
	public int getHorizonTime() {
		return horizonTime;
	}
	public void setHorizonTime(int horizonTime) {
		this.horizonTime = horizonTime;
	}
	public int getnResources() {
		return nResources;
	}
	public void setnResources(int nResources) {
		this.nResources = nResources;
	}
	public int getnAtt() {
		return nAtt;
	}
	public void setnAtt(int nAtt) {
		this.nAtt = nAtt;
	}
	public int getAlphaIni() {
		return alphaIni;
	}
	public void setAlphaIni(int alphaIni) {
		this.alphaIni = alphaIni;
	}
	public double getRho() {
		return rho;
	}
	public void setRho(double rho) {
		this.rho = rho;
	}
	public int getTolerance() {
		return tolerance;
	}
	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}
	public int getMaxVlCambian() {
		return maxVlCambian;
	}
	public void setMaxVlCambian(int maxVlCambian) {
		this.maxVlCambian = maxVlCambian;
	}
	public double[] getDelta() {
		return delta;
	}
	public void setDelta(double[] delta) {
		this.delta = delta;
	}
	public int[] getDelta2() {
		return delta2;
	}
	public void setDelta2(int[] delta2) {
		this.delta2 = delta2;
	}
	public int[] getDriftDetectado() {
		return driftDetectado;
	}
	public void setDriftDetectado(int[] driftDetectado) {
		this.driftDetectado = driftDetectado;
	}
	public Support getXu() {
		return xu;
	}
	public void setXu(Support xu) {
		this.xu = xu;
	}
	public double[] getAlphaIniL() {
		return alphaIniL;
	}
	public void setAlphaIniL(double[] alphaIniL) {
		this.alphaIniL = alphaIniL;
	}
	public double[] getAlpha() {
		return alpha;
	}
	public void setAlpha(double[] alpha) {
		this.alpha = alpha;
	}
	public int getLinguisticVarNumber() {
		return linguisticVarNumber;
	}
	public void setLinguisticVarNumber(int linguisticVarNumber) {
		this.linguisticVarNumber = linguisticVarNumber;
	}
	public double[] getwUser() {
		return wUser;
	}
	public void setwUser(double[] wUser) {
		this.wUser = wUser;
	}
	public String[] getCriteria() {
		return criteria;
	}
	public void setCriteria(String[] criteria) {
		this.criteria = criteria;
	}
	public int[] getUserRequiredLevel() {
		return userRequiredLevel;
	}
	public void setUserRequiredLevel(int[] userRequiredLevel) {
		this.userRequiredLevel = userRequiredLevel;
	}
	public String[] getResources() {
		return resources;
	}
	public void setResources(String[] resources) {
		this.resources = resources;
	}
	public String[] getAttributes() {
		return attributes;
	}
	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
    

    

}
