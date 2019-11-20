package com.mygdx.game;

public abstract class Character {
	protected int HP;
	protected int ATK;
	protected String Name;
	
	public int getHP() {
		return HP;
	}
	
	public void setHP(int hP) {
		HP = hP;
	}
	
	public int getATK() {
		return ATK;
	}
	
	public void setATK(int aTK) {
		ATK = aTK;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
}
