import javafx.scene.paint.Color;
public class Var {
	static String pressedKey="";
	static String writtenWord="";
	static boolean keyDefined=false;
	
	static int playerWidth=50;
	static int playerHeight=150;
	static int horizontalSensitivity=5;
	
	static boolean continueslyPressedKeyCheck[]=new boolean[8];
	static double mouseCord[]=new double[4];
	static boolean mouseClickMeans=false;
	static int Height=800;
	static int Width=1200;
	
	 static int stripRespawnY=-Var.stripLength;
	 static int totalNumberOfStrips=20;
	 static int stripLength=Height/(totalNumberOfStrips);
	 static int stripWidth=15;
	 static int spaceBetStrips=25;
	 
	 static int greenAreaRate=7;//1/5
	 static int sideRoadsWidth=Width/greenAreaRate;
	 
	 static int maxRadiusRandom=50;
	 static int minRadiusRandom=10;
	 static int totalNumberOfTrees=20;
	 
	 static int totalNumberOfBots=10;//always must be EVEN
	 static int botWidth=50;
	 static int botHeight=100;
	 static int minBotSpace=70;
	 
	 static float maxGameSpeed=50;
	 static float gameSpeed=10;
	 static float minGameSpeed=10; 
	 static long firstTime=-1;
	 static float gameSpeedIncreaseConstant=0.1f;
	 
	 static int lastAddedLevel=0;
	 

	 
	 static Color treeColors[]= {Color.DARKGREEN,Color.DARKSEAGREEN,Color.LIGHTGREEN}; 
	 static Color botColors[]= {Color.AQUAMARINE,Color.CYAN,Color.BLUE,Color.CORAL,Color.DODGERBLUE,Color.LIGHTGREEN};
	 
}
