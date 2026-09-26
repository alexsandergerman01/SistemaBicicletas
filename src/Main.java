public class Main {
    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        BicicletaElectrica bicE01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        BicicletaElectrica bicE02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        BicicletaMontanya bicM01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
        BicicletaMontanya bicM02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

        bicE01.activarGarantiaExtendida();

        gestor.registrarBicicleta(bicE01);
        gestor.registrarBicicleta(bicE02);
        gestor.registrarBicicleta(bicM01);
        gestor.registrarBicicleta(bicM02);

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