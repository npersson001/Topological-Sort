import java.util.ArrayList;
import java.util.Map;

public class Node {
	ArrayList<Edge> edgesFromNode = new ArrayList<Edge>();
	String label;
	long id;
	long inDegree;
	
	public Node(){
	}
	public Node(long inputId, String inputName){
		label = inputName;
		id = inputId;
		inDegree = 0;
	}
	
	public void setLabel(String input){
		label = input;
	}
	public String getLabel(){
		return label;
	}
	public void setId(long input){
		id = input;
	}
	public long getId(){
		return id;
	}
	
	public boolean addEdge(Edge inputEdge){
		for(int i = 0; i < edgesFromNode.size(); i++){
			if(inputEdge.getDLabel() == edgesFromNode.get(i).getDLabel()){
				return false;
			}
		}
		edgesFromNode.add(inputEdge);
		
		return true;
	}
	
	public boolean delEdges(){
		edgesFromNode.clear();
		return true;
	}
	
	public boolean delEdgesToNode(String label){
		for(int i = 0; i < edgesFromNode.size(); i++){
			if(edgesFromNode.get(i).getDLabel() == label){
				edgesFromNode.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public long getEdgesToNode(String label){
		long numEdgesToNode = 0;
		
		for(int i = 0; i < edgesFromNode.size(); i++){
			if(edgesFromNode.get(i).getDLabel() == label){
				numEdgesToNode++;
			}
		}
		return numEdgesToNode;
	}
	
	public ArrayList<Edge> getEdges(){
		return edgesFromNode;
	}
	
	public boolean containsEdgeId(long idToCheck){
		for(int i = 0; i < edgesFromNode.size(); i++){
			if(edgesFromNode.get(i).getId() == idToCheck){
				return true;
			}
		}
		return false;
	}
	
	public long getNumEdges(){
		return edgesFromNode.size();
	}
	
	public long getInDegree(){
		return inDegree;
	}
	
	public void changeInDegree(long change){
		inDegree += change;
	}
	
	public Node copyNode(){
		Node copiedNode = new Node(id, label);
		copiedNode.inDegree = inDegree;
		copiedNode.edgesFromNode = edgesFromNode;
		return copiedNode;
	}
}
