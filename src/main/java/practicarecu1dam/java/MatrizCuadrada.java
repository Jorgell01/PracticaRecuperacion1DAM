package practicarecu1dam.java;

public class MatrizCuadrada extends Matriz {
    public MatrizCuadrada(int size) {
        super(size, size);
    }

    public int determinante() {
        if (filas != columnas) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada.");
        }
        return calcularDeterminante(datos, filas);
    }

    private int calcularDeterminante(int[][] matriz, int n) {
        int det = 0;
        if (n == 1) {
            return matriz[0][0];
        }
        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }
        int[][] temp = new int[n][n];
        int signo = 1;
        for (int f = 0; f < n; f++) {
            obtenerCofactor(matriz, temp, 0, f, n);
            det += signo * matriz[0][f] * calcularDeterminante(temp, n - 1);
            signo = -signo;
        }
        return det;
    }

    private void obtenerCofactor(int[][] matriz, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                if (fila != p && columna != q) {
                    temp[i][j++] = matriz[fila][columna];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public Matriz inversa() {
        int det = determinante();
        if (det == 0) {
            throw new ArithmeticException("La matriz no tiene inversa (determinante es 0).");
        }
        int n = filas;
        Matriz adjunta = obtenerAdjunta();
        Matriz inversa = new Matriz(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa.datos[i][j] = (int) (adjunta.datos[i][j] / (double) det);
            }
        }
        return inversa;
    }

    private Matriz obtenerAdjunta() {
        int n = filas;
        Matriz adjunta = new Matriz(n, n);
        if (n == 1) {
            adjunta.datos[0][0] = 1;
            return adjunta;
        }
        int signo = 1;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                obtenerCofactor(datos, temp, i, j, n);
                signo = ((i + j) % 2 == 0) ? 1 : -1;
                adjunta.datos[j][i] = signo * calcularDeterminante(temp, n - 1);
            }
        }
        return adjunta;
    }

    public int traza() {
        int traza = 0;
        for (int i = 0; i < filas; i++) {
            traza += datos[i][i];
        }
        return traza;
    }
}
