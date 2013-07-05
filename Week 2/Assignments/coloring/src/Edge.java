
public class Edge {
	private int id;
	private int startVertice;
	private int endVertice;
	
	public Edge(int idIn, int startIn, int endIn){
		id = idIn;
		startVertice = startIn;
		endVertice = endIn;
	}
	
	public int getId(){
		return id;
	}

	public int getStartVertice() {
		return startVertice;
	}

	public int getEndVertice() {
		return endVertice;
	}
	
	@Override
	public String toString(){
		String output = "id: " + id + "\n";
		output += "startNode: " + startVertice + "\n";
		output += "endNode: " + endVertice + "\n";
		
		return output;
	}

}
