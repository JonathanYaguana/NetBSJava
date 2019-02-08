/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logaritmo;

/**
 *
 * @author Mauricio
 */
public class Logaritmo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int num = 2;
      for (int base = 0; base < 10; base++) {
         System.out.println("Logaritmo de "+base+" en base " + num + " = " + log(base, num));
      }
   }

   private static Double log(double base, int num) {
      return (Math.log(base) / Math.log(num));
   }
    
}
