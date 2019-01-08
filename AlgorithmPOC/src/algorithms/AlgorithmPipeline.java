package algorithms;

import java.util.ArrayList;

import daoLayer.utility.TimeWindow;
import interfaces.Algorithm;

public class AlgorithmPipeline extends Algorithm {

	ArrayList<Algorithm> pipeline;
	private String name;
	private TimeWindow window;

	public AlgorithmPipeline(String name, TimeWindow window) {
		pipeline = new ArrayList<>();
		this.name = name;
		this.window = window;
	}
	
	public AlgorithmPipeline(String name) {
		pipeline = new ArrayList<>();
		this.name = name;
	}


	public void addToPipeline(Algorithm algorithm) {
		pipeline.add(algorithm);
	}

	public void printPipeline() {
		for (Algorithm algorithm : pipeline) {
			System.out.println(algorithm.getName());
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void initialize() {
		for (Algorithm algorithm : pipeline) {
			algorithm.setTimeWindow(window);
		}
	}

	
	@Override
	public void executeAlgorithm() {
		for (Algorithm algorithm : pipeline) {
			algorithm.execute();
		}

	}

	@Override
	public void shutdown() {
		//To be put something with saving onto DB if any

	}

}
