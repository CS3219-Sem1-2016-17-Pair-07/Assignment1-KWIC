package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularShift {
	public CircularShift() throws IOException {
		for (int i = 0; i < LineStorage.getInstance().getSize(); i++) {
			ArrayList<String> words = new ArrayList<String>(
					Arrays.asList(LineStorage.getInstance().getLine(i).split(" ")));
			for (int z = 0; z < words.size(); z++) {
				String keyWord = words.get(0);

				if (!LineStorage.getInstance().checkIgnoreWords(keyWord)) {
					IndexStorage.getInstance().add(convertToLine(words));
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
