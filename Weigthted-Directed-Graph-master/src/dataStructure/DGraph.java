package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DGraph implements Serializable,graph {
	
	private int edgeSize = 0;
	private int mc = 0;
/**
 * A hash map that contains all the nodes in this DGraph as values,
 *  and their key's are the map keys.
 */
	public HashMap<Integer, node_data> nodes = new HashMap<>();

	@Override
	public node_data getNode(int key) {
		if(nodes.get(key)!=null) {
			return nodes.get(key);
		}
		else return null;
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if((nodes.get(src)!=null)&&(nodes.get(dest)!=null)){
			return ((Node) getNode(src)).neighbours.get(dest);
		}
		else return null;
	}

	@Override
	public void addNode(node_data n) {

		if(nodes.containsKey(n.getKey())) {
			throw new RuntimeException("node with this key is already exist");
		}
		else {
			nodes.put(n.getKey(), (Node) n);
			mc++;
		}				
	}

	@Override
	public void connect(int src, int dest, double w) {
		if((nodes.get(src)==null) || (nodes.get(dest)==null)) {
			throw new RuntimeException("Invalid input");
		}
		if(((Node)nodes.get(src)).neighbours.containsKey(dest)) {
			throw new RuntimeException("There is already an edge");
		}

		Edge e = new Edge(src, dest, 0, w , null);
		edgeSize++;
		((Node)nodes.get(src)).neighbours.put(dest, e);
		mc++;
	}



	@Override
	public Collection<node_data> getV() {
		return nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return ((Node) nodes.get(node_id)).neighbours.values();
	}

	@Override
	public node_data removeNode(int key) {
		if(nodes.containsKey(key)) {

			edgeSize-=((Node)nodes.get(key)).neighbours.values().size();

			((Node)nodes.get(key)).neighbours.clear();
			Iterator<Integer> it = nodes.keySet().iterator();
			while(it.hasNext()) {
				removeEdge(it.next(), key);
			}	
			mc++;
			return nodes.remove(key);

		}
		else
			return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		if(((Node)nodes.get(src)).neighbours.containsKey(dest)) {
			edgeSize--;
			mc++;
			return ((Node)nodes.get(src)).neighbours.remove(dest);
		}
		else
			return null;
	}

	@Override
	public int nodeSize() {
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		return edgeSize;
	}

	@Override
	public int getMC() {
		return mc;
	}
	
	
	/**
	 * An iterator that loop on the nodes of a DGraph.
	 * @return the iterator.
	 */
	public Iterator<node_data> nodeitr() {
		return nodes.values().iterator();
	}
}