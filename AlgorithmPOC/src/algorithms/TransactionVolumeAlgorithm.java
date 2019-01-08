package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import daoLayer.MerchantTransactionsDAO;
import daoLayer.TransactionVolumeDAO;
import daoLayer.pojo.MerchantTransactions;
import daoLayer.pojo.TotalTransactionVolume;
import daoLayer.utility.TimeWindow;
import interfaces.Algorithm;

public class TransactionVolumeAlgorithm extends Algorithm {

	private MerchantTransactions[] transactions;
	private ArrayList<TotalTransactionVolume> finalResult;
	private TimeWindow window;
	
	public TransactionVolumeAlgorithm(TimeWindow window) {
		this.window = window;
	}
	
	public TransactionVolumeAlgorithm() {
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TransactionVolume";
	}

	@Override
	public void initialize() {
		transactions = MerchantTransactionsDAO.read();
	}

	@Override
	public void shutdown() {
		TransactionVolumeDAO.save(finalResult);
	}

	@Override
	public void executeAlgorithm() {
		HashMap<Integer, Integer> resultTable = new HashMap<>();

		int id;
		int previousTotal = 0;
		for (MerchantTransactions transaction : transactions) {
			// Merchant ID
			id = transaction.getMerhcantId();

			// Fill previousTotal, with total in previous iterations, if any, otherwise
			// previousTotal =0
			previousTotal = resultTable.getOrDefault(id, 0);

			resultTable.put(id, previousTotal + transaction.getTransactionVolume());
		}

		finalResult = new ArrayList<>();
		for (int key : resultTable.keySet()) {
			int recordID = -1; //Temporary sub for auto-incerment
			finalResult.add(new TotalTransactionVolume(recordID,key, resultTable.get(key), window));
		}
	}

}
