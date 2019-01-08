package daoLayer;

import java.util.ArrayList;

import daoLayer.pojo.MeanTicketSize;
import daoLayer.pojo.MerchantTransactions;
import daoLayer.utility.InputReader;
import daoLayer.utility.OutputWriter;
import daoLayer.utility.TimeWindow;
import interfaces.DAO;
import interfaces.Result;

public class MeanTicketSizeDAO implements DAO {

	public static final String fileName = "meanticketsize.txt";

	public static MerchantTransactions[] read() {
		return MerchantTransactions.parseAll(InputReader.readData(fileName));
	}
	
	public static MerchantTransactions[] read(TimeWindow window) {
		return MerchantTransactions.parseAll(InputReader.readData(fileName));
	}

	public static void save(Result result) {
		OutputWriter.writeToFile(fileName, result.toStringFormat());
	}

	public static void save(ArrayList<MeanTicketSize> finalResult) {
		ArrayList<String> writeableResult = new ArrayList<>();
		for (MeanTicketSize result : finalResult) {
			writeableResult.add(result.toStringFormat());
			OutputWriter.writeToFile(fileName, writeableResult);
		}
	}
}
