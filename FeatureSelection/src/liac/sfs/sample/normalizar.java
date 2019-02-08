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
public class normalizar {
    public static double [][] normalizar(double matriz[][]) {
        double[] valuesmax = new double[matriz.length];
        double[] valuesmin = new double[matriz.length];
        double temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0;
        boolean aux, aux2;
        for (int i = 0; i < matriz.length; i++) {
            aux = false;
            aux2 = false;
            for (int j = 0; j < matriz[0].length; j++) {
                if (aux == true) {
                    temp2 = matriz[i][j];
                    if (temp1 < temp2) {
                        temp1 = temp2;
                    }
                }
                if (aux == false) {
                    temp1 = matriz[i][j];
                    aux = true;
                }
                             
            }
            for (int x = 0; x < matriz[0].length; x++) {
                if (aux2 == true) {
                    temp4 = matriz[i][x];
                    if (temp3 > temp4) {
                        temp3 = temp4;
                    }
                }
                if (aux2 == false) {
                    temp3 = matriz[i][x];
                    aux2 = true;
                }                
            }
            valuesmax[i] = temp1;
            valuesmin[i] = temp3;
        }
        
        double [][] x = new double [matriz.length][matriz[0].length];
        double valor, min, max, nvalor, resta1, resta2;
        for (int i = 0; i < matriz.length; i++) {
            valor = 0;
            nvalor = 0;
            max = valuesmax[i];
            min = valuesmin[i];
            for (int j = 0; j < matriz[0].length; j++) {
                valor=matriz[i][j];
                resta1 = (valor - min);
                resta2 = max - min;
                if ((resta1 == 0) && (resta2 == 0)) {
                    nvalor = 0;
                    x[i][j] = nvalor;
                }else{
                    nvalor = resta1 / resta2;
                    x [i][j]= nvalor;
                }
            }
        }




        for (int i = 0; i < x[0].length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[j][i]+"  \t");               
            }
            System.out.println();
        }
        
        return x;
    }
}
