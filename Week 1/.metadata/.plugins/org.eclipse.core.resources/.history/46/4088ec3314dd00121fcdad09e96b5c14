import java.util.ArrayList;
import java.util.List;


public class SolveProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		KnapsackSolver solver = new DynamicProgrammingKnapsackSolver();
		//create a list of items to use
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1,16,2));
		items.add(new Item(2,19,3));
		items.add(new Item(3,23,4));
		items.add(new Item(4,28,5));
		
		try
		{
			Knapsack optimumSack = solver.solve(4, 7, items);
			System.out.println("The optimum sack is:\n" + optimumSack.toString());
		}
		catch(Exception e)
		{
			System.out.println("There was an error:\n" + e.getMessage());
		}

	}

}
