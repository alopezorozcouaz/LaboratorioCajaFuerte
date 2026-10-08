public class Main {
    public static void main(String []args){
        System.out.println("Iniciando simulador de caja fuerte");

        // declaración del objeto
        CajaFuerte caja = new CajaFuerte("000202601", "SecureBox A1",
                1234, 50000.0);

        System.out.println("Caja fuerte creada correctamente");
    }
}
