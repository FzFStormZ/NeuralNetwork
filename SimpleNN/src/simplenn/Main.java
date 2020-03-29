/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplenn;

import java.util.Scanner;

/**
 *
 * @author Dylan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Data in input
        double[][] inputs = new double[][]{
            {0, 0, 1}, // 1 input
            {1, 1, 1}, // 1 input
            {1, 0, 1}, // 1 input
            {0, 1, 1} // 1 input
        };

        // Data in output
        double[][] outputs = new double[][]{
            {0, 1, 1, 0} // 4 possibles outputs 
        };

        // Create a neural network
        NeuralNetwork simple = new NeuralNetwork(inputs, outputs);

        // Before practising (random weights) :
        System.out.println("Weights before Training : ");
        new Utils().doubleToString(simple.getSynapseWeights());

        // Start training phase
        simple.training(1000000);

        // After practising (good weights) :
        System.out.println("Weights after Training : ");
        new Utils().doubleToString(simple.getSynapseWeights());

        // After practising outputs :
        System.out.println("Outputs after Training : ");
        new Utils().doubleToString(simple.getOutputsResults());

        // Test if neural network have learned correctly
        Scanner scan = new Scanner(System.in);
        double[] input = new double[simple.getNbInputsNeuron()];
        for (int i = 0; i < simple.getNbInputsNeuron(); i++) {
            System.out.println("Enter a input value : ");
            input[i] = scan.nextDouble(); // Recup all inputs values of the user
        }

        // Testing outputs with new inputs values :
        System.out.println("Testing outputs : ");
        new Utils().doubleToString(simple.testing(new double[][]{input}));
    }
}
