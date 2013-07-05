import java.util.Collections;
import java.util.List;
import java.util.Set;


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
	
	public Vertice getVerticeByIndex(int verticeIndex){
		return vertices.get(verticeIndex);
	}
	
	public void setVerticeByIndex(int verticeIndex, Vertice verticeIn){
		vertices.set(verticeIndex, verticeIn);
	}
	
	public int getIndexOfTopUncolouredVertice(){
		int index = 0;
		for(int i = 0; i < vertices.size(); i++){
			if(!vertices.get(i).isColoured()){
				index = i;
				break;
			}
		}
		return index;
	}

	public void updateVerticesWithNeighbourColour(Set<Integer> verticeIDsToUpdate, Integer neighbourColour) {
		for(Vertice v:vertices){
			if(verticeIDsToUpdate.contains(new Integer(v.getId()))){
				v.addNeighbourColour(neighbourColour);
				v.setNumberOfUncolouredNeighbours(v.getNumberOfUncolouredNeighbours() - 1);
			}
		}
		
	}
	
	public int addNewColourToGraph()
	{
		int newMaxColour = colours.size();
		colours.add(newMaxColour);
		return newMaxColour;
	}
	
	public String toString(){
		String output = "";
		
    	output += "Edges:\n";
    	for(Edge e:getEdges()){
    		output +=e;
    	}
    	output +="Vertices:\n";
    	for(Vertice v:getVertices()){
    		output +=v;
    	}
    	output +="Colours:\n";
    	for(Integer c:getColours()){
    		output +=c + " ";
    	}
    	output += "\n";
    	
    	return output;
	}
	
}