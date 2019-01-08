package daoLayer.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {

	public static ArrayList<String> readData(String filename) {
		ArrayList<String> lines = new ArrayList<>();
		
		try {
			Scanner in = new Scanner(new File(filename));
			
			while (in.hasNextLine()) {
				lines.add(in.nextLine());
			}

			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
	}

}

