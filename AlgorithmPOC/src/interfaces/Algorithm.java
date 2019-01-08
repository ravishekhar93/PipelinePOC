package interfaces;

import java.util.ArrayList;

import daoLayer.utility.TimeWindow;

public abstract class Algorithm {
	
	protected ArrayList<Result> result;
	protected TimeWindow window;
	
	public void setTimeWindow(TimeWindow window) {
		this.window=window;
	}
	
	//Name of this algorithm
	public abstract String getName();
	
	//Any pre-processing and loading up of inputs from DB
	public abstract void initialize();
	
	//Main Logic
	public abstract void executeAlgorithm();
	
	//Main algorithmic controller
	public ArrayList<Result> execute() {
		initialize();
		executeAlgorithm();
		shutdown();
		return result;
	}
	
	//Any post-processing and saving the results in DB
	public abstract void shutdown();

}
