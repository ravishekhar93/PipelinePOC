package daoLayer.pojo;

import java.util.ArrayList;

import daoLayer.utility.TimeWindow;
import interfaces.Result;

public class TotalTransactionVolume implements Result {

	private int id; // Auto increment
	private int merchantId;
	private int totalTransaction;
	private TimeWindow window;

	public TotalTransactionVolume(int id, int merchantId, int totalTransaction, TimeWindow window) {
		this.id = id;
		this.merchantId = merchantId;
		this.totalTransaction = totalTransaction;
		this.window = window;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getTotalTransaction() {
		return totalTransaction;
	}

	public void setTotalTransaction(int totalTransaction) {
		this.totalTransaction = totalTransaction;
	}

	public TimeWindow getWindow() {
		return window;
	}

	public void setWindow(TimeWindow window) {
		this.window = window;
	}

	@Override
	public String toStringFormat() {
		return String.valueOf(merchantId + " " + totalTransaction + "\n");
	}

	public static TotalTransactionVolume parseData(String inputLine) {
		// One of the fields will have a window ID
		String input[] = inputLine.split(" ");

		TimeWindow window = null;
		// window = getWindow(windowID)

		return new TotalTransactionVolume(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[1]),  window);
	}

	public static TotalTransactionVolume[] parseAll(ArrayList<String> inputRaw) {
		TotalTransactionVolume[] all = new TotalTransactionVolume[inputRaw.size()];

		for (int i = 0; i < inputRaw.size(); i++)
			all[i] = parseData(inputRaw.get(i));

		return all;
	}

	public TotalTransactionVolume getResult() {
		return this;
	}

}
