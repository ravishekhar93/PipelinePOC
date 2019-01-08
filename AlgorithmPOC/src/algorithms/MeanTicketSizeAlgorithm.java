package algorithms;

import java.util.ArrayList;

import daoLayer.MeanTicketSizeDAO;
import daoLayer.PaymentVolumeDAO;
import daoLayer.TransactionVolumeDAO;
import daoLayer.pojo.MeanTicketSize;
import daoLayer.pojo.TotalPaymentVolume;
import daoLayer.pojo.TotalTransactionVolume;
import daoLayer.utility.TimeWindow;
import interfaces.Algorithm;

public class MeanTicketSizeAlgorithm extends Algorithm {

	private TotalPaymentVolume[] totalPayVolume;
	private TotalTransactionVolume[] totalTransactVolume;
	private ArrayList<MeanTicketSize> finalResult;
	private TimeWindow window;
	
	public MeanTicketSizeAlgorithm(TimeWindow window) {
		this.window=window;
	}
	
	public MeanTicketSizeAlgorithm() {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AllAverage";
	}

	@Override
	public void initialize() {
		totalPayVolume = PaymentVolumeDAO.read();
		totalTransactVolume = TransactionVolumeDAO.read();
	}

	@Override
	public void shutdown() {
		MeanTicketSizeDAO.save(finalResult);
	}

	@Override
	public void executeAlgorithm() {

		finalResult = new ArrayList<>();

		for (int i = 0; i < totalPayVolume.length; i++) {
			float avgVol = totalPayVolume[i].getTotalVolume() / totalTransactVolume[i].getTotalTransaction();
			finalResult.add(new MeanTicketSize(avgVol, totalPayVolume[i].getMerchantId(), window));
		}
	}
}
