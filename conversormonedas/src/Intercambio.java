public class Intercambio {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidadOrigen;
    private double cantidadDestino;
    private double razonCambio;

    @Override
    public String toString() {
        return "Transaccion de " + cantidadOrigen + " " + monedaOrigen + " a " + cantidadDestino + " " + monedaDestino + " con razon de cambio: " + razonCambio;
    }

    public Intercambio(String monedaOrigen, String monedaDestino, double cantidadOrigen, double cantidadDestino, double razonCambio){
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOrigen = cantidadOrigen;
        this.cantidadDestino = cantidadDestino;
        this.razonCambio = razonCambio;
    }
}
