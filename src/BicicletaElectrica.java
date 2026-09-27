public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {
    private int autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaActiva;

    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomiaKm, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaActiva = false;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        // Validación agregada: La autonomía debe ser mayor a 0
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía en kilómetros debe ser mayor que cero.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        // Un boolean inherentemente solo acepta true o false, por lo que la validación es automática
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000;
        if (!bateriaCertificada) {
            costoBase += costoBase * 0.25;
        }
        return costoBase;
    }

    @Override
    public boolean tieneGarantiaExtendidaActiva() {
        return garantiaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaActiva = true;
    }
}