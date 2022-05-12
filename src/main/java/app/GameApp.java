package app;

public abstract class GameApp implements App {
	public String item = "何か";
	
	public GameApp() {}
	
	public GameApp(String item) {
		this.item = item;
	}
	
	public abstract String play();
	
	public String start(String name) {
		return (name + "さんと" + this.item + "でゲームを開始します。"+play());
	}
}