package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Seele extends Character{

	private int HP;
	
	private int[] Position_Seele;
	private Sprite Seele_field;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		Seele_field = new Sprite(new Texture(Gdx.files.internal("Character/Board/Seele.png")));
		Position_Seele = new int[] {32, 624};
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
		// TODO Auto-generated method stub
		if(pos == 1) {
			Position_Seele = new int[] {32, 624};
		}else if(pos == 2) {
			Position_Seele = new int[] {32, 528};
		}else if(pos == 3) {
			Position_Seele = new int[] {32, 432};
		}else if(pos == 4) {
			Position_Seele = new int[] {32, 336};
		}else if(pos == 5) {
			Position_Seele = new int[] {32, 240};
		}else if(pos == 6) {
			Position_Seele = new int[] {128, 240};
		}else if(pos == 7) {
			Position_Seele = new int[] {224, 240};
		}else if(pos == 8) {
			Position_Seele = new int[] {224, 336};		
		}else if(pos == 9) {
			Position_Seele = new int[] {224, 432};	
		}else if(pos == 10) {
			Position_Seele = new int[] {224, 528};			
		}else if(pos == 11) {
			Position_Seele = new int[] {224, 624};			
		}else if(pos == 12) {
			Position_Seele = new int[] {320, 624};		
		}else if(pos == 13) {
			Position_Seele = new int[] {416, 624};	
		}else if(pos == 14) {
			Position_Seele = new int[] {416, 528};
		}else if(pos == 15) {
			Position_Seele = new int[] {416, 432};
		}else if(pos == 16) {
			Position_Seele = new int[] {416, 336};
		}else if(pos == 17) {
			Position_Seele = new int[] {416, 240};
		}else if(pos == 18) {
			Position_Seele = new int[] {512, 240};
		}else if(pos == 19) {
			Position_Seele = new int[] {608, 240};
		}else if(pos == 20) {
			Position_Seele = new int[] {608, 336};
		}else if(pos == 21) {
			Position_Seele = new int[] {608, 432};
		}else if(pos == 22) {
			Position_Seele = new int[] {704, 432};
		}else if(pos == 23) {
			Position_Seele = new int[] {800, 432};
		}else if(pos == 24) {
			Position_Seele = new int[] {800, 528};
		}else if(pos == 25) {
			Position_Seele = new int[] {800, 624};
		}else if(pos == 26) {
			Position_Seele = new int[] {896, 624};
		}else if(pos == 27) {
			Position_Seele = new int[] {992, 624};
		}else if(pos == 28) {
			Position_Seele = new int[] {992, 528};
		}else if(pos == 29) {
			Position_Seele = new int[] {992, 432};
		}else if(pos == 30) {
			Position_Seele = new int[] {992, 336};
		}else if(pos == 31) {
			Position_Seele = new int[] {992, 240};
		}else if(pos == 32) {
			Position_Seele = new int[] {896, 240};
		}else if(pos == 33) {
			Position_Seele = new int[] {800, 240};
		}else if(pos == 34) {
			Position_Seele = new int[] {800, 144};
		}else if(pos == 35) {
			Position_Seele = new int[] {800, 48};
		}else if(pos == 36) {
			Position_Seele = new int[] {896, 48};
		}else if(pos == 37) {
			Position_Seele = new int[] {992, 48};
		}else if(pos == 38) {
			Position_Seele = new int[] {1088, 48};
		}else if(pos == 39) {
			Position_Seele = new int[] {1184, 48};
		}else if(pos == 40) {
			Position_Seele = new int[] {1184, 144};
		}else if(pos == 41) {
			Position_Seele = new int[] {1184, 240};	
		}else if(pos == 42) {
			Position_Seele = new int[] {1184, 336};	
		}else if(pos == 43) {
			Position_Seele = new int[] {1184, 432};	
		}else if(pos == 44) {
			Position_Seele = new int[] {1184, 528};
		}else if(pos == 45) {
			Position_Seele = new int[] {1184, 624};
		}else {
			Position_Seele = new int[] {1184, 624};
		}
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

}
