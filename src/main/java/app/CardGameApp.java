package app;

public class CardGameApp extends GameApp {
	
	public CardGameApp() {
		super("トランプ");
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	@Override
	public String play() {
		return "ババ抜きを行います。";
	}
	
}