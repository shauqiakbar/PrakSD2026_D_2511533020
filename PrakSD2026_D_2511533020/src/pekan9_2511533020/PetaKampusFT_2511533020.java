package pekan9_2511533020;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PetaKampusFT_2511533020 extends JFrame {

  
    private Map<String, List<String>> adjMatrix_3020;
    private Map<String, Point> nodePositions_3020;
    private List<String> visitedNodes_3020;
    private List<String> pathFound_3020;
    private String currentMethod_3020 = "";
    
   
    private JComboBox<String> cmbStart_3020;
    private JComboBox<String> cmbGoal_3020;
    private JButton btnBFS_3020, btnDFS_3020, btnReset_3020;
    private JLabel lblHasil_3020, lblJalur_3020, lblDikunjungi_3020, lblJumlah_3020;
    private GraphPanel_3020 panelGraph_3020;

    public PetaKampusFT_2511533020() {
        setTitle("Pencarian Jalur FT UNAND - 2511533020");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        JPanel mainPanel_3020 = new JPanel();
        mainPanel_3020.setLayout(null);
        mainPanel_3020.setBackground(new Color(235, 240, 245));
        setContentPane(mainPanel_3020);

        
        initGraphData_3020();

       
        JPanel banner_3020 = new JPanel(null);
        banner_3020.setBackground(new Color(27, 79, 114));
        banner_3020.setBounds(0, 0, 850, 45);
        JLabel lblTitle_3020 = new JLabel("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS", JLabel.CENTER);
        lblTitle_3020.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitle_3020.setForeground(Color.WHITE);
        lblTitle_3020.setBounds(0, 0, 850, 45);
        banner_3020.add(lblTitle_3020);
        mainPanel_3020.add(banner_3020);

        
        JLabel lblStart = new JLabel("Lokasi Awal  :");
        lblStart.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblStart.setBounds(20, 60, 90, 25);
        mainPanel_3020.add(lblStart);

        String[] nodesArray = nodePositions_3020.keySet().toArray(new String[0]);
        cmbStart_3020 = new JComboBox<>(nodesArray);
        cmbStart_3020.setBounds(115, 60, 130, 25);
        mainPanel_3020.add(cmbStart_3020);

        JLabel lblGoal = new JLabel("Lokasi Tujuan :");
        lblGoal.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblGoal.setBounds(20, 95, 90, 25);
        mainPanel_3020.add(lblGoal);

        cmbGoal_3020 = new JComboBox<>(nodesArray);
        cmbGoal_3020.setBounds(115, 95, 130, 25);
        mainPanel_3020.add(cmbGoal_3020);

     
        btnBFS_3020 = new JButton("[ BFS ]");
        btnBFS_3020.setBackground(new Color(46, 204, 113));
        btnBFS_3020.setForeground(Color.BLACK);
        btnBFS_3020.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnBFS_3020.setBounds(480, 75, 90, 30);
        mainPanel_3020.add(btnBFS_3020);

        
        btnDFS_3020 = new JButton("[ DFS ]");
        btnDFS_3020.setBackground(new Color(244, 156, 23));
        btnDFS_3020.setForeground(Color.BLACK);
        btnDFS_3020.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnDFS_3020.setBounds(585, 75, 90, 30);
        mainPanel_3020.add(btnDFS_3020);

     
        btnReset_3020 = new JButton("[ RESET ]");
        btnReset_3020.setBackground(new Color(231, 76, 60));
        btnReset_3020.setForeground(Color.WHITE);
        btnReset_3020.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnReset_3020.setBounds(690, 75, 100, 30);
        mainPanel_3020.add(btnReset_3020);

     
        panelGraph_3020 = new GraphPanel_3020();
        panelGraph_3020.setBounds(20, 140, 795, 270);
        mainPanel_3020.add(panelGraph_3020);

      
        lblHasil_3020 = new JLabel("Hasil Pencarian :");
        lblHasil_3020.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblHasil_3020.setBounds(20, 425, 600, 20);
        mainPanel_3020.add(lblHasil_3020);

        lblJalur_3020 = new JLabel("Jalur :");
        lblJalur_3020.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblJalur_3020.setBounds(20, 445, 790, 20);
        mainPanel_3020.add(lblJalur_3020);

        lblDikunjungi_3020 = new JLabel("Node Dikunjungi :");
        lblDikunjungi_3020.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblDikunjungi_3020.setBounds(20, 465, 790, 20);
        mainPanel_3020.add(lblDikunjungi_3020);

        lblJumlah_3020 = new JLabel("Jumlah Node Dikunjungi : 0");
        lblJumlah_3020.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblJumlah_3020.setBounds(20, 485, 400, 20);
        mainPanel_3020.add(lblJumlah_3020);

      
        btnBFS_3020.addActionListener(e -> BFS());
        btnDFS_3020.addActionListener(e -> DFS());
        btnReset_3020.addActionListener(e -> resetGraph());
    }

    private void initGraphData_3020() {
        adjMatrix_3020 = new LinkedHashMap<>();
        nodePositions_3020 = new LinkedHashMap<>();
        visitedNodes_3020 = new ArrayList<>();
        pathFound_3020 = new ArrayList<>();

        
        nodePositions_3020.put("Dekanat", new Point(60, 60));
        nodePositions_3020.put("Teknik_Sipil", new Point(340, 60));
        nodePositions_3020.put("Teknik_Mesin", new Point(620, 60));
        
        nodePositions_3020.put("Gedung_A", new Point(60, 130));
        nodePositions_3020.put("Teknik_Lingkungan", new Point(340, 130));
        nodePositions_3020.put("Teknik_Elektro", new Point(620, 130));
        
        nodePositions_3020.put("Gedung_B", new Point(60, 200));
        nodePositions_3020.put("Lab_Terpadu", new Point(340, 200));
        nodePositions_3020.put("Masjid_Teknik", new Point(620, 200));
        
        nodePositions_3020.put("Teknik_Industri", new Point(340, 250));

        for (String node : nodePositions_3020.keySet()) {
            adjMatrix_3020.put(node, new ArrayList<>());
        }

      
        addEdge_3020("Dekanat", "Gedung_A");
        addEdge_3020("Dekanat", "Teknik_Sipil");
        addEdge_3020("Dekanat", "Teknik_Mesin");
        addEdge_3020("Gedung_A", "Gedung_B");
        addEdge_3020("Gedung_A", "Teknik_Industri");
        addEdge_3020("Gedung_B", "Lab_Terpadu");
        addEdge_3020("Gedung_B", "Teknik_Mesin");
        addEdge_3020("Teknik_Sipil", "Teknik_Mesin");
        addEdge_3020("Teknik_Sipil", "Lab_Terpadu");
        addEdge_3020("Teknik_Mesin", "Teknik_Elektro");
        addEdge_3020("Teknik_Elektro", "Teknik_Industri");
        addEdge_3020("Teknik_Elektro", "Masjid_Teknik");
        addEdge_3020("Teknik_Industri", "Teknik_Lingkungan");
        addEdge_3020("Teknik_Lingkungan", "Teknik_Sipil");
        addEdge_3020("Lab_Terpadu", "Masjid_Teknik");
        addEdge_3020("Masjid_Teknik", "Teknik_Lingkungan");
    }

    private void addEdge_3020(String u, String v) {
        adjMatrix_3020.get(u).add(v);
        adjMatrix_3020.get(v).add(u);
    }


    public void BFS() {
        visitedNodes_3020.clear();
        pathFound_3020.clear();
        currentMethod_3020 = "BFS";
        
        String start = (String) cmbStart_3020.getSelectedItem();
        String goal = (String) cmbGoal_3020.getSelectedItem();

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(start);
        visitedNodes_3020.add(start);

        boolean found = false;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(goal)) {
                found = true;
                break;
            }
            for (String neighbor : adjMatrix_3020.get(current)) {
                if (!visitedNodes_3020.contains(neighbor)) {
                    visitedNodes_3020.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (found) {
            String curr = goal;
            while (curr != null) {
                pathFound_3020.add(0, curr);
                curr = parentMap.get(curr);
            }
        }
        displayPath();
        displayGraph();
    }

   
    public void DFS() {
        visitedNodes_3020.clear();
        pathFound_3020.clear();
        currentMethod_3020 = "DFS";

        String start = (String) cmbStart_3020.getSelectedItem();
        String goal = (String) cmbGoal_3020.getSelectedItem();

        Stack<String> stack = new Stack<>();
        Map<String, String> parentMap = new HashMap<>();

        stack.push(start);

        boolean found = false;
        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (!visitedNodes_3020.contains(current)) {
                visitedNodes_3020.add(current);
            }

            if (current.equals(goal)) {
                found = true;
                break;
            }

            List<String> neighbors = adjMatrix_3020.get(current);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                String neighbor = neighbors.get(i);
                if (!visitedNodes_3020.contains(neighbor) && !stack.contains(neighbor)) {
                    parentMap.put(neighbor, current);
                    stack.push(neighbor);
                }
            }
        }

        if (found) {
            String curr = goal;
            while (curr != null) {
                pathFound_3020.add(0, curr);
                curr = parentMap.get(curr);
            }
        }
        displayPath();
        displayGraph();
    }

   
    public void displayGraph() {
        panelGraph_3020.repaint();
    }


    public void displayPath() {
        lblHasil_3020.setText("Hasil Pencarian : " + currentMethod_3020);
        if (pathFound_3020.isEmpty()) {
            lblJalur_3020.setText("Jalur : Tidak ditemukan");
        } else {
            lblJalur_3020.setText("Jalur : " + String.join(" -> ", pathFound_3020));
        }
        lblDikunjungi_3020.setText("Node Dikunjungi : " + String.join(", ", visitedNodes_3020));
        lblJumlah_3020.setText("Jumlah Node Dikunjungi : " + visitedNodes_3020.size());
    }


    public void resetGraph() {
        visitedNodes_3020.clear();
        pathFound_3020.clear();
        currentMethod_3020 = "";
        lblHasil_3020.setText("Hasil Pencarian :");
        lblJalur_3020.setText("Jalur :");
        lblDikunjungi_3020.setText("Node Dikunjungi :");
        lblJumlah_3020.setText("Jumlah Node Dikunjungi : 0");
        displayGraph();
    }

 
    private class GraphPanel_3020 extends JPanel {
        public GraphPanel_3020() {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Monospaced", Font.BOLD, 13));
            g2.drawString("VISUALISASI GRAPH", 15, 25);

            float[] dashPattern = {6.0f, 5.0f};
            Stroke dashedStroke = new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
            Stroke solidStroke = new BasicStroke(2.5f);

            Set<String> drawnEdges = new HashSet<>();
            for (String node : adjMatrix_3020.keySet()) {
                Point p1 = nodePositions_3020.get(node);
                for (String neighbor : adjMatrix_3020.get(node)) {
                    String edgeKey = node.compareTo(neighbor) < 0 ? node + "-" + neighbor : neighbor + "-" + node;
                    if (!drawnEdges.contains(edgeKey)) {
                        Point p2 = nodePositions_3020.get(neighbor);

                        if (pathFound_3020.contains(node) && pathFound_3020.contains(neighbor) &&
                            Math.abs(pathFound_3020.indexOf(node) - pathFound_3020.indexOf(neighbor)) == 1) {
                            g2.setColor(new Color(231, 76, 60)); 
                            g2.setStroke(solidStroke);
                        } else {
                            g2.setColor(Color.LIGHT_GRAY); 
                            g2.setStroke(dashedStroke);
                        }
                        g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                        drawnEdges.add(edgeKey);
                    }
                }
            }

            g2.setFont(new Font("Monospaced", Font.BOLD, 12));
            for (Map.Entry<String, Point> entry : nodePositions_3020.entrySet()) {
                String nodeName = entry.getKey();
                Point p = entry.getValue();

                if (pathFound_3020.contains(nodeName)) {
                    g2.setColor(new Color(41, 128, 185)); 
                } else if (visitedNodes_3020.contains(nodeName)) {
                    g2.setColor(new Color(211, 84, 0));    
                } else {
                    g2.setColor(Color.BLACK);             
                }

                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(nodeName);
                int textHeight = fm.getHeight();
                g2.clearRect(p.x - (textWidth / 2) - 4, p.y - (textHeight / 2), textWidth + 8, textHeight);
 
                g2.drawString(nodeName, p.x - (textWidth / 2), p.y + (textHeight / 4));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetaKampusFT_2511533020().setVisible(true);
        });
    }
}