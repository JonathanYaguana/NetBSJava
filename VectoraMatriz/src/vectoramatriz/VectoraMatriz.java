/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectoramatriz;

/**
 *
 * @author Mauricio
 */
public class VectoraMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vDist[] = {774, 647, 192, 754, 515, 578, 861, 947, 253};
        int n= (int)Math.sqrt(vDist.length);
        int taula[][] = new int[n][n]; 
        int cont = 0;

        for (int x = 0; x < n; x++) {
          for (int y = 0; y < n; y++) {
            taula[y][x] = vDist[cont];
            cont++;
          }
        }

        MostrarTaula(taula, n);
    }
    private static void MostrarTaula(int[][] taula, int n) {
    System.out.println("Matriz:");
    String str = "";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        str += taula[j][i] + "\t";
      }
      System.out.println(str);
      str = "";
    }
  }
    
}
