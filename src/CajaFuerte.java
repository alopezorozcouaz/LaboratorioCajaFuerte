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

    /**
     * Permite mediante una clave valida
     * abrir la caja, después de tres intentos
     * erroneos se bloquea la caja
     * @param claveIngresada
     */
    public void abrir(int claveIngresada){
        if (intentosFallidos >= 3){
            System.out.println("Caja fuerte bloqueada");
            return;
        }

        if (estado){ // si ya esta abierta manda un mensaje
            System.out.println("La caja fuerte ya esta abierta");
            return;
        }

        if (claveIngresada == claveAcceso){
            estado = true; // la caja ha sido abierta
            intentosFallidos = 0;
            System.out.println("Acceso autorizado");
        }else{
            intentosFallidos++; // suma 1 a intentosFallidos

            System.out.println("Clave incorrecta. Intentos restantes: " +
                    (3 - intentosFallidos));

            if (intentosFallidos >= 3) {
                estado = false;
                System.out.println("Caja fuerte bloqueada");
            }
        }
    }

    /**
     * Cierra la caja si esta abierta
     */
    public void cerrar(){
        if (estado){
            estado = false;
            System.out.println("Se ha cerrado la caja");
        }else{
            System.out.println("La caja ya esta cerrada");
        }
    }

    /**
     * permite depositar una cantidad
     * a la caja fuerte
     * @param cantidad
     */
    public void depositar(double cantidad){
        if (!estado){
            System.out.println("Primero abre la caja");
            return;
        }

        if (cantidad <= 0 || saldoActual + cantidad > capacidadMaxima){
            System.out.println("Depósito no permitido");
            return;
        }

        saldoActual += cantidad;
        System.out.println("Depósito realizado");
    }

    /**
     * Permite retirar una cantidad de la caja
     * @param cantidad
     */
    public void retirar(double cantidad){
        if (!estado){
            System.out.println("Primero abre la caja");
            return;
        }

        if (cantidad <=0 || cantidad > saldoActual){
            System.out.println("Retiro no permitido");
            return;
        }

        saldoActual -= cantidad;
        System.out.println("Retiro realizado");
    }

    /**
     * impresión de los datos de la caja
     */
    public void mostrarEstado(){
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Serie: " + numeroSerie);
        System.out.print("La caja esta: " );

        if (estado){
            System.out.println("abierta");
        }else{
            System.out.println("cerrada");
        }

        System.out.println("Intentos fallidos: " + intentosFallidos);

        if (estado){
            System.out.println("Saldo: " + saldoActual);
        }else{
            System.out.println("Saldo: información protegida");
        }
    }
}
