/*
 * ARGUMENTACIÓN TEÓRICA SOLICITADA:
 *
 * 1. Diferencia entre paradigmas: A diferencia de la programación estructurada (que se centra
 * en funciones y secuencias lógicas de arriba hacia abajo), la Programación Orientada a Objetos (POO)
 * permite modelar entidades del mundo real (como Bicicleta) agrupando sus datos (atributos) y
 * su comportamiento (métodos) en una misma estructura. Esto facilita la reutilización de código
 * mediante la herencia y el polimorfismo.
 *
 * 2. Argumentación sobre el tipado estático: Java utiliza un tipado estático, lo que significa
 * que el tipo de las variables se verifica en tiempo de compilación. Esto aporta una gran ventaja
 * en proyectos grandes, ya que previene errores de tipo antes de ejecutar el programa, asegurando
 * que una variable definida como BicicletaElectrica no reciba accidentalmente texto u otro tipo de dato.
 */

public class Main {
    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        System.out.println("=== REGISTRO DE BICICLETAS (CON MANEJO DE EXCEPCIONES) ===");

        // Se implementa bloque try-catch para capturar posibles errores de validación (IllegalArgumentException)
        try {
            BicicletaElectrica bicE01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
            BicicletaElectrica bicE02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
            BicicletaMontanya bicM01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
            BicicletaMontanya bicM02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

            bicE01.activarGarantiaExtendida();

            gestor.registrarBicicleta(bicE01);
            gestor.registrarBicicleta(bicE02);
            gestor.registrarBicicleta(bicM01);
            gestor.registrarBicicleta(bicM02);

            // Intento de registro inválido para demostrar que el catch funciona
            // BicicletaElectrica biciMala = new BicicletaElectrica("BIC-ERR", 1990, 20.0, 50, true);

        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar bicicleta: " + e.getMessage());
        }

        System.out.println("\n=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");
        Bicicleta encontrada = gestor.buscarPorCodigo("BIC-E01");
        if (encontrada != null && encontrada instanceof BicicletaElectrica) {
            BicicletaElectrica be = (BicicletaElectrica) encontrada;
            System.out.printf("Tipo: Bicicleta Eléctrica | Código: %s | Año: %d | Peso: %.1f kg | Autonomia: %d km | Bateria certificada: %s\n",
                    be.getCodigo(), be.getAnioFabricacion(), be.getPeso(), be.getAutonomiaKm(), be.isBateriaCertificada() ? "Si" : "No");
            System.out.printf("  Garantia extendida: %s | Costo mantención: $%.0f\n",
                    be.tieneGarantiaExtendidaActiva() ? "Si" : "No", be.calcularCostoMantencion());
        }
        System.out.println("---\n");

        System.out.println("=== LISTADO DE BICICLETAS ===");
        for (Bicicleta bici : gestor.getInventario()) {
            System.out.println(bici.toString());
        }
    }
}