package practicarecu1dam.java;

// Clase que representa una matriz, que es un array bidimensional
public class Matriz extends Array {
    // Constructor que inicializa la matriz con el número de filas y columnas especificadas
    public Matriz(int filas, int columnas) {
        super(filas, columnas); // Llama al constructor de la clase base Array
    }

    // Método para obtener la transposición de la matriz
    public Matriz traspuesta() {
        Matriz result = new Matriz(columnas, filas); // Crea una nueva matriz con filas y columnas intercambiadas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[j][i] = this.datos[i][j]; // Asigna el valor transpuesto a la nueva matriz
            }
        }
        return result; // Devuelve la matriz transpuesta
    }
}