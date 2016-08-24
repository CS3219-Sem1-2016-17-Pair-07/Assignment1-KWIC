package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Class to do the circular shifting of the lines retrieved from the 
 * shared Input Storage and then store the data into Index Storage
 */

public class CircularShift {
	public CircularShift() throws IOException {
		for (int i = 0; i < InputStorage.getInstance().getSize(); i++) {
			ArrayList<String> words = new ArrayList<String>(
					Arrays.asList(InputStorage.getInstance().getLine(i).split(" ")));
			for (int z = 0; z < words.size(); z++) {
				String keyWord = words.get(0);

				if (!InputStorage.getInstance().checkIgnoreWords(keyWord)) {
					IndexStorage.getInstance().add(convertToLine(words));
				} else {
					keyWord = keyWord.toLowerCase();
				}

				words.remove(0);
				words.add(keyWord);
			}
		}
	}

	// Returns the array list for the line as a whole line
	private String convertToLine(ArrayList<String> words) {

		String line = "";
		for (int i = 0; i < words.size(); i++) {
			line = line + " " + words.get(i);
		}
		line = line.trim();

		return line;
	}
}
