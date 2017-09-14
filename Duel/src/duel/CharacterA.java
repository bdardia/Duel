package duel;

import java.util.Random;

public class CharacterA implements Dueler{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private String name;
	
	public CharacterA() {
		
	}
	
	public void taunt() {
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];

	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
