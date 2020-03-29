/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplenn;

/**
 *
 * @author Dylan
 */
public class NeuralNetwork {

    // Data in input/output
    private final double[][] inputs;
    private final double[][] outputs;

    // Inputs and outputs numbers
    private final int nbInputsNeuron;
    private final int nbOutputsNeuron;

    // Outputs results to know if neural network is operational
    private double[][] outputsResults;

    // Adjustement for weights
    private double[][] adjust;

    // Set of weights
    private double[][] synapseWeights;

    public NeuralNetwork(double[][] inputs, double[][] outputs) {
        this.inputs = inputs;
        this.outputs = new Maths().matrixTranspose(outputs); // Take transpose of outputs matrix

        // Take the number of weights to create as a function of the number of neurons as inputs
        this.nbInputsNeuron = this.inputs[0].length;
        this.nbOutputsNeuron = this.outputs[0].length;

        // Create a set of weights which matches a set of inputs neurons
        this.synapseWeights = new Weight().matriceWeights(nbInputsNeuron, nbOutputsNeuron);
    }

    /**
     * Practising test iterations times
     *
     * @param iterations times
     */
    public void training(int iterations) {
        for (int n = 0; n < iterations; n++) {

            // A temp copy of inputs
            double[][] input_layers = inputs;

            // A product of (inputs and weights) and give outputs results
            double[][] outputs_layers = new Maths().matrixMultiply(input_layers, synapseWeights);
            outputsResults = outputs_layers;
            for (int i = 0; i < outputsResults.length; i++) {
                for (int j = 0; j < outputsResults[i].length; j++) {
                    outputsResults[i][j] = new Maths().sigmoid(outputs_layers[i][j]);
                }
            }

            // Calculate adjustement for weights
            adjust = new double[outputsResults.length][outputsResults[0].length]; // Not sure about how give length !!
            for (int i = 0; i < adjust.length; i++) {
                for (int j = 0; j < adjust[i].length; j++) {

                    // error * f'(outputs) 
                    adjust[i][j] = (outputs[i][j] - outputsResults[i][j]) * new Maths().sigmoidDerivation(outputsResults[i][j]);
                }
            }

            // Send adjustments to synapseWeights
            synapseWeights = new Maths().matrixAdd(synapseWeights, new Maths().matrixMultiply(new Maths().matrixTranspose(input_layers), adjust));
        }
    }

    /**
     * Test our outputs after training phase with inputs values of the user
     *
     * @param inputs user values
     * @return outputs results
     */
    public double[][] testing(double[][] inputs) {
        // A temp copy of inputs
        double[][] input_layers = inputs;

        // A product of (inputs and weights) and give outputs results
        double[][] outputs_layers = new Maths().matrixMultiply(input_layers, synapseWeights);
        outputsResults = outputs_layers;
        for (int i = 0; i < outputsResults.length; i++) {
            for (int j = 0; j < outputsResults[i].length; j++) {
                outputsResults[i][j] = new Maths().sigmoid(outputs_layers[i][j]);
            }
        }

        return outputsResults;
    }

    public double[][] getSynapseWeights() {
        return synapseWeights;
    }

    public double[][] getOutputsResults() {
        return outputsResults;
    }

    public int getNbInputsNeuron() {
        return nbInputsNeuron;
    }

}
