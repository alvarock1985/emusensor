package xyz.acmeapps.api.EmuSensor.fuzzy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Support {
    public double getMax(double[] list){
        double value = 0;
        ArrayList<Double> aux = new ArrayList<>();
        for(int i=0;i<list.length;i++){
            aux.add(list[i]);
        }
        value = Collections.max(aux);
        return value;
    }

    public double getMin(double[] list){
        double value = 0;
        ArrayList<Double> aux = new ArrayList<>();
        for(int i=0;i<list.length;i++){
            aux.add(list[i]);
        }
        value = Collections.min(aux);
        return value;
    }


    public int getMaxIndex(double[] list){
        int index;
        double value = 0;
        ArrayList<Double> aux = new ArrayList<>();
        for(int i=0;i<list.length;i++){
            aux.add(list[i]);
        }
        value = Collections.min(aux);

        index = Arrays.asList(list).indexOf(value)+1;

        return index;
    }

    public double[] sortDoubleArray(double[] list){
        ArrayList<Double> aux = new ArrayList<>();
        for(int i=0;i<list.length;i++){
            aux.add(list[i]);
        }

        Collections.sort(aux);
        double[] sorted = new double[aux.size()];
        for(int i=0;i<sorted.length;i++){
            sorted[i] = aux.get(i);
        }

        return sorted;
    }
    public int[] dobToInt(double [] list){
        int[] intList = new int[list.length];
        for(int i=0;i<list.length;i++){
            intList[i] = (int)list[i];
        }

        return intList;
    }

    public int[] ceilOnList(double[] list){
        int[] result = new int[list.length];
        for(int i=0;i<list.length;i++){
            if(list[i]-(int)list[i]==0){
                result[i] = (int)list[i];
            }else{
                result[i] = (int)list[i]+1;
            }
        }
        return result;
    }

    public double[] multListInt(double[] list, int mult){
        double[] result = new double[mult];
        for(int i=0;i<mult;i++){
            result[i] = list[0];
        }
        return result;

    }

    public double[] calcDelta(int val){
        int count =0;
        int delta = 100/(val-1);
        double[] p = new double[val];

        for(int i=0;i<101;i+=delta){
            if(i==0){
                count = 0;
                p[count] = i;
            }else{
                count++;
                p[count] = i;
            }
        }
        return p;
    }

    public int countList(double[] list, double query){
        ArrayList<Double> aux = new ArrayList<>();
        for(int i=0;i<list.length;i++){
            aux.add(list[i]);
        }
        int result = Collections.frequency(aux, query);
        return result;
    }

    public int boolToInt(Boolean bol){
        int result;
        if(bol){
            result = 1;
        }
        else{
            result = 0;
        }
        return result;
    }
}
