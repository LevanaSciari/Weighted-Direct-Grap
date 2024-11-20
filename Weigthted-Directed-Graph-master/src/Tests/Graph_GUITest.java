package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.Node;
import gui.Graph_GUI;
import utils.Point3D;

class Graph_GUITest {

	@Test
	void testDrawAll() {
		Graph_GUI diamond = new Graph_GUI();
		DGraph d = new DGraph();

		Node n24 = new Node(24, new Point3D(0,0), 0.0, "", 0);
		Node n25 = new Node(25, new Point3D(0,0), 0.0, "", 0);
		Node n26 = new Node(26, new Point3D(0,0), 0.0, "", 0);
		Node n27 = new Node(27, new Point3D(0,0), 0.0, "", 0);

		Point3D p15 = new Point3D(75,25);
		Point3D p16 = new Point3D(25,75);
		Point3D p17 = new Point3D(100,100);
		Point3D p18 = new Point3D(0,0);

		n24.setLocation(p17);
		n25.setLocation(p16);
		n26.setLocation(p18);
		n27.setLocation(p15);

		d.addNode(n24);
		d.addNode(n25);
		d.addNode(n26);
		d.addNode(n27);

		d.connect(24, 25, 4);
		d.connect(25, 26, 2);
		d.connect(26, 27, 2);
		d.connect(27, 24, 1);
		d.connect(25, 24, 4);
		d.connect(26, 25, 2);
		d.connect(27, 26, 2);
		d.connect(24, 27, 1);

		diamond.init(d);
		diamond.drawAll();
	}

}