/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelasumatoriamatriz;
import java.util.Scanner;
public class algoritmo_10_matriz {
    Scanner leer= new Scanner (System.in);
    
  
     public static void main(String[] args){
       algoritmo_10_matriz menu= new algoritmo_10_matriz();
       menu.menuGeneral();
    }
  
  
   public int menuGeneral(){
   int opcion;
   do{
       System.out.println("===== 1.SUMA DIAGONAL PRINCIPAL MATRIZ A^B     ====");

       System.out.print("Ingrese una opcion: ");
       opcion=leer.nextInt();
  
       switch(opcion){
           case 1: DiagonalPrincipalMatrices();break;

       } 
      
   }while(opcion != 8); 
   return 0;
   }


public void DiagonalPrincipalMatrices(){

        int n, m, i, j;
        int A[][] = new int[10][10];
        int B[][] = new int[10][10];
      
        System.out.print("Ingrese dimension n: ");
        n = leer.nextInt();
        System.out.print("Ingrese dimension m: ");
        m = leer.nextInt();

        System.out.println("INGRESE VALORES MATRIZ A");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                System.out.print("A[" + (i) + "," + (j) + "]= ");
                A[i][j] = leer.nextInt();
            }
        }

        System.out.println("INGRESE VALORES MATRIZ B");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                System.out.print("B[" + (i) + "," + (j) + "]= ");
                B[i][j] = leer.nextInt();
            }
        }

        //IMPRIMIENDO MATRICES A Y B
        System.out.println("======== MATRIZ A =========");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                System.out.print("\t" + A[i][j]);
            }
            System.out.println();
        }

        System.out.println("====== MATRIZ B ========");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                System.out.print("\t" + B[i][j]);
            }
            System.out.println();
        }
      
        //IMPRIMIENDO DIAGONAL PRINCIPAL MATRIZ A  Y B
        int DA = 0,suma=0, DB = 0;
        System.out.println("===========DIAGONAL PRINCIPAL MATRIZ A  Y B =============");
         for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
               if(i==j){
                    System.out.print("\t"+A[i][j]);
                    DA=DA+A[i][j];
                
               }
            }
        }
         System.out.println(" ---->> DA: "+DA);
        
         for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if(i==j){
                    System.out.print("\t"+B[i][j]);
                    DB=DB+B[i][j];
              
               }
            }
        }
      System.out.println(" ---->> DB: "+DB);
    
      suma=DA+DB;
      System.out.println("la suma es :"+suma);
        
 }
}