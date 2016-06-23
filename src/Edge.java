
public class Edge {
	long id, weight;
	String sLabel, dLabel, eLabel;
	
	public Edge(){
		
	}
	public Edge(long inputId, String inputSLabel, String inputDLabel, long inputWeight, String inputELabel){
		id = inputId;
		weight = inputWeight;
		sLabel = inputSLabel;
		dLabel = inputDLabel;
		eLabel = inputELabel;
	}
	
	public void setId(long input){
		id = input;
	}
	public long getId(){
		return id;
	}
	public void setWeight(long input){
		weight = input;
	}
	public long getWeight(){
		return weight;
	}
	public void setSLabel(String input){
		sLabel = input;
	}
	public String getSLabel(){
		return sLabel;
	}
	public void setDLabel(String input){
		dLabel = input;
	}
	public String getDLabel(){
		return dLabel;
	}
	public void setELabel(String input){
		eLabel = input;
	}
	public String getELabel(){
		return eLabel;
	}
}
