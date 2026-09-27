public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

        // Atributos específicos de la eléctrica
        private int autonomia;
        private boolean bateriaCertificada;
        private boolean garantiaActiva; // Indicador de garantía

        // Constructor
        public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomia, boolean bateriaCertificada) {
            // "super" llama al constructor de la clase padre (Bicicleta)
            super(codigo, anioFabricacion, peso);
            this.autonomia = autonomia;
            this.bateriaCertificada = bateriaCertificada;
            this.garantiaActiva = false; // Por defecto asume que no tiene garantía extendida al crearla
        }

        // --- Implementación de la Interfaz ---
        @Override
        public boolean tieneGarantiaActiva() {
            return garantiaActiva;
        }

        @Override
        public void activarGarantia() {
            this.garantiaActiva = true;
        }

        // --- Implementación del cálculo de costo de mantención ---
        @Override
        public double calcularCostoMantencion() {
            double costoBase = 45000; // Costo base de eléctrica

            if (!bateriaCertificada) { // Si NO está certificada
                costoBase = costoBase + (costoBase * 0.25); // Aumenta 25%
            }

            return costoBase;
        }

        // Getters y Setters específicos
        public int getAutonomia() {
            return autonomia;
        }

        public void setAutonomia(int autonomia) {
            this.autonomia = autonomia;
        }

        public boolean isBateriaCertificada() {
            return bateriaCertificada;
        }

        public void setBateriaCertificada(boolean bateriaCertificada) {
            this.bateriaCertificada = bateriaCertificada;
        }
    }
