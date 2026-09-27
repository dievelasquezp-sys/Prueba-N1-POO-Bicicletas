import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {
    // Atributo: Una lista para guardar todas las bicicletas sin importar su tipo
    private List<Bicicleta> inventario;

    // Constructor: Inicializa la lista vacía cuando creamos el taller
    public GestorTallerBicicletas() {
        this.inventario = new ArrayList<>();
    }

    // Método para agregar bicicletas al taller
    public void agregarBicicleta(Bicicleta bicicleta) {
        inventario.add(bicicleta);
        System.out.println("Bicicleta agregada con éxito: " + bicicleta.getCodigo());
    }

    // Método para mostrar todas las bicicletas registradas usando el toString()
    public void mostrarBicicletas() {
        System.out.println("--- INVENTARIO DEL TALLER ---");
        for (Bicicleta bici : inventario) {
            System.out.println(bici.toString());
        }
    }

    // EL PUNTO ESTRELLA: Método que aplica POLIMORFISMO para calcular el costo total
    public double calcularCostoTotalMantencion() {
        double total = 0;
        for (Bicicleta bici : inventario) {
            // Polimorfismo: Java decide automáticamente si aplica la fórmula de Eléctrica o de Montaña
            total = total + bici.calcularCostoMantencion();
        }
        return total;
    }
}


