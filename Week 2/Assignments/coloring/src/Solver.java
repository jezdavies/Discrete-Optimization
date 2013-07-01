import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Solver {
    
    /**
     * The main class
     */
	
	private int nodeCount;
	private int edgeCount;
	private int colourCount;
	private Edge[] edges;
	private int[] nodes;
	private int[] colours;
	
	

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
        nodeCount = Integer.parseInt(firstLine[0]);
        edgeCount = Integer.parseInt(firstLine[1]);
        List<Edge> inputEdges = new ArrayList<Edge>();
        List<Integer> inputNodes = new ArrayList<Integer>();
        
        for(int i=1; i < edgeCount+1; i++){
          String line = lines.get(i);
          String[] parts = line.split("\\s+");
          int startNode = Integer.parseInt(parts[0]);
          int endNode = Integer.parseInt(parts[1]);
          inputEdges.add(new Edge(i, startNode, endNode));
          if(!inputNodes.contains(startNode)){
        	  inputNodes.add(new Integer(startNode));
          }
          if(!inputNodes.contains(endNode)){
        	  inputNodes.add(new Integer(endNode));
          }      	  

        }
        colourCount = 0;
        colours = new int[nodeCount];
        edges = inputEdges.toArray(new Edge[inputEdges.size()]);
        nodes = new int[inputNodes.size()];
        for(int i = 0; i<inputNodes.size(); i++){
        	nodes[i] = inputNodes.get(i);
        }
    }
    
    private void solve() throws Exception{
    	showInput();    	
    	 
    }
    
    private void writeOutput(){
    	
        // prepare the solution in the specified output format
        System.out.println(colourCount +" 0");
        for(int i : colours){
        	System.out.print(i + " ");
        	
        }      
    }
    
    private void showInput(){
    	System.out.println("Edges:");
    	for(Edge e:edges){
    		System.out.println(e);
    	}
    	System.out.println("Nodes:");
    	for(int n:nodes){
    		System.out.println(n);
    	}
    	System.out.println("Colours:");
    	for(int c:colours){
    		System.out.println(c);
    	}
    }
}