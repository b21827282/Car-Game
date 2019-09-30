import java.util.Random;

import javafx.scene.paint.Color;

public class Tree {
	int treeX;
	int treeY=0;
	int treeRadius;
	Color treeColor;
	public Tree() {
		Random random = new Random();
		int r = random.nextInt(Var.maxRadiusRandom)+Var.minRadiusRandom;
		treeRadius=r;
		r =random.nextInt(Var.treeColors.length);
		treeColor=Var.treeColors[r];
		r=random.nextInt(Var.sideRoadsWidth*2);
		if(r>Var.sideRoadsWidth)
			treeX=Var.Width-Var.sideRoadsWidth+r%Var.sideRoadsWidth-20;
		else {
			treeX=r%Var.sideRoadsWidth-20;
		}
		r=random.nextInt(Var.Height);
		this.treeY-=r;
	}
	public void moveTree() {
		treeY+=Var.gameSpeed;
		if(treeY>Var.Height+100) {
			treeY=Var.stripRespawnY;
		}
	
	}
	  public int getX() {
		   return treeX;
	   }
	   public int getY() {
		   return treeY;
	   }
	   public Color getColor() {
		   return this.treeColor;
	   }
	   public int getRadius() {
		   return this.treeRadius;
	   }
}
