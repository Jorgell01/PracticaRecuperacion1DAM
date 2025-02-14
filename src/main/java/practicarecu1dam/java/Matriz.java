package practicarecu1dam.java;

public class Matriz extends Array {
    public Matriz(int filas, int columnas) {
        super(filas, columnas);
    }

    public Matriz traspuesta() {
        Matriz result = new Matriz(columnas, filas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.datos[j][i] = this.datos[i][j];
            }
        }
        return result;
    }
}
