package xyz.acmeapps.api.EmuSensor.fuzzy;




import java.util.ArrayList;
import java.util.Arrays;

public class Methods {
    int nAtt = 3;
    Support xu = new Support();
    public int count =0;
    public double[] addScalar(double[] x, double[] num){
        if(num.length ==1){
            for(int i=0;i<x.length;i++){
                x[i] += num[0];
            }
        }else{
            for(int i=0;i<x.length;i++){
                x[i] += num[i];
            }
        }
        return x;
    }

    public double[] multScalar(double[] x, double[] num){
        if(num.length ==1){
            for(int i=0;i<x.length;i++){
                x[i] *= num[0];
            }
        }else{
            for(int i=0;i<x.length;i++){
                x[i] *= num[i];
            }
        }
        return x;
    }

    public double[] substractList(double[]x, int[]y){
        double[] aux = new double[5];
        for(int i=0;i<x.length;i++){
            aux[i] = x[i] - y[i];
        }

        return aux;
    }

    public double[] obtainElem(double[] l, int[] ind){
        double[] aux = new double[l.length];
        //ArrayList<Double> aux2 = new ArrayList<>();

        for(int i=0;i<l.length;i++){
            aux[i] = l[i];
        }

        return aux;
    }

    public int ceil(double num){
        int aux = (int)num;
        if(num-aux==0){
            return aux;
        }else{
            return aux+1;
        }
    }

    public double[] percentile(double[] xe, double[]p){
        //
        double[] aux = {0, 25, 50, 75, 100};
        double[] x = xu.sortDoubleArray(xe);
        double[] numero = {1};
        double[] aux2 = {(x.length-1)*0.01};
        double[] trim = this.addScalar(this.multScalar(aux, aux2), numero);
        int[] aux3 = xu.dobToInt(trim);
        int[] aux4 = xu.ceilOnList(trim);

        double[] delta = this.substractList(trim, aux3);
        int[] deltaInt = xu.dobToInt(delta);
        double[] aux5 = xu.multListInt(numero, delta.length);


        double[] result = this.addScalar(this.multScalar(this.obtainElem(x, aux3), delta), this.multScalar(this.obtainElem(x, aux4), this.substractList(aux5, deltaInt)));

        return result;
    }



    public double[][][] linguisticValues(double[][] dd, int nVl){
        int lingVar = 5;
        count =0;
        double[][][] lv = new double[3][1][3];
        int nAtt = 3;
        double[] p = xu.calcDelta(nVl);
        double[] p2 = {0, 25, 50, 75, 100};


        double[][] prc = new double[3][5];
        for(int i=0;i<3;i++){
            double[] aux = dd[i];
            double[] aux2 = this.percentile(aux, p);
            //System.out.println(Arrays.toString(aux2));
            prc[i] = aux2;
        }
        //System.out.println(Arrays.deepToString(prc));
        for(int i=0;i<nAtt;i++){
            lv[i][0][0] = prc[i][0];
            lv[i][0][1] = prc[i][0];
            lv[i][0][2] = prc[i][0];
            for(int j=0;j<lingVar-2;j++){
                //lv[i][1][j] = prc[i][j];
                //lv[i][2][j] = prc[i][j+1];
                //lv[i][3][j] = prc[i][j+2];
            }
            //lv[i][4][0] = prc[i][lingVar-2];
            //lv[i][4][1] = prc[i][lingVar-1];
            //lv[i][4][2] = prc[i][lingVar-1];
        }
        //System.out.println(Arrays.deepToString(lv));
        return lv;
    }

