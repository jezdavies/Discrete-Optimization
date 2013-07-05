import java.util.Collections;


public class GreedyGraphAlgorithm {
	private Graph graph;
	public Graph solverGraph(Graph graphIn){
		graph = graphIn;
		//order the vertices by their number of uncoloured neighbours
		graph.sortVerticesByDescendingNumberUncolouredNeighbours();
		//assign the most connected vertice the first colour that isn't used by one of it's neighbours
		//TODO complete greedy algorithm
	}
}
