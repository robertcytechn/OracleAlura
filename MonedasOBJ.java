public class MonedasOBJ {

    private double valor;
    private String moneda;
    
    public MonedasOBJ(double valorV, String monedaV) {
        this.valor = valorV;
        this.moneda = monedaV;
    }

    public double getValor() {
        return valor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double convertir(double cantidad){
        return cantidad * this.valor;
    }

    //convertir de una moneda a otra moneda
    public double convertir(MonedasOBJ moneda, double cantidad){
        return cantidad * this.valor / moneda.getValor();
    }
}
