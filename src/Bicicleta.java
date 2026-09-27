public abstract class Bicicleta {
    private String codigo;
    private  int anioFabricacion;
    private double peso;

    // 2. El constructor delega la asignación a los setters para validar
    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    // 3. Getters y Setters con las validaciones exigidas y manejo de excepciones
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        // Valida que no sea nulo ni vacío
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío.");
        }
        this.codigo = codigo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        // Valida que esté en el rango 2000 - 2026
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año de fabricación debe estar entre 2000 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        // Valida que sea mayor que cero
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero.");
        }
        this.peso = peso;
    }

    // 4. Método abstracto para calcular el costo (cada hija lo hará a su manera)
    public abstract double calcularCostoMantencion();

    // 5. toString que incluye únicamente el código y el año
    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}
