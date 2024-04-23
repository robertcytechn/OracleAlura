import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIGET {
    // agregamos una lista que contenga objetos de clase monedas
    public MonedasOBJ monedas[];
    
    public APIGET() {
        // inicializamos la lista de monedas
        monedas = new MonedasOBJ[5];

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

            // - parseamos la respuesta
            String json = response.toString();
            String[] DataMonedas = json.split(",");
            for (int i = 0; i < DataMonedas.length; i++) {
                String[] moneda = DataMonedas[i].split(":");
                if (moneda[0].contains("USD")) {
                    monedas[0] = new MonedasOBJ(Double.parseDouble(moneda[1]), "USD");  // dolares americanos
                } 
                else if (moneda[0].contains("EUR")) {
                    monedas[1] = new MonedasOBJ(Double.parseDouble(moneda[1]), "EUR");  // euros
                } 
                else if (moneda[0].contains("JPY")) {
                    monedas[2] = new MonedasOBJ(Double.parseDouble(moneda[1]), "MXN");  // pesos mexicanos
                } 
                else if (moneda[0].contains("GBP")) {
                    monedas[3] = new MonedasOBJ(Double.parseDouble(moneda[1]), "GBP");  // libras
                } 
                else if (moneda[0].contains("AUD")) {
                    monedas[4] = new MonedasOBJ(Double.parseDouble(moneda[1]), "JPY");  // yenes
                } 
                else if (moneda[0].contains("CAD")) {
                    monedas[5] = new MonedasOBJ(Double.parseDouble(moneda[1]), "KRW"); // wones
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
