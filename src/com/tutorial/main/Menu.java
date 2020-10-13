package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r=new Random();
	public Menu(Game game,Handler handler,HUD hud)
	{
		this.game=game;
		this.handler=handler;
		this.hud=hud;
		
		
	}
	public void mousePressed(MouseEvent e)
	{
		
		int mx=e.getX();
		int my=e.getY();
		
		
		if(mouseOver(mx,my,400, 200, 200,100) && game.gameState==STATE.Menu)
				{
			game.gameState=STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
			 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy));
				}

			if(mouseOver(mx,my,400, 500, 200,100)&& game.gameState==STATE.Menu)
				{
		System.exit(1);
				}
		if(mouseOver(mx,my,325,500, 300, 100) && game.gameState==STATE.End)
		{ HUD.HEALTH=100;
		HUD.score=0;
	    HUD.level=1;
	    handler=new Handler();
			game.gameState=STATE.Menu;
	
		//	handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
			// handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy));
				
			//handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
			 //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy));
		}
			
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my  < y + height)
			{
				return true;
			}
			else return false;
		}else return false;
		
	}
	
	public void render(Graphics g)
{  Font fnt=new Font("calibri",1,50);
   Font fnt2=new Font("calibri",1,30);
   if(game.gameState==STATE.Menu) {g.setFont(fnt);
    g.setColor(Color.green);
	g.drawString("Menu", 425, 100);
	
	g.setColor(Color.white);
	g.setFont(fnt2);
	g.drawString("Play", 445, 260);
	g.drawRect(400, 200, 200,100);
	
	g.drawString("Help", 445, 415);
	g.setColor(Color.white);
	g.drawRect(400, 350, 200,100);
	
	g.drawString("Quit", 445, 560);
	g.setColor(Color.white);
	g.drawRect(400, 500, 200,100);}
   else if(game.gameState==STATE.End)
	{
		g.setFont(fnt);
	    g.setColor(Color.green);
		g.drawString("Try Again", 400, 100);
		g.drawString("You lost to a score of : " + HUD.score, 250, 260);
		g.setColor(Color.white);
		g.drawRect(325, 500, 300, 100);
		g.fillRect(325,500, 300, 100);
		g.setColor(Color.black);
		g.drawString("Back", 400, 560);
		
		
	}
	

}
public void tick()
{
}
}


