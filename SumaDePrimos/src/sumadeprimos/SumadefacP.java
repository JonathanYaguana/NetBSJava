/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumadeprimos;

import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class SumadefacP {
    public static int num=2, sumTotal=0,contPrimos=0;
    
    public static void main(String[] args) {
        int cantPrim=0;
        Scanner lector=new Scanner(System.in);
        System.out.println("Ingrese un numero");
        cantPrim=lector.nextInt();  
        esPrimo(cantPrim); 
        System.out.println("La suma total es: "+sumTotal);
    }
    
    public static void esPrimo(int cantPrim){
        boolean bandera=true;
        while (bandera) {
            int cont=0;  
            for (int i = 1; i <= num ; i++) {
                if (num%i==0) {
                    cont++;
                }
            }
            if (cont!=2) {
                num++;
                cont=0;
           }else{ 
                sumaPrimo(num);
                cont=0;                
                num++;
                contPrimos++;                
            }
            
            if (contPrimos==cantPrim) {
                bandera=false;
            }            
        }                 
    }
    
    public static void sumaPrimo(int primo){        
        int Fact=1;
        int cont=primo;
        while (cont>0) {            
            Fact=Fact*cont;
            cont--;
        }
        System.out.println("Nº primo: "+primo+"  "+"Factorial: "+Fact);
        sumTotal=sumTotal+Fact;               
    }
}
