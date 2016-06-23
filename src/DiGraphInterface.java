
public interface DiGraphInterface {
	public boolean addNode(long id, String name);
	public boolean addEdge(long id, String sNode, String dNode, long weight, String edge);
	public boolean delNode(String node);
	public boolean delEdge(String sNode, String dNode);
	public long numNodes();
	public long numEdges();
	public void print();
	public String[] topoSort();
}
