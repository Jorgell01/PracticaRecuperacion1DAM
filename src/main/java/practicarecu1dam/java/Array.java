package practicarecu1dam.java;

public class Array {
    protected int dimensiones;
    protected int filas;
    protected int columnas;
    protected int[][] datos;

    public Array(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new int[filas][columnas];
    }

    public void insertarDato(int fila, int columna, int dato) {
        datos[fila][columna] = dato;
    }

    public int recuperarDato(int fila, int columna) {
        return datos[fila][columna];
    }

    public Array sumar(Array other) {
        Array result = new Array(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] + other.datos[i][j];
            }
        }
        return result;
    }

    public Array restar(Array other) {
        Array result = new Array(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] - other.datos[i][j];
            }
        }
        return result;
    }

    public Array multiplicarEscalar(int escalar) {
        Array result = new Array(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[i][j] = this.datos[i][j] * escalar;
            }
        }
        return result;
    }

    public Array multiplicarArray(Array other) {
        if (this.columnas != other.filas) {
            throw new IllegalArgumentException("Columnas de la primera matriz deben ser iguales a las filas de la segunda matriz.");
        }
        Array result = new Array(this.filas, other.columnas);
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < other.columnas; j++) {
                for (int k = 0; k < this.columnas; k++) {
                    result.datos[i][j] += this.datos[i][k] * other.datos[k][j];
                }
            }
        }
        return result;
    }

    public void ordenar() {
        for (int i = 0; i < filas; i++) {
            java.util.Arrays.sort(datos[i]);
        }
    }

    public boolean buscar(int dato) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (datos[i][j] == dato) {
                    return true;
                }
            }
        }
        return false;
    }
}
