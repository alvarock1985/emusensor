package xyz.acmeapps.api.EmuSensor.fuzzy;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProcess {
	
	Methods met = new Methods();
	Support supp = new Support();
	
	public double[][][] normalizeData(ArrayList<double[][]> allData, int horizonTime, int nAtt, int nResources, String[] attributes){
		
		double[][][] decision = new double[nAtt][horizonTime][allData.size()];		
		
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
                    if(attributes[a] == "benefit"){
                        normalDecision[t][a][x] = Math.round((decision[t][a][x]/max)*10000)/10000d;
                    }else{
                        normalDecision[t][a][x] = Math.round((min/decision[t][a][x])*10000)/10000d;
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(normalDecision));
        return normalDecision;
		
	}
	
	public double[][] dwsFObjCalc(ArrayList<double[][]> allData, Config config){
		double[] alpha = config.getAlpha();
		int[] delta2 = config.getDelta2();
		double[][][] normal = this.normalizeData(allData, config.getHorizonTime(), config.getnAtt(), config.getnResources(), config.getAttributes());
		double[][][][] lvTime = new double[3][3][5][3];
        for(int tt=0;tt<3;tt++){
            //System.out.println(T);
        	//System.out.println(Arrays.deepToString(normal[tt]));
            lvTime[tt] = met.linguisticValues(normal[tt], config.getLinguisticVarNumber());
        }
        
        double[][][] rTime = new double[3][5][3];
        double[][]dwsFObj = new double[3][5];
        for(int tau=0;tau<3;tau++){
        
            for(int tt=0;tt<tau+1;tt++){
                rTime[tt] = met.waOperator(normal[tt], config.getCriteria(), config.getUserRequiredLevel(), lvTime[tt]);
            }

            for(int k=0;k<config.getnAtt();k++){
                int bbool =0;
                for(int p=0;p<config.getLinguisticVarNumber();p++){
                    //System.out.println(p);
                    DriftSympthom ds = met.driftSymptom(lvTime, k, p, tau, config.getDelta2()[k], config.getRho(), config.getTolerance());
                    int bolnum = (int)ds.getBbool();
                    bbool += bolnum;
                    
                    //System.out.println(bbool);
                }
                if(bbool>= config.getMaxVlCambian()){
                    alpha[k] = config.getAlphaIni();
                    delta2[k] = 1;
                }else{
                    alpha[k] = 0.1;
                }

            }

            double[][] rAgg = met.dynamicAggregator(rTime, (double)tau, delta2, alpha);
            //System.out.println(rAgg[2][4]);
            for(int j=0;j<rAgg[0].length;j++){
                double count =0;
                for(int k=0;k<config.getnAtt();k++){
                    count += Math.round(rAgg[k][j] * config.getwUser()[k]*1000)/1000d;
                    //System.out.println(count);
                    //System.out.println(rAgg[k][j]);
                    //System.out.println(wUser[k]);

                }
                dwsFObj[tau][j] = Math.round(count*100)/100d;
            }
            for(int jj=0;jj<config.getnAtt();jj++){
                delta2[jj] += 1;
            }
        }
		return dwsFObj;
		
	}
	
	
	

}
