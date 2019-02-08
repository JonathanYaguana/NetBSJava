/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmondcg;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mauricio
 */
public class AlgoritmoNDCG {
    
    /**
     * @param args the command line arguments
     */
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
        double [] VU = new double [limit];
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
                  VU[cont]=list[i];
//                  System.out.println(cont+"  "+VU[cont]);
//                System.out.println(cont);
//                System.out.println(list[i]+" se repite: "+cont2);
                cont++;
            }           
        }
        System.out.println();
        System.out.println("longitud de usuarios: "+cont);
        extraercol(m, cont, VU);
    }
    
    static void extraercol(double[][] m, int cont, double [] VU) {
        int lim = m.length;
        double[] aux1 = new double[lim];
        double[] aux2 = new double[lim];
        double[] aux3 = new double[lim];
        double[] aux4 = new double[lim];
        double [][] pre = new double [lim][m[0].length-1];
        double [][] rat = new double [lim][m[0].length-1];
        int r = 0;
        
        for (int i = 1; i <= cont; i++) {
            double m1,m2,m3,m4;
            for (int j = 0; j < lim; j++) {
                    m1=m[j][IdUser];
                    m2=m[j][IdMovie];
                    m3=m[j][Pred];
                    m4=m[j][Rat];

                    aux1[j]=m1;
                    aux2[j]=m2;
                    aux3[j]=m3;
                    aux4[j]=m4;
            }
        }
        int i1=0;
        for (int i = 0; i < m.length; i++) {
            //prediction
            pre[i1][IdUser] = aux1[i];
            pre[i1][IdMovie] = aux2[i];
            pre[i1][Pred-1] = aux3[i];
            //rating
            rat[i1][IdUser] = aux1[i];
            rat[i1][IdMovie] = aux2[i];
            rat[i1][Rat] = aux4[i];
            i1++;
        }
        
        System.out.println("\n ******* prediction *******");
        //prediction
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[0].length; j++) {
                System.out.print(pre[i][j]+"  \t");
            }
            System.out.println();
        }
        //rating
        System.out.println("\n******* rating *******");
        for (int i = 0; i < rat.length; i++) {
            for (int j = 0; j < rat[0].length; j++) {
                System.out.print(rat[i][j]+"  \t");
            }
            System.out.println();
        }
        ordenarp(pre, rat, cont, VU);
    }
    static void ordenarp(double[][] pre, double [][] rat, int cont, double [] VU){
        double temp0 = 0, temp1=0, temp2=0;     
        double[] tempA = new double[pre.length];
        double[] tempP = new double[pre.length];
        double[] tempR = new double[rat.length];
        
        for (int i = 0; i < pre.length; i++) {
            tempA[i] = pre[i][IdUser];
            tempP[i] = pre[i][IdMovie];
            tempR[i] = rat[i][Rat];
        }

        //prediction        
        for (int i = 0; i < tempP.length; i++) {
            for (int j = 0; j < tempP.length-i-1; j++) {
                if (tempP[j]<tempP[j+1]) {
                    temp0 = tempP[j+1];
                    tempP[j+1] = tempP[j];
                    tempP[j] = temp0;
                }
            }        
        }

        //IdUser
        for (int i = 0; i < tempA.length; i++) {
            for (int j = 0; j < tempA.length-i-1; j++) {
                if (tempA[j]>tempA[j+1]) {
                    temp1 = tempA[j+1];
                    tempA[j+1] = tempA[j];
                    tempA[j] = temp1;
                }
            }        
        }
        
        //rating
        for (int i = 0; i < tempR.length-1; i++) {
            for (int j = 0; j < tempR.length-i-1; j++) {
                if (tempR[j]<tempR[j+1]) {
                    temp0 = tempR[j+1];
                    tempR[j+1] = tempR[j];
                    tempR[j] = temp0;
                }
            }
        }

        //1er ordenamiento prediction en base a la columna 2
        for (int i = 0; i < tempP.length; i++) {
            for (int j = 0; j < pre.length-1; j++) {
                if (tempP[i] == pre[j][IdMovie]) {
                    temp0 = pre[j][IdUser];
                    temp1 = pre[j][IdMovie];
                    temp2 = pre[j][Rat];

                    pre[j][IdUser] = pre[j+1][IdUser];
                    pre[j][IdMovie] = pre[j+1][IdMovie];
                    pre[j][Rat] = pre[j+1][Rat];
                    
                    pre[j+1][IdUser] = temp0;
                    pre[j+1][IdMovie] = temp1;
                    pre[j+1][Rat] = temp2;
                }
            }
        }
        
        //2do ordenamiento prediction en base a la columna 1
        for (int i = 0; i < tempP.length; i++) {
            for (int j = 0; j < pre.length-1; j++) {
                if (tempA[i] == pre[j][IdUser]) {
                    
                    temp0 = pre[j][IdUser];
                    temp1 = pre[j][IdMovie];
                    temp2 = pre[j][Rat];

                    pre[j][IdUser] = pre[j+1][IdUser];
                    pre[j][IdMovie] = pre[j+1][IdMovie];
                    pre[j][Rat] = pre[j+1][Rat];
                    
                    pre[j+1][IdUser] = temp0;
                    pre[j+1][IdMovie] = temp1;
                    pre[j+1][Rat] = temp2;
                }
            }
        }
        //1er ordenamiento rating
        for (int i = 0; i < tempR.length; i++) {
            for (int j = 0; j < rat.length-1; j++) {
                if (tempR[i] == rat[j][Rat]) {
                    temp0 = rat[j][IdUser];
                    temp1 = rat[j][IdMovie];
                    temp2 = rat[j][Rat];

                    rat[j][IdUser] = rat[j+1][IdUser];
                    rat[j][IdMovie] = rat[j+1][IdMovie];
                    rat[j][Rat] = rat[j+1][Rat];
                    
                    rat[j+1][IdUser] = temp0;
                    rat[j+1][IdMovie] = temp1;
                    rat[j+1][Rat] = temp2;
                }
            }
        }
        //2do ordenamiento rating
        for (int i = 0; i < tempR.length; i++) {
            for (int j = 0; j < rat.length-1; j++) {
                if (tempA[i] == rat[j][IdUser]) {
                    
                    temp0 = rat[j][IdUser];
                    temp1 = rat[j][IdMovie];
                    temp2 = rat[j][Rat];

                    rat[j][IdUser] = rat[j+1][IdUser];
                    rat[j][IdMovie] = rat[j+1][IdMovie];
                    rat[j][Rat] = rat[j+1][Rat];
                    
                    rat[j+1][IdUser] = temp0;
                    rat[j+1][IdMovie] = temp1;
                    rat[j+1][Rat] = temp2;
                }
            }
        }
        
        System.out.println();  
        
        System.out.println("Matriz ordenada decrecientemente");
        System.out.println("\n******* prediction *******");
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[0].length; j++) {
                if (pre[i][j]!=0) {
                    System.out.print(pre[i][j]+"  \t");
                }                
            }
            System.out.println();
        }
        System.out.println("\n******* rating *******");        
        for (int i = 0; i < rat.length; i++) {
            for (int j = 0; j < rat[0].length; j++) {
                if (rat[i][j]!=0) {
                    System.out.print(rat[i][j]+"  \t");
                }                
            }
            System.out.println();
        }
        
        dcg(pre, rat, cont, VU);
    }
    
    static void dcg(double pre [][], double rat [][], int cont, double[] vu) {
        double [][] dcgP = new double [pre.length][pre.length];
        double [][] dcgR = new double [rat.length][rat.length];
        double [][] sumatoriaMP = new double [pre.length][pre.length];
        double [][] sumatoriaMR = new double [pre.length][pre.length];
        double log, axp = 0, axr=0;
        List<Double> uv = new ArrayList<Double>();
        
        for (int i = 0; i < vu.length; i++) {
            if (vu[i]!=0) {
                uv.add(vu[i]);
            }
        }
        //prediction
        for (int i = 0; i < uv.size(); i++) {
            double sumatoriap=0;
            int p = 1;
            for (int j = 0; j < pre.length; j++) {
//                System.out.println(i+"  "+h[i]+" = "+pre[j][IdUser]);
                if (uv.get(i) == pre[j][IdUser]) {
//                    System.out.println(p+1);
                    axp = pre[j][Pred-1];
//                    System.out.println(axp);
                    log = logaritmo(p+1, 2);
//                    System.out.println(log);
                    dcgP[i][j]=axp/log;
//                    System.out.println(dcgP[i][j]);
                    sumatoriap=sumatoriap+dcgP[i][j];
//                    System.out.println(sum);
                    sumatoriaMP[i][p-1]= sumatoriap;
//                    System.out.println(uv.get(i)+"  "+sumatoriaMP[i][j]);
                    p++;
                }
            }
        }
                    System.out.println("");
//        rating
        for (int s = 0; s < uv.size(); s++) {
            double sumatoriar=0;
            int p = 1;
            for (int t = 0; t < rat.length; t++) {
                if (uv.get(s) == rat[t][IdUser]) {
                    axr = rat[t][Rat];
//                    System.out.println(axr);
                    log=logaritmo(p+1, 2);
//                    System.out.println(uv.get(s)+"  "+log);
                    dcgR[s][t]=axr/log;
//                    System.out.println(axr+" / "+log+" = "+dcgR[s][t]);
//                    System.out.print(sumatoriar+" + "+dcgR[s][t]);
                    sumatoriar=sumatoriar+dcgR[s][t];
//                    System.out.println(" = "+sumatoriar);
                    sumatoriaMR[s][p-1]=sumatoriar;
//                    System.out.println(p+"  "+sumatoriaMR[s][p-1]);
                    p++;
                }
            }
        }
        
//imprimir somatorias de prediction 
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre.length; j++) {
                if (sumatoriaMP[i][j]!=0) {
                    System.out.print(sumatoriaMP[i][j]+"  \t");   
                }
            }
            System.out.println();
        }
        
        System.out.println();
//imprimir somatorias de rating
        for (int i = 0; i < rat.length; i++) {
            for (int j = 0; j < rat.length; j++) {
                if (sumatoriaMR[i][j]!=0) {
                    System.out.print(sumatoriaMR[i][j]+"  \t");   
                }
            }
            System.out.println();
        }
    }
    

        
}


