public class Zona {
    private String mineral;
    private int cantidad;
    private double pureza;

    public Zona(String mineral, int cantidad, double pureza)
    {
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }
    public double calcularValor() {
        return this.cantidad * this.pureza;
    }
    public String getMineral() {
        return mineral;
    }
    @Override
    public String toString() {
        return "Zona{" +
                "mineral='" + mineral + '\'' +
                ", cantidad=" + cantidad +
                ", pureza=" + pureza +
                '}';
    }
}