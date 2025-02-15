package practicarecu1dam.java;

// Clase que representa un array bidimensional básico
public class Array {
    protected int dimensiones; // Número de dimensiones del array (en este caso, siempre 2)
    protected int filas; // Número de filas del array
    protected int columnas; // Número de columnas del array
    protected int[][] datos; // Array bidimensional que almacena los datos

    // Constructor que inicializa el array con el número de filas y columnas especificadas
    public Array(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new int[filas][columnas]; // Inicializa el array con ceros
    }

    // Método para insertar un dato en una posición específica del array
    public void insertarDato(int fila, int columna, int dato) {
        datos[fila][columna] = dato; // Asigna el valor 'dato' a la posición especificada
    }

    // Método para recuperar un dato de una posición específica del array
    public int recuperarDato(int fila, int columna) {
        return datos[fila][columna]; // Devuelve el valor almacenado en la posición especificada
    }

    // Método para sumar dos arrays elemento por elemento
    public Array sumar(Array other) {
        Array result = new Array(filas, columnas); // Crea un nuevo array para almacenar el resultado
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] + other.datos[i][j]; // Suma los elementos correspondientes
            }
        }
        return result; // Devuelve el array resultante de la suma
    }

    // Método para restar dos arrays elemento por elemento
    public Array restar(Array other) {
        Array result = new Array(filas, columnas); // Crea un nuevo array para almacenar el resultado
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] - other.datos[i][j]; // Resta los elementos correspondientes
            }
        }
        return result; // Devuelve el array resultante de la resta
    }

    // Método para multiplicar cada elemento del array por un valor escalar
    public Array multiplicarEscalar(int escalar) {
        Array result = new Array(filas, columnas); // Crea un nuevo array para almacenar el resultado
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] * escalar; // Multiplica cada elemento por el escalar
            }
        }
        return result; // Devuelve el array resultante de la multiplicación escalar
    }

    // Método para multiplicar dos arrays (multiplicación de matrices)
    public Array multiplicarArray(Array other) {
        if (this.columnas != other.filas) {
            throw new IllegalArgumentException("Columnas de la primera matriz deben ser iguales a las filas de la segunda matriz.");
        }
        Array result = new Array(this.filas, other.columnas); // Crea un nuevo array para almacenar el resultado
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < other.columnas; j++) {
                for (int k = 0; k < this.columnas; k++) {
                    result.datos[i][j] += this.datos[i][k] * other.datos[k][j]; // Realiza la multiplicación de matrices
                }
            }
        }
        return result; // Devuelve el array resultante de la multiplicación de matrices
    }

    // Método para ordenar cada fila del array
    public void ordenar() {
        for (int i = 0; i < filas; i++) {
            java.util.Arrays.sort(datos[i]); // Ordena cada fila del array
        }
    }

    // Método para buscar un valor en el array
    public boolean buscar(int dato) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (datos[i][j] == dato) {
                    return true; // Devuelve true si encuentra el valor en el array
                }
            }
        }
        return false; // Devuelve false si no encuentra el valor en el array
    }

    // Métodos getter para filas y columnas
    public int getFilas() {
        return filas; // Devuelve el número de filas del array
    }

    public int getColumnas() {
        return columnas; // Devuelve el número de columnas del array
    }
}