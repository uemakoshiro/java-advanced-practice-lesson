package main.java.jp.co.axiz.app;

public abstract class GameApp implements App {
	private String item = "何か";
	private int playTime;
	
	public GameApp() {}
	
	public GameApp(String item) {
		this.item = item;
	}
	
	protected abstract String play();
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public String start(String name) {
		return (name + "さんと" + this.item + "でゲームを開始します。"+play());
	}
}