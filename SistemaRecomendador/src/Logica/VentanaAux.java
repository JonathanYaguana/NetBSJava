/*
 * Clase Java desarrolada por tage.
 *
 * Para información sobre el uso de esta clase, así como bugs, actualizaciones,
 * o mejoras envíar un email a ta.ge@hotmail.es
 */ 

package Logica;

import Agentes.agenteHumano;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * @author tage Expression correo is undefined on line 13, column 22 in Templates/Classes/Class.java.
 * @date 30/01/2018
 */

public class VentanaAux extends JFrame{
        
    private JLabel texto;           // etiqueta o texto no editable
    public JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion

    public VentanaAux() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }
    
    private void configurarVentana() {
        this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(310, 210);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto = new JLabel();
        caja = new JTextField();
        boton = new JButton();
        // configuramos los componentes
        texto.setText("Inserte Palabra:");    // colocamos un texto a la etiqueta
        texto.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Buscar");   // colocamos un texto al boton
        boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        //boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
       
        boton.setActionCommand("buscar");
        // adicionamos los componentes a la ventana
        this.add(texto);
        this.add(caja);
        this.add(boton);       
    }
    
    public JButton getBoton(){
        return boton;
    }
     
    public void newWindows(){
        VentanaAux V = new VentanaAux();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}
