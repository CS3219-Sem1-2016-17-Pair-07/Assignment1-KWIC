package PipeFilter;

public class PipeAndFilter {
	
	public PipeAndFilter(String lines, String ignoreWords){
		
		// Just read in lines and ignore words
		Pipe p1 = new Pipe();
		Pipe p2 = new Pipe();
		Pipe p3 = new Pipe();
		
		new Input(lines,ignoreWords,p1).start();
		new CircularShifter(p1, p2).start();
		new Alphabetizer(p2, p3).start();
		new Output(p3).start();
	}
}
