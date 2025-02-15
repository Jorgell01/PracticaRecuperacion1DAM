package practicarecu1dam.java;

// Clase que representa una matriz rectangular, que es una matriz con diferente número de filas y columnas
public class MatrizRectangular extends Matriz {

    public MatrizRectangular(int filas, int columnas) {
        super(filas, columnas); // Llama al constructor de la clase base Matriz
    }

    public void insertarDato(int fila, int columna, int dato) {
        validarIndices(fila, columna); // Valida los índices antes de insertar el dato
        datos[fila][columna] = dato; // Asigna el valor 'dato' a la posición especificada
    }

    public int recuperarDato(int fila, int columna) {
        validarIndices(fila, columna); // Valida los índices antes de recuperar el dato
        return datos[fila][columna]; // Devuelve el valor almacenado en la posición especificada
    }

    private void validarIndices(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índices fuera de rango."); // Verifica que los índices estén dentro del rango
        }
    }
}