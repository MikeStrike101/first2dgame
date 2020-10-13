package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);

speedX=5;
speedY=5;
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void tick() {
	x+=speedX;
	y+=speedY;
		if(y<=0 || y>=Game.HEIGHT -32) speedY*=-1;
		if(x<=0 || x>=Game.WIDTH -16) speedX*=-1;
	}


	public void render(Graphics g) {
	    g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 16, 16);
	}

}
