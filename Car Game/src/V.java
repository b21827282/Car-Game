import java.util.Random;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class V {

	static void createStrips_ONCE() {
		for(int i= 0;i<Var.totalNumberOfStrips;i++) {
			Obj.strips[i]=new Strip(Var.stripRespawnY+i*(Var.stripLength+Var.spaceBetStrips));
		}
	}
	static void drawStrips() {
		for(int i =0;i<Var.totalNumberOfStrips;i++) {
			Assignment.ui.fillrect(Color.BLACK, Obj.strips[i].getX(), Obj.strips[i].getY(),Var.stripWidth,Var.stripLength);
			Obj.strips[i].moveStrip();
		}
	}
	
	
	static void createTrees_ONCE() {
		for(int i= 0;i<Var.totalNumberOfTrees;i++) {
			Obj.trees[i]=new Tree();
		}
		
	}
	static void drawTrees() {
		for(int i= 0;i<Var.totalNumberOfTrees;i++) {
			Assignment.ui.setFill(Obj.trees[i].getColor());
			Assignment.ui.arc(Obj.trees[i].getX(), Obj.trees[i].getY(), Obj.trees[i].getRadius(), 0, 360, ArcType.ROUND);
			Obj.trees[i].moveTree();
		}
	}
	static void drawPlayer1() {
		Assignment.ui.fillrect(Obj.player.getColor(), Obj.player.playerX, Obj.player.playerY, Var.playerWidth, Var.playerHeight);
    	Obj.player.didCrashedWithBot();
	}
	static void drawPlayer2() {
		Assignment.ui.fillrect(Obj.player2.getColor(), Obj.player2.playerX, Obj.player2.playerY, Var.playerWidth, Var.playerHeight);
		Obj.player2.didCrashedWithBot();
	}
	
	static void createBots_ONCE() {
		Random r=new Random();
    	for(int i=0;i<Var.totalNumberOfBots/2;i++) {
			Obj.bots[i]=new Bot(Var.sideRoadsWidth+r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2-Var.botWidth),-(i*(Var.botHeight+Var.minBotSpace)),true);			
    	}
    	for(int i=Var.totalNumberOfBots/2;i<Var.totalNumberOfBots;i++) {
			Obj.bots[i]=new Bot(Var.sideRoadsWidth+(Var.Width-Var.sideRoadsWidth*2)/2+r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2-Var.botWidth),-(i*(Var.botHeight+Var.minBotSpace)),false);			
		}
	}
	static void respawnAllBots() {
		  for(int i=0;i<Var.totalNumberOfBots;i++) {
			  Obj.bots[i].botRespawn();
		  }
	  }
	  static void drawBots() {
	    	for(int i=0;i<Var.totalNumberOfBots;i++) {
	    		Assignment.ui.fillrect(Obj.bots[i].getColor(), Obj.bots[i].getX(), Obj.bots[i].getY(), Var.botWidth,  Var.botHeight);
	    		Obj.bots[i].moveBot();
	    	}
	    }
	  static void drawRawBackground() {
	    	Assignment.ui.fillrect(Color.DARKGREY, 0, 0, Var.Width, Var.Height);
	    }
	    static void drawSideRoads() {
	    	Assignment.ui.fillrect(Color.BURLYWOOD, 0, 0, Var.Width/Var.greenAreaRate, Var.Height);
	    	Assignment.ui.fillrect(Color.BURLYWOOD, Var.Width-Var.Width/Var.greenAreaRate, 0,  Var.Width/Var.greenAreaRate, Var.Height);    
	    }
		//WHEN GAME FİNİSHED
	   static void drawGameOver() {
	    	if(System.currentTimeMillis()%1000<500) {
	    		Assignment.ui.drawText("GAME OVER LEVEL:"+calculateLevel()+"\nYOUR POINT IS\n          "+Obj.player.totalPoint+"\nPRESS ENTER TO START", 70, Var.Width/2-200, Var.Height/2-200, Color.DARKRED, Color.BLACK, 3);
	    	}else {
	    		Assignment.ui.drawText("GAME OVER LEVEL:"+calculateLevel()+"\nYOUR POINT IS\n          "+Obj.player.totalPoint+"\nPRESS ENTER TO START", 70, Var.Width/2-200, Var.Height/2-200, Color.BLACK, Color.DARKRED, 3);
	    	}
	    	
	    }
	   static void player1Wins() {
		   if(System.currentTimeMillis()%1000<500) {
	    		Assignment.ui.drawText("PLAYER 1 HAS WON!", 70, Var.Width/2-200, Var.Height/2-200, Color.DARKRED, Color.BLACK, 3);
	    	}else {
	    		Assignment.ui.drawText("PLAYER 1 HAS WON!", 70, Var.Width/2-200, Var.Height/2-200, Color.DARKRED, Color.BLACK, 3);
	    	}
	   }
	   
	   static void player2Wins() {
		   if(System.currentTimeMillis()%1000<500) {
	    		Assignment.ui.drawText("PLAYER 2 HAS WON!", 70, Var.Width/2-200, Var.Height/2-200, Color.DARKRED, Color.BLACK, 3);
	    	}else {
	    		Assignment.ui.drawText("PLAYER 2 HAS WON!", 70, Var.Width/2-200, Var.Height/2-200, Color.DARKRED, Color.BLACK, 3);
	    	}
	   }
	    static int calculateLevel() {
	    	return (int) (Obj.player.totalPoint/3);
	    }
	    static void drawSpeed() {
	    	Assignment.ui.drawText("Velocity: "+String.valueOf((int)Var.gameSpeed), 20, 1000, 100, Color.WHITE, Color.BLACK, 1);
	    }
	    static void drawPoint() {
	    	Assignment.ui.drawText("Score: "+String.valueOf(Obj.player.totalPoint), 20, 1000, 50, Color.WHITE, Color.BLACK, 1);
	    }
	    
	    static void functionKeyCheck(KeyCode keyCode) {
	    	Var.keyDefined=true;
	    	switch(keyCode) {
	    	case BACK_SPACE:
	    		if(!isEmptyString(Var.writtenWord)) {
	    			String t="";
	    			String[] splitted=Var.writtenWord.split("");
	    			for(int i=0;i<(Var.writtenWord.length()-1);i++){	       				
	       				t+=splitted[i];
	       			}
	       			Var.writtenWord=t;
	    		}
	    		break;
	    	case UP:
	       		Var.continueslyPressedKeyCheck[0]=true;
	       		break;
	       	case DOWN:
	       		Var.continueslyPressedKeyCheck[1]=true;
	       		break;
	       	case LEFT:
	       		Var.continueslyPressedKeyCheck[2]=true;
	       		break;
	       	case RIGHT:
	       		Var.continueslyPressedKeyCheck[3]=true;
	       		break;
	       	case W:
	       		Var.continueslyPressedKeyCheck[4]=true;
	       		break;
	       	case A:
	       		Var.continueslyPressedKeyCheck[5]=true;
	       		break;
	       	case S:
	       		Var.continueslyPressedKeyCheck[6]=true;
	       		break;
	       	case D:
	       		Var.continueslyPressedKeyCheck[7]=true;
	       		break;
	       	case SPACE:
	       		Var.pressedKey=" ";
	       		break;
	       	case DELETE:
	       		Var.writtenWord="";
	       		break;		
	       	case CONTROL:
	       		break;	
	       	case TAB:
	       		break;
	       	case ENTER:
	       		Obj.player.didCrashed=false;
	       		Obj.player2.didCrashed=false;
	       		Obj.player.setX(Var.sideRoadsWidth*5);
	       		Obj.player.setY(Var.Height-Var.playerHeight-120);
	       		Obj.player2.setX(Var.sideRoadsWidth*2);
	    		Var.minGameSpeed=9;
	    		Var.gameSpeed=9;
	    		Var.maxGameSpeed=50;
	    		Obj.player.totalPoint=0;
	    		Obj.player.setColor(Color.AZURE);
	    		Obj.player2.setColor(Color.AZURE);
	    		respawnAllBots();
	       		break;	
	       		
	       	
	       		///----------------
	    	default:
	    	Var.keyDefined=false;
	    	break;
	    	
	    		
	    	
	    	}
	    	
	    }
	    static void letterKeyCheck(KeyCode keyCode){
			Var.keyDefined=true;
			 switch(keyCode) {       	 
		       	case A:	     	
		       		Var.pressedKey="A";
		     	break;      		 
		      	case B:
		      		Var.pressedKey="B";	
		      	break;
		      	case C:
		      		Var.pressedKey="C" ;
		     	break;	       
		    	case D:
		    		Var.pressedKey="D"; 
		    	break; 
		    	case E:
		    		Var.pressedKey="E";
		   		 break; 
		    	case F:
		    		Var.pressedKey="F";
		   		 break; 
		    	case G:
		    		Var.pressedKey="G";
		   		 break; 
		    	case H:
		    		Var.pressedKey="H";
		   		 break; 
		    	case I:
		    		Var.pressedKey="I";
		   		 break; 
		    	case J:
		    		Var.pressedKey="J";
		   		 break; 
		    	case K:
		    		Var.pressedKey="K";
		   		 break; 
		    	case L:
		    		Var.pressedKey="L";
		   		 break; 
		    	case M:
		    		Var.pressedKey="M";
		   		 break; 
		    	case N:
		    		Var.pressedKey="N";
		   		 break; 
		    	case O:
		    		Var.pressedKey="O";
		   		 break; 
		    	case P:
		    		Var.pressedKey="P";
		   		 break; 
		    	case Q:
		    		Var.pressedKey="Q";
		   		 break; 
		    	case R:
		    		Var.pressedKey="R";

		   		 	break; 
		    	case S:
		    		Var.pressedKey="S";
		   		 break; 
		    	case T:////not for writing
		    			    		
		   		 break; 
		    	case U:
		    		Var.pressedKey="U";
		   		 break; 
		    	case V:
		    		Var.pressedKey="V";
		   		 break; 
		    	case W:
		    		Var.pressedKey="W";
		   		 break; 
		    	case X:
		    		Var.pressedKey="X";
		   		 break; 
		    	case Y:
		    		Var.pressedKey="Y";
		   		break; 	   		 
		    	case Z:
		    		Var.pressedKey="Z";
		   		break;
		    	case COMMA:
		    		Var.pressedKey=",";
		        break;
		    	case PERIOD:
		    		Var.pressedKey=":";
		    		break;
		    		
		   			///----------------------
		    	default :
		    	Var.keyDefined=false;
		    	break;
		       	}
	    }
	    
	    
	    static boolean isEmptyString(String inputString) {
	    	if(!inputString.equals("")&&inputString!=null){
	    		return false;
	    	}    	
	    	return true;
	    	
	    }
	    static void playerMoves() {
	 
	    	if(Var.continueslyPressedKeyCheck[2]) {
	    		Obj.player.playerLeft();
	    	}
	    	if(Var.continueslyPressedKeyCheck[3]) {
	    		Obj.player.playerRight();
	    	}
	    }
	    
	    static void player2Moves() {
	    	
	    	if(Var.continueslyPressedKeyCheck[5])
	    		Obj.player2.playerLeft();
	    	if(Var.continueslyPressedKeyCheck[7]){
	    		Obj.player2.playerRight();
	    	}
	    }
}
