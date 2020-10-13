package com.tutorial.main;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
Random r=new Random();
Handler handler;
	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
	this.handler=handler;
	//	speedX=r.nextInt(5)+1;
		//speedY=r.nextInt(5);

	}

public Rectangle getBounds()
{
	return new Rectangle((int)x,(int)y,32,32);
}
	public void tick() {
	x+=speedX;
	y+=speedY;
x=Game.clamp((int)x, 0, Game.WIDTH-38);
y=Game.clamp((int)y, 0, Game.HEIGHT-61);

collision();
	}
private void collision()
{
	for(int i=0;i<handler.object.size();i++)
	{
		GameObject tempObject=handler.object.get(i);
		if(tempObject.getId()==ID.BasicEnemy)
		   if(getBounds().intersects(tempObject.getBounds()))
			    HUD.HEALTH-=2;
		
   	}
}

	public void render(Graphics g) {
		 
		g.setColor(Color.black);
		g.fillRect((int)x,(int) y, 32, 32);
	}

}
