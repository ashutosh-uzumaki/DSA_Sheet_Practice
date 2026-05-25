package org.example.arrays.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int i=0; i<size; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<size; i++){
            for(int j=0; j<size/2; j++){
                int temp = matrix[i][size-j-1];
                matrix[i][size-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
