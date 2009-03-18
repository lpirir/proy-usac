/*
 * MainPanel.java
 *
 * Created on 10 de septiembre de 2005, 11:01 PM
 */

import java.awt.event.*;
import java.awt.*;
/**Clase principal y Container secundario de la interfaz grafica, Controla todo lo visible y llama a la creacion de los demas paneles
 * @author Erik Giron
 */
public class MainPanel extends javax.swing.JPanel {
    private Tablero tab;
    private OpcionesJugador opcionesJug;
    private VisorCodigo vc;
    private final static String miNombre = "(C) 2005 Erik Vladimir Giron Marquez, C# 200313492";
    private static int switchPosInicial = 6;  // Switch estatico para cambiar posiciones iniciales de las fichas
    private javax.swing.JApplet appletPrincipal;

    /**Inicializa todo el panel*/
    public MainPanel() {

                System.out.println("O_TELL_O; Proyecto No. 2 de Lenguajes Formales.\n Desarrollado por: "
                                    + miNombre);
        initComponents();
     //   this.jButton3.setEnabled(false);
        opcionesJug = new OpcionesJugador();
        tab = new Tablero();
        initOpciones();
    }

    /**@param applet Applet principal que se pasa por parametro
     * Asigna al puntero appletPrincipal applet principal para obtener getDocumentBase */
    public void setAppletPrincipal(javax.swing.JApplet applet){
        //if (vc!= null)
            this.appletPrincipal = applet;
    }

    /**Dibuja y Redubuja el tablero con las opciones del jugador establecidas
     * @param evt Evento del mouse que llamo a la funcion*/
    private void initTablero(MouseEvent evt)
    {
        jLabelMensajes.setText("");
        kill(vc);
        if (opcionesJug.getStatus() == true){
            kill(opcionesJug);
           /* try{
                remove(opcionesJug); // intenta remover tablero si no existe
            }
            catch(Exception e){
                System.out.println("Opciones Jugador no existe" + e.toString());
            }*/
        }
        else
        {
            jLabelMensajes.setText("Debe definir primero opciones de usuario");
        }
        if (tab.getJuegoIniciado()==true){
            kill(tab);
            tab = new Tablero();
        }

        tab.setJugador(opcionesJug.getJugador(),opcionesJug.getJugador2()); // Inicia al jugador humano con opciones dadas

        tab.setPosInicialFichas(this.switchPosInicial % 6); // Inicializa el layout predeterminado para las fichas
                                                            // segun la variable estatica switchPosInicial;
        //jLabelMensajes.setText("PRESIONE [ESC] SI DESEA TERMINAR EL JUEGO...");
        add(tab);   // agrega al container
        this.validateTree(); // redibuja ??
        tab.iniciarJuego();
//        jLabel1.setText("O_TELL_O");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
     /**Inicializa y dibuja el panel de opciones de jugador*/
    private void initOpciones(){
        jLabelMensajes.setText(miNombre);
        opcionesJug = new OpcionesJugador();
            /*try{
                remove(tab);

            }
            catch(Exception e){
                System.out.println("Tab no existe" + e.toString());
            }*/
        //killVisor();
            kill(vc);
            kill(tab);
            add(opcionesJug);
            this.validateTree();
    }

    /**Quita y elimina del panel principal cualquier componente dado en el parametro usando polimorfismo parametrico
     *@param o Componente a eliminar*/
    private void kill(Component o){
            try{
                remove(o);
            }
            catch(Exception e){
                System.out.println("Visor no existe: " + e.toString());
            }
    }
    /**Inicializa y dibuja el panel de visor de Codigo*/
    private void initSourceViewer(){
        vc = new VisorCodigo(appletPrincipal);
//        vc.setAppletPrincipal(appletPrincipal);
        kill(tab);
        kill(opcionesJug);
    //    killTablero();
    //    killOpciones();
        add(vc);
        this.validateTree();

    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelMensajes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("(C) 2005 Erik Vladimir Giron Marquez, C# 200313492");
        jButton4.setText("Ver Records");
        jButton4.setToolTipText("Ver Records Personales...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());

        setMinimumSize(new java.awt.Dimension(640, 480));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel1.setBorder(new javax.swing.border.EtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(430, 32));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UNIVERSIDAD DE SAN CARLOS DE GUATEMALA");
        jPanel3.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 10));
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Proyecto No.2 Lenguajes Formales y de Programacion, 2do Ciclo 2005");
        jPanel3.add(jLabel2);

        jPanel1.add(jPanel3);

        jButton1.setText("Opciones Jugador...");
        jButton1.setToolTipText("Haga clic aqui para cambiar las opciones del Jugador.");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jPanel2.add(jButton1);

        jButton5.setText("Ver Codigo Fuente");
        jButton5.setToolTipText("Abre el manual de usuario");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });

        jPanel2.add(jButton5);

        jPanel1.add(jPanel2);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setMinimumSize(new java.awt.Dimension(432, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(432, 64));
        jPanel5.setPreferredSize(new java.awt.Dimension(432, 40));
        jButton3.setFont(new java.awt.Font("Dialog", 3, 12));
        jButton3.setText("Iniciar Nuevo Juego");
        jButton3.setToolTipText("Haga clic aqui para iniciar el juego...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });

        jPanel5.add(jButton3);

        jButton2.setText("Posicionar Fichas..");
        jButton2.setToolTipText("Intercambia Posiciones Iniciales de las fichas.");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });

        jPanel5.add(jButton2);

        jButton6.setText("Terminar Juego");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });

        jPanel5.add(jButton6);

        jPanel4.add(jPanel5);

        jLabelMensajes.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabelMensajes.setForeground(new java.awt.Color(255, 0, 102));
        jLabelMensajes.setText("Mensaje");
        jLabelMensajes.setPreferredSize(new java.awt.Dimension(480, 13));
        jPanel4.add(jLabelMensajes);

        add(jPanel4, java.awt.BorderLayout.SOUTH);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Haga clic en \"Iniciar Nuevo Juego\" para comenzar a jugar...");
        add(jLabel4, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        initSourceViewer();
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        if (tab.getJuegoIniciado() == true)
            tab.terminarJuego();
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        switchPosInicial += 1; // Aumenta el entero de la posicion Inicial
        initTablero(evt);
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased

    initTablero(evt);

    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        initOpciones();
    }//GEN-LAST:event_jButton1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMensajes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
