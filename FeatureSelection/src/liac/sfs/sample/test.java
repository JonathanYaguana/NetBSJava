/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liac.sfs.sample;

/**
 *
 * @author Mauricio
 */
public class test {
    public static void main(String[] args) {
        double n [][] = {
            {6,7,5}, 
            {3,8,4}, 
            {1,0,2}, 
            {9,5,2}
        };
        
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                System.out.print(n[i][j]+"  ");
            }
            System.out.println();
        }
        
        double[] resul = new double[n[0].length];
        double[] result = new double[n[0].length];
        double temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0;
        boolean aux, aux2;
        for (int i = 0; i < n[0].length; i++) {
            aux = false;
            aux2 = false;
            for (int j = 0; j < n.length; j++) {
                if (aux == true) {
                    temp2 = n[j][i];
                    if (temp1 < temp2) {
                        temp1 = temp2;
                    }
                }
                if (aux == false) {
                    temp1 = n[j][i];
                    aux = true;
                }                
            }
            for (int x = 0; x < n.length; x++) {
                if (aux2 == true) {
                    temp4 = n[x][i];
                    if (temp3 > temp4) {
                        temp3 = temp4;
                    }
                }
                if (aux2 == false) {
                    temp3 = n[x][i];
                    aux2 = true;
                }                
            }
            resul[i] = temp1;
            result[i] = temp3;
//            System.out.println("** Mayor **" + temp1);
//            System.out.println("** Menor **" + temp3);
        }
//        for (int i = 0; i < resul.length; i++) {
//            System.out.println("+++ "+resul[i]);
//            System.out.println("--- "+result[i]);
//        }
        System.out.println("Número de fila: "+n.length);
	System.out.println("Número de columnas: "+n[0].length);
        
        double [][] x = new double [n[0].length][n.length];
        double valor, min, max, nvalor, resta1, resta2;       
        
        for (int i = 0; i < n[0].length; i++) {
            valor = 0;
            nvalor = 0;
            max = resul[i];
            min = result[i];
//            System.out.println(resul[i]);
            for (int j = 0; j < n.length; j++) {
//                System.out.println(j+"  "+n[j][i]);
                  valor=n[j][i];
                  resta1 = (valor - min);
                  resta2 = max - min;
                  nvalor = resta1 / resta2;
                  x [i][j]= nvalor;
//                  System.out.println(j+" : "+valor+" - "+min+" = "+resta1);
//                  System.out.println(j+" : "+max+" - "+min+" = "+resta2);
//                  System.out.println(j+"  "+nvalor);
            }
        }
        for (int i = 0; i < x[0].length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[j][i]+"  \t");               
            }
            System.out.println();
        }
    }
}
