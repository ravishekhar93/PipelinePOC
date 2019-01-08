package daoLayer.pojo;

import java.sql.Date;
import java.util.ArrayList;

import interfaces.Result;

public class MerchantTransactions implements Result {

	private int transactionId;
	private int merhcantId; // Its the merchant ID, not transaction ID
	private int transactionVolume;
	private int transactionAmount;
	private Date transactionDate;

	public MerchantTransactions(int transactionId, int merhcantId, int transactionVolume, int transactionAmount,
			Date transactionDate) {
		this.transactionId = transactionId;
		this.merhcantId = merhcantId;
		this.transactionVolume = transactionVolume;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getMerhcantId() {
		return merhcantId;
	}

	public void setMerhcantId(int merhcantId) {
		this.merhcantId = merhcantId;
	}

	public int getTransactionVolume() {
		return transactionVolume;
	}

	public void setTransactionVolume(int transactionVolume) {
		this.transactionVolume = transactionVolume;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public static MerchantTransactions parseData(String inputLine) {
		String[] inp = inputLine.split(" ");
		Date transactionDate = null;
		// transactionDate = getDate(inp[4]);

		return new MerchantTransactions(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]),
				Integer.parseInt(inp[3]), transactionDate);
	}

	public static MerchantTransactions[] parseAll(ArrayList<String> inputRaw) {
		MerchantTransactions all[] = new MerchantTransactions[inputRaw.size()];

		for (int i = 0; i < inputRaw.size(); i++)
			all[i] = parseData(inputRaw.get(i));

		return all;
	}

	
	@Override
	public String toStringFormat() {
		//TODO: transactionId is auto-increment, not to be saved manually
		return  transactionId + " " + merhcantId
				+ " " + transactionVolume + " " + transactionAmount
				+ " " + transactionDate+"\n";
	}

	@Override
	public MerchantTransactions getResult() {
		return this;
	}

}
