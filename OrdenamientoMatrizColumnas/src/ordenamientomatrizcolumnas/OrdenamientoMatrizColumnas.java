/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientomatrizcolumnas;

/**
 *
 * @author Mauricio
 */
public class OrdenamientoMatrizColumnas {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
 
        int numeros[][]= new int [4][4];
        int columna=0;
        int var_fila=0;
        int var_fila2=0;
        int temp=0;
        numeros[0][0]=456;
        numeros[0][1]=24;
        numeros[0][2]=548;
        numeros[0][3]=290;
 
        numeros[1][0]=234;
        numeros[1][1]=861;
        numeros[1][2]=21;
        numeros[1][3]=468;
 
        numeros[2][0]=593;
        numeros[2][1]=245;
        numeros[2][2]=552;
        numeros[2][3]=691;
 
        numeros[3][0]=616;
        numeros[3][1]=154;
        numeros[3][2]=101;
        numeros[3][3]=384;
 
        //imprimimos array sin ordenar
 
        System.out.println("----ARRAY SIN ORDENAR----");
        while(var_fila <4) {
            while(columna<4) {
                System.out.print("  "+numeros[columna][var_fila]+"  \t");
                columna++;
            }
            System.out.println();
            columna=0;
            var_fila++;
        }
 
        var_fila=0;
        columna=0;
 
        //ordenamos el array
 
        while(columna<4) { 
            while(var_fila<3) {
               while(var_fila2<3) {
                   if(numeros[columna][var_fila]>numeros[columna][var_fila2+1]&& var_fila2>=var_fila) {
                       temp=numeros[columna][var_fila];
//                       System.out.println(" * "+temp);
                        numeros[columna][var_fila]=numeros[columna][var_fila2+1];
//                        System.out.println(" ** "+numeros[columna][var_fila]);
                        numeros[columna][var_fila2+1]=temp;
//                        System.out.println(" *** "+numeros[columna][var_fila2+1]);
                   }
                   var_fila2++;
               }
               var_fila2=0;
               var_fila++;
            }
           var_fila2=0;
           var_fila=0;
           columna++;
        }
        columna=0;
        var_fila=0;
 
        //Imprimimos el array
        System.out.println("----IMPRIMIMOS EL ARRAY ORDENADO--------");
        while(var_fila <4){
         while(columna<4){
          System.out.print("  "+numeros[columna][var_fila]+"  \t");
          columna++;
         }
         System.out.println();
         columna=0;
         var_fila++;
        }
    }
    
}