    public Similarity fSimilarity(double[] triang1, double[] triang2){

        double min1 = triang1[0];
        double centroid1 = triang1[1];
        double max1 = triang1[2];
        double min2 = triang2[0];
        double centroid2 = triang2[1];
        double max2 = triang2[2];
        
        //System.out.println(centroid1);
        //System.out.println(centroid2);
        double similarity = 0;
        double interception = 0;
        int signDrift = 0;

        double h1 = 0;
        double h2 = 0;
        double h3 = 0;
        if(centroid1>centroid2){
            double minTemp = min1;
            double centroidTemp = centroid1;
            double maxTemp = max1;

            min1 = min2;centroid1 = centroid2;max1 = max2;
            min2 = minTemp;centroid2=centroidTemp;max2=maxTemp;
            signDrift = -1;

        }else if(centroid1<centroid2){
            signDrift = 1;

        }else{
            Boolean signDriftBol = (max2-min2)>(max1-min1);
            signDrift = xu.boolToInt(signDriftBol);
            //System.out.println(signDriftBol);
        }

        //Cases I --> IV
        if(centroid1 == centroid2){
            if((max1 - min1)<(max2-min2)){
                similarity = (max1 - min1) / (max2 - min2);
            }else{
                similarity = (max2 - min2) / (max1 - min1);
            }
        }

        if(max1 <= min2){
            similarity = 0;
        }

        if(max1 <= max2 && min1 <= min2 && max1 > min2){
            interception = 0.5 * (((max1 - min2) * (max1 - min2)) / (max1 - centroid1 + centroid2 - min2));
            similarity = interception / (0.5 * (max1 - min1 + max2 - min2) - interception);
        }

        if(max1 <= max2 && min1 > min2){
            h1 = (min1 - min2) / (centroid2 - min2 + min1 - centroid1);
            h2 = (max1 - min2) / (centroid2 - min2 + max1 - centroid1);
            interception = 0.5*(max1 - min2)*h2 - 0.5*(min1-min2)*h1;
            similarity = (interception / (0.5 * (max2 - min2 + max1 - min1) - interception));
        }

        if(max1 > max2 && min1 <= min2){
            h1 = (max1 - min2) / (max1 - centroid1 + centroid2 - min2);
            h2 = (max1 - max2) / (max1 - centroid1 + centroid2 - max2);
            interception = 0.5*(max1-min2)*h1 - 0.5*(max1-max2)*h2;
            similarity = interception / (0.5 * (max1 - min1 + max2 - min2) - interception);
        }
        if(max1 > max2 && min1 > min2){
            h1 = (min1 - min2) / (centroid2 - min2 + min1 - centroid1);
            h2 = (max1 - max2) / (max1 - centroid1 + centroid2 - max2);
            h3 = (max1 - min2) / (max1 - centroid1 + centroid2 - min2);
            interception = 0.5*(max1 - min2)*h3 - 0.5*(min1-min2)*h1 - 0.5*(max1-max2)*h2;
            similarity = interception / (0.5 * (max2 - min2 + max1 - min1) - interception);
        }

        if(similarity>=1){
            similarity=1;
        }
        if(similarity<=0){
            similarity=0;
        }
        //System.out.println(signDrift);
        Similarity sim = new Similarity();
        sim.setSimilarity(Math.round(similarity*100)/100d);
        sim.setInterception(Math.round(interception*100)/100d);
        sim.setSignDrift((int)signDrift==1);
        //System.out.println(signDrift==1);
        return sim;
    }

    public double membershipAtLeast(double x, double pe, double[][] a){
        double mu =0;
        int p = (int)pe -1;
        //System.out.println(p);
        if(x< a[p][0]){
            mu =0;
        }else if(x>=a[p][1]){
            mu=1;
        }else{
            mu =  ((a[p][0] - x) / (a[p][0] - a[p][1]));
        }
        return Math.round(mu*100)/100d;
    }

    public double membershipAtMost(double x, double pe, double[][] a){
        double mu =0;
        int p = (int)pe -1;

        if(x<=a[p][1]){
            mu =1;
        }else if(x>a[p][2]){
            mu=0;
        }else{
            mu =  ((a[p][2] - x) / (a[p][1] - a[p][2]));
        }
        return Math.round(mu*100)/100d;
    }

    public double[][] waOperator(double[][] d,String[] criteria, int[]level, double[][][] lv ){
        double[][] r = new double[5][3];
        double [] userRequiredLevel = {4, 4, 2};
        int nAtt=3;
        for(int ii=0;ii<d[0].length;ii++){
            for(int jj=0;jj<nAtt;jj++){
                if(criteria[jj]=="least"){
                    r[ii][jj] = this.membershipAtLeast(d[jj][ii], userRequiredLevel[jj], lv[jj]);
                    //System.out.println(d[jj][ii]);
                    //System.out.println(userRequiredLevel[jj]);
                    //System.out.println(lv[jj]);
                }else if(criteria[jj]=="most"){
                    r[ii][jj] = this.membershipAtMost(d[jj][ii], userRequiredLevel[jj], lv[jj]);
                }
            }
        }
        return r;
    }
    
    public DriftSympthom driftSympthomSimple(ArrayList<double[]> lV,double rho,int tolerance){
    	
        int counter = 0;
        int jj =0;
        double flag=0;
        double bbool=0;
        DriftSympthom df = new DriftSympthom();
        double[] drift = new double[lV.size()];
        double[] tr1 = new double[3];
        double[] tr2 = new double[3];
    	int delta = 1;
    	
    	
    	for(int tt=0;tt<lV.size()-1;tt++){
        	//System.out.println(tt);
            tr1 = lV.get(0);
            //System.out.println(Arrays.toString(tr1));
            tr2 = lV.get(tt+1);
            int count = xu.countList(tr1, tr1[0]);
            //System.out.println(xu.countList(tr1, tr1[0]));
            //if(count == 3){
            //    continue;
            //}
            Similarity sim = this.fSimilarity(tr1, tr2);
            drift[tt] = 1-sim.getSimilarity();
            //System.out.println(drift[jj]);
            //System.out.println(sim.getSignDrift());
            if(Math.abs(drift[jj])*xu.boolToInt(sim.signDrift) > rho){
            	
                //System.out.println(Math.round(Math.abs(drift[jj])*xu.boolToInt(sim.signDrift)*100)/100d);
                if(flag==xu.boolToInt(sim.signDrift)){
                	
                    counter +=1;
                    //System.out.println(counter);
                }else{
                    counter = 0;
                    flag = xu.boolToInt(sim.signDrift);
                    //System.out.println(sim.signDrift);
                }

                //
            }
            jj+=1;
            
        }
    	//System.out.println(counter);
        if(counter >= tolerance){
            bbool = 1;
        }
        
        
        df.setBbool(bbool);
        df.setDrift(drift);
        //System.out.println(Arrays.toString(df.getDrift()));
        //System.out.println(df.getBbool());
        return df;

    	
    }

