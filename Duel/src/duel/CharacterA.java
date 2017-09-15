package duel;

import java.util.Random;

public class CharacterA implements Dueler{
	private static final String[] TAUNTS = {"Im amazing", " get rekted"};
	private final int attacking = 1;
	private final int defending = 0;
	private int hp = -1;
	
	private Random rand = new Random();
	
	
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
		String taunt = TAUNTS[this.rand.nextInt(TAUNTS.length)];
		System.out.println(taunt);

	}
	
	public int getAction(Object caller) {
		
		if(caller instanceof Duel) {
			int descision = this.rand.nextInt(1);
			if(descision == this.defending) {
				return 2;
			}
			else if(descision == this.attacking){
				if (caller.d1Loaded) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
		return 3;
	}
		
		
	public void hit(Object caller) {
		
	}

	

}
