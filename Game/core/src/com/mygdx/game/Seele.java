package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Seele extends Character{

	private int HP;
	private int[][] Position;
	private int[] Position_Seele;
	private Sprite Seele_field;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		Seele_field = new Sprite(new Texture(Gdx.files.internal("Character/Board/Seele.png")));
		Position_Seele = new int[] {32, 624};
		Position = new int[][] {
			{32, 624}, {32, 528}, {32, 432}, {32, 336} , {32, 240}
		  , {128, 240}, {224, 240}, {224, 336}, {224, 432}, {224, 528}
		  , {224, 624}, {320, 624}, {416, 624}, {416, 528}, {416, 432}
		  , {416, 336}, {416, 240}, {512, 240}, {608, 240}, {608, 336}
		  , {608, 432}, {704, 432}, {800, 432}, {800, 528}, {800, 624}
		  , {896, 624}, {992, 624}, {992, 528}, {992, 432}, {992, 336}
		  , {992, 240}, {896, 240}, {800, 240}, {800, 144}, {800, 48}
		  , {896, 48}, {992, 48}, {1088, 48}, {1184, 48}, {1184, 144}
		  , {1184, 240}, {1184, 336}, {1184, 432}, {1184, 528}, {1184, 624}
		  };
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		Seele_field.setPosition(Position_Seele[0], Position_Seele[1]);
		Seele_field.setSize(84, 127);
		Seele_field.draw(batch);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	public void setPosition_Seele(int pos) {
		Position_Seele = Position[pos - 1];
	}

	@Override
	public void drawCombat(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setAnimation(int animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void TakeDMG(int dmg) {
		// TODO Auto-generated method stub
		this.HP -= dmg;
	}
	
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.HP;
	}
	
	@Override
	public void setDice_atk(int dice_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDice_def(int dice_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sprite getDice_combat() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setSkill_atk(int skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkill_def(int skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(int random) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHP(int hP) {
		// TODO Auto-generated method stub
		
	}

}
