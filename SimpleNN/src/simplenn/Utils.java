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
public class Utils {

    public Utils() {
    }

    /**
     * Print all values of the matrix
     *
     * @param matrix a matrix
     */
    public void doubleToString(double[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.println(matrix[x][y]);
            }
        }
    }
}
