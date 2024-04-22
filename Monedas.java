public class Monedas {
    public String nombre;
    public double valor; // valor en dólares

    public Monedas(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // convertir de dólares a la moneda actual
    public double convertir(double cantidad) {
        return cantidad / this.valor;
    }

    // convertir de la moneda actual a otra moneda
    public double convertir(Monedas otraMoneda, double cantidad) {
        return this.convertir(cantidad) * otraMoneda.valor;
    }

    // imprimir la moneda
    @Override
    public String toString() {
        return this.nombre + " (" + this.valor + ")";
    }
    
}
