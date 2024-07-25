// Brute force Solution

// public class SetMatrixZeros {

//     public void markRow(int[][] matrix, int i){
//         for(int j = 0; j < matrix[0].length; j++){
//             if(matrix[i][j] != 0) matrix[i][j] = -1000;
//         }
//     }

//     public void markColumn(int[][] matrix, int j){
//         for(int i = 0; i < matrix.length; i++){
//             if(matrix[i][j] != 0) matrix[i][j] = -1000;
//         }
//     }


//     public void setZeroes(int[][] matrix) {
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == 0){
//                     markRow(matrix, i);
//                     markColumn(matrix, j);
//                 }
//             }
//         }

//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == -1000) matrix[i][j] = 0;
//             }
//         }
//     }
// }

// Better Solution

// public class SetMatrixZeros{
//     public void setZeroes(int[][] matrix){
//         int n = matrix.length;
//         int m = matrix[0].length;

//         int[] row = new int[n];
//         int[] col = new int[m];

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 if(matrix[i][j] == 0){
//                     row[i] = 1;
//                     col[j] = 1;
//                 }
//             }
//         }

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 if(row[i] == 1 || col[j] == 1){
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// }


// Optimal Solution

public class SetMatrixZeros{
    public void setZeroes(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        // row array = matrix[i][0]
        // column array = matrix[0][j]

        int col0 = matrix[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    // Mark ith row
                    matrix[i][0] = 0;
                    // Mark jth column
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}