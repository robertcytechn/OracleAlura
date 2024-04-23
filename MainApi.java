public class MainApi {
    public static void main(String[] args) {
        // creamos un objeto de la clase APIGET
        APIGET api = new APIGET();
        
        // imprimimos los datos de la lista de monedas
        for (int i = 0; i < api.monedas.length; i++) {
            System.out.println(api.monedas[i].getMoneda() + ": " + api.monedas[i].getValor());
        }
    }
}
