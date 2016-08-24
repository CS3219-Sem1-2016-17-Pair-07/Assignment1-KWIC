package PipeFilter;

/*
 * Main constructor for pipe and filter architecture
 */
public class PipeAndFilter {
	
	private static Pipe p1;
	private static Pipe p2;
	private static Pipe p3;
	
	private static PipeAndFilter instance = null;
	
	private PipeAndFilter(String lines, String ignoreWords) {
		p1 = new Pipe();
		p2 = new Pipe();
		p3 = new Pipe();
		
		// Input writes to p1
		new Input(lines,ignoreWords,p1).start();
		// CircularShifter reads from p1 and writes to p2
		new CircularShifter(p1, p2).start();
		// Alphabetizer reads from p2 and writes to p3
		new Alphabetizer(p2, p3).start();
		// Output reads from p3 and display the output
		new Output(p3).start();
	}
	
	public static PipeAndFilter getInstance(String lines, String ignoreWords) {
		if(instance == null) {
			instance = new PipeAndFilter(lines, ignoreWords);
		} else {
	        p1.write(Input.parseInput(lines, ignoreWords));
		}
		return instance;
   }
}
