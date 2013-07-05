import java.util.Collections;
import java.util.List;
import java.util.Set;


public class GreedyGraphAlgorithm {
	private Graph graph;
	
	//improved and refactored version of solve that has improved method of determining available colours
	//Also sees if instead of creating a new colour it can assign a different colour to a neighbour - not currently working
	public Graph solveGraph(Graph graphIn){
		graph = graphIn;
		//repeat the following for every vertice in the graph
		for(int i = 0; i < graph.getVerticeCount(); i++){
			//order the vertices by their number of uncoloured neighbours
			graph.sortVerticesByDescendingNumberUncolouredNeighbours();
//			graph.sortVerticesByDescendingNumberNeighbours();
			//assign the most connected vertice the first colour that isn't used by one of it's neighbours
			
			//first get the most connected vertice
			int topUncolouredVerticeIndex = graph.getIndexOfTopUncolouredVertice();
			int verticeColour = 0;
			//now get the set of available colours for that vertice (i.e. ones that aren't being used by any of it's neighbours)
			List<Integer> availableColours = graph.getColoursNotUsedByVerticeNeighbours(topUncolouredVerticeIndex);
			if(availableColours.size()>0){
				//we have an available colour so select the first one
				//TODO ?change this so we assign the most or least used colour rather than just a random one?
				verticeColour = availableColours.get(0);
			}
			else
			{
				//let's see if we can get a neighbour to change it's colour without causing an issue
				//in which case we can assign this vertice to have that colour instead of adding a new one
				int freeColour = -1;
				//freeColour = graph.changeVerticeColourToAnotherAvailableColour(topUncolouredVerticeIndex);
				if(freeColour >= 0){
					verticeColour = freeColour;
				} else{
					verticeColour = graph.addNewColourToGraph();
				}
				
			}
			//now actually assign the chosen colour to the vertice
			graph.setVerticeColour(topUncolouredVerticeIndex, verticeColour);
						
		}
		
		//sort the vertices by their ID
        graph.sortVerticesByAscendingId();
        //now return the solved graph;
		return graph;
		
	}
}
