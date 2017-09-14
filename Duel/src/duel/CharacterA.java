package duel;

import java.util.Random;

public class CharacterA {
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private String name;
	
	public CharacterA(String name) {
		this.name = name;
	}
	
	public void taunt() {
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
		System.out.println(taunt);

	}

	public String getName() {
		return this.name;
	}

}
