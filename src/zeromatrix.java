
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

 class ZeroMatrix
{
    public static void main(String[] args) {


        int [][] matrix = {
                {1,2,3},
                {4,0,6},
                {7,8,9}
        };
        //System.out.println("output"+ rotateMatrix(matrix));
        rotateMatrix(matrix);
        print(matrix);
    }

    public static void rotateMatrix(int [][] matrix ){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m;i++){
            for (int j=0; j<n; j++){
                if(matrix[i][j]  == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m;i++){
            for (int j=0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }

    public static void print(int[][] matrix){
        int length = matrix.length;

        for(int i =0; i< length; i++){
            for(int j = 0; j< length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}






