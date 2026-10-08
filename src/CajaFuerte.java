public class CajaFuerte {
    private String numeroSerie;
    private String modelo;
    private int claveAcceso;
    private boolean estado;
    private byte intentosFallidos;
    private double capacidadMaxima;
    private double saldoActual;

    // constructor con 4 parámetros
    public CajaFuerte(String numeroSerie, String modelo, int claveAcceso, double capacidadMaxima) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.claveAcceso = claveAcceso;
        this.capacidadMaxima = capacidadMaxima;
    }
}
