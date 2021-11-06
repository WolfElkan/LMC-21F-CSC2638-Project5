// Code modified from: https://www.w3schools.com/java/java_files_read.asp

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


class Concordance {
	Bikary bikary;
	Concordance() {
		bikary = new Bikary();
	}
	public static void main(String[] args) {
		long START = System.currentTimeMillis();

		int start;
		if (args.length > 1) {
			start = Integer.parseInt(args[1]);
		} else {
			start = 0;
		}

		int end;
		if (args.length > 2) {
			end = Integer.parseInt(args[2]);
		} else {
			end = -1;
		}

		Concordance mobydick = new Concordance();
		mobydick.ingestFile(args[0], start, end);
		// mobydick.bikary.showDict();
		mobydick.bikary.showFreq();

		long runtime = System.currentTimeMillis() - START;
		long sec = runtime / 1000;
		long mil = runtime % 1000;
		String pad = "";
		if (mil < 10) {
			pad = "00";
		} else if (mil < 100) {
			pad = "0";
		}
		System.out.print("Runtime: ");
		System.out.print(sec);
		System.out.print('.');
		System.out.print(pad);
		System.out.print(mil);
		System.out.println(" seconds");
	}

	void ingestFile(String filename, int start, int end) {
		int line = 1;
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (line >= start && (line <= end || end == -1)) {
					// System.out.print(" ");
					// System.out.println(line);
					ingestLine(data, line);
					// if (line % 1000 == 0) {
					// }
				}
				line++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}		
	}
	void ingestLine(String data, int line) {
		// System.out.println(data);
		String[] words = data.split(" |—");
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			Node occurance = new Node(line, i+1);
			bikary.addWord(words[i], occurance);
		}
	}
}