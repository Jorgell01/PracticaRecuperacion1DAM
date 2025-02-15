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
        MatrizMultidimensional matrizMultidimensional = new MatrizMultidimensional(2, 3, 2);
        matrizMultidimensional.insertarDato(0, 0, 0, 1);
        matrizMultidimensional.insertarDato(0, 1, 0, 2);
        matrizMultidimensional.insertarDato(0, 2, 0, 3);
        matrizMultidimensional.insertarDato(1, 0, 0, 4);
        matrizMultidimensional.insertarDato(1, 1, 0, 5);
        matrizMultidimensional.insertarDato(1, 2, 0, 6);
        matrizMultidimensional.insertarDato(0, 0, 1, 7);
        matrizMultidimensional.insertarDato(0, 1, 1, 8);
        matrizMultidimensional.insertarDato(0, 2, 1, 9);
        matrizMultidimensional.insertarDato(1, 0, 1, 10);
        matrizMultidimensional.insertarDato(1, 1, 1, 11);
        matrizMultidimensional.insertarDato(1, 2, 1, 12);
        System.out.println("\nMatriz Multidimensional:");
        System.out.println(matrizMultidimensional);

        // Prueba de la clase MatrizRectangular
        MatrizRectangular matrizRectangular = new MatrizRectangular(2, 3);
        matrizRectangular.insertarDato(0, 0, 1);
        matrizRectangular.insertarDato(0, 1, 2);
        matrizRectangular.insertarDato(0, 2, 3);
        matrizRectangular.insertarDato(1, 0, 4);
        matrizRectangular.insertarDato(1, 1, 5);
        matrizRectangular.insertarDato(1, 2, 6);
        System.out.println("\nMatriz Rectangular:");
        imprimirArray(matrizRectangular);
    }

    // Método auxiliar para imprimir el contenido de un objeto Array en un formato legible
    private static void imprimirArray(Array array) {
        for (int i = 0; i < array.getFilas(); i++) {
            for (int j = 0; j < array.getColumnas(); j++) {
                System.out.print(array.recuperarDato(i, j) + " ");
            }
            System.out.println();
        }
    }
}