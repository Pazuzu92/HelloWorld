import java.util.Arrays;

public class MyMatrix {
    private int stringQuantity;
    private int columnQuantity;

    public MyMatrix(int stringQuantity, int columnQuantity) {
        this.stringQuantity = stringQuantity;
        this.columnQuantity = columnQuantity;
    }

    int[][] matrix = new int[stringQuantity][columnQuantity];

    public MyMatrix multipleTo(MyMatrix anotherMatrix){
        MyMatrix newMatrix = new MyMatrix(matrix.length, matrix[0].length);

        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < anotherMatrix.matrix[0].length; column++) {
                for (int newMatrixRow = 0; newMatrixRow < anotherMatrix.matrix.length; newMatrixRow++) {
                    newMatrix.matrix[row][column] = newMatrix.matrix[row][column] +
                            matrix[row][newMatrixRow] * anotherMatrix.matrix[newMatrixRow][column];
                }
            }
        }

        return newMatrix;
    }

}
