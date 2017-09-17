package duel;

import java.util.Random;

public class CharacterA implements Dueler{
	private static final String[] TAUNTS = {"Im amazing", "get rekted", "Im the alpha bot", "gg", "like my Hcks?", "Ive got Awsome Sause"};
	private final int defending = 0;
	private int hp = -1;
	private boolean loaded = false;
	
	private Random rand = new Random();
	
	
	private String name = "Player_3";
	
	private Dueler opponent;
	private int opponentLastMove;
	private boolean opponentIsLoaded;
	
	private int previousTauntIndex = -1;
	
	public CharacterA() {
	}
	
	
	public boolean determineIfOpponentIsFair(Dueler d, int target) {
		this.opponent = d;
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
		int tauntIndex = this.rand.nextInt(TAUNTS.length);
		if(tauntIndex == this.previousTauntIndex) {
			if(tauntIndex == 0) {
				tauntIndex = TAUNTS.length;
			}
			else {
				tauntIndex-=1;
			}
		}
		String taunt = TAUNTS[tauntIndex];
		this.previousTauntIndex = tauntIndex;
		System.out.println(taunt);

	}
	
	public int getAction(Object caller) {
		if(caller instanceof Duel) {
			Duel gameMaster = (Duel) caller;
			this.updateOpponentState(gameMaster);
			
			int descision = this.rand.nextInt(2);
			boolean shouldLoad = (!this.opponentIsLoaded && !this.loaded);
			if(shouldLoad) { //loads at beginning of the game and whenever there is a safe opportunity to load
				System.out.println("safe load");
				this.loaded = true;
				return Duel.LOADING;
			}
			if(descision == this.defending || this.hp > this.opponent.getHP()) {
				return 2;
			}
			else { //attack if not defending
				if (this.loaded) {
					this.loaded = false;
					return Duel.SHOOTING;
				}
				else {
					this.loaded = true;
					return Duel.LOADING;
				}
			}
		}
		return 3;
	}
		
	public void updateOpponentState(Duel gameMaster) {
		this.opponentLastMove = gameMaster.getLastActionOf(this.opponent);
		if(this.opponentLastMove == Duel.LOADING) {
			this.opponentIsLoaded = true;
		}
		if(this.opponentLastMove == Duel.SHOOTING) {
			this.opponentIsLoaded = false;
		}
	}
	public void hit(Object caller) {
		this.hp-= 10;
		
	}

	

}
