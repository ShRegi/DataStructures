package datastructures.shavaleevar.datastructures.maps;

public class MatrixTest {
    public static void main(String[] args) {
        testMatrix();
    }

    private static void testMatrix() {
        Matrix<String> stringMatrix = new HashMatrix<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 1000000; j++) {
                stringMatrix.set(i,j, "a");
            }
        }
    }
}
