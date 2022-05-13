package app;

public class Rabbit extends Animal {
	
	public Rabbit() {
		
	}
	
	public Rabbit(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String introduceAge() {
		return "種類はウサギです。人間で言うと、60歳以上です。";
	}
	
	public String getFilePath() {
		return "c:\\work\\rabbit.txt";
	}
}