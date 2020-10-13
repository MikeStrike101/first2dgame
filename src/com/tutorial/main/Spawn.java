package com.tutorial.main;

import java.util.Random;

public class Spawn {
private Handler handler;
private HUD hud;
private Random r;
private int scoreKeep=0;
public Spawn(Handler handler,HUD hud)
{
	this.handler=handler;
	this.hud=hud;
}

public void tick()
{
	scoreKeep++;
	r=new Random();
	if(scoreKeep>=100) {scoreKeep=0;hud.setLevel(hud.getLevel()+1);
	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy));}

	
		
	
}


}