    public DriftSympthom driftSymptom(double[][][][] lvTime, int attribute, int p, int tau, double delta, double rho,int tolerance){
    	
    	//System.out.println(Arrays.deepToString(lvTime));
        double counter = 0;
        int jj =0;
        double flag=0;
        double bbool=0;
        DriftSympthom df = new DriftSympthom();
        double[] drift = new double[tau];
        double[] tr1 = new double[3];
        double[] tr2 = new double[3];
        //System.out.println(p);
        //System.out.println(tau-(int)delta+1);
        //System.out.println(delta);
        for(int tt=tau-(int)delta+1;tt<tau;tt++){
        	//System.out.println(tt);
            tr1 = lvTime[tt][attribute][0];
            System.out.println(Arrays.toString(tr1));
            tr2 = lvTime[tt+1][attribute][0];
            int count = xu.countList(tr1, tr1[0]);
            //System.out.println(xu.countList(tr1, tr1[0]));
            if(count == 3){
                continue;
            }
            Similarity sim = this.fSimilarity(tr2, tr1);
            drift[tt] = 1-sim.getSimilarity();
            //System.out.println(sim.getSignDrift());

            if(Math.abs(drift[jj])*xu.boolToInt(sim.signDrift) > rho){
                //System.out.println(Math.round(Math.abs(drift[jj])*xu.boolToInt(sim.signDrift)*100)/100d);


                if(flag==xu.boolToInt(sim.signDrift)){
                    counter +=1;
                }else{
                    counter = 0;
                    flag = xu.boolToInt(sim.signDrift);
                }

                //
            }
            jj+=1;
            //System.out.println(jj);
        }

        if(counter >= tolerance){
            bbool = 1;
        }
        
        
        df.setBbool(bbool);
        df.setDrift(drift);
        //System.out.println(Arrays.toString(df.getDrift()));
        //System.out.println(df.getBbool());
        return df;

    }

    public double[][] exponentialWeight(double tau, int [] delta, double[] alpha){
        double[] a1 = {1,1,1};
        double[] b = {tau};
        double[] num = {1};
        double[] ini = this.substractList(this.multScalar(a1, b), delta);
        ini = this.addScalar(ini, num);
        double fin = tau;

        double[][] tW = new double[alpha.length][(int)fin+1];
        for(int a=0;a<alpha.length;a++){
            for(int k=(int)ini[a];k<(int)fin+1;k++){
                double aux = Math.exp(alpha[a]*(k-tau+delta[a])/delta[a])*(1-Math.exp(-alpha[a]/delta[a]))/(Math.exp(alpha[a])-1);
                //System.out.println(a);
                tW[a][k] = Math.round(aux*100)/100d;
            }
        }
        return tW;
    }

    public double[][] dynamicAggregator(double[][][] rTime, double tau, int[] delta, double[] alpha ){
        double[] a = {1,1,1};
        double[] b = {tau};
        double[] num = {1};
        double[] ini = this.substractList(this.multScalar(a, b), delta);
        //
        ini = this.addScalar(ini, num);
        int fin = (int)tau;
        double[][] tW = this.exponentialWeight(tau, delta, alpha);

        double[][][] rT = new double[nAtt][fin+1][rTime[0].length];
        //System.out.println(rTime.length);
        for(int k=0;k<nAtt;k++){

            for(int tt=(int)ini[k];tt<fin+1;tt++){

                for(int j=0;j<rTime[tt].length;j++){
                    //System.out.println(j);
                    rT[k][tt][j] = rTime[tt][j][k];
                    //System.out.println(rT[k][tt][j]);
                }
            }
        }
        //System.out.println(rT[0][0][1]);
        double[][] rAgg = new double[nAtt][rT[0][0].length];
        for(int k=0;k<nAtt;k++){
            for(int j=0;j<rT[k][0].length;j++){
                double summ=0;

                for(int t=0;t<rT[k].length;t++){

                    summ += rT[k][t][j] * tW[k][t];

                }
                rAgg[k][j] = summ;
                //System.out.println(rAgg[k][j] );
            }
        }
        //System.out.println(rAgg[2][4]);
        return rAgg;
    }



}
