//creamos una clase para hacer un conversor de monedas

public class ConversorMonedas {

    // creamos una lista de monedas de la clase Monedas
    public static Monedas[] monedas = {
        new Monedas("Dólar", 1),
        new Monedas("Euro", 0.85),
        new Monedas("Libra", 0.77),
        new Monedas("Yen", 110.92),
        new Monedas("Peso Mexicano", 19.22),
        new Monedas("Peso Colombiano", 3285.0),
        new Monedas("Peso Argentino", 37.0),
        new Monedas("Real", 3.25),
        new Monedas("Bolívar", 248487.0),
        new Monedas("Bitcoin", 0.00011)
    };
    

    public static void main(String[] args) {
        System.out.println("Conversor de monedas José Roberto Tamayo Montejano");

        // imprimimos las monedas disponibles
        for (int i = 0; i < monedas.length; i++) {
            System.out.println((i + 1) + ". " + monedas[i]);
        }

        // seleccionamos la moneda de origen
        int monedaOrigen = 0;
        System.out.println("Selecciona la moneda de origen:");
        // leemos la moneda de origen del usuario y la guardamos en la variable monedaOrigen si no es un numero entero volvelo a pedir
        while (monedaOrigen < 1 || monedaOrigen > monedas.length) {
            System.out.print("Introduce un número entre 1 y " + monedas.length + ": ");
            // controlamos el error si el usuario introduce un valor que no es un número
            try {
                monedaOrigen = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero.");
            }
        }

       //hacemos un menu para saber si el usuario seguira convirtiendo momnedas o no
        boolean continuar = true;
        while (continuar) {
            // seleccionamos la moneda de destino
            int monedaDestino = 0;
            System.out.println("Selecciona la moneda de destino:");
            // leemos la moneda de destino del usuario y la guardamos en la variable monedaDestino si no es un numero entero volvelo a pedir
            while (monedaDestino < 1 || monedaDestino > monedas.length) {
                System.out.print("Introduce un número entre 1 y " + monedas.length + ": [numero de la moneda de destino]");
                // controlamos el error si el usuario introduce un valor que no es un número
                try {
                    monedaDestino = Integer.parseInt(System.console().readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número entero.");
                }
            }

            // leemos la cantidad a convertir
            double cantidad = 0;
            System.out.print("Introduce la cantidad a convertir: ");
            // leemos la cantidad a convertir del usuario y la guardamos en la variable cantidad si no es un numero entero volvelo a pedir
            while (cantidad <= 0) {
                // controlamos el error si el usuario introduce un valor que no es un número
                try {
                    cantidad = Double.parseDouble(System.console().readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número.");
                }
            }

            // convertimos la cantidad de la moneda de origen a la moneda de destino
            double resultado = monedas[monedaOrigen - 1].convertir(monedas[monedaDestino - 1], cantidad);
            System.out.println(cantidad + " " + monedas[monedaOrigen - 1].nombre + " son " + resultado + " " + monedas[monedaDestino - 1].nombre);

            // preguntamos al usuario si quiere seguir convirtiendo monedas
            System.out.print("¿Quieres convertir otra cantidad? (s/n): ");
            String respuesta = System.console().readLine();
            continuar = respuesta.equals("s");
        }

        System.out.println("¡Hasta luego! Gracias por usar el conversor de monedas de José Roberto Tamayo Montejano");
        System.out.println("vuelve pronto");
    }
}