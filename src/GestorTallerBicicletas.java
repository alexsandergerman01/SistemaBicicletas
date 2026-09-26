import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {
    private List<Bicicleta> inventario;

    public GestorTallerBicicletas() {
        this.inventario = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta bicicleta) {
        inventario.add(bicicleta);
        System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName() + ") registrada correctamente.");
    }

    public Bicicleta buscarPorCodigo(String codigo) {
        for (Bicicleta bici : inventario) {
            if (bici.getCodigo().equalsIgnoreCase(codigo)) {
                return bici;
            }
        }
        return null;
    }

    public List<Bicicleta> getInventario() {
        return inventario;
    }
}