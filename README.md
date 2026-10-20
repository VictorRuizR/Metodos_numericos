# Métodos Numéricos: Integración Numérica (Trapecio y Simpson 1/3 Compuesto)

**Materia:** SCC-1017 Métodos Numéricos
**Institución:** Instituto Tecnológico Superior de Xalapa — Ingeniería en Sistemas Computacionales
**Docente:** Víctor Hugo Vásquez Herrera
**Práctica:** Tarea 1, Unidad 4 — Implementación de Simpson 1/3 Compuesto y análisis comparativo
**Autor:** _(escribe aquí tu nombre)_

## Descripción

Proyecto en Java que aproxima la integral definida de una función con dos métodos:

- **Trapecio Compuesto**
- **Simpson 1/3 Compuesto**

Ambos usan el mismo criterio de paro: el número de subintervalos `n` se duplica en cada iteración (`n -> 2n`) hasta que el **error absoluto** entre dos aproximaciones sucesivas sea menor que la tolerancia.

Función de ejemplo: `f(x) = x^2` en el intervalo `[0, 2]`, con tolerancia `0.0001`. El valor exacto es `8/3 ≈ 2.6666666666...`.

## Estructura del proyecto

```
src/
└── dif_e_Integracion/
    ├── TrapecioCompuesto.java   # f(x), calcularH(), método base y método iterativo del Trapecio
    ├── SimpsonCompuesto.java    # Método base y método iterativo de Simpson 1/3 (reutiliza f(x) y h)
    ├── Main.java                # Ejecuta ambos métodos y los compara
    ├── MainTrap.java            # Ejecuta solo el Trapecio Compuesto
    └── MainSim.java             # Ejecuta solo Simpson 1/3 Compuesto
```

## Requisitos

- **JDK 8 o superior** (se probó con JDK 21).
- Opcional: IntelliJ IDEA u otro IDE.

Para verificar que Java está instalado:

```
java -version
javac -version
```

## Cómo compilar y ejecutar

### Opción A: desde la terminal

1. Clona el repositorio y entra a la carpeta raíz:

   ```
   git clone <URL-DEL-REPOSITORIO>
   cd <NOMBRE-DEL-REPOSITORIO>
   ```

2. Compila las clases del paquete `dif_e_Integracion` (los `.class` se generan en la carpeta `out`):

   ```
   javac -d out src/dif_e_Integracion/*.java
   ```

3. Ejecuta el programa que quieras (siempre desde la carpeta raíz del repositorio):

   ```
   java -cp out dif_e_Integracion.Main        # Trapecio y Simpson, uno tras otro
   java -cp out dif_e_Integracion.MainTrap    # Solo Trapecio Compuesto
   java -cp out dif_e_Integracion.MainSim     # Solo Simpson 1/3 Compuesto
   ```

### Opción B: desde IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona **File > Open**, luego elige la carpeta del proyecto.
2. Verifica que el SDK del proyecto sea un JDK (**File > Project Structure > Project**).
3. Abre `src/dif_e_Integracion/Main.java`.
4. Haz clic en el botón verde junto a `public static void main` y elige **Run 'Main.main()'**.

## Ejemplo de salida (`Main`, tolerancia = 0.0001)

```
--- ITERACIONES (TRAPECIO COMPUESTO) ---
n = 2 | Integral = 3.0
n = 4 | Integral = 2.75 | Error = 0.25
n = 8 | Integral = 2.6875 | Error = 0.0625
n = 16 | Integral = 2.671875 | Error = 0.015625
n = 32 | Integral = 2.66796875 | Error = 0.00390625
n = 64 | Integral = 2.6669921875 | Error = 9.765625E-4
n = 128 | Integral = 2.666748046875 | Error = 2.44140625E-4
n = 256 | Integral = 2.66668701171875 | Error = 6.103515625E-5

Resultado final Trapecio: 2.66668701171875

--- ITERACIONES (SIMPSON COMPUESTO) ---
n = 2 | Integral = 2.6666666666666665
n = 4 | Integral = 2.6666666666666665 | Error = 0.0

Resultado final Simpson: 2.6666666666666665
```

## Resumen de resultados

| Método | Iteraciones del `while` | `n` final | Resultado | Error vs. exacto (8/3) |
|---|---|---|---|---|
| Trapecio Compuesto | 7 | 256 | 2.66668701171875 | ≈ 2.03 × 10⁻⁵ |
| Simpson 1/3 Compuesto | 1 | 4 | 2.6666666666666665 | ≈ 0 |

Simpson 1/3 es exacto para polinomios de grado ≤ 3, por eso con `f(x) = x²` converge en la primera iteración. Para ver más iteraciones en Simpson, cambia `funcion` en `TrapecioCompuesto.java` por una función no polinómica, por ejemplo `Math.sin(x)` o `Math.exp(x)`.
