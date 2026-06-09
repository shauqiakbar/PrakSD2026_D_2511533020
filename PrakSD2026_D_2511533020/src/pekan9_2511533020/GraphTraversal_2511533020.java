package pekan9_2511533020;

import java.util.*;
public class GraphTraversal_2511533020 {
	private Map<String, List<String>> graph = new HashMap<>();
	
	// Menambahkan edge (graf tak berarah)
	public void addEdge_2511533020(String node1_3020, String node2_3020) {
		graph.putIfAbsent(node1_3020, new ArrayList<>());
		graph.putIfAbsent(node2_3020, new ArrayList<>());
		graph.get(node1_3020).add(node2_3020);
		graph.get(node2_3020).add(node1_3020);
	}
	// Menampilkan graf awal
	public void printGraph_2511533020() {
		System.out.println("Graf Awal (Adjacency List) : ");
		for(String node_3020 : graph.keySet()) {
			System.out.print(node_3020 + " -> ");
			List<String> neighbors_3020 = graph.get(node_3020);
			System.out.println(String.join(", ",  neighbors_3020));
		}
		System.out.println();
	}
	
	// DFS rekursif	
	public void dfs_2511533020(String start_3020) {
		Set<String> visited_3020 = new HashSet<>();
		System.out.println("Penelusuran DFS : ");
		dfsHelper_2511533020(start_3020, visited_3020);
		System.out.println();
	}
	private void dfsHelper_2511533020(String current_3020, Set<String> visited_3020) {
		if(visited_3020.contains(current_3020)) return;
		visited_3020.add(current_3020);
		System.out.print(current_3020 + " ");
		for (String neighbor_3020 : graph.getOrDefault(current_3020, new ArrayList<>())) {
			dfsHelper_2511533020(neighbor_3020, visited_3020);
		}
	}
	// BFS iteratif
	public void bfs_2511533020(String start_3020) {
		Set<String> visited_3020 = new HashSet<>();
		Queue<String> queue_3020 = new LinkedList<>();
		queue_3020.add(start_3020);
		visited_3020.add(start_3020);
		System.out.println("Penelusuran BFS : ");
		while(!queue_3020.isEmpty()) {
			String current_3020 = queue_3020.poll();
			System.out.print(current_3020 + " ");
			for(String neighbor : graph.getOrDefault(current_3020, new ArrayList<>()))
				if(!visited_3020.contains(neighbor)) {
					queue_3020.add(neighbor);
					visited_3020.add(neighbor);
				}
		}
		System.out.println();
	}
	//Main
	public static void main(String[] args) {
		GraphTraversal_2511533020 graph_3020 = new GraphTraversal_2511533020();
		
		// Contoh graf : A-B, A-C, B-D, B-E
		graph_3020.addEdge_2511533020("A", "B");
		graph_3020.addEdge_2511533020("A", "C");
		graph_3020.addEdge_2511533020("B", "D");
		graph_3020.addEdge_2511533020("B", "E");
		// Cetak graf awal
		System.out.println("Graf Awal adalah : ");
		graph_3020.printGraph_2511533020();
		// Lakukan penelusuran 
		graph_3020.dfs_2511533020("A");
		graph_3020.bfs_2511533020("A");
	}
}