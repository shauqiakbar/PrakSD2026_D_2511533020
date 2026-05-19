package pekan7_2511533020;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class InsertionSortGUI_2511533020 extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private int[] array_3020;
	    private JLabel[] labelArray_3020;
	    private JButton stepButton_3020, resetButton_3020, setButton_3020;
	    private JTextField inputField_3020;
	    private JPanel panelArray_3020;
	    private JTextArea stepArea_3020;

	    private int i_3020 = 1, j_3020;
	    private boolean sorting_3020 = false;
	    private int stepCount_3020 = 1;	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	    public InsertionSortGUI_2511533020() {
	        setTitle("Insertion Sort Langkah per Langkah");
	        setSize(750, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        // Panel input
	        JPanel inputPanel = new JPanel(new FlowLayout());
	        inputField_3020 = new JTextField(30);
	        setButton_3020 = new JButton("Set Array");
	        inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
	        inputPanel.add(inputField_3020);
	        inputPanel.add(setButton_3020);

	        panelArray_3020 = new JPanel();
	        panelArray_3020.setLayout(new FlowLayout());

	        JPanel controlPanel = new JPanel();
	        stepButton_3020 = new JButton("Langkah Selanjutnya");
	        resetButton_3020 = new JButton("Reset");
	        stepButton_3020.setEnabled(false);
	        controlPanel.add(stepButton_3020);
	        controlPanel.add(resetButton_3020);
	        
	        stepArea_3020 = new JTextArea(8, 60);
	        stepArea_3020.setEditable(false);
	        stepArea_3020.setFont(new Font("Monospaced", Font.PLAIN, 14));
	        JScrollPane scrollPane = new JScrollPane(stepArea_3020);

	        add(inputPanel, BorderLayout.NORTH);
	        add(panelArray_3020, BorderLayout.CENTER);
	        add(controlPanel, BorderLayout.SOUTH);
	        add(scrollPane, BorderLayout.EAST);

	        setButton_3020.addActionListener(e -> setArrayFromInput_3020());

	        stepButton_3020.addActionListener(e -> performStep_3020());

	        resetButton_3020.addActionListener(e -> reset_3020());
		
	    }
	    private void setArrayFromInput_3020() {
	        String text = inputField_3020.getText().trim();
	        if (text.isEmpty()) return;
	        String[] parts = text.split(",");
	        array_3020 = new int[parts.length];
	        try {
	            for (int k = 0; k < parts.length; k++) {
	                array_3020[k] = Integer.parseInt(parts[k].trim());
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan "
	                    + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        i_3020 = 1;
	        stepCount_3020 = 1;
	        sorting_3020 = true;
	        stepButton_3020.setEnabled(true);
	        stepArea_3020.setText("");
	        panelArray_3020.removeAll();
	        labelArray_3020 = new JLabel[array_3020.length];
	        for (int k = 0; k < array_3020.length; k++) {
	            labelArray_3020[k] = new JLabel(String.valueOf(array_3020[k]));
	            labelArray_3020[k].setFont(new Font("Arial", Font.BOLD, 24));
	            labelArray_3020[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            labelArray_3020[k].setPreferredSize(new Dimension(50, 50));
	            labelArray_3020[k].setHorizontalAlignment(SwingConstants.CENTER);
	            panelArray_3020.add(labelArray_3020[k]);
	        }
	        panelArray_3020.revalidate();
	        panelArray_3020.repaint();
	    }
	    private void performStep_3020() {
	        if (i_3020 < array_3020.length && sorting_3020) {
	            int key = array_3020[i_3020];
	            int j_3020 = i_3020 - 1;

	            StringBuilder stepLog = new StringBuilder();
	            stepLog.append("Langkah ").append(stepCount_3020).
	            append(": Memasukkan ").append(key).append("\n");

	            while (j_3020 >= 0 && array_3020[j_3020] > key) {
	                array_3020[j_3020 + 1] = array_3020[j_3020];
	                j_3020--;
	            }
	            array_3020[j_3020 + 1] = key;

	            updateLabels();
	            stepLog.append("Hasil: ").append(arrayToString(array_3020)).append("\n\n");
	            stepArea_3020.append(stepLog.toString());

	            i_3020++;
	            stepCount_3020++;

	            if (i_3020 == array_3020.length) { 
	                sorting_3020 = false;
	                stepButton_3020.setEnabled(false);
	                JOptionPane.showMessageDialog(this, "Sorting selesai!");
	        }
	        }
	    }
	            private void updateLabels() {
	                for (int k = 0; k < array_3020.length; k++) {
	                    labelArray_3020[k].setText(String.valueOf(array_3020[k]));
	                }
	            }

	            private void reset_3020() {
	                inputField_3020.setText("");
	                panelArray_3020.removeAll();
	                panelArray_3020.revalidate();
	                panelArray_3020.repaint();
	                stepArea_3020.setText("");
	                stepButton_3020.setEnabled(false);
	                sorting_3020 = false;
	                i_3020 = 1;
	                stepCount_3020 = 1;
	            }

	            private String arrayToString(int[] arr_3020) {
	                StringBuilder sb = new StringBuilder();
	                for (int k = 0; k < arr_3020.length; k++) {
	                    sb.append(arr_3020[k]);
	                    if (k < arr_3020.length - 1) sb.append(", ");
	                }
	                return sb.toString();
	            }

	            public static void main(String[] args) {
	                SwingUtilities.invokeLater(() -> {
	                    InsertionSortGUI_2511533020 gui = new InsertionSortGUI_2511533020();
	                    gui.setVisible(true);
	                });
	            }
	        }