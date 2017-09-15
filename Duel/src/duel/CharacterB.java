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
		if (d.getHP() == target)
		{
			return true;
		}
		return false;
	}
	public int getAction(Object caller)
	{
		double odds = Math.random();
		boolean fairInstance = caller instanceof Duel;
		boolean recentlyLoaded = false;
		if (!fairInstance)
		{
			return 3;
		}
		if (odds < 0.333 && !recentlyLoaded)
		{
			recentlyLoaded = !recentlyLoaded;
			return 0;
		}
		else if (odds < 0.666 && odds > 0.333 && recentlyLoaded)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	public void hit(Object caller)
	{
		boolean fairInstance = caller instanceof Duel;
		if (!fairInstance)
		{
			return;
		}
		this.hp -= 10;
	}
	public CharacterB()
	{
		
	}
}
