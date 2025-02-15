package practicarecu1dam.java;

import java.util.Arrays;

// Clase que representa una matriz multidimensional (3D)
public class MatrizMultidimensional extends Matriz {
    private int[][][] datos; // Matriz multidimensional (3D)

    // Constructor que inicializa la matriz multidimensional con las dimensiones especificadas
    public MatrizMultidimensional(int filas, int columnas, int profundidad) {
        super(filas, columnas); // Llama al constructor de la clase base Matriz
        this.datos = new int[filas][columnas][profundidad]; // Inicializa la matriz 3D con ceros
    }

    // Método para insertar un dato en una posición específica de la matriz 3D
    public void insertarDato(int fila, int columna, int profundidad, int dato) {
        validarIndices(fila, columna, profundidad); // Valida los índices antes de insertar el dato
        datos[fila][columna][profundidad] = dato; // Asigna el valor 'dato' a la posición especificada
    }

    // Método para recuperar un dato de una posición específica de la matriz 3D
    public int recuperarDato(int fila, int columna, int profundidad) {
        validarIndices(fila, columna, profundidad); // Valida los índices antes de recuperar el dato
        return datos[fila][columna][profundidad]; // Devuelve el valor almacenado en la posición especificada
    }

    // Método para sumar dos matrices multidimensionales (3D)
    public MatrizMultidimensional sumar(MatrizMultidimensional otra) {
        validarCompatibilidad(otra); // Valida que las matrices sean compatibles para la suma
        MatrizMultidimensional resultado = new MatrizMultidimensional(getFilas(), getColumnas(), datos[0][0].length); // Crea una nueva matriz para almacenar el resultado

        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                for (int k = 0; k < datos[0][0].length; k++) {
                    resultado.datos[i][j][k] = this.datos[i][j][k] + otra.datos[i][j][k]; // Suma los elementos correspondientes
                }
            }
        }
        return resultado; // Devuelve la matriz resultante de la suma
    }

    // Método para restar dos matrices multidimensionales (3D)
    public MatrizMultidimensional restar(MatrizMultidimensional otra) {
        validarCompatibilidad(otra); // Valida que las matrices sean compatibles para la resta
        MatrizMultidimensional resultado = new MatrizMultidimensional(getFilas(), getColumnas(), datos[0][0].length); // Crea una nueva matriz para almacenar el resultado

        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                for (int k = 0; k < datos[0][0].length; k++) {
                    resultado.datos[i][j][k] = this.datos[i][j][k] - otra.datos[i][j][k]; // Resta los elementos correspondientes
                }
            }
        }
        return resultado; // Devuelve la matriz resultante de la resta
    }

    // Método para multiplicar la matriz 3D por un escalar
    public MatrizMultidimensional multiplicarPorEscalar(int escalar) {
        MatrizMultidimensional resultado = new MatrizMultidimensional(getFilas(), getColumnas(), datos[0][0].length); // Crea una nueva matriz para almacenar el resultado

        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                for (int k = 0; k < datos[0][0].length; k++) {
                    resultado.datos[i][j][k] = this.datos[i][j][k] * escalar; // Multiplica cada elemento por el escalar
                }
            }
        }
        return resultado; // Devuelve la matriz resultante de la multiplicación escalar
    }

    // Método para validar los índices y evitar errores
    private void validarIndices(int fila, int columna, int profundidad) {
        if (fila < 0 || fila >= getFilas() || columna < 0 || columna >= getColumnas() || profundidad < 0 || profundidad >= datos[0][0].length) {
            throw new IndexOutOfBoundsException("Índices fuera de rango"); // Lanza una excepción si los índices están fuera de rango
        }
    }

    // Método para validar que dos matrices sean compatibles para la suma/resta
    private void validarCompatibilidad(MatrizMultidimensional otra) {
        if (this.getFilas() != otra.getFilas() || this.getColumnas() != otra.getColumnas() || this.datos[0][0].length != otra.datos[0][0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones"); // Lanza una excepción si las matrices no tienen las mismas dimensiones
        }
    }

    // Método para mostrar la matriz en formato legible
    @Override
    public String toString() {
        return Arrays.deepToString(datos); // Devuelve una representación en cadena de la matriz 3D
    }

    // Método para obtener las dimensiones de la matriz en formato (filas, columnas, profundidad)
    public int[] getDimensiones() {
        return new int[]{getFilas(), getColumnas(), datos[0][0].length}; // Devuelve un array con las dimensiones de la matriz
    }
}