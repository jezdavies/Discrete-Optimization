import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Solver {
    
    /**
     * The main class
     */
	
	private Graph graph;
	
	

    public static void main(String[] args) {
        try {
        	Solver solver = new Solver();
        	solver.setup(args);
        	solver.solve();
        	solver.writeOutput();
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * Read in the data and create the list of items, capacity and number of item variables.
     */
    private void setup(String[] args) throws IOException{
   
    	int verticeCount;
    	int edgeCount;
    	int colourCount;
    	List<Edge> edges = new ArrayList<Edge>();
    	List<Vertice> vertices = new ArrayList<Vertice>();
    	List<Integer> colours= new ArrayList<Integer>();
    	
    	//now get the file we're going to parse
        String fileName = null;
        
        // get the temp file name
        for(String arg : args){
            if(arg.startsWith("-file=")){
                fileName = arg.substring(6);
            } 
        }
        if(fileName == null){
            //return;
        	//TODO remove hardcoded file to be used if no parameter passed
        	fileName = "./data/gc_4_1";
        }
        //System.out.println("************FILENAME: " + fileName + " ******************");

        // read the lines out of the file
        List<String> lines = new ArrayList<String>();

        BufferedReader input =  new BufferedReader(new FileReader(fileName));
        try {
            String line = null;
            while (( line = input.readLine()) != null){
                lines.add(line);
            }
        }
        finally {
            input.close();
        }
        
        
        // parse the data in the file
        String[] firstLine = lines.get(0).split("\\s+");
        verticeCount = Integer.parseInt(firstLine[0]);
        edgeCount = Integer.parseInt(firstLine[1]);
        
        for(int i=1; i < edgeCount+1; i++){
          String line = lines.get(i);
          String[] parts = line.split("\\s+");
          int startVerticeID = Integer.parseInt(parts[0]);
          int endVerticeID = Integer.parseInt(parts[1]);
          Vertice startVertice;
          Vertice endVertice;
          //add the new edge to the collection of edges
          edges.add(new Edge(i, startVerticeID, endVerticeID));
          
          //check if we already have the vertice that this edge starts with
          if((vertices.size() < (startVerticeID + 1)) || (vertices.get(startVerticeID) == null)){
        	   startVertice = new Vertice(startVerticeID, 0);
        	   //we know it has a neighbour that is at the end of this edge so add it to the list
        	   startVertice.addUncolouredNeighbourID(new Integer(endVerticeID));
        	  vertices.add(startVerticeID, startVertice);        	  
          }else{
        	  //we already have this vertice but lets see if it already has the end of this vertice registered as a neighbour, if not then add it
        	  if(!vertices.get(startVerticeID).getNeighbourIDs().contains(new Integer(endVerticeID))){
        		  vertices.get(startVerticeID).addUncolouredNeighbourID(endVerticeID);
        	  }
        	  
          }
          //now do the same for the end vertice
          if((vertices.size() < (endVerticeID + 1)) || (vertices.get(endVerticeID) == null)){
       	   endVertice = new Vertice(endVerticeID, 0);
       	   //we know it has a neighbour that is at the start of this edge so add it to the list
       	   endVertice.addUncolouredNeighbourID(new Integer(startVerticeID));
       	  vertices.add(endVerticeID, endVertice);        	  
         }else{
       	  //we already have this vertice but lets see if it already has the start of this vertice registered as a neighbour, if not then add it
       	  if(!vertices.get(endVerticeID).getNeighbourIDs().contains(new Integer(startVerticeID))){
       		vertices.get(endVerticeID).addUncolouredNeighbourID(startVerticeID);
       	  }
       	  
         }
        }
        
        //create the graph object to represent the input and store the solution
        graph = new Graph(vertices, edges, colours);
        
    }
    

    
    private void writeOutput(){
    	
        // prepare the solution in the specified output format
        System.out.println(graph.getColourCount() +" 0");
        for(Integer i : graph.getColours()){
        	System.out.print(i + " ");
        	
        }      
    }
    
    private void showInput(){
    	System.out.println("Edges:");
    	for(Edge e:graph.getEdges()){
    		System.out.println(e);
    	}
    	System.out.println("Vertices:");
    	for(Vertice v:graph.getVertices()){
    		System.out.println(v);
    	}
    	System.out.println("Colours:");
    	for(Integer c:graph.getColours()){
    		System.out.println(c);
    	}
    }
    
    private void solve() throws Exception{
    	showInput();   
    	
    	GreedyGraphAlgorithm algorithm = new GreedyGraphAlgorithm();
    	graph = algorithm.solverGraph(graph);
    	
    	 
    }
}