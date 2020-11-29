public class Main {
    public static void main(String[] args) {
        MyMatrix matrix1 = new MyMatrix(2, 1);
        MyMatrix matrix2 = new MyMatrix(1, 2);

        matrix1.matrix[0][0] = 1;
        matrix1.matrix[1][0] = 2;
        matrix2.matrix[0][0] = 3;
        matrix2.matrix[0][1] = 4;
        MyMatrix matrix = matrix1.multipleTo(matrix2);

        for (int i = 0; i < matrix.matrix.length; i++) {
            for (int j = 0; j < matrix.matrix[0].length; j++) {
                System.out.println(matrix);
            }
        }

    }
}
