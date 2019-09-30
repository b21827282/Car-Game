import java.util.Random;
import javafx.scene.paint.Color;
public class Bot {
	int botX=0;
	int botY=0;
	boolean onLeft;
	Color botColor;
	boolean active=true;
	public Bot(int x ,int y,boolean onLeft) {
		Random r = new Random();
		botColor=Var.botColors[r.nextInt(Var.botColors.length)];
		this.botX=x;
		this.botY=y;
		this.onLeft=onLeft;
	}
	public void moveBot() {
		botY+=Var.gameSpeed;
		if(botY>600) {
			botColor=Color.BLACK;
			 if(active) {
				 Obj.player.addPoint(); 
			 }
			 active=false;
		}
		if(botY>Var.Height) {
			Random r = new Random();
			botColor = Var.botColors[r.nextInt(Var.botColors.length)];
			botY-=2000;
			if(onLeft==true) {				 
				botX=r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2)-Var.botWidth+Var.sideRoadsWidth;
			}else {
				botX=Var.sideRoadsWidth+(Var.Width-Var.sideRoadsWidth*2)/2+r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2-Var.botWidth);
			}
			active=true;
			
		}
	}
	 public Color getColor() {
		 return botColor;
	 }
	 public int getX() {
		 return botX;
		 
	 }
	 public int getY() {
		 return botY;		 
	 }
	 public int getCentreX() {
		 return botX+Var.botWidth/2;
	 }
	 public int getCentreY() {
		 return botY+Var.botHeight/2;
	 }
	 public void botRespawn() {
		 Random r=new Random();
		 active=true;
		 botColor=Var.botColors[r.nextInt(Var.botColors.length)] ;
		 botY-=2000;
		 if(onLeft==true) {				 
				botX=r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2)-Var.botWidth+Var.sideRoadsWidth;
		}else {
			botX=Var.sideRoadsWidth+(Var.Width-Var.sideRoadsWidth*2)/2+r.nextInt((Var.Width-Var.sideRoadsWidth*2)/2-Var.botWidth);
		} 
	 }
	public void crashed() {
		botColor=Color.DARKRED;
	}
}
