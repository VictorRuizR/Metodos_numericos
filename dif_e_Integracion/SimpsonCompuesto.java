package dif_e_Integracion;

/**
 * Clase que implementa el método de Integración Numérica por Simpson 1/3 Compuesto
 * con un criterio de paro basado en el error absoluto y duplicación de subintervalos.
 */
public class SimpsonCompuesto {

    /**
     * Método base que calcula la aproximación de la integral mediante la
     * regla de Simpson 1/3 Compuesta para un número fijo de subintervalos (n).
     *
     * Fórmula: I = (h/3) * [ f(a) + 4*sum(f(x_impares)) + 2*sum(f(x_pares)) + f(b) ]
     *
     * @param a Límite inferior.
     * @param b Límite superior.
     * @param n Número de subintervalos (debe ser par).
     * @return La aproximación numérica de la integral para ese n.
     */
    private static double calcularSimpson(double a, double b, int n) {
        // Reutilizamos el método calcularH de la clase TrapecioCompuesto
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        // Recorremos los puntos intermedios desde k = 1 hasta n-1
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            // Si k es impar, lleva coeficiente 4; si k es par, lleva coeficiente 2
            if (k % 2 != 0) {
                // Reutilizamos la función f(x) de la clase TrapecioCompuesto
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        // Aplicación de la fórmula general de Simpson Compuesto usando TrapecioCompuesto.
        double extremos = TrapecioCompuesto.funcion(a) + TrapecioCompuesto.funcion(b);

        return (h / 3) * (extremos + 4 * sumaImpares + 2 * sumaPares);
    }

    /**
     * Método iterativo que aplica el criterio de paro por error absoluto.
     * Duplica el número de subintervalos (n -> 2n) en cada iteración del ciclo while
     * hasta que la diferencia entre dos aproximaciones sucesivas sea menor a la tolerancia.
     */
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2; // Número inicial de subintervalos (debe ser par)
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0; // Inicializamos con un valor grande para entrar al while

        System.out.println("--- ITERACIONES (SIMPSON COMPUESTO) ---");
        System.out.println("n = " + n + " | Integral = " + integralAnterior);

        // Ciclo while para evaluar la convergencia iterativa
        while (errorAbsoluto > tolerancia) {
            n *= 2; // Duplicamos los subintervalos (sigue siendo par)
            double integralNueva = calcularSimpson(a, b, n);

            // Cálculo del error absoluto entre la iteración nueva y la anterior
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error = " + errorAbsoluto);

            // Actualizamos el valor anterior para la siguiente comparación
            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}