package daoLayer;

import java.util.ArrayList;

import daoLayer.pojo.TotalTransactionVolume;
import daoLayer.utility.InputReader;
import daoLayer.utility.OutputWriter;
import daoLayer.utility.TimeWindow;
import interfaces.DAO;

public class TransactionVolumeDAO implements DAO {

	public static final String fileName = "totaltransactionvolume.txt";

	public static TotalTransactionVolume[] read() {
		return TotalTransactionVolume.parseAll(InputReader.readData(fileName));
	}
	
	public static TotalTransactionVolume[] read(TimeWindow window) {
		return TotalTransactionVolume.parseAll(InputReader.readData(fileName));
	}

	public static void save(ArrayList<TotalTransactionVolume> finalResult) {
		ArrayList<String> writeableResult = new ArrayList<>();
		for (TotalTransactionVolume result : finalResult) {
			writeableResult.add(result.toStringFormat());
			OutputWriter.writeToFile(fileName, writeableResult);
		}
	}
}
