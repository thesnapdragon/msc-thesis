package hu.bme.mit.plcspec.testsuitegenerator.measurements;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;

public class GraphReader {
	private Graph graph = null;
	
	public void read(String file) {
		graph = new TinkerGraph();
		GraphMLReader reader = new GraphMLReader(graph);
		String fileName = "resources/" + file + ".graphml";
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(fileName));
			reader.inputGraph(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Graph getGraph() {
		return graph;
	}

}
