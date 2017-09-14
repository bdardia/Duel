package duel;

import java.util.Random;

public class CharacterB implements Dueler 
{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private int startingHP;
	private int hp;
	
	public void taunt() 
	{
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
	}
	public String getName()
	{
		return "Character B";
	}
	public void setStartingHP(int hp)
	{
		this.startingHP = hp;
		this.hp = startingHP;
	}
	public int getHP()
	{
		return this.hp;
	}
	public CharacterB()
	{
		
	}
}
