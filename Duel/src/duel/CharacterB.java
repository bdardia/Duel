package duel;

import java.util.Random;

public class CharacterB implements Dueler 
{
	private static final String[] TAUNTS = {"This is gonna be easy", "What a no namer", "That's a 1", "You play like a bot"};
	private int startingHP;
	private int hp;
	private boolean recentlyLoaded = false;
	private boolean firstRound = true;
	private Dueler characterA;
	private boolean opponentIsLoaded = false;
	
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
		characterA = d;
		if (d.getHP() == target)
		{
			return true;
		}
		return false;
	}
	public int getAction(Object caller)
	{
		opponentLoaded((Duel)caller);
		double odds = Math.random();
		double safeFactor = 0.2;
		boolean fairInstance = caller instanceof Duel;
		if (firstRound)
		{
			firstRound = false;
			return 0;
		}
		if (!fairInstance)
		{
			return 3;
		}
		if (this.getHP() < characterA.getHP())
		{
			safeFactor = 0.2 + ((characterA.getHP() - this.getHP()) / 100);
		}
		if (this.getHP() > characterA.getHP())
		{
			safeFactor = (this.getHP() - characterA.getHP()) / 100;
		}
		if (this.getHP() == characterA.getHP())
		{
			safeFactor = 0.2;
		}
		if ((!opponentIsLoaded && !recentlyLoaded) || ((odds < safeFactor) && !recentlyLoaded))
		{
			recentlyLoaded = !recentlyLoaded;
			return 0;
		}
		else if (odds > (safeFactor + 0.4) && recentlyLoaded)
		{
			recentlyLoaded = !recentlyLoaded;
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
	public void opponentLoaded(Duel mainDuel)
	{
		if (mainDuel.getLastActionOf(characterA) == 0)
		{
			this.opponentIsLoaded = true;
		}
		else if (mainDuel.getLastActionOf(characterA) == 1)
		{
			this.opponentIsLoaded = false;
		}
	}
	public CharacterB()
	{
		
	}
}
