package pekan8_2511533020;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BubbleSortGUI_2511533020 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane_3020;
    private JTextField inputField_3020;
    private JButton inputButton_3020;
    private JButton stepButton_3020;
    private JButton resetButton_3020;
    private JPanel panelArray_3020;
    private JTextArea stepArea_3020;

    private int[] array_3020;
    private JLabel[] labelArray_3020;

    private int i_3020 = 0;
    private int j_3020 = 0;
    private int stepCount_3020 = 1;
    private boolean sorting_3020 = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BubbleSortGUI_2511533020 frame = new BubbleSortGUI_2511533020();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BubbleSortGUI_2511533020() {
        setTitle("Visualisasi Bubble Sort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 500);

        contentPane_3020 = new JPanel();
        contentPane_3020.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane_3020.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane_3020);

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel lblInput = new JLabel("Masukkan angka (pisahkan koma):");
        inputField_3020 = new JTextField(25);
        inputButton_3020 = new JButton("Tampilkan");

        topPanel.add(lblInput);
        topPanel.add(inputField_3020);
        topPanel.add(inputButton_3020);
        contentPane_3020.add(topPanel, BorderLayout.NORTH);

        panelArray_3020 = new JPanel();
        panelArray_3020.setLayout(new FlowLayout());
        contentPane_3020.add(panelArray_3020, BorderLayout.CENTER);

        stepArea_3020 = new JTextArea();
        stepArea_3020.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(stepArea_3020);
        scrollPane.setPreferredSize(new Dimension(300, 0));
        contentPane_3020.add(scrollPane, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        stepButton_3020 = new JButton("Sorting Selanjutnya");
        resetButton_3020 = new JButton("Reset");
        stepButton_3020.setEnabled(false);

        bottomPanel.add(stepButton_3020);
        bottomPanel.add(resetButton_3020);
        contentPane_3020.add(bottomPanel, BorderLayout.SOUTH);

        inputButton_3020.addActionListener(e -> setArrayFromInput_3020());
        stepButton_3020.addActionListener(e -> performStep_3020()); // ← Dipanggil performStep_3020
        resetButton_3020.addActionListener(e -> reset_3020());
    }

    private void setArrayFromInput_3020() {
        String text = inputField_3020.getText().trim();
        if (text.isEmpty()) return;

        String[] parts = text.split(",");
        array_3020 = new int[parts.length];

        try {
            for (int k_3020 = 0; k_3020 < parts.length; k_3020++) {
                array_3020[k_3020] = Integer.parseInt(parts[k_3020].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        i_3020 = 0;
        j_3020 = 0;
        stepCount_3020 = 1;
        sorting_3020 = true;

        stepButton_3020.setEnabled(true);
        stepArea_3020.setText("");

        panelArray_3020.removeAll();
        labelArray_3020 = new JLabel[array_3020.length];

        for (int k_3020 = 0; k_3020 < array_3020.length; k_3020++) {
            labelArray_3020[k_3020] = new JLabel(String.valueOf(array_3020[k_3020]));
            labelArray_3020[k_3020].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_3020[k_3020].setOpaque(true);
            labelArray_3020[k_3020].setBackground(Color.WHITE);
            labelArray_3020[k_3020].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_3020[k_3020].setPreferredSize(new Dimension(60, 50));
            labelArray_3020[k_3020].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_3020.add(labelArray_3020[k_3020]);
        }

        panelArray_3020.revalidate();
        panelArray_3020.repaint();
    }

    private void performStep_3020() {
        if (!sorting_3020 || i_3020 >= array_3020.length - 1) {
            sorting_3020 = false;
            stepButton_3020.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting Selesai!");
            return;
        }

        resetHighlights_3020();
        StringBuilder stepLog = new StringBuilder();

        labelArray_3020[j_3020].setBackground(Color.CYAN);
        labelArray_3020[j_3020 + 1].setBackground(Color.CYAN);

        
        if (array_3020[j_3020] > array_3020[j_3020 + 1]) {
            // Swap
            int temp_3020 = array_3020[j_3020];
            array_3020[j_3020] = array_3020[j_3020 + 1];
            array_3020[j_3020 + 1] = temp_3020;

            updateLabels_3020();

            labelArray_3020[j_3020].setBackground(Color.RED);
            labelArray_3020[j_3020 + 1].setBackground(Color.RED);

            stepLog.append("Langkah ").append(stepCount_3020).append(": Menukar elemen ke-")
                    .append(j_3020).append(" (").append(array_3020[j_3020 + 1]).append(") dengan ke-")
                    .append(j_3020 + 1).append(" (").append(array_3020[j_3020]).append(")\n");
        } else {
            stepLog.append("Langkah ").append(stepCount_3020).append(": Tidak ada pertukaran antara ke-")
                    .append(j_3020).append(" dan ke-").append(j_3020 + 1).append("\n");
        }

        stepLog.append("Hasil: ").append(arrayToString(array_3020)).append("\n\n");
        stepArea_3020.append(stepLog.toString()); // 

        j_3020++;

        if (j_3020 >= array_3020.length - i_3020 - 1) {
           
            labelArray_3020[array_3020.length - i_3020 - 1].setBackground(Color.GREEN);
            j_3020 = 0;
            i_3020++;
            stepCount_3020++;
        }

        if (i_3020 >= array_3020.length - 1) {
            sorting_3020 = false;
            stepButton_3020.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting Selesai!");
        }
    }

    private void updateLabels_3020() {
        for (int k_3020 = 0; k_3020 < array_3020.length; k_3020++) {
            labelArray_3020[k_3020].setText(String.valueOf(array_3020[k_3020]));
        }
    }

    private void resetHighlights_3020() {
        if (labelArray_3020 == null) return;
        for (JLabel label : labelArray_3020) { 
            label.setBackground(Color.WHITE); 
        }
    }

    private void reset_3020() {
        inputField_3020.setText("");
        panelArray_3020.removeAll();
        panelArray_3020.revalidate();
        panelArray_3020.repaint();
        stepArea_3020.setText("");
        stepButton_3020.setEnabled(false);

        array_3020 = null;      
        labelArray_3020 = null; 
        sorting_3020 = false;
        i_3020 = 0;
        j_3020 = 0;
        stepCount_3020 = 1;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int k_3020 = 0; k_3020 < arr.length; k_3020++) {
            sb.append(arr[k_3020]);
            if (k_3020 < arr.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}