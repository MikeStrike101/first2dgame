package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class HUD {
	public static float HEALTH=100;
	private float greenValue=255;
	public static int score=0;
	public static int level=1;
	private Random r=new Random();
	private Game game;
	private Handler handler;
public void tick()
{
	//HEALTH--;
	HEALTH=Game.clamp(HEALTH,0,100);
	
	
	greenValue=Game.clamp(greenValue, 0, 255);
	greenValue=HEALTH*2;
	score++;


}
public void render(Graphics g)
{
	g.setColor(Color.gray);
	g.fillRect(15, 15, 200, 32);

    g.setColor(new Color(150,(int)greenValue,0));
	g.fillRect(15, 15, (int)HEALTH * 2, 32);
	g.setColor(Color.white);
	g.drawRect(15, 15, 200, 32);
	
	g.drawString(" Score : " + score,15,64);
	g.drawString(" Enemies : " + level,15,80);
}
public HUD (Game game,Handler handler)
{
	this.game=game;
	this.handler=handler;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}


}
