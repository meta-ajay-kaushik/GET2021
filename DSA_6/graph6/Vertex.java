package graph6;
import java.util.LinkedList;
import java.util.List;
public class Vertex {
	private List<Neighbour> neighbours = new LinkedList<Neighbour>();
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}
	public List<Neighbour> getNeighbourList(){
		return this.neighbours;
	}
}