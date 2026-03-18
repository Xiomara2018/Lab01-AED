import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Analizador miAnalizador = new Analizador();
        Scanner teclado = new Scanner(System.in);

        try {
            miAnalizador.cargarDatos("datos.txt");

            System.out.print("Ingrese el tamaño de la subregión (k): ");
            int k = teclado.nextInt();
            
            miAnalizador.analizadorRegion(k);
            
        } catch (Exception e) {

            System.out.println("Error: No se pudo leer el archivo. Asegúrate de que 'datos.txt' exista .");
        } finally {
            teclado.close();
        }
    }
}