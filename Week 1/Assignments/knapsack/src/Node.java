import java.util.Comparator;
import java.util.List;

public class Node {
	private int value;
	private int room;
	private double estimate;
	private List<Item> items;
	private int itemIndex;
	private int weight;
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public double getEstimate() {
		return estimate;
	}

	public void setEstimate(double estimate) {
		this.estimate = estimate;
	}
	
	public Node(int valueIn, int roomIn, int weightIn, int estimateIn, int itemIndexIn, List<Item>itemsIn){
		setValue(valueIn);
		setRoom(roomIn);
		setWeight(weightIn);
		setEstimate(estimateIn);
		setItemIndex(itemIndexIn);
		setItems(itemsIn);
	}
	
	public void addItem(Item item){
		items.add(item);
		value += item.getValue();
		weight += item.getWeight();
		room -= item.getWeight();
	}
	
	public Item getLastItem()
	{
		return getItems().get(getItems().size() -1);
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}
	
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	public static Comparator<Node> descendingEstimateNodeComparator = new Comparator<Node>(){
		public int compare(Node node1, Node node2){
			Double node1Estimate = new Double(node1.getEstimate());
			Double node2Estimate = new Double(node2.getEstimate());
			
			//use descending order
			return node2Estimate.compareTo(node1Estimate);
		}
	};

}
