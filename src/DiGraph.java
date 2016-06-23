import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DiGraph implements DiGraphInterface {
	Map<String, Node> nodesHash = new HashMap<String, Node>();
	Map<Long, Node> nodesIdHash = new HashMap<Long, Node>();
	int numEdges, numNodes;
	
	public DiGraph(){
	}
	
	public boolean addNode(long idNum, String label){
		if(idNum < 0 || label == null){
			return false;
		}
		
		if(nodesHash.containsKey(label)){
			return false;
		}
		if(nodesIdHash.containsKey(idNum)){
			return false;
		}
		
		Node newNode = new Node(idNum, label);
		nodesHash.put(label, newNode);
		nodesIdHash.put(idNum, newNode);
		numNodes++;
		return true;
	}
	
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel){
		
		if(idNum < 0){
			return false;
		}
		
		for(Map.Entry<String, Node> entry: nodesHash.entrySet()){
			if(entry.getValue().containsEdgeId(idNum)){
				return false;
			}
		}
		
		if(nodesHash.containsKey(sLabel) == false || nodesHash.containsKey(dLabel) == false){
			return false;
		}
		
		Edge newEdge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
		//may need to add to nodesIdHash
		if(nodesHash.get(sLabel).addEdge(newEdge)){
			numEdges++;
			nodesHash.get(dLabel).changeInDegree(1); //*****************************************************
			return true;
		}
		return false;
	}
	
	public boolean delNode(String label){
		long nodeToDelete;
		
		if(!nodesHash.containsKey(label)){
			return false;
		}
		
		//may not need to even delete edges if we are deleting the entire node anyway
		numEdges -= nodesHash.get(label).getNumEdges();
		for(int i = 0; i < nodesHash.get(label).getNumEdges(); i++){  //**************************************************
			nodesHash.get(nodesHash.get(label).getEdges().get(i).getDLabel()).changeInDegree(-1);
		}
		nodesHash.get(label).delEdges();
		nodeToDelete = nodesHash.get(label).getId();
		nodesHash.remove(label);
		nodesIdHash.remove(nodeToDelete);
		
		//may need to delete edges in nodesIdHash too
		for(Map.Entry<String, Node> entry: nodesHash.entrySet()){
			numEdges -= entry.getValue().getEdgesToNode(label);
			entry.getValue().delEdgesToNode(label);
		}
		
		numNodes--;
		return true;
	}
	
	public boolean delEdge(String sNode, String dNode){
		//may need to delete in nodesIdHash too
		if(nodesHash.containsKey(sNode) && nodesHash.get(sNode).delEdgesToNode(dNode)){
			nodesHash.get(dNode).changeInDegree(-1);  //************************************************
			numEdges--;
			return true;
		}
		return false;
	}
	
	public long numNodes(){
		return numNodes;
	}
	
	public long numEdges(){
		return numEdges;
	}
	
	public void print(){
		for(Map.Entry<String, Node> entry: nodesHash.entrySet()){
			System.out.println("(" + entry.getValue().getId() + ")" + entry.getValue().getLabel());
			for(int i = 0; i < entry.getValue().getEdges().size(); i++){
				if(entry.getValue().getEdges().get(i).getELabel() == null){
					System.out.println("  (" + entry.getValue().getEdges().get(i).getId() + ")--" + entry.getValue().getEdges().get(i).getWeight() + "--> " + entry.getValue().getEdges().get(i).getDLabel());
				}
				else{
					System.out.println("  (" + entry.getValue().getEdges().get(i).getId() + ")--" + entry.getValue().getEdges().get(i).getELabel() + "," + entry.getValue().getEdges().get(i).getWeight() + "--> " + entry.getValue().getEdges().get(i).getDLabel());
				}
			}
		}
	}
	
	public String[] topoSort(){
		DiGraph graph = new DiGraph();
		String[] sortedNodes = new String[numNodes];
		Queue<Node> tempQueue = new LinkedList<Node>();
		Node sNode;
		int count = 0;
		
		for(Map.Entry<String, Node> entry: nodesHash.entrySet()){
			graph.nodesHash.put(entry.getKey(), entry.getValue().copyNode());
		}
		
		for(Map.Entry<String, Node> entry: graph.nodesHash.entrySet()){
			if(entry.getValue().getInDegree() == 0){
				tempQueue.add(entry.getValue());
			}
		}
		
		while(tempQueue.size() > 0){
			sNode = tempQueue.remove();
			for(int i = 0; i < sNode.getNumEdges(); i++){
				graph.nodesHash.get(sNode.getEdges().get(i).getDLabel()).changeInDegree(-1);
				if(graph.nodesHash.get(sNode.getEdges().get(i).getDLabel()).getInDegree() == 0){
					tempQueue.add(graph.nodesHash.get(sNode.getEdges().get(i).getDLabel()));
				}
			}
			sortedNodes[count] = sNode.getLabel();
			count++;
		}
		
		if(sortedNodes[sortedNodes.length - 1] == null){
			return null;
		}
		
		return sortedNodes;
	}
	

}