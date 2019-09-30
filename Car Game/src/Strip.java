
public class Strip {
	int stripX=Var.Width/2;
	int stripY=10;
	public Strip(int stripY) {	   
		   this.stripY=stripY;
	}
	public void  moveStrip() {
		stripY+=Var.gameSpeed;
		if(stripY>(Var.Height+100)) {
			   stripY=Var.stripRespawnY;		   
		   }
	   }
	public int getX() {
		return stripX;
	}

	public int getY() {
		return stripY;
	}
	
	
}
