package app;

public class Cat extends Animal {
	
	public Cat() {
		
	}
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String introduceAge() {
		return "種類はネコです。人間で言うと、30代です。";
	}
	
	public String getFilePath() {
		return "c:\\work\\cat.txt";
	}
}