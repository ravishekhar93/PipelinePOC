package utility;

import java.util.Date;

import algorithms.AlgorithmPipeline;
import algorithms.MeanTicketSizeAlgorithm;
import algorithms.PaymentVolumeAlgorithm;
import algorithms.TransactionVolumeAlgorithm;
import daoLayer.utility.TimeWindow;

public class LogicController {

	public static void main(String[] args) {
		
		
		//Creating a minor Workflow, consisting of 3 leaf Algorithms
		AlgorithmPipeline minorPipeline = new AlgorithmPipeline("Mean Ticket Workflow");
		minorPipeline.addToPipeline(new PaymentVolumeAlgorithm());
		minorPipeline.addToPipeline(new TransactionVolumeAlgorithm());
		minorPipeline.addToPipeline(new MeanTicketSizeAlgorithm()); 
		
		//Creating a timeWindow, with Time duration not being backwards i.e false
		TimeWindow window = new TimeWindow(new Date(), TimeWindow.MEDIUM, false);
		
		//Parent Branch 
		AlgorithmPipeline majorPipeline = new AlgorithmPipeline("Some Parent Workflow",window);
		//Adding a nested pipeline
		majorPipeline.addToPipeline(minorPipeline);
		//execution
		majorPipeline.execute();

	}

}
