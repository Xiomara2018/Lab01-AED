import java.io.File;
import java.util.Scanner;
public class Analizador {
    private Zona[][] terreno;
    private int filas;
    private int columnas;
    
    public void cargarDatos(String nombreArchivo ) throws Exception {
        Scanner lectorArchivo = new Scanner(new File(nombreArchivo));
        this.filas = lectorArchivo.nextInt();
        this.columnas = lectorArchivo.nextInt();
        this.terreno = new Zona[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Sirng main = lectorArchivo.next();
                int cantidad = lectorArchivo.nextInt();
                double puereza = lectorArchivo.nextDouble();

                this.terreno[i][j] = new Zona(main, cantidad, puereza);
            }
        }
        lectorArchivo.close();
                
    }
}
