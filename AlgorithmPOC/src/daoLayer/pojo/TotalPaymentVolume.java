package daoLayer.pojo;

import java.util.ArrayList;

import daoLayer.utility.TimeWindow;
import interfaces.Result;

public class TotalPaymentVolume implements Result {

	private Integer id; // Auto Increment
	private Integer merchantId;
	private Integer totalVolume;
	private TimeWindow windowId;

	public TotalPaymentVolume(Integer id, Integer merchantId, Integer totalVolume, TimeWindow windowId) {
		this.id = id;
		this.merchantId = merchantId;
		this.totalVolume = totalVolume;
		this.windowId = windowId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}

	public TimeWindow getWindowId() {
		return windowId;
	}

	public void setWindowId(TimeWindow windowId) {
		this.windowId = windowId;
	}

	@Override
	public String toStringFormat() {
		return String.valueOf(id+" "+merchantId + " " + totalVolume +" "+windowId+"\n");
	}

	public static TotalPaymentVolume parseData(String inputLine) {
		// One of the fields will have a window ID
		String input[] = inputLine.split(" ");

		TimeWindow window = null;
		// window = getWindow(windowID)

		return new TotalPaymentVolume(Integer.parseInt(input[0]), Integer.parseInt(input[1]),Integer.parseInt(input[2]), window);
	}

	public static TotalPaymentVolume[] parseAll(ArrayList<String> inputRaw) {
		TotalPaymentVolume all[] = new TotalPaymentVolume[inputRaw.size()];

		for (int i = 0; i < inputRaw.size(); i++)
			all[i] = parseData(inputRaw.get(i));

		return all;
	}

	public TotalPaymentVolume getResult() {
		return this;
	}

}
