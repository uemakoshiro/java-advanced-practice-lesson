package app;

public class GameApp {
	public String item = "何か";
	
	public GameApp() {}
	
	public GameApp(String item) {
		this.item = item;
	}
	
	public String start(String name) {
		return (name + "さんと" + this.item + "でゲームを開始します");
	}
}