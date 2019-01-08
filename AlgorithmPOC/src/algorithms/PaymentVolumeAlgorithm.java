package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import daoLayer.MerchantTransactionsDAO;
import daoLayer.PaymentVolumeDAO;
import daoLayer.pojo.MerchantTransactions;
import daoLayer.pojo.TotalPaymentVolume;
import daoLayer.utility.TimeWindow;
import interfaces.Algorithm;

public class PaymentVolumeAlgorithm extends Algorithm {

	private MerchantTransactions[] transactions;
	private ArrayList<TotalPaymentVolume> finalResult;
	private TimeWindow window;

	public PaymentVolumeAlgorithm(TimeWindow window) {
		this.window = window;
	}

	public PaymentVolumeAlgorithm() {
	}

	public String getName() {
		return "PaymentVolume";
	}

	@Override
	public void initialize() {
		transactions = MerchantTransactionsDAO.read();
	}

	@Override
	public void shutdown() {
		PaymentVolumeDAO.save(finalResult);
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

			resultTable.put(id, previousTotal + transaction.getTransactionAmount());
		}

		finalResult = new ArrayList<>();
		for (int key : resultTable.keySet()) {
			// TODO: null is a substitute of Auto increment ID
			finalResult.add(new TotalPaymentVolume(null, key, resultTable.get(key), window));
		}

		// result = finalResult;
	}
}
