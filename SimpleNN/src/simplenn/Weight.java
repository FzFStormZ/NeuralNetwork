/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplenn;

import java.util.Random;

/**
 *
 * @author Dylan
 */
public class Weight {

    private final double weightValue;

    public Weight() {
        this.weightValue = 0.0;
    }

    /**
     * Create a random array which constitute all weights of inputs neuron
     *
     * @param inputsNeuron number of inputs neuron
     * @param outputsNeuron number of outputs neuron
     * @return double of weights
     */
    public double[][] matriceWeights(int inputsNeuron, int outputsNeuron) {
        double[][] array = new double[inputsNeuron][outputsNeuron];
        for (double[] array1 : array) {
            for (int j = 0; j < array1.length; j++) {
                array1[j] = Math.random() * 2; // Change value to put your range between value(out) and 0(in)
            }
        }
        return array;
    }
}
