package practicarecu1dam;

// Importamos las clases necesarias para realizar las pruebas unitarias
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Importamos las clases que vamos a probar
import practicarecu1dam.java.Matriz;
import practicarecu1dam.java.MatrizCuadrada;
import practicarecu1dam.java.MatrizMultidimensional;
import practicarecu1dam.java.Vector;
import practicarecu1dam.java.Array;

class TestArrayJUnit {

    // Prueba unitaria para la clase Array
    @Test
    void testArray() {
        // Creamos un objeto Array de 2x2
        Array array = new Array(2, 2);
        // Insertamos datos en el array
        array.insertarDato(0, 0, 1);
        array.insertarDato(0, 1, 2);
        array.insertarDato(1, 0, 3);
        array.insertarDato(1, 1, 4);

        // Verificamos que los datos se han insertado correctamente
        assertEquals(1, array.recuperarDato(0, 0));
        assertEquals(2, array.recuperarDato(0, 1));
        assertEquals(3, array.recuperarDato(1, 0));
        assertEquals(4, array.recuperarDato(1, 1));
    }

    // Prueba unitaria para la clase Vector
    @Test
    void testVector() {
        // Creamos un objeto Vector de tamaño 3
        Vector vector = new Vector(3);
        // Insertamos datos en el vector
        vector.insertarDato(0, 0, 5);
        vector.insertarDato(0, 1, 6);
        vector.insertarDato(0, 2, 7);

        // Verificamos que los datos se han insertado correctamente
        assertEquals(5, vector.recuperarDato(0, 0));
        assertEquals(6, vector.recuperarDato(0, 1));
        assertEquals(7, vector.recuperarDato(0, 2));
    }

    // Prueba unitaria para la transposición de una matriz
    @Test
    void testMatrizTraspuesta() {
        // Creamos un objeto Matriz de 2x2
        Matriz matriz = new Matriz(2, 2);
        // Insertamos datos en la matriz
        matriz.insertarDato(0, 0, 1);
        matriz.insertarDato(0, 1, 2);
        matriz.insertarDato(1, 0, 3);
        matriz.insertarDato(1, 1, 4);

        // Obtenemos la matriz transpuesta
        Matriz traspuesta = matriz.traspuesta();

        // Verificamos que la transposición es correcta
        assertEquals(1, traspuesta.recuperarDato(0, 0));
        assertEquals(3, traspuesta.recuperarDato(0, 1));
        assertEquals(2, traspuesta.recuperarDato(1, 0));
        assertEquals(4, traspuesta.recuperarDato(1, 1));
    }

    // Prueba unitaria para la clase MatrizCuadrada
    @Test
    void testMatrizCuadrada() {
        // Creamos un objeto MatrizCuadrada de tamaño 2x2
        MatrizCuadrada matrizCuadrada = new MatrizCuadrada(2);
        // Insertamos datos en la matriz
        matrizCuadrada.insertarDato(0, 0, 1);
        matrizCuadrada.insertarDato(0, 1, 2);
        matrizCuadrada.insertarDato(1, 0, 3);
        matrizCuadrada.insertarDato(1, 1, 4);

        // Verificamos que la traza y el determinante son correctos
        assertEquals(5, matrizCuadrada.traza());
        assertEquals(-2, matrizCuadrada.determinante());
    }

    // Prueba unitaria para la clase MatrizMultidimensional
    @Test
    void testMatrizMultidimensional() {
        // Creamos un objeto MatrizMultidimensional de 2x3
        MatrizMultidimensional matrizMultidimensional = new MatrizMultidimensional(2, 3);
        // Insertamos datos en la matriz
        matrizMultidimensional.insertarDato(0, 0, 1);
        matrizMultidimensional.insertarDato(0, 1, 2);
        matrizMultidimensional.insertarDato(0, 2, 3);
        matrizMultidimensional.insertarDato(1, 0, 4);
        matrizMultidimensional.insertarDato(1, 1, 5);
        matrizMultidimensional.insertarDato(1, 2, 6);

        // Verificamos que los datos se han insertado correctamente
        assertEquals(1, matrizMultidimensional.recuperarDato(0, 0));
        assertEquals(6, matrizMultidimensional.recuperarDato(1, 2));
    }
}
