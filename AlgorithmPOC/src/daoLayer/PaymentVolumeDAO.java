package daoLayer;

import java.util.ArrayList;

import daoLayer.pojo.TotalPaymentVolume;
import daoLayer.utility.InputReader;
import daoLayer.utility.OutputWriter;
import daoLayer.utility.TimeWindow;
import interfaces.DAO;

public class PaymentVolumeDAO implements DAO {

	public static final String fileName = "totalpaymentvolume.txt";

	public static TotalPaymentVolume[] read() {
		return TotalPaymentVolume.parseAll(InputReader.readData(fileName));
	}
	
	public static TotalPaymentVolume[] read(TimeWindow window) {
		return TotalPaymentVolume.parseAll(InputReader.readData(fileName));
	}

	public static void save(ArrayList<TotalPaymentVolume> finalResult) {
		ArrayList<String> writeableResult = new ArrayList<>();
		for (TotalPaymentVolume result : finalResult) {
			writeableResult.add(result.toStringFormat());
			OutputWriter.writeToFile(fileName, writeableResult);
		}

	}

}
