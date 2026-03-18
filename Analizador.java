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
                String main = lectorArchivo.next();
                int cantidad = lectorArchivo.nextInt();
                double pureza = lectorArchivo.nextDouble();

                this.terreno[i][j] = new Zona(main, cantidad, pureza);
            }
        }
        lectorArchivo.close();
    }
    
    public void analizadorRegion(int k){
        double maxValor = -1;
        int mejorFila = 0, mejorCol = 0;
        
        for (int i = 0 ; i < filas - k + 1; i++) {
            for (int j = 0; j < columnas - k + 1; j++) {
                double sumaActual = 0;
                for (int r = i; r < i + k; r++) {
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
        
        String[] nombres = new String[k * k];
        int[] conteo = new int[k * k]; 
        int tipos = 0;

        for (int i = f; i < f + k; i++) {
            for (int j = c; j < c + k; j++) {
                System.out.println(terreno[i][j]);
                String mineral = terreno[i][j].getMineral();
                boolean encontrado = false;
                
                for (int m = 0; m < tipos; m++) {
                    if (nombres[m].equals(mineral)) {
                        conteo[m]++;
                        encontrado = true;
                        break;
                    }
                }
                
                if (!encontrado) {
                    nombres[tipos] = mineral;
                    conteo[tipos] = 1;
                    tipos++;
                }
            }
        }
        
        String predominante = ""; 
        int maxC = 0;
        
        for (int m = 0; m < tipos; m++) {
            if (conteo[m] > maxC) {
                maxC = conteo[m];
                predominante = nombres[m];
            }
        }
        
        System.out.println ("Valor total: " + max);
        System.out.println("Mineral predominante: " + predominante);
    }
}