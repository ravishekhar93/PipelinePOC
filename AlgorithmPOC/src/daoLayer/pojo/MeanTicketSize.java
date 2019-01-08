package daoLayer.pojo;

import daoLayer.utility.TimeWindow;
import interfaces.Result;

public class MeanTicketSize implements Result {
	
	private float meanTicketSize;
	private int merchantId;
	private TimeWindow window;

	public MeanTicketSize(float meanTicketSize, int merchantId, TimeWindow window) {
		this.meanTicketSize = meanTicketSize;
		this.merchantId = merchantId;
		this.window = window;
	}

	public float getMeanTicketSize() {
		return meanTicketSize;
	}

	public void setMeanTicketSize(float meanTicketSize) {
		this.meanTicketSize = meanTicketSize;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public TimeWindow getWindow() {
		return window;
	}

	public void setWindow(TimeWindow window) {
		this.window = window;
	}

	@Override
	public String toStringFormat() {
		return String.valueOf(merchantId + " " + meanTicketSize + "\n");
	}

	public MeanTicketSize getResult() {
		return this;
	}
}
