package dcps;

public class calculatorMatrix {

    Validate v = new Validate();

    public void inputMenu() {
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");

    }

    public void printMatrix(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public int[][] getMatrix(int row, int col) {
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = v.getSize("Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return matrix;
    }

    public void addsubMatrix(boolean c) {
        System.out.println(c ? "-----Addition-----" : "-----Subtraction-----");
        int row1 = v.getSize("Enter row matrix 1: ");
        int col1 = v.getSize("Enter column matrix 1: ");

        int row2;
        int col2;
        while (true) {
            row2 = v.getSize("Enter row matrix 2: ");
            if (row2 == row1) {
                break;
            } else {
                System.err.println("Need row2 = row1");
            }

        }
        while (true) {
            col2 = v.getSize("Enter column matrix2 : ");
            if (col2 == col1) {
                break;
            } else {
                System.err.println("Need col2 = col1");
            }
        }
        System.out.println("Input Matrix1:");
        int matrix1[][] = getMatrix(row1, col1);
        System.out.println("Input Matrix2:");
        int matrix2[][] = getMatrix(row2, col2);
        int ketqua[][] = new int[row2][col2];

        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                if (c == true) {
                    ketqua[i][j] = matrix1[i][j] + matrix2[i][j];
                } else {
                    ketqua[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }
        System.out.println("-----Result-----");
        if (c == true) {
            printMatrix(matrix1, row1, col1);
            System.out.println("+");
            printMatrix(matrix2, row2, col2);
            System.out.println("=");
            printMatrix(ketqua, row2, col2);
        } else {
            printMatrix(matrix1, row1, col1);
            System.out.println("-");
            printMatrix(matrix2, row2, col2);
            System.out.println("=");
            printMatrix(ketqua, row2, col2);
        }
    }

    public void mulMatrix() {
        int row1 = v.getSize("Enter row matrix 1: ");
        int col1 = v.getSize("Enter column matrix 1: ");

        int row2;

        while (true) {
            row2 = v.getSize("Enter row matrix 2: ");
            if (row2 == col1) {
                break;
            } else {
                System.err.println("Need row2 = col1");
            }

        }
        int col2 = v.getSize("Enter column matrix 2: ");
        System.out.println("Input Matrix1:");
        int matrix1[][] = getMatrix(row1, col1);
        System.out.println("Input Matrix2:");
        int matrix2[][] = getMatrix(row2, col2);
        int ketqua[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    ketqua[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("-----Result-----");
        printMatrix(matrix1, row1, col1);
        System.out.println("*");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");

        printMatrix(ketqua, row1, col2);

    }

}
