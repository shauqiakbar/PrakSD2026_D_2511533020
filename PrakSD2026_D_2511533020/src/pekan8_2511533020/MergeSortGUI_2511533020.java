package pekan8_2511533020;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

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

public class MergeSortGUI_2511533020 extends JFrame {
    private static final long serialVersionUID = 1L;
    private int[] array_3020;
    private JLabel[] labelArray_3020;
    private JButton stepButton_3020, resetButton_3020, setButton_3020;
    private JTextField inputField_3020;
    private JPanel panelArray_3020;
    private JTextArea stepArea_3020;

    
    private Queue<int[]> mergeQueue_3020 = new LinkedList<>();
    private boolean isMerging_3020 = false;
    private boolean copying_3020 = false;
    private int left_3020, mid_3020, right_3020;
    private int[] temp_3020;
    private int i_3020, j_3020, k_3020;
    private int stepCount_3020 = 1;

    public MergeSortGUI_2511533020() {
        setTitle("Merge Sort Langkah per Langkah"); 
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

     
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

    private void generateMergeSteps_3020(int l_3020, int r_3020) {
        if (l_3020 < r_3020) {
            int m_3020 = (l_3020 + r_3020) / 2;
            generateMergeSteps_3020(l_3020, m_3020);
            generateMergeSteps_3020(m_3020 + 1, r_3020);
            mergeQueue_3020.add(new int[]{l_3020, m_3020, r_3020});
        }
    }

    private void setArrayFromInput_3020() {
        String text = inputField_3020.getText().trim();
        if (text.isEmpty()) return;
        String[] parts = text.split(",");
        array_3020 = new int[parts.length];
        try {
            for (int i_3020 = 0; i_3020 < parts.length; i_3020++) {
                array_3020[i_3020] = Integer.parseInt(parts[i_3020].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya Angka dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        labelArray_3020 = new JLabel[array_3020.length];
        panelArray_3020.removeAll();
        for (int i_3020 = 0; i_3020 < array_3020.length; i_3020++) {
            labelArray_3020[i_3020] = new JLabel(String.valueOf(array_3020[i_3020]));
            labelArray_3020[i_3020].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_3020[i_3020].setOpaque(true);
            labelArray_3020[i_3020].setBackground(Color.WHITE);
            labelArray_3020[i_3020].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_3020[i_3020].setPreferredSize(new Dimension(50, 50));
            labelArray_3020[i_3020].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_3020.add(labelArray_3020[i_3020]);
        }

        mergeQueue_3020.clear();
        generateMergeSteps_3020(0, array_3020.length - 1);
        stepButton_3020.setEnabled(true);
        stepArea_3020.setText("");
        stepCount_3020 = 1;
        isMerging_3020 = false;
        panelArray_3020.revalidate();
        panelArray_3020.repaint();
    }

    private void performStep_3020() {
        resetHighlights_3020();

        if (!isMerging_3020 && !mergeQueue_3020.isEmpty()) {
            int[] range = mergeQueue_3020.poll();
            left_3020 = range[0];
            mid_3020 = range[1];
            right_3020 = range[2];
            temp_3020 = new int[right_3020 - left_3020 + 1];
            i_3020 = left_3020;
            j_3020 = mid_3020 + 1;
            k_3020 = 0;
            copying_3020 = false;
            isMerging_3020 = true;
            stepArea_3020.append("Langkah " + stepCount_3020++ + ": Mulai merge dari " + left_3020 + " ke " + right_3020 + "\n");
            return;
        }

        if (isMerging_3020 && !copying_3020) {
            if (i_3020 <= mid_3020 && j_3020 <= right_3020) {
                labelArray_3020[i_3020].setBackground(Color.CYAN);
                labelArray_3020[j_3020].setBackground(Color.CYAN);
                if (array_3020[i_3020] <= array_3020[j_3020]) {
                    temp_3020[k_3020++] = array_3020[i_3020++];
                } else {
                    temp_3020[k_3020++] = array_3020[j_3020++];
                }
                stepArea_3020.append("Langkah " + stepCount_3020++ + ": Bandingkan dan salin elemen\n");
                return;
            } else if (i_3020 <= mid_3020) { 
                temp_3020[k_3020++] = array_3020[i_3020++];
                stepArea_3020.append("Langkah " + stepCount_3020++ + ": Salin sisa kiri\n");
                return;
            } else if (j_3020 <= right_3020) {
                temp_3020[k_3020++] = array_3020[j_3020++];
                stepArea_3020.append("Langkah " + stepCount_3020++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying_3020 = true; 
                k_3020 = 0;
                return;
            }
        }

        if (copying_3020 && k_3020 < temp_3020.length) {
            array_3020[left_3020 + k_3020] = temp_3020[k_3020];
            labelArray_3020[left_3020 + k_3020].setText(String.valueOf(temp_3020[k_3020])); 
            labelArray_3020[left_3020 + k_3020].setBackground(Color.GREEN); 
            k_3020++;
            stepArea_3020.append("Langkah " + stepCount_3020++ + ": Tempelkan ke array utama\n"); 
            return;
        }

        if (copying_3020 && k_3020 == temp_3020.length) {
            isMerging_3020 = false;
            copying_3020 = false;
        }

        if (mergeQueue_3020.isEmpty() && !isMerging_3020) {
            stepArea_3020.append("Selesai.\n");
            stepButton_3020.setEnabled(false); 
            JOptionPane.showMessageDialog(this, "Merge Sort Selesai"); // ← Diperbaiki
        }
    }

    private void resetHighlights_3020() { // ← Diperbaiki: Hightlights jadi Highlights
        if (labelArray_3020 == null) return;
        for (JLabel label : labelArray_3020) { // ← Diperbaiki: JLabel_3020 jadi JLabel
            if (label.getBackground() != Color.GREEN) {
                label.setBackground(Color.WHITE);
            }
        }
    }

    private void reset_3020() {
        inputField_3020.setText("");
        panelArray_3020.removeAll();
        panelArray_3020.revalidate();
        panelArray_3020.repaint();
        stepArea_3020.setText("");
        stepButton_3020.setEnabled(false);
        if (mergeQueue_3020 != null) {
            mergeQueue_3020.clear();
        }
        isMerging_3020 = false;
        copying_3020 = false;
        stepCount_3020 = 1;
        array_3020 = null;
        labelArray_3020 = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511533020 gui_3020 = new MergeSortGUI_2511533020();
            gui_3020.setVisible(true);
        });
    }
}