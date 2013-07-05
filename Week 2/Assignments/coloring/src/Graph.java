import java.util.Collections;
import java.util.List;


public class Graph {
	private List<Edge> edges;
	private List<Vertice> vertices;	
	private List<Integer> colours;

	public Graph(List<Vertice> verticesIn, List<Edge>  edgesIn, List<Integer> coloursIn) {
		edges = edgesIn;
		vertices = verticesIn;
		colours = coloursIn;
	}

	public List<Edge>  getEdges() {
		return edges;
	}

	public void setEdges(List<Edge>  edges) {
		this.edges = edges;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	public List<Integer> getColours() {
		return colours;
	}

	public void setColours(List<Integer> colours) {
		this.colours = colours;
	}

	public int getVerticeCount() {
		return getVertices().size();
	}

	public int getEdgeCount() {
		return getEdges().size();
	}


	public int getColourCount() {
		return getColours().size();
	}
	
	public void sortVerticesByDescendingNumberUncolouredNeighbours(){
		Collections.sort(vertices, Vertice.descendingNumberUncolouredNeighboursComparator);
	}
	
	public void sortVerticesByAscendingId()
	{
		Collections.sort(vertices, Vertice.ascendingIDComparator);
	}
	
}