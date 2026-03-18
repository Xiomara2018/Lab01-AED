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
    public void analizadorRegion(int k){
        double maxValor = -1;
        int mejorFila =0, mejorCol =0;
        for (int i = 0 ; i < filas - k + 1; i++) {
            for (int j = 0; j < columnas - k + 1; j++) {
                double sumaActual =0;
                for (int r =i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        sumaActual += terreno[r][c].calcularValor();
                    }
                }
                if (sumaActual > maxValor) {
                    maxValor = sumaActual;
                    mejorFila = i;
                    mejorCol = j;
                }
            }
        }
        mostrarResultado(mejorFila, mejorCol, k, maxValor);
    }
    private void mostrarResultado(int f , int c, int k , double max) {
        System.out.println("La region mas valiosa es:");
        System.out.println("Coordenada inicial: " + f + ", " + c + " )");
        String [] nombres = new String[k * k];
        int tipos = 0;

        for

intln("Valor total: " + max);

    }
}
