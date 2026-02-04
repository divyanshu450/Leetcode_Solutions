class Solution {
    public void rotate(int[][] matrix) {
        /*
        to rotate n*n matrix, we can transpose (swap rows and cols) and then simply reverse the rows.
        in place is possible, but not when m*n is there.
        */

        //---- TRANSPOSE:
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == j){ break;}//only one half across diagnol, not both sides of diagnol becuase then it will remain unchanged.
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                // System.out.println("After SWAP: matrix[i][j]: "+ matrix[i][j]);
                // System.out.println("After SWAP: matrix[j][i]: "+ matrix[j][i]);
            }
        }

        //---- REVERSE:
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length / 2; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }
}