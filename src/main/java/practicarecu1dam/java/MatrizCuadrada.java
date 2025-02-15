package practicarecu1dam.java;

// Clase que representa una matriz cuadrada, que es una matriz con el mismo número de filas y columnas
public class MatrizCuadrada extends Matriz {
    // Constructor que inicializa la matriz cuadrada con el tamaño especificado
    public MatrizCuadrada(int size) {
        super(size, size); // Llama al constructor de la clase base Matriz con filas y columnas iguales
    }

    // Método para calcular el determinante de la matriz cuadrada
    public int determinante() {
        if (filas != columnas) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada."); // Verifica que la matriz sea cuadrada
        }
        return calcularDeterminante(datos, filas); // Llama al método auxiliar para calcular el determinante
    }

    // Método auxiliar para calcular el determinante de una matriz
    private int calcularDeterminante(int[][] matriz, int n) {
        int det = 0; // Inicializa el determinante
        if (n == 1) {
            return matriz[0][0]; // Caso base: si la matriz es 1x1, el determinante es el único elemento
        }
        if (n == 2) {
            // Caso base: si la matriz es 2x2, calcula el determinante directamente
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }
        int[][] temp = new int[n][n]; // Matriz temporal para almacenar los cofactores
        int signo = 1; // Signo para alternar los cofactores
        for (int f = 0; f < n; f++) {
            obtenerCofactor(matriz, temp, 0, f, n); // Obtiene el cofactor de la matriz
            det += signo * matriz[0][f] * calcularDeterminante(temp, n - 1); // Suma o resta el cofactor al determinante
            signo = -signo; // Alterna el signo
        }
        return det; // Devuelve el determinante calculado
    }

    // Método auxiliar para obtener el cofactor de una matriz
    private void obtenerCofactor(int[][] matriz, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0; // Inicializa los índices para la matriz temporal
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                // Copia los elementos de la matriz original a la temporal, omitiendo la fila p y la columna q
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

    // Método para calcular la inversa de la matriz cuadrada
    public Matriz inversa() {
        int det = determinante(); // Calcula el determinante de la matriz
        if (det == 0) {
            throw new ArithmeticException("La matriz no tiene inversa (determinante es 0)."); // Verifica que el determinante no sea 0
        }
        int n = filas; // Tamaño de la matriz
        Matriz adjunta = obtenerAdjunta(); // Obtiene la matriz adjunta
        Matriz inversa = new Matriz(n, n); // Crea una nueva matriz para almacenar la inversa
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa.datos[i][j] = (int) (adjunta.datos[i][j] / (double) det); // Calcula cada elemento de la inversa
            }
        }
        return inversa; // Devuelve la matriz inversa
    }

    // Método auxiliar para obtener la adjunta de una matriz
    private Matriz obtenerAdjunta() {
        int n = filas; // Tamaño de la matriz
        Matriz adjunta = new Matriz(n, n); // Crea una nueva matriz para almacenar la adjunta
        if (n == 1) {
            adjunta.datos[0][0] = 1; // Caso base: si la matriz es 1x1, la adjunta es 1
            return adjunta;
        }
        int signo = 1; // Signo para alternar los cofactores
        int[][] temp = new int[n][n]; // Matriz temporal para almacenar los cofactores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                obtenerCofactor(datos, temp, i, j, n); // Obtiene el cofactor de la matriz
                signo = ((i + j) % 2 == 0) ? 1 : -1; // Alterna el signo
                adjunta.datos[j][i] = signo * calcularDeterminante(temp, n - 1); // Asigna el cofactor a la adjunta
            }
        }
        return adjunta; // Devuelve la matriz adjunta
    }

    // Método para calcular la traza de la matriz cuadrada
    public int traza() {
        int traza = 0; // Inicializa la traza
        for (int i = 0; i < filas; i++) {
            traza += datos[i][i]; // Suma los elementos de la diagonal principal
        }
        return traza; // Devuelve la traza calculada
    }
}