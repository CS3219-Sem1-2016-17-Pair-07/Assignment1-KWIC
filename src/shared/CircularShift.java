package shared;

import java.util.ArrayList;
import java.util.Arrays;

public class CircularShift {
	public CircularShift(Input inputStorage, Output outputStorage) {
		for (int i = 0; i < inputStorage.getSize(); i++) {
			ArrayList<String> words = new ArrayList<String>(Arrays.asList(inputStorage.getLine(i).split(" ")));
			for (int z = 0; z < words.size(); z++) {
				String keyWord = words.get(0);

				if (!inputStorage.checkIgnoreWords(keyWord)) {
					outputStorage.add(convertToLine(words));
				} else {
					keyWord = keyWord.toLowerCase();
				}

				words.remove(0);
				words.add(keyWord);
			}
		}
	}

	private String convertToLine(ArrayList<String> words) {

		String line = "";
		for (int i = 0; i < words.size(); i++) {
			line = line + " " + words.get(i);
		}
		line = line.trim();

		return line;
	}
}
