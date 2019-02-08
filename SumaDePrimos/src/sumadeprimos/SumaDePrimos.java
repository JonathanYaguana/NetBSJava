package sumadeprimos;

/**
 *
 * @author Mauricio
 */
import java.util.Scanner;
public class SumaDePrimos {

    public static int numI=2, sumTotal=0,contPrimos=0;
    
    public static void main(String[] args) {
        int Prim=0;
        Scanner l=new Scanner(System.in);
        System.out.println("Ingrese un numero");
        Prim=l.nextInt();  
        esPrimo(Prim); 
        System.out.println("La suma total de los primos es: "+sumTotal);
    }
    
    public static void esPrimo(int cantPrim){
        boolean bandera=true;
        while (bandera) {
            int cont=0;  
            for (int i = 1; i <= numI ; i++) {
                if (numI%i==0) {
                    cont++;
                }
            }
            if (cont!=2) {
                numI++;
                cont=0;
           }else{ 
                sumaPrimo(numI);
                cont=0;                
                numI++;
                contPrimos++;                
            }
            
            if (contPrimos==cantPrim) {
                bandera=false;
            }            
        }                 
    }
    
    public static void sumaPrimo(int primo){
        System.out.println("Nº primo: "+primo);
        sumTotal=sumTotal+primo;           
        
    }
}