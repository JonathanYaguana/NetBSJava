/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Mauricio
 */
public class Pruebas {

        static double [] list;
    public static void main(String[] args) {
        double [][] M = {
            {1,2,3,1.5},
            {2,2,4,4.5},
            {1,5,3,3.2},
            {3,6,3,3.3},
            {1,4,3,4.5},
            {3,6,2,1.2},
            {2,3,3,3.5}
        };
//        System.out.println("col "+M[0].length);
//        System.out.println("fil "+M.length);
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
    
    static void longitudusers(double[][] m) {
        int limit = m.length, cont = 0;
        double[] aux = new double[limit];
        list= new double [limit];
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
                System.out.println(list[i]+" se repite: "+cont2);
                cont++;
            }
        }
//        System.out.println(cont);
    }
}