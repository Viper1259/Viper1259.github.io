package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class genegic {
    // y=-x^2+26x+55

    public static double fx(double x) {
        return -x*x+46*x+55;
    }

    public static int[] init() {
        Random r = new Random();
        int[] arr = new int[8];
        for(int i=0; i<8; i++) {
            arr[i] = r.nextInt(31+1);
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

        return arr;
    }

    public static int[] selection(int[] x) {
        int sum = 0;
        double [] f = new double[x.length];
        Random rand = new Random();
        for(int i=0; i<x.length; i++) {
            f[i] = 1/Math.pow(fx(x[i]+rand.nextGaussian())-(fx(x[i]+rand.nextGaussian())+rand.nextGaussian()),2);
            sum += f[i];
        }
        double[] ratio = new double[x.length];
        for(int i=0; i<x.length; i++) {
        	ratio[i] = (double)f[i] / (double)sum;
        }
        int[] sx = new int[x.length];
        Random r = new Random();
        for(int i=0; i<x.length; i++) {
            double p = r.nextDouble();
            		if(p < ratio[0]) sx[i] = x[0];
            		else if(p < ratio[1]) sx[i] = x[1];
            		else if(p < ratio[2]) sx[i] = x[2];
            		else if(p < ratio[3]) sx[i] = x[3];
            		else if(p < ratio[4]) sx[i] = x[4];
            		else if(p < ratio[5]) sx[i] = x[5];
            		else if(p < ratio[6]) sx[i] = x[6];
            		else				  sx[i] = x[7];
            		
        }
        return sx;
    }

    public static String int2String(String x) {
        return String.format("%8s", x).replace(' ', '0');
    }

    public static String[] crossOver(int[] x) {
        String[] arr = new String[x.length];
        for(int i=0; i<x.length; i+=2) {
            String bit1 = int2String(Integer.toBinaryString(x[i]));
            String bit2 = int2String(Integer.toBinaryString(x[i+1]));

            arr[i] = bit1.substring(0, 2) + bit2.substring(2, 5);
            arr[i+1] = bit2.substring(0, 2) + bit1.substring(2, 5);
        }

        return arr;
    }

    public static int invert(String x) {
        Random r = new Random();
        int a = Integer.parseInt(x, 2);
        for(int i=0; i<x.length(); i++) {
            double p = (double)1/ (double)32;
            if(r.nextDouble() < p) {
                a = 1 << i ^ a;
            }
        }
        return a;
    }

    public static double[] mutation(String[] x) {
        double[] arr = new double[x.length];
        for (int i=0; i<x.length; i++) {
            arr[i] = invert(x[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] x = init();
        for(int i=0; i<100; i++) {
            int[] sx = selection(x);			//선택연산
            String[] cx = crossOver(sx);		//교차연산
            double[] mx = mutation(cx);			//돌연변이연산

            Random rand = new Random();
            double[] f = new double[mx.length];
            double max = 0;
            for(int t=0;t<mx.length;t++) {
            	double []rn=new double[mx.length];
            	rn[t] = mx[t]+rand.nextGaussian();
            	System.out.printf("(%.2f, ",rn[t]);
            	System.out.printf("%.2f) ",fx(rn[t])+(rand.nextGaussian()));
            }
            System.out.println();
            for(int j = 0; j <mx.length; j++) {
                f[j] =1/Math.pow(fx(mx[j])-(fx(mx[j])+rand.nextGaussian()),2);
                max = Math.max(max, f[j]);
                System.out.printf("%.2f ", f[j]);
            }
            System.out.println();
            
        }
    }
}