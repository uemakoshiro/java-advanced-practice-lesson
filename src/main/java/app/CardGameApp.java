package app;

public class CardGameApp extends GameApp {
	
	public CardGameApp() {
		super();
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	@Override
	public String start(String name) {
		String msg = (name + "さんと" + this.item + "でゲームを開始します");
		if("トランプ".equals(this.item)) {
			msg += "。<br>ババ抜きを行います。";
		}
		return msg;
	}
	
}