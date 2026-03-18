public class Zona {
    private String mineral;
    private int cantidad;
    private double puereza;

    public Zona(String mineral, int cantidad, double puerza)
    {
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.puereza = puerza;
    }
    public double calcularValor() {
        return this.cantidad * this.puereza;
    }
    public String getMineral() {
        return mineral;
    }
    @Override
    public String toString() {
        return "Zona{" +
                "mineral='" + mineral + '\'' +
                ", cantidad=" + cantidad +
                ", puereza=" + puereza +
                '}';
    }
}