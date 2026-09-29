import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConfiguracionPagina extends JFrame {

    private final JPanel panelPagina;

    private final JSpinner superior;
    private final JSpinner inferior;
    private final JSpinner izquierdo;
    private final JSpinner derecho;

    private final JComboBox<String> orientacion;

    public ConfiguracionPagina() {

        setTitle("Configuración de página");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // =========================
        // PANEL PRINCIPAL
        // =========================

        JPanel principal = new JPanel(new BorderLayout());
        principal.setBackground(new Color(235, 238, 242));

        // =========================
        // ENCABEZADO
        // =========================

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));

        encabezado.setBackground(
                new Color(35, 45, 58)
        );

        encabezado.setBorder(
                new EmptyBorder(20, 25, 20, 25)
        );

        JLabel titulo = new JLabel(
                "CONFIGURACIÓN DE PÁGINA"
        );

        titulo.setForeground(Color.WHITE);

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        23
                )
        );

        JLabel descripcion = new JLabel(
                "Modifica los márgenes y la orientación de la página"
        );

        descripcion.setForeground(
                new Color(235, 238, 242)
        );

        descripcion.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        encabezado.add(titulo);

        encabezado.add(
                Box.createVerticalStrut(5)
        );

        encabezado.add(descripcion);

        principal.add(
                encabezado,
                BorderLayout.NORTH
        );

        // =========================
        // PANEL DE CONTROLES
        // =========================

        JPanel controles = new JPanel();

        controles.setLayout(
                new BoxLayout(
                        controles,
                        BoxLayout.Y_AXIS
                )
        );

        controles.setBackground(Color.WHITE);

        controles.setBorder(
                new EmptyBorder(
                        25,
                        20,
                        25,
                        20
                )
        );

        controles.setPreferredSize(
                new Dimension(280, 0)
        );

        // =========================
        // MÁRGENES
        // =========================

        JLabel tituloMargenes =
                new JLabel("MÁRGENES");

        tituloMargenes.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        tituloMargenes.setForeground(
                new Color(25, 40, 60)
        );

        controles.add(tituloMargenes);

        controles.add(
                Box.createVerticalStrut(15)
        );

        // =========================
        // SPINNERS
        // =========================

        superior = crearSpinner(10);
        inferior = crearSpinner(10);
        izquierdo = crearSpinner(10);
        derecho = crearSpinner(10);

        controles.add(
                crearFila(
                        "Superior:",
                        superior
                )
        );

        controles.add(
                Box.createVerticalStrut(10)
        );

        controles.add(
                crearFila(
                        "Inferior:",
                        inferior
                )
        );

        controles.add(
                Box.createVerticalStrut(10)
        );

        controles.add(
                crearFila(
                        "Izquierdo:",
                        izquierdo
                )
        );

        controles.add(
                Box.createVerticalStrut(10)
        );

        controles.add(
                crearFila(
                        "Derecho:",
                        derecho
                )
        );

        controles.add(
                Box.createVerticalStrut(30)
        );

        // =========================
        // ORIENTACIÓN
        // =========================

        JLabel tituloOrientacion =
                new JLabel("ORIENTACIÓN");

        tituloOrientacion.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        tituloOrientacion.setForeground(
                new Color(25, 40, 60)
        );

        controles.add(tituloOrientacion);

        controles.add(
                Box.createVerticalStrut(10)
        );

        orientacion =
                new JComboBox<>();

        orientacion.addItem("Vertical");
        orientacion.addItem("Horizontal");

        orientacion.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        orientacion.setMaximumSize(
                new Dimension(230, 35)
        );

        controles.add(orientacion);

        controles.add(
                Box.createVerticalStrut(30)
        );

        
        JButton reset =
                new JButton("RESET ");

        reset.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        reset.setForeground(Color.WHITE);

        reset.setBackground(
                new Color(65, 105, 170)
        );

        reset.setFocusPainted(false);

        reset.setBorderPainted(false);

        reset.setOpaque(true);

        reset.setMaximumSize(
                new Dimension(230, 40)
        );

        controles.add(reset);

        

        controles.add(
                Box.createVerticalGlue()
        );

        

        JLabel ayuda =
                new JLabel(
                        "<html><center>" +
                        "Los cambios se muestran<br>" +
                        "automáticamente en la página." +
                        "</center></html>"
                );

        ayuda.setForeground(
                new Color(90, 105, 125)
        );

        ayuda.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        ayuda.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        ayuda.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        controles.add(ayuda);

        principal.add(
                controles,
                BorderLayout.WEST
        );

        

        panelPagina = new JPanel() {

            @Override
            protected void paintComponent(
                    Graphics g
            ) {

                super.paintComponent(g);

                dibujarPagina(g);
            }
        };

        panelPagina.setBackground(
                new Color(
                        225,
                        228,
                        233
                )
        );

        principal.add(
                panelPagina,
                BorderLayout.CENTER
        );

        

        superior.addChangeListener(
                e -> actualizar()
        );

        inferior.addChangeListener(
                e -> actualizar()
        );

        izquierdo.addChangeListener(
                e -> actualizar()
        );

        derecho.addChangeListener(
                e -> actualizar()
        );

        orientacion.addActionListener(
                e -> actualizar()
        );

        reset.addActionListener(
                e -> restablecer()
        );

        setContentPane(principal);
    }

    

    private JSpinner crearSpinner(
            int valor
    ) {

        JSpinner spinner =
                new JSpinner(
                        new SpinnerNumberModel(
                                valor,
                                0,
                                50,
                                1
                        )
                );

        spinner.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        return spinner;
    }

    
    private JPanel crearFila(
            String texto,
            JSpinner spinner
    ) {

        JPanel fila =
                new JPanel(
                        new BorderLayout(10, 0)
                );

        fila.setBackground(Color.WHITE);

        fila.setMaximumSize(
                new Dimension(240, 40)
        );

        JLabel etiqueta =
                new JLabel(texto);

        etiqueta.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        etiqueta.setForeground(
                new Color(25, 40, 60)
        );

        fila.add(
                etiqueta,
                BorderLayout.WEST
        );

        fila.add(
                spinner,
                BorderLayout.EAST
        );

        return fila;
    }

   

    private void dibujarPagina(
            Graphics g
    ) {

        Graphics2D g2 =
                (Graphics2D) g.create();

        
        

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int anchoPanel =
                panelPagina.getWidth();

        int altoPanel =
                panelPagina.getHeight();

        
        boolean horizontal =
                orientacion.getSelectedIndex() == 1;

        int anchoPagina;
        int altoPagina;

        if (horizontal) {

            anchoPagina = 500;
            altoPagina = 350;

        } else {

            anchoPagina = 350;
            altoPagina = 500;
        }

        int x =
                (anchoPanel - anchoPagina) / 2;

        int y =
                (altoPanel - altoPagina) / 2;

        

        g2.setColor(
                new Color(
                        180,
                        182,
                        185
                )
        );

        g2.fillRect(
                x + 8,
                y + 8,
                anchoPagina,
                altoPagina
        );

        

        g2.setColor(Color.WHITE);

        g2.fillRect(
                x,
                y,
                anchoPagina,
                altoPagina
        );

        

        g2.setColor(
                new Color(
                        60,
                        65,
                        70
                )
        );

        g2.setStroke(
                new BasicStroke(2)
        );

        g2.drawRect(
                x,
                y,
                anchoPagina,
                altoPagina
        );

       

        int margenSuperior =
                (int) superior.getValue();

        int margenInferior =
                (int) inferior.getValue();

        int margenIzquierdo =
                (int) izquierdo.getValue();

        int margenDerecho =
                (int) derecho.getValue();

        

        float escala = 3.0f;

        int ms =
                (int)
                (margenSuperior * escala);

        int mi =
                (int)
                (margenInferior * escala);

        int mizq =
                (int)
                (margenIzquierdo * escala);

        int mder =
                (int)
                (margenDerecho * escala);

       

        int areaX =
                x + mizq;

        int areaY =
                y + ms;

        int areaAncho =
                anchoPagina -
                mizq -
                mder;

        int areaAlto =
                altoPagina -
                ms -
                mi;

        if (areaAncho < 0)
            areaAncho = 0;

        if (areaAlto < 0)
            areaAlto = 0;

       

        g2.setColor(
                new Color(
                        100,
                        180,
                        255
                )
        );

        g2.setStroke(
                new BasicStroke(
                        2,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_ROUND
                )
        );

        g2.drawRect(
                areaX,
                areaY,
                areaAncho,
                areaAlto
        );


        g2.setColor(
                new Color(
                        25,
                        40,
                        60
                )
        );

        g2.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        String texto =
                horizontal
                        ? "Orientación horizontal"
                        : "Orientación vertical";

        // Centrar texto debajo de la hoja

        FontMetrics fm =
                g2.getFontMetrics();

        int anchoTexto =
                fm.stringWidth(texto);

        int textoX =
                x +
                (anchoPagina - anchoTexto) / 2;

        g2.drawString(
                texto,
                textoX,
                y + altoPagina + 25
        );

        g2.dispose();
    }

    private void actualizar() {

        panelPagina.repaint();
    }

    private void restablecer() {

        superior.setValue(10);
        inferior.setValue(10);
        izquierdo.setValue(10);
        derecho.setValue(10);

        orientacion.setSelectedIndex(0);

        panelPagina.repaint();
    }



    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            ConfiguracionPagina ventana =
                    new ConfiguracionPagina();

            ventana.setVisible(true);
        });
    }
}