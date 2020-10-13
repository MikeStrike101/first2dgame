package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private boolean[] keyDown=new boolean[4];
    private Handler handler;

    public KeyInput(Handler handler)
    {
    	this.handler=handler;
    	keyDown[0]=false;
    	keyDown[1]=false;
    	keyDown[2]=false;
    	keyDown[3]=false;
    }
    
	public void keyPressed(KeyEvent e)
    { int key = e.getKeyCode();
    	for(int i=0;i<handler.object.size();i++)
    	{
    		GameObject tempObject=handler.object.get(i);
    		if(tempObject.getId()==ID.Player)
    		{
    			//key events for Player 1
    			if(key==KeyEvent.VK_W) {tempObject.setSpeedY(-10);keyDown[0]=true;}
    			else if(key==KeyEvent.VK_S) {tempObject.setSpeedY(+10);keyDown[1]=true;}
    			else if(key==KeyEvent.VK_D) {tempObject.setSpeedX(+10);keyDown[2]=true;}
    			else if(key==KeyEvent.VK_A) {tempObject.setSpeedX(-10);keyDown[3]=true;}
    		}
    	//	if(key==KeyEvent.VK_ESCAPE) System.exit(1);
    	}
    	if(key==KeyEvent.VK_ESCAPE) System.exit(1);
    	
    	
    }
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++)
    	{
    		GameObject tempObject=handler.object.get(i);
    		if(tempObject.getId()==ID.Player)
    		{
    			//key events for Player 1
    			if(key==KeyEvent.VK_W) keyDown[0]=false; //tempObject.setSpeedY(0);
    			else if(key==KeyEvent.VK_S) keyDown[1]=false;//tempObject.setSpeedY(0);
    			else if(key==KeyEvent.VK_D) keyDown[2]=false;//tempObject.setSpeedX(0);
    			else if(key==KeyEvent.VK_A) keyDown[3]=false;//tempObject.setSpeedX(0);
    			
    			if(!keyDown[0] && !keyDown[1]) tempObject.setSpeedY(0);
    			if(!keyDown[2] && !keyDown[3]) tempObject.setSpeedX(0);
    			
  }    	
    	}
	}
}
