package xyz.acmeapps.api.EmuSensor.fuzzy;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProcessDrift {
	public Support supp = new Support();
	public Config config = new Config();
	public Methods met = new Methods();
	public int nAtt = config.getnAtt();
	public int horizonTime  = config.getHorizonTime();
	public int nResources = config.getnResources();
	public String[] attributes = config.getAttributes();
	public double[][][] decision = new double[horizonTime][nAtt][nResources];
	public double[] alpha = config.getAlpha();
	public int[] delta2 = config.getDelta2();
	
	private double[][][] normalizeData(ArrayList<double[][]> allData){
		
		for(int i=0;i<horizonTime;i++){
            double[][] aux = null;
            for(int a=0;a<nAtt;a++){
                for(int b =0;b<nResources;b++){
                    aux = allData.get(b);
                    decision[i][a][b] = aux[i][a];
                }
            }
        }
		
		double[][][] normalDecision = new double[nAtt][horizonTime][allData.size()];
		
        for(int t=0;t<horizonTime;t++){
            double[][] aux = new double[1][1];
            for(int a=0;a<nAtt;a++){
                for(int x=0;x<nResources;x++){
                    double max = supp.getMax(decision[t][a]);                  
                    double min = supp.getMin(decision[t][a]);
                    //System.out.println(Arrays.deepToString(decision[t]));
                    if(attributes[a] == "caudal"){
                        normalDecision[t][a][x] = Math.round((decision[t][a][x]/max)*10000)/10000d;
                    }else{
                        normalDecision[t][a][x] = Math.round((min/decision[t][a][x])*10000)/10000d;
                    }
                }
            }
        }
        return decision;
        //System.out.println(Arrays.deepToString(decision));
	}
	
	public ArrayList<DriftSympthom> calcDrift(ArrayList<double[][]> allData){
		double[][][] decision = this.normalizeData(allData);		
		double[][][][] lvTime = new double[3][3][5][3];
		double[][][] rTime = new double[3][5][3];
		ArrayList<DriftSympthom> drifts = new ArrayList<>();
		
        for(int tt=0;tt<3;tt++){
            //System.out.println(Arrays.deepToString(decision[tt]));
        	
            lvTime[tt] = met.linguisticValues(decision[tt], config.getLinguisticVarNumber());
        }
        
        //System.out.println(Arrays.deepToString(lvTime));
        //System.out.println(Arrays.toString(lvTime[0][0][0]));
        for(int tau=0;tau<3;tau++){



            for(int k=0;k<nAtt;k++){
                int bbool =0;
                for(int p=0;p<config.getLinguisticVarNumber()-2;p++){
                    //System.out.println(p);
                    DriftSympthom ds = met.driftSymptom(lvTime, k, p, tau, delta2[k], config.getRho(), config.getTolerance());
                    int bolnum = (int)ds.getBbool();
                    bbool += bolnum;
                    //System.out.println(delta2[k]);
                    drifts.add(ds);
                }
                if(bbool>= config.getMaxVlCambian()){
                    alpha[k] = config.getAlphaIni();
                    delta2[k] = 1;
                }else{
                    alpha[k] = 0.1;
                }

            }
            
            //double[][] rAgg = met.dynamicAggregator(rTime, (double)tau, delta2, alpha);
            //System.out.println(rAgg[2][4]);
            
            for(int jj=0;jj<config.getnAtt();jj++){
                delta2[jj] += 1;
            }
        }
        return drifts;
	}
}
