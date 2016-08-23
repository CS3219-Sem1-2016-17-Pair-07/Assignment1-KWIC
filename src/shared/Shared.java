package shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import PipeFilter.Alphabetizer;

public class Shared {

	private InputStorage inputStorage;

	public Shared(ArrayList<String> lines, HashSet<String> ignoreWords) {
		inputStorage = new InputStorage(lines, ignoreWords);
		circularShift();
	}

	public void circularShift() {
		for (int i = 0; i < inputStorage.getSize(); i++) {
			ArrayList<String> words = new ArrayList(Arrays.asList(inputStorage.getLine(i).split(" ")));
			for (int z = 0; z < words.size(); z++) {
				String keyWord = words.get(0);

				if (!inputStorage.checkIgnoreWords(keyWord)) {
					
				} else {
					keyWord = keyWord.toLowerCase();
				}

				words.remove(0);
				words.add(keyWord);
			}
		}
	}

	public void alphabetizer() {

	}

}
