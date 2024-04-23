public class Monedas {
    public Double valor;
    public String nombre;

    public Monedas(String nombre, Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String toString(){
        return this.nombre + " : " + this.valor;
    }

    public Double convertir(Double cantidad){
        return cantidad * this.valor;
    }

    public Double convertirA(Double cantidad, Monedas moneda){
        return cantidad * this.valor / moneda.valor;
    }
    
}
