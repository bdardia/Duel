package duel;

import java.util.Random;

public class CharacterB implements Dueler 
{
	private static final String[] TAUNTS = {"This is gonna be easy", "What a no namer"};
	private int startingHP;
	private int hp;
	
	public void taunt() 
	{
		Random rand = new Random();
		String taunt = TAUNTS[rand.nextInt(TAUNTS.length)];
		System.out.println(taunt);
	}
	public String getName()
	{
		return "Player_12";
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
	public boolean determineIfOpponentIsFair(Dueler d, int target)
	{
		if (d.getHP() == 30)
		{
			return true;
		}
		return false;
	}
	public CharacterB()
	{
		
	}
}
