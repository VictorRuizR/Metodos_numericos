package dif_e_Integracion;

public class Main {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        // Trapecio Compuesto
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("\nResultado final Trapecio: " + resultadoTrapecio);

        System.out.println();

        // Simpson Compuesto
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("\nResultado final Simpson: " + resultadoSimpson);
    }
}