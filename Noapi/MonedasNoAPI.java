public class MonedasNoAPI {
    public Double valor;
    public String nombre;

    public MonedasNoAPI(String nombre, Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String toString(){
        return this.nombre + " : " + this.valor;
    }

    public Double convertir(Double cantidad){
        return cantidad * this.valor;
    }

    public Double convertirA(Double cantidad, MonedasNoAPI moneda){
        return cantidad * this.valor / moneda.valor;
    }
    
}
