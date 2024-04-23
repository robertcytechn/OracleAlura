import java.awt.Color;
import javax.swing.*;


public class VentanaApi {
    private JFrame ventana;
    private JPanel panelTitulo;
    private JLabel labelTitulo;

    private JLabel labelMonedaDe;
    private JComboBox<String> optionPaneMonedas;

    private JLabel labelMonedaA;
    private JComboBox<String> optionPaneMonedasA;

    private JTextField textFieldCantidad;
    private JLabel labelCantidad;


    private JButton botonConvertir;
    private JButton botonCerrar;

    public APIGET apiGet;

    public VentanaApi(){
        // iniciamos la APIGET
        apiGet = new APIGET();
        // valores y configuracion de la ventana
        ventana = new JFrame("Programa para convercion de monedas <José Roberto Tamayo>");
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(new Color(020, 20, 20));
        ventana.setLayout(null);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

         // Panel titulo
         panelTitulo = new JPanel();
         panelTitulo.setBounds(0, 0, 500, 50);
         panelTitulo.setBackground(new Color(35, 35, 35));
         panelTitulo.setLayout(null);
         ventana.add(panelTitulo);
 
         // Label titulo
         labelTitulo = new JLabel("Conversor de monedas");
         labelTitulo.setBounds(170, 10, 155, 30);
         labelTitulo.setForeground(new Color(255, 255, 255));
         panelTitulo.add(labelTitulo);

         // ComboBoxMonedas agregamos las opciones de convercion de monedas desde la API convertir de
        labelMonedaDe = new JLabel("De:");
        labelMonedaDe.setBounds(200, 65, 50, 30);
        labelMonedaDe.setForeground(new Color(255, 255, 255));
        ventana.add(labelMonedaDe);
        optionPaneMonedas = new JComboBox<String>( new String[] {
            "USD",
            "EUR",
            "MXN",
            "LIBRAS",
            "JUNES",
            "WONES",
           });
        optionPaneMonedas.setSelectedIndex(0);
        optionPaneMonedas.setBackground(new Color(35, 35, 35));
        optionPaneMonedas.setForeground(new Color(255, 255, 255));
        optionPaneMonedas.setBounds(250, 65, 200, 30);
        ventana.add(optionPaneMonedas);


        // ComboBoxMonedas agregamos las opciones de convercion de monedas desde la API convertir a
        labelMonedaA = new JLabel("A:");
        labelMonedaA.setBounds(200, 100, 50, 30);
        labelMonedaA.setForeground(new Color(255, 255, 255));
        ventana.add(labelMonedaA);
        optionPaneMonedasA = new JComboBox<String>( new String[] {
            "USD",
            "EUR",
            "MXN",
            "LIBRAS",
            "JUNES",
            "WONES",
           });
        optionPaneMonedasA.setSelectedIndex(0);
        optionPaneMonedasA.setBackground(new Color(35, 35, 35));
        optionPaneMonedasA.setForeground(new Color(255, 255, 255));
        optionPaneMonedasA.setBounds(250, 100, 200, 30);
        ventana.add(optionPaneMonedasA);

        // TextField para ingresar la cantidad y label
        labelCantidad = new JLabel("Cantidad que deceas convertir:");
        labelCantidad.setBounds(50, 160, 200, 30);
        labelCantidad.setForeground(new Color(255, 255, 255));
        ventana.add(labelCantidad);
        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(250, 160, 200, 30);
        textFieldCantidad.setBackground(new Color(35, 35, 35));
        textFieldCantidad.setForeground(new Color(255, 255, 255));
        ventana.add(textFieldCantidad);

        // Boton para convertir
        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(250, 200, 100, 30);
        botonConvertir.setBackground(new Color(60, 60, 60));
        botonConvertir.setForeground(new Color(255, 255, 255));
        ventana.add(botonConvertir);

        // Boton para cerrar
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(470, 510, 100, 30);
        botonCerrar.setBackground(Color.red);
        botonCerrar.setForeground(new Color(255, 255, 255));
        ventana.add(botonCerrar);

        // agregamos el evento del boton cerrar
        botonCerrar.addActionListener(e -> {
            System.exit(0);
        });

        // Agregamos el evento al boton convertir onclick para convertir la moneda
        botonConvertir.addActionListener(e -> {
            // obtenemos el valor de la moneda de
            String monedaDe = optionPaneMonedas.getSelectedItem().toString();
            // obtenemos el valor de la moneda a
            String monedaA = optionPaneMonedasA.getSelectedItem().toString();
            // obtenemos la cantidad a convertir
            String cantidad = textFieldCantidad.getText();
            // convertimos la moneda
            double resultado = apiGet.convertir(monedaDe, monedaA, Double.parseDouble(cantidad));
            // mostramos el resultado
            JOptionPane.showMessageDialog(null, "El resultado de " + cantidad + " " + monedaDe + " a "+ monedaA + " = " + resultado);
        });

        ventana.setVisible(true);
    }
}
