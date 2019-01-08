package daoLayer.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class OutputWriter {
	
	public static void appendToFile(String filename, String line) {
		try {
			Writer fileWriter = new FileWriter(filename);
			fileWriter.append(line);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void writeToFile(String filename, String line) {
		try {
			Writer fileWriter = new FileWriter(filename);
			fileWriter.write(line); // Assuming new line has been included
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(String filename, ArrayList<String> lines) {
		try {
			Writer fileWriter = new FileWriter(filename);
			for(String line: lines) {
				fileWriter.write(line); // Assuming new line has been included 
			}
			
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
