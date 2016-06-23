
public class AssnTopoSort {
	public static void main (String[] args){
		DiGraphInterface diGraph = new DiGraph();
		
		diGraph.addNode(0, "NewYork");
		diGraph.addNode(1, "Washington");
		diGraph.addNode(2, "Chicago");
		diGraph.addNode(3, "Denver");
		
		diGraph.addEdge(0, "NewYork", "Chicago", 1, null);
		diGraph.addEdge(1, "NewYork", "Washington", 3, "prop");
		diGraph.addEdge(3, "Washington", "NewYork", 3, null);
		diGraph.addEdge(2, "Washington", "Denver", 2, null);
		diGraph.addEdge(4, "Chicago", "Denver", 1, null);
		diGraph.addEdge(5, "Chicago", "Washington", 1, "prop");
		diGraph.addEdge(6, "Denver", "Washington", 2, "meal");
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
		
		String[] nodes = diGraph.topoSort();
		
		if(nodes != null){
			for(int i = 0; i < nodes.length; i++){
				System.out.println(nodes[i]);
			}
		}
		
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
		
		String[] nodes1 = diGraph.topoSort();
		
		
		if(nodes1 != null){
			for(int i = 0; i < nodes1.length; i++){
				System.out.println(nodes[i]);
			}
		}
	}
	/*
	 DiGraphInterface diGraph = new DiGraph();
		
		diGraph.addNode(0, "NewYork");
		diGraph.addNode(1, "Washington");
		diGraph.addNode(2, "Chicago");
		diGraph.addNode(3, "Denver");
		
		diGraph.addEdge(0, "NewYork", "Chicago", 1, null);
		diGraph.addEdge(1, "NewYork", "Washington", 3, "prop");
		diGraph.addEdge(3, "Washington", "NewYork", 3, null);
		diGraph.addEdge(2, "Washington", "Denver", 2, null);
		diGraph.addEdge(4, "Chicago", "Denver", 1, null);
		diGraph.addEdge(5, "Chicago", "Washington", 1, "prop");
		diGraph.addEdge(6, "Denver", "Washington", 2, "meal");
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
		
		diGraph.addNode(0, "Cary");
		diGraph.addNode(4, "NewYork");
		
		diGraph.addEdge(0, "NewYork", "Denver", 2, null);
		diGraph.addEdge(7, "NewYork", "Chicago", 3, null);
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
		
		diGraph.delEdge("NewYork", "Washington");
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
		
		diGraph.delNode("NewYork");
		
		diGraph.print();
		
		System.out.println(diGraph.numNodes());
		System.out.println(diGraph.numEdges());
	 */
}
