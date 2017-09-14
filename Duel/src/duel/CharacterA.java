package duel;

import java.util.Random;

public class CharacterA implements Dueler{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private int hp = -1;
	
	
	private String name = "Player_3";
	
	public CharacterA() {
	}
	
	
	public boolean determineIfOpponentIsFair(Dueler d, int target) {
		return d.getHP() == target;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setStartingHP(int hp) {
		if(this.hp == -1 & hp > 0) {
			this.hp = hp;
		}
		
	}
	
	public void taunt() {
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
		System.out.println(taunt);

	}

	

}
