package daoLayer;

import daoLayer.pojo.MerchantTransactions;
import daoLayer.utility.InputReader;
import daoLayer.utility.OutputWriter;
import daoLayer.utility.TimeWindow;
import interfaces.DAO;
import interfaces.Result;

public class MerchantTransactionsDAO implements DAO {
	
	public static final String fileName="transaction.txt";
	
	
	public static MerchantTransactions[] read() {
		return MerchantTransactions.parseAll(InputReader.readData(fileName));
	}
	
	public static MerchantTransactions[] read(TimeWindow window) {
		return MerchantTransactions.parseAll(InputReader.readData(fileName));
	}
	
	public static void save(Result result) {
		OutputWriter.writeToFile(fileName, result.toStringFormat());
	}

}
