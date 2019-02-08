/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelasumatoriamatriz;

import mpi.MPI;
import java.util.Scanner;

/**
 *
 * @author 31enr
 */
public class Suma {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int mat[][] = {{5, 7, 8}, {5, 8, 1}, {7, 8, 0}};
        int sumaDiagonal = 0;
        int myrank, origen;

        for (int x = 0; x < 3; x++) {
            sumaDiagonal = sumaDiagonal + mat[x][x];
        }
        System.out.println("La suma de la diagonal principal es : " + sumaDiagonal);
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        MPI.Finalize();

        System.out.println("CPU: <" + rank + "> de <" + size + ">");

        long endTime = System.nanoTime();
        System.out.println("Duración " + (endTime - startTime) / 1e6 + "ms");
    }

}
