package PipeFilter;


public class Pipe {
	
	private Information info;
	
	public Pipe(){
	}
	
	public void write(Information info){
		this.info = info;
	}
	
	public Information read(){
		return info;
	}
}
