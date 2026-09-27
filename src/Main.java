public class Main {
    public static void main(String[] args) {
        // 1. Instanciar el gestor del taller
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        System.out.println("--- REGISTRANDO BICICLETAS ---");

        try {
            // 2. Crear bicicletas de prueba (con datos correctos para pasar las validaciones)
            // Bicicleta Electrica: (codigo, año, peso, autonomia, bateriaCertificada)
            BicicletaElectrica bici1 = new BicicletaElectrica("ELEC-100", 2024, 25.5, 60, true);
            BicicletaElectrica bici2 = new BicicletaElectrica("ELEC-101", 2023, 28.0, 45, false); // Sin certificar

            // Bicicleta de Montaña: (codigo, año, peso, suspensiones)
            BicicletaMontania bici3 = new BicicletaMontania("MONT-200", 2022, 14.5, 2); // Más de 1 suspensión

            // 3. Agregar al gestor
            gestor.agregarBicicleta(bici1);
            gestor.agregarBicicleta(bici2);
            gestor.agregarBicicleta(bici3);

            // Activar garantía a una bicicleta eléctrica usando el método de la interfaz
            bici1.activarGarantia();

        } catch (IllegalArgumentException e) {
            // Si algún dato fuera inválido (ej. año 1990), el programa no se cae, sino que avisa:
            System.out.println("Error al registrar bicicleta: " + e.getMessage());
        }

        System.out.println("\n");

        // 4. Mostrar todas las bicicletas
        gestor.mostrarBicicletas();

        System.out.println("\n");

        // 5. Mostrar el costo total usando polimorfismo
        double costoTotal = gestor.calcularCostoTotalMantencion();
        System.out.println("--- CÁLCULO DE COSTOS ---");
        System.out.println("El costo total de mantención del taller es: $" + (int) costoTotal);

        /*
         * --- COMENTARIOS SOLICITADOS POR LA RÚBRICA SOBRE POO ---
         *
         * 1. Herencia: Se aplicó haciendo que BicicletaElectrica y BicicletaMontanya utilicen
         *    "extends Bicicleta". Esto permite que ambas clases hijas hereden los atributos (código,
         *    año, peso) y reutilicen el constructor de la clase padre mediante "super()".
         *
         * 2. Polimorfismo: Se evidencia en la clase GestorTallerBicicletas (método calcularCostoTotalMantencion).
         *    Al recorrer la lista genérica de Bicicletas, se llama al método calcularCostoMantencion(),
         *    y el programa decide automáticamente en tiempo de ejecución si aplicar la fórmula de
         *    la bicicleta eléctrica o de la de montaña.
         *
         * 3. Encapsulamiento: Se implementó utilizando modificadores "private" para todos los
         *    atributos, protegiendo los datos, y controlando su asignación mediante métodos "set"
         *    que validan las reglas de negocio (ej. año entre 2000 y 2026) antes de guardar la información.
         */
    }
}