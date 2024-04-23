import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIGET {
    // agregamos una lista que contenga objetos de clase monedas
    public MonedasOBJ monedas[];
    
    public APIGET() {
        // inicializamos la lista de monedas
        monedas = new MonedasOBJ[6];

        // llenamos la lista con objetos de clase monedas y los datos de la API

        // - consumimos la API
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/USD"); // URL de la API
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String Data;
            StringBuilder response = new StringBuilder();
            while ((Data = reader.readLine()) != null) {
                response.append(Data);
            }
            reader.close();

            try {
                // - parseamos la respuesta
            String json = response.toString();
                String[] DataMonedas = json.split(",");
                // creamos un objeto de la clase MonedasOBJ con los datos de la moneda USD (dolares) en la posicion 0 con valor 1.0
                monedas[0] = new MonedasOBJ(1.0, "USD");

                // recorremos el array de datos de la API
                for (int i = 6; i < DataMonedas.length; i++) {

                    String[] monedaApiData = DataMonedas[i].split(":");
                    //remplasamos las comillas dobles
                    monedaApiData[0] = monedaApiData[0].replace("\"", "");
                    monedaApiData[1] = monedaApiData[1].replace("\"", "");
                    // eliminamos las llaves
                    monedaApiData[0] = monedaApiData[0].replace("{", "");
                    monedaApiData[0] = monedaApiData[0].replace("}", "");
                    monedaApiData[1] = monedaApiData[1].replace("{", "");
                    monedaApiData[1] = monedaApiData[1].replace("}", "");
                    // eliminamos los corchetes
                    monedaApiData[0] = monedaApiData[0].replace("[", "");
                    monedaApiData[0] = monedaApiData[0].replace("]", "");
                    monedaApiData[1] = monedaApiData[1].replace("[", "");
                    monedaApiData[1] = monedaApiData[1].replace("]", "");

                    if (monedaApiData[0].contains("EUR")) {
                        monedas[1] = new MonedasOBJ(Double.parseDouble(monedaApiData[1]), "EUR");  // euros
                    } 
                    else if (monedaApiData[0].contains("MXN")) {
                        monedas[2] = new MonedasOBJ(Double.parseDouble(monedaApiData[1]), "MXN");  // pesos mexicanos
                    } 
                    else if (monedaApiData[0].contains("GBP")) {
                        monedas[3] = new MonedasOBJ(Double.parseDouble(monedaApiData[1]), "LIBRAS");  // libras
                    } 
                    else if (monedaApiData[0].contains("JPY")) {
                        monedas[4] = new MonedasOBJ(Double.parseDouble(monedaApiData[1]), "YUNES");  // yenes
                    } 
                    else if (monedaApiData[0].contains("KRW")) {
                        monedas[5] = new MonedasOBJ(Double.parseDouble(monedaApiData[1]), "WONES"); // wones
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e + " al capturar los datos de la API");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public double convertir(String monedaDe, String monedaA, double cantidad) {
        // buscamos la moneda de origen y la moneda a la que se va a convertir en la lista de monedas
        MonedasOBJ monedaDeOBJ = null;
        MonedasOBJ monedaAOBJ = null;
        for (MonedasOBJ moneda : monedas) {
            if (moneda != null) {
                if (moneda.getMoneda().equals(monedaDe)) {
                    monedaDeOBJ = moneda;
                }
                if (moneda.getMoneda().equals(monedaA)) {
                    monedaAOBJ = moneda;
                }
            }
        }
        // si no se encuentran las monedas se retorna 0.0
        if (monedaDeOBJ != null && monedaAOBJ != null) {
            return cantidad * monedaAOBJ.getValor() / monedaDeOBJ.getValor();
        } else {
            return 0.0;
        }
    }
}
