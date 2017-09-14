package duel;

import java.util.Random;

public class CharacterB implements Dueler 
{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	
	public void taunt() 
	{
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
	}
	public String getName()
	{
		return null;
	}
	public CharacterB()
	{
		
	}
}
