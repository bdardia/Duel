package duel;

import java.util.Random;

public class CharacterA implements Dueler{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private final int startingHp;
	
	
	private String name = "Player_3";
	
	public CharacterA() {
	}
	
	public void taunt() {
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
		System.out.println(taunt);

	}

	public String getName() {
		return this.name;
	}
	
	void setStartingHP(int hp) {
		this.hp = hp;
	}
	
	

}
