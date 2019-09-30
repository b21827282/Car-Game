import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Assignment extends Application {
	Scene theScene;
	static P ui;
	
	@Override
	public void start(Stage theStage) throws Exception {
		theStage.setTitle(" RACE ");
		Group root = new Group();
		theScene = new Scene(root);
		theStage.setScene(theScene);
		theStage.setHeight(Var.Height);
		theStage.setWidth(Var.Width);
		theStage.setResizable(false);
		theStage.centerOnScreen();
		Canvas canvas=new Canvas(Var.Width,Var.Height);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		ui=new P(gc);
		new AnimationTimer() {

			@Override
			public void handle(long currentNanotime) {
				if(FrameRate(60)) {
					if(!Obj.player.didCrashed&&!Obj.player2.didCrashed) {
						ui.cleanCanvas();
						V.drawRawBackground();
						V.drawSideRoads();
						V.drawStrips();
						V.drawTrees();
						V.drawPlayer1();
						V.drawPlayer2();
						V.drawBots();
						V.drawPoint();
						V.drawSpeed();
						if(V.calculateLevel()!=Var.lastAddedLevel) {
							Var.lastAddedLevel=V.calculateLevel();
							Var.gameSpeed++;
							Var.minGameSpeed++;
							Var.maxGameSpeed++;
							
						}
						if(Var.gameSpeed<Var.minGameSpeed) {
                 	    	  Var.gameSpeed=Var.minGameSpeed;
                 	      }
					}
					if(Obj.player.didCrashed) {
						V.player1Wins();
					}
					if(Obj.player2.didCrashed) {
						V.player2Wins();
					}
				}
				keyPressed();
             	specificKeyReleased();
              	mouseMoved();
                mouseClicked(); 
                V.playerMoves();
				V.player2Moves();
			}

			
			
		}.start();
		theStage.show();
		
	}
	public static void main(String[] args) {
		V.createStrips_ONCE();
		V.createBots_ONCE();
		V.createTrees_ONCE();
		Obj.player=new Player();
		Obj.player2=new Player2();
		Var.firstTime=System.currentTimeMillis();
		launch(args);
	}
	
	
	
	static long LAST_FRAME_TIME=0;
	boolean FrameRate(float rate) {
		if(System.currentTimeMillis()-LAST_FRAME_TIME>(1000/rate)) {
			LAST_FRAME_TIME=System.currentTimeMillis();
			return true;
			
		}
		return false;
	}
	
	
	void keyPressed() {
		theScene.setOnKeyPressed(e->{
			Var.keyDefined=false;
			Var.pressedKey="";
			KeyCode keyboardInput=e.getCode();
			V.functionKeyCheck(keyboardInput);
			if(!Var.keyDefined) {
				V.letterKeyCheck(keyboardInput);
			}
			
			
			if(!V.isEmptyString(Var.pressedKey)) {
				Var.writtenWord+=Var.pressedKey;
			}
		});
	}
	void specificKeyReleased() {
		theScene.setOnKeyReleased(e->{
			KeyCode keyboardInput=e.getCode();
			switch(keyboardInput){
			 
	           	case LEFT:
	           		Var.continueslyPressedKeyCheck[2]=false;
	           		break;
	           	case RIGHT:
	           		Var.continueslyPressedKeyCheck[3]=false;
	           		break; 
	           
	           	case A:
	           		Var.continueslyPressedKeyCheck[5]=false;
	           		break;
	          
	           	case D:
	           		Var.continueslyPressedKeyCheck[7]=false;
	           		break;
			}
			
		});
	}
	 void mouseMoved() {    	
	    	theScene.setOnMouseMoved(e->{  
	    		Var.mouseCord[2]=e.getSceneX();
	    		Var.mouseCord[3]=e.getSceneY();         
	    	});
	    }
	    void mouseClicked() {
	    	theScene.setOnMouseClicked(e->{
	    		//MouseButton k=e.getButton();PRIMARY,SECONDARY
	    		Var.mouseClickMeans=true;
	    		Var.mouseCord[0]=e.getSceneX();
	    		Var.mouseCord[1]=e.getSceneY();
	    		System.out.println(Var.mouseCord[0]+":"+Var.mouseCord[1]);
	    	});
	    }
	
}
