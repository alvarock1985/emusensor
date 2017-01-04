package xyz.acmeapps.api.EmuSensor.calc;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double[] values = new double[5];
		
//		Random rnd = new Random();
//		for(int i=0;i<5;i++){
//			values[i]=rnd.nextDouble();
//		}
		/*for(int i=0;i<5;i++){
			System.out.print(values[i]);
		}*/
		//System.out.println("\n");
		double[] responseTime = {3, 5, 2, 7, 6, 4, 9};
		//RESPONSE TIME menos es mejor
		double min = Quartile.min(responseTime);
		double MedianaVA = Quartile.quartile(responseTime, 25);
		double MedianaA = Quartile.quartile(responseTime, 50);
		double MedianaAA = Quartile.quartile(responseTime, 75);
		double max = Quartile.max(responseTime);
		
		System.out.println("EA class: " + " minEA="+ min + " MedianaEA=" + min + " maxEA="+MedianaVA );
		System.out.println("VA class: " + " minVA="+ min + " MedianaVA="+MedianaVA + " maxVA="+MedianaA );
		System.out.println("A class: " + " minA="+ MedianaVA + " MedianaA="+MedianaA + " maxA="+MedianaAA );
		System.out.println("AA class: " + " minAA="+ MedianaA + " MedianaAA="+MedianaAA + " maxAA="+max );
		System.out.println("PA class: " + " minPA="+ MedianaAA + " MedianaPA="+max + " maxPA="+max );
		//RELIABILITY mas es mejor
		
		
		}

}
