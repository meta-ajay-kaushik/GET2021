package graph6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
public class GraphImplementation implements Graph {
	private int numberOfVertices;
	private Vertex vertices[];
	// adjacency list of graph
	private LinkedList<Edge> edgeList;
	public int getNumberOfVertices() {
		return numberOfVertices;
	}
	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}
	public LinkedList<Edge> getEdgeList() {
		return edgeList;
	}
	//constructor
	public GraphImplementation(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();
		for (int i = 0; i < numberOfVertices; i++)
			vertices[i] = new Vertex();
	}
	// edge class to add edges with weight or distance in the list
	private Edge edge;
	public void addEdge(int source, int destination, int weight) {
		edgeList.add(new Edge(source, destination, weight));
		this.vertices[source].addNeighbour(destination, weight);
		this.vertices[destination].addNeighbour(source, weight);
	}
	@Override
	public boolean isConnected() {
		if (this.numberOfVertices <= 0)
			return false;
		return this.dfs(0).size() == this.getNumberOfVertices();
	}
	// dfs algorithm
	private Set<Integer> dfs(int source) {
		Stack<Integer> dfsStack = new Stack<Integer>();
		Set<Integer> visitedVertex = new HashSet<Integer>();
		dfsStack.push(source);
		while (!dfsStack.isEmpty()) {
			int vertex = dfsStack.pop();
			// if vertex is already visited then move further
			if (visitedVertex.contains(vertex)) {
				continue;
			}
			visitedVertex.add(vertex);
			// pushing it's all neighbour in stack
			for (Neighbour neighbour : this.vertices[vertex].getNeighbourList()) {
				dfsStack.push(neighbour.getNeighbourVertex());
			}
		}
		return visitedVertex;
	}
	@Override
	public Integer[] reachable(int vertex) {
		Set<Integer> visitedVertex = this.dfs(vertex);
		Integer[] reachableNode = visitedVertex.toArray(new Integer[0]);
		Arrays.sort(reachableNode);
		return reachableNode;
	}
	@Override
	public List<Edge> minimumSpanningTree() {
		List<Edge> minimumSpanningTreeEdges = new ArrayList<Edge>();
		// sorting edgeList based on weight in ascending order
		Collections.sort(this.edgeList, Edge.sortByWeight);
		// hash map for storing the parent node of a vertex key-> vertex
		// value->parent of vertex
		HashMap<Integer, Integer> parentVertices = new HashMap<Integer, Integer>();
		// Initially every vertex is parent of itself
		for (int i = 0; i < this.numberOfVertices; i++) {
			parentVertices.put(i, i);
		}
		int index = 0;
		for (Edge edge : this.getEdgeList()) {
			// if limits crosses then break the loop
			if (index > this.getNumberOfVertices() - 1) {
				break;
			} else if (!isCycle(parentVertices, edge.getstartVertex(),
					edge.getendVertex())) {
				minimumSpanningTreeEdges.add(edge);
			}
		}
		return minimumSpanningTreeEdges;
	}
	private boolean isCycle(HashMap<Integer, Integer> parentVertices, int v1,
			int v2) {
		int parent1 = parent(parentVertices, v1);
		int parent2 = parent(parentVertices, v2);
		if (parent1 == parent2) {
			return true;
		}
		parentVertices.put(parent1, parent2);
		return false;
	}
	private int parent(HashMap<Integer, Integer> parentVertices, int vertex) {
		while (parentVertices.get(vertex) != vertex) {
			vertex = parentVertices.get(vertex);
		}
		return vertex;
	}
	//Dijkstra algorithm
	private int[] dijkstra(int source) {
		int dist[] = new int[this.getNumberOfVertices()];
		for (int i = 0; i < this.getNumberOfVertices(); i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		Set<Integer> visited = new HashSet<Integer>();
		dist[source] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
				this.getNumberOfVertices(), Pair.sortPairByWeight);
		pq.add(new Pair(0, source));
		while (!pq.isEmpty()) {
			Pair pair = pq.peek();
			pq.remove();
			if (visited.contains(pair.getVertex())) {
				continue;
			}
			visited.add(pair.getVertex());
			for (Neighbour neighbour : this.vertices[pair.getVertex()]
					.getNeighbourList()) {
				if (dist[neighbour.getNeighbourVertex()] > dist[pair
						.getVertex()] + neighbour.getEdgeWeight()) {
					dist[neighbour.getNeighbourVertex()] = dist[pair
							.getVertex()] + neighbour.getEdgeWeight();
					pq.add(new Pair(dist[neighbour.getNeighbourVertex()],
							neighbour.getNeighbourVertex()));
				}
			}
		}
		return dist;
	}
	public int shortestPath(int source, int destination) {
		int dist[] = this.dijkstra(source);
		return dist[destination];
	}
}