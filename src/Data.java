
public class Data {
	private String config;
	private int score;
	//constructor 
	public Data(String config,int score) {
		this.config=config;
		this.score=score;
		
	}
	//getter method to get configuration
	public String getConfiguration() {
		return this.config;
	}
	//getter method to get score
	public int getScore() {
		return this.score;
	}
}
