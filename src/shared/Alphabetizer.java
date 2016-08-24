package shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Alphabetizer {

	private ArrayList<String> lines;

	public Alphabetizer(ArrayList<String> lines, HashSet<String> ignoreWord) {
		this.lines = lines;
		alphabetized();
	}

	private void alphabetized() {
		Collections.sort(lines);
	}

}
