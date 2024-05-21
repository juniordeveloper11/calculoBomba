
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraBomba extends JFrame {
    private JTextField textFieldVazao;
    private JTextField textFieldAltura;
    private JTextField textFieldEficiencia;
    private JLabel labelResultado;

    public CalculadoraBomba() {
        setTitle("Calculadora de Bomba Centrífuga e Submersa");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos componentes
        JLabel labelVazao = new JLabel("Vazão (m³/h):");
        textFieldVazao = new JTextField(10);

        JLabel labelAltura = new JLabel("Altura (m):");
        textFieldAltura = new JTextField(10);

        JLabel labelEficiencia = new JLabel("Eficiência (%):");
        textFieldEficiencia = new JTextField(10);

        JButton buttonCalcular = new JButton("Calcular");
        labelResultado = new JLabel("Resultado: ");

        // Adiciona ação ao botão
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPotencia();
            }
        });

        // Configuração do layout
        setLayout(new GridLayout(5, 2));
        add(labelVazao);
        add(textFieldVazao);
        add(labelAltura);
        add(textFieldAltura);
        add(labelEficiencia);
        add(textFieldEficiencia);
        add(buttonCalcular);
        add(labelResultado);
    }

    private void calcularPotencia() {
        try {
            double vazao = Double.parseDouble(textFieldVazao.getText());
            double altura = Double.parseDouble(textFieldAltura.getText());
            double eficiencia = Double.parseDouble(textFieldEficiencia.getText());

            double potencia = (vazao * altura) / (75 * (eficiencia / 100));

            labelResultado.setText(String.format("Potência da Bomba: %.2f kW", potencia));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraBomba().setVisible(true);
            }
        });
    }
}

