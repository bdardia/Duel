# Duel
Two pretty good bots fighting each other in a duel to the death
---
Player_3 will always win once it takes the lead. When it has more health than its opponent (and they're loaded) it will block every turn.
```javascript
int descision;
if(!this.opponentIsLoaded) {
	descision = 1; //should attack or load : loading is just a safe as gaurding
}
else {
	descision = this.rand.nextInt(2);
}

boolean safeLoad = (!this.opponentIsLoaded && !this.loaded);
if(safeLoad) { //loads at beginning of the game and whenever there is a safe opportunity to load maybe add some randomness if the other bot adapts
	//System.out.println("safe load");
	this.loaded = true;
	return Duel.LOADING;
}
if(descision == this.defending || this.hp > this.opponent.getHP() && this.opponentIsLoaded) {
	return Duel.GUARDING;
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
```
Player_12 will shoot based on the health difference between the two bots. If it's a close game, it wont risk as much by shooting less.
If it needs to stage a comeback or hold a lead, it will shoot more often. When losing, a modifier is added so it will shoot more.

```javascript
private double safeFactor = 0.2;
```
```javascript
if (firstRound)
{
	firstRound = false;
	recentlyLoaded = true;
	return 0;
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
if ((!opponentIsLoaded && !(recentlyLoaded)) || ((odds < safeFactor) && !(recentlyLoaded)))
{
	recentlyLoaded = !recentlyLoaded;
	return 0;
}
else if (odds < (safeFactor + 0.3) && recentlyLoaded)
{
	recentlyLoaded = !recentlyLoaded;
	return 1;
}
else
{
	return 2;
}
```

Both will always shoot on the first round.
---
