package gui;

import dataStructure.DGraph;
import dataStructure.Node;
import utils.Point3D;

public class gui_main {

	public static void main(String[] args) {

//*******************Example GUI_Graph*****************
		Graph_GUI Example = new Graph_GUI();
		DGraph e = new DGraph();
		
		e.addNode(new Node(1, new Point3D(0,50), 0, "", 0));
		e.addNode(new Node(2, new Point3D(-50,0), 0, "", 0));
		e.addNode(new Node(3, new Point3D(50,0), 0, "", 0));
		
		e.connect(1, 2, 2);
		e.connect(2, 3, 3);
		e.connect(3, 1, 1);
		
		
		Example.init(e);	
		Example.drawAll();
	}
}