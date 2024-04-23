import java.awt.Color;

import javax.swing.*;
public class Ventana extends JFrame{

    private JFrame ventana;
    private JPanel panelTitulo;
    private JLabel labelTitulo;

    private JComboBox<String> optionPaneMonedas;

    private JTextField textFieldCantidad;
    private JLabel labelCantidad;


    private JButton botonConvertir;
    private JButton botonCerrar;

    private JLabel labelValoresMonedas;
    private JLabel labelValoresMonedas1;
    private JLabel labelValoresMonedas2;

    // valores de las monedas 
    // 1 dolar = 17.12 pesos mexicanos
    // 1 euro = 18.25 pesos mexicanos
    // 1 yen = 0.18 pesos mexicanos
    // 1 won = 0.018 pesos mexicanos
    // 1 libra esterlina = 28.00 pesos mexicanos

    private double dolar = 17.12;
    private double euro = 18.25;
    private double yen = 0.18;
    private double won = 0.018;
    private double libraEsterlina = 28.00;

    public Ventana(){
        ventana = new JFrame("Programa para convercion de monedas <José Roberto Tamayo>");
        ventana.setSize(500, 500);
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

        // ComboBoxMonedas agregamos las opciones de convercion de monedas
        optionPaneMonedas = new JComboBox<String>( new String[] {
            "Seleccione una opcion", // 0
            "Pesos Mx a Dolares", // 1
            "Pesos Mx a Euros",    // 2
            "Pesos Mx a Yenes",   // 3
            "Pesos Mx a Won",    // 4
            "Pesos Mx a Libras Esterlinas",  // 5
            "Dolares a Pesos Mx",  // 6
            "Euros a Pesos Mx",  // 7
            "Yenes a Pesos Mx",  // 8
            "Won a Pesos Mx",    // 9
            "Libras Esterlinas a Pesos Mx"  // 10
        });
        optionPaneMonedas.setSelectedIndex(0);
        optionPaneMonedas.setBackground(new Color(35, 35, 35));
        optionPaneMonedas.setForeground(new Color(255, 255, 255));
        optionPaneMonedas.setBounds(150, 65, 200, 30);
        ventana.add(optionPaneMonedas);


        // TextField para ingresar la cantidad y label
        labelCantidad = new JLabel("Cantidad que deceas convertir:");
        labelCantidad.setBounds(50, 100, 200, 30);
        labelCantidad.setForeground(new Color(255, 255, 255));
        ventana.add(labelCantidad);


        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(250, 100, 200, 30);
        textFieldCantidad.setBackground(new Color(35, 35, 35));
        textFieldCantidad.setForeground(new Color(255, 255, 255));
        ventana.add(textFieldCantidad);

        // Boton para convertir
        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(150, 150, 100, 30);
        botonConvertir.setBackground(new Color(60, 60, 60));
        botonConvertir.setForeground(new Color(255, 255, 255));
        ventana.add(botonConvertir);

        // Agregamos el evento al boton convertir onclick para convertir la moneda
        botonConvertir.addActionListener(e -> {
            String cantidad = textFieldCantidad.getText();
            String moneda = optionPaneMonedas.getSelectedItem().toString();
            int selectDefault = optionPaneMonedas.getSelectedIndex();

            double CantidadEnDoble = 0;
            
            //colocamos un if para verificar si la cantidad no esta vacia

            // Verificamos si la cantidad es un numero si no lo es mostramos un mensaje de error
            // con esto controlamos el error o la excepcion que se pueda generar
            try {
                CantidadEnDoble = Double.parseDouble(cantidad);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "La cantidad ingresada no es valida, debe de ser un nuemo entero o flotante", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // verificacmos que se alla seleccionado una moneda para convertir
            if(selectDefault < 1){
                JOptionPane.showMessageDialog(null, "Debes de seleccionar una moneda para convertir", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                // Verificamos que moneda se selecciono para convertir
                switch (moneda) {
                    // aqui mostramos el resultado de la convercion de la moneda [los valores de las monedas tambien se pueden cambiar aqui]
                    case "Pesos Mx a Dolares":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " pesos mexicanos es igual a " + (CantidadEnDoble / dolar) + " dolares", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Pesos Mx a Euros":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " pesos mexicanos es igual a " + (CantidadEnDoble / euro) + " euros", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Pesos Mx a Yenes":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " pesos mexicanos es igual a " + (CantidadEnDoble / yen) + " yenes", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Pesos Mx a Won":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " pesos mexicanos es igual a " + (CantidadEnDoble / won) + " won", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Pesos Mx a Libras Esterlinas":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " pesos mexicanos es igual a " + (CantidadEnDoble / libraEsterlina) + " libras esterlinas", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;


                    case "Dolares a Pesos Mx":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " dolares es igual a " + (CantidadEnDoble * dolar) + " pesos mexicanos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Euros a Pesos Mx":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " euros es igual a " + (CantidadEnDoble * euro) + " pesos mexicanos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Yenes a Pesos Mx":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " yenes es igual a " + (CantidadEnDoble * yen) + " pesos mexicanos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Won a Pesos Mx":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " won es igual a " + (CantidadEnDoble * won) + " pesos mexicanos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Libras Esterlinas a Pesos Mx":
                        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " libras esterlinas es igual a " + (CantidadEnDoble * libraEsterlina) + " pesos mexicanos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        break;
                }
            }

        });



        // Label para mostrar los valores de las monedas
        labelValoresMonedas = new JLabel("Valores de las monedas: 1 dolar = 17.12 pesos mexicanos, ");
        labelValoresMonedas.setBounds(10, 300, 500, 30);
        labelValoresMonedas.setForeground(new Color(255, 255, 255));
        ventana.add(labelValoresMonedas);

        labelValoresMonedas1 = new JLabel("1 euro = 18.25 pesos mexicanos, 1 yen = 0.18 pesos mexicanos, ");
        labelValoresMonedas1.setBounds(10, 320, 500, 30);
        labelValoresMonedas1.setForeground(new Color(255, 255, 255));
        ventana.add(labelValoresMonedas1);

        labelValoresMonedas2 = new JLabel("1 won = 0.018 pesos mexicanos, 1 libra esterlina = 28.00 pesos mexicanos");
        labelValoresMonedas2.setBounds(10, 340, 500, 30);
        labelValoresMonedas2.setForeground(new Color(255, 255, 255));
        ventana.add(labelValoresMonedas2);

        ventana.setVisible(true);



        // agregamos boton de cerrar 
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(360, 410, 100, 30);
        botonCerrar.setBackground(Color.red);
        botonCerrar.setForeground(new Color(255, 255, 255));
        ventana.add(botonCerrar);


        // Agregamos el evento al boton cerrar para cerrar la ventana
        botonCerrar.addActionListener(e -> {
            System.out.println("Gracias por usar el programa para convertir monedas de cambios :D <José Roberto Tamayo Montejano>");
            System.exit(0);
        });

    }
}
