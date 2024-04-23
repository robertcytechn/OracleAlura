public class MainApi {
    public static VentanaApi entanaApi;
    public static void main(String[] args) {
        // creamos un objeto de la clase APIGET
        entanaApi = new VentanaApi();
        
        // imprimimos el contenido de apiGet de ventanaApi con un for
        for (int i = 0; i < entanaApi.apiGet.monedas.length; i++) {
            System.out.println(entanaApi.apiGet.monedas[i].getMoneda() + " " + entanaApi.apiGet.monedas[i].getValor());
        }
    }
}
