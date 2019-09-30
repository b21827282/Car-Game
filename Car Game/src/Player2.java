import javafx.scene.paint.Color;
public class Player2 {
	int playerX=Var.sideRoadsWidth*2;
	int playerY=Var.Height-Var.playerHeight-120;
	int playerCentreY=playerY+Var.playerHeight/2;
	int playerCentreX;
	boolean didCrashed=false;
	int totalPoint=0;
	Color playerColor=Color.AZURE;
	public void playerLeft() {
		if(playerX>(Var.sideRoadsWidth+Var.horizontalSensitivity+5)) {
			playerX-=5;
			playerCentreX=playerX+Var.playerWidth/2;
			
		}
		
	}
	public void playerRight() {
		  if(playerX<(Var.Width/2-Var.horizontalSensitivity-Var.playerWidth-5)) {
			  playerX+=5;
			  playerCentreX=playerX+Var.playerWidth/2;
			 ;
		  }
	  }
	public void didCrashedWithBot() {
		  if(!didCrashed) {
		  for(int i=0;i<Var.totalNumberOfBots;i++) {
			  if(Math.abs(playerCentreX-Obj.bots[i].getCentreX())<(Var.playerWidth/2+Var.botWidth/2)&&Math.abs(playerCentreY-Obj.bots[i].getCentreY())<(Var.playerHeight/2+Var.botHeight/2)) {
				  didCrashed=true;
				  playerColor=Color.DARKRED;
				  Obj.bots[i].crashed();
				  V.drawPlayer2();
	       	      V.drawBots();
				  break;
			  }
		  }	  
		  }
	  }
	public void setX(int x) {
		playerX=x;
	}
	public void startAgain() {
		   playerColor=Color.AZURE; 
		   totalPoint=0;
	  }
	  public Color getColor() {
		  return playerColor;
	  }
	  public void setColor(Color color) {
		  playerColor = color;
	  }
	
}
