/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmondcg;

import static algoritmondcg.AlgoritmoNDCG.extraercol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class prueba {
 
 
    static double [] list;
    static int IdUser = 0, IdMovie = 1, Rat = 2, Pred = 3;
    public static void main(String[] args) {
        double [][] M = {
            {1,4,3,1.5},
            {2,2,4,4.5},
            {1,9,4,3.2},
            {3,1,3,3.3},
            {1,5,5,4.5},
            {3,6,2,1.2},
            {2,3,3,3.5}
        };
//        double log;
//                log=logaritmo(2, 4);
//        System.out.println("  "+log);
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j]+"  ");
            }
            System.out.println();
        }
        longitudusers(M);
        
    }
    
    
    static boolean numero(double num){
        for(int i=0; i<list.length;i++){
            if(list[i]==num){
                return false;
            }
        }
        return true;
    }
    private static Double logaritmo(double num, double base) {
      return (Math.log(num)/Math.log(base));
    }
    
    static void longitudusers(double[][] m) {
        int limit = m.length, cont = 0;
        double[] aux = new double[limit];
        list= new double [limit];
        List<Double> VU = new ArrayList<Double>();
//        double [] VU = new double[m.length];//VU = valores Unicos
        //numero de columna
        int numC=0;
        for (int i = 0; i < limit; i++) {
            double nuevo;
            nuevo = m[i][numC] * 1.0;
            aux[i] = nuevo;
        }
        
        for (int i = 0; i < aux.length; i++) {
            int cont2 = 0;
            for (int j = 0; j < aux.length; j++) {
                    if (aux[i] == aux[j]) {
                        cont2++;
                        if(numero(aux[i])){
                            list[i]=aux[i];
                        }
                    }
            }
            if(list[i]!=0){
                VU.add(list[i]);
//                System.out.println(cont);
//                System.out.println(list[i]+" se repite: "+cont2);
                cont++;
            }           
        }
        double [][] dcgP = new double [m.length][m.length];
        double [][] suma = new double [m.length][m.length];
        double log, axp = 0, axr=0;
        for (int i = 0; i < VU.size(); i++) {
            double sum=0;
            for (int j = 0; j < m.length; j++) {
                if (VU.get(i) == m[j][IdUser]) {
                    axp = m[j][Pred];
//                    System.out.println(axp);
                    log = logaritmo(m[j][IdUser]+1, 2);
//                    System.out.println(log);
                    dcgP[i][j]=axp/log;
//                    System.out.println(dcgP[i][j]);
                    sum=sum+dcgP[i][j];
//                    System.out.println(sum);
                    suma[i][j]= sum;
                    System.out.println(suma[i][j]);
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(suma[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("longitud de usuarios: "+cont);
        
    }
}
