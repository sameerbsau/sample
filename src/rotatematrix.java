
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

 class Main1
{
    public static void main(String[] args) {


        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println("output"+ rotateMatrix(matrix));
        print(rotateMatrix(matrix));
    }

    public static int[][] rotateMatrix(int [][] matrix ){
        int length = matrix.length;
        int [][] rotatedmatrix = new int[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                rotatedmatrix[i][j] = matrix[length -j -1][i];
            }
        }
        return rotatedmatrix;
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






