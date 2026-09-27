public class BicicletaMontania extends Bicicleta {
    // Atributo específico de montaña
    private int suspensiones;

    // Constructor que cumple la promesa con el padre
    public BicicletaMontania(String codigo, int anioFabricacion, double peso, int suspensiones) {
        super(codigo, anioFabricacion, peso);
        this.suspensiones = suspensiones;
    }

    // Método que cumple la promesa del cálculo
    @Override
    public double calcularCostoMantencion() {
        double costoBase = 30000;

        if (suspensiones > 1) {
            costoBase = costoBase + (costoBase * 0.15);
        }

        return costoBase;
    }

    // Getter y Setter
    public int getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(int suspensiones) {
        this.suspensiones = suspensiones;
    }
}

