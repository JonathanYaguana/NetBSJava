/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liac.sfs.sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import liac.sfs.algorithm.*;
import liac.sfs.loader.DataLoader;
import liac.sfs.loader.DataLoaderException;
import liac.sfs.loader.Dataset;
import liac.sfs.loader.MatrixUtil;
import org.ejml.simple.*;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

/**
 *
 * @author liac01
 */
public class Main {

	public static void main(String[] args) throws DataLoaderException, FileNotFoundException, IOException {
            String var = "data/sheet.arff"    ;
            Dataset dataset = DataLoader.loadARFF(var);
            BufferedReader reader = new BufferedReader(new FileReader(var));
            ArffReader arff = new ArffReader(reader);
            Instances datos = arff.getData();
            
//            System.out.println("num atributtes " + (datos.numAttributes()) + " numero de datos: " + (datos.numInstances()));                
            ArrayList<SimpleMatrix> covs = new ArrayList<>();
            ArrayList atributos = new ArrayList();
		//covs = Main.getCovarianceMatrix(dataset);
            covs.add(Main.getCovarianceMatrix(dataset.getDataset()));
//                System.out.println(dataset.getDataset());

            for (int i = 0; i < covs.size(); i++) {

                SimpleMatrix corrMat = MatrixUtil.getCorrelationMatrix(covs.get(i));
                
//			corrMat.print();

                AlgorithmSelection algorithm;
                algorithm = new BackwardSelection(dataset.getInputSize(), new CostFunctionCorrelation(corrMat, dataset.getInputSize(), dataset.getNumClasses()));
                
                ArrayList<Integer> features;	
                features = algorithm.algorithm();

                System.out.println("(" + features.size() + "): " + features.toString());
                for (int j = 0; j < features.size(); j++) {
                    atributos.add(features.get(j));
                }
                
                for (int z = 0; z < features.size(); z++) {
                    for (int j = 0; j < datos.numAttributes(); j++) {
                        if (features.get(z) == j) {
                            System.out.println(j+" "+datos.attribute(j));
                        }
                    }
                }
                Main.normaliacion(datos, atributos);
            }
	}
	
	public static ArrayList<SimpleMatrix> getCovarianceMatrix(Dataset dataset){
            ArrayList<SimpleMatrix> covs = new ArrayList<>();
            ArrayList<SimpleMatrix> means = new ArrayList<>();
            SimpleMatrix ds = new SimpleMatrix(dataset.getDataset());
            SimpleMatrix result = new SimpleMatrix(ds.numRows(), ds.numRows());
            SimpleMatrix mean = new SimpleMatrix(ds.numRows(), 1);
            int numClasses = dataset.getNumClasses(), numAttr = dataset.getInputSize();
            int nums [] = new int[numClasses], classes [] = new int[ds.numCols()];

            for (int i = 0; i < numClasses; i++) 
            {
                    covs.add(result);
                    means.add(mean);
            }

            //Calculating mean vectors
            for (int i = 0; i < ds.numCols(); i++)
            {	
                    for(int j = 0; j < numClasses; j++)
                    {
                            if(ds.get(numAttr + j, i) == 1)
                            {
                                    means.set(j, means.get(j).plus(ds.extractVector(false, i)));
                                    ++nums[j];
                                    classes[i] = j;
                                    break;
                            }
                    }
            }
            for(int i = 0; i < numClasses; i++)
                    means.set(i, means.get(i).scale(1.0 / nums[i]));


            //Calculating covariance matrix
            for (int i = 0; i < ds.numCols(); i++)
            {
                    SimpleMatrix tmp = new SimpleMatrix(ds.extractVector(false, i));
                    tmp = tmp.minus(means.get(classes[i]));
                    covs.set(classes[i], covs.get(classes[i]).plus(tmp.mult(tmp.transpose())));
            }
            for(int i = 0; i < numClasses; i++)
                    covs.set(i, covs.get(i).scale(1.0 / (nums[i] - 1)));

            return covs;		
        }

    public static SimpleMatrix getCovarianceMatrix(SimpleMatrix ds){
        SimpleMatrix result = new SimpleMatrix(ds.numRows(), ds.numRows());
        SimpleMatrix mean = new SimpleMatrix(ds.numRows(), 1);

        //Calculating the mean vector
        for (int i = 0; i < ds.numCols(); i++) 
                mean = mean.plus(ds.extractVector(false, i));
        mean = mean.scale(1.0 / ds.numCols());

        //Calculating covariance matrix
        for (int i = 0; i < ds.numCols(); i++)
        {
                SimpleMatrix tmp = new SimpleMatrix(ds.extractVector(false, i));
                tmp = tmp.minus(mean);
                result = result.plus(tmp.mult(tmp.transpose()));
        }
        result = result.scale(1.0 / (ds.numCols() + 1));
        
        return result;		
    }

    public static double[][] normaliacion(Instances datos, ArrayList atributos){
        Scanner ls = new Scanner(System.in);
        double data[][] = new double[datos.numAttributes()][datos.numInstances()];
        int dataset;
        for (int i = 0; i < datos.numInstances(); i++) {
            double[] dt = datos.instance(i).toDoubleArray();
            for (int j = 0; j < datos.numAttributes(); j++) {
                data[j][i] = dt[j];
            }
        }   

        double newdata [][] = new double[atributos.size()][datos.numInstances()];
        int temp=0;
        for (int i = 0; i < data[0].length; i++) {
            for (int j = 0; j < atributos.size(); j++) {
                temp = (int) atributos.get(j);
                newdata[j][i] = data[temp-1][i];
            }
        }
        System.out.println();
        String t = " normalizar el dataset ";
        System.out.println("1:"+t+"filtrado");
        System.out.println("2:"+t+"completo");
        System.out.println("Ingrese 1 o 2: ");
        dataset = ls.nextInt();
        
            if (dataset == 1) {
                System.out.println("DATASET FILTRADO");
                normalizar.normalizar(newdata);
            }else{
                System.out.println("DATASET COMPLETO");
                normalizar.normalizar(data);
            }
        return data;
    }
}