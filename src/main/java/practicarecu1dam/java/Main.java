package practicarecu1dam.java;

public class Main {
    public static void main(String[] args) {
        // Prueba de la clase Array
        Array array = new Array(2, 2);
        array.insertarDato(0, 0, 1);
        array.insertarDato(0, 1, 2);
        array.insertarDato(1, 0, 3);
        array.insertarDato(1, 1, 4);
        System.out.println("Array:");
        imprimirArray(array);

        // Prueba de la clase Vector
        Vector vector = new Vector(3);
        vector.insertarDato(0, 0, 5);
        vector.insertarDato(0, 1, 6);
        vector.insertarDato(0, 2, 7);
        System.out.println("\nVector:");
        imprimirArray(vector);

        // Prueba de la clase Matriz
        Matriz matriz = new Matriz(2, 2);
        matriz.insertarDato(0, 0, 1);
        matriz.insertarDato(0, 1, 2);
        matriz.insertarDato(1, 0, 3);
        matriz.insertarDato(1, 1, 4);
        Matriz traspuesta = matriz.traspuesta();
        System.out.println("\nMatriz:");
        imprimirArray(matriz);
        System.out.println("Matriz traspuesta:");
        imprimirArray(traspuesta);

        // Prueba de la clase MatrizCuadrada
        MatrizCuadrada matrizCuadrada = new MatrizCuadrada(2);
        matrizCuadrada.insertarDato(0, 0, 1);
        matrizCuadrada.insertarDato(0, 1, 2);
        matrizCuadrada.insertarDato(1, 0, 3);
        matrizCuadrada.insertarDato(1, 1, 4);
        System.out.println("\nMatriz Cuadrada:");
        imprimirArray(matrizCuadrada);
        System.out.println("Traza: " + matrizCuadrada.traza());
        System.out.println("Determinante: " + matrizCuadrada.determinante());

        // Prueba de la clase MatrizMultidimensional
        MatrizMultidimensional matrizMultidimensional = new MatrizMultidimensional(2, 3);
        matrizMultidimensional.insertarDato(0, 0, 1);
        matrizMultidimensional.insertarDato(0, 1, 2);
        matrizMultidimensional.insertarDato(0, 2, 3);
        matrizMultidimensional.insertarDato(1, 0, 4);
        matrizMultidimensional.insertarDato(1, 1, 5);
        matrizMultidimensional.insertarDato(1, 2, 6);
        System.out.println("\nMatriz Multidimensional:");
        imprimirArray(matrizMultidimensional);
    }

    private static void imprimirArray(Array array) {
        for (int i = 0; i < array.filas; i++) {
            for (int j = 0; j < array.columnas; j++) {
                System.out.print(array.recuperarDato(i, j) + " ");
            }
            System.out.println();
        }
    }
}