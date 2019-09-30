import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.*;

public class P {
	GraphicsContext picasso_gc;
	
	public P(GraphicsContext picasso_gc) {
		this.picasso_gc = picasso_gc;
	}

	public void drawText(String text,int size,double x,double y,Color fill,Color stroke,int width) {
		picasso_gc.setFill(fill);
		picasso_gc.setStroke(stroke);
		picasso_gc.setLineWidth(width);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, size);
		picasso_gc.setFont(theFont);
		picasso_gc.fillText(text, x, y);
		picasso_gc.strokeText(text, x, y);
	}
	public void arc(double x,double y,double r,double startAngle,double endAngle,ArcType type) {
		setStroke(Color.BLACK,3);
		picasso_gc.fillArc(x, y, r, r, startAngle, endAngle, type);
	}
	
	public void line(int x1,int y1,int x2,int y2) {
		picasso_gc.strokeLine(x1, y1, x2, y2);
	}
	
	public void line_specified(Color color,float lineWidth,float x1,float y1,float x2,float y2) {
		setStroke(color,lineWidth);
		picasso_gc.strokeLine(x1, y1, x2, y2);
	}
	public void rect(Color color,float lineWidth,float x,float y,int Xdim,int Ydim) {
		setStroke(color,lineWidth);
	    picasso_gc.strokeRect(x, y, Xdim, Ydim);  	
	}
	public void fillrect(Color color,float x,float y,int Xdim,int Ydim) {
	    setFill(color);
	    picasso_gc.fillRect(x, y, Xdim, Ydim);  	
	}
	   
	//-------------------
	public void cleanCanvas() {
		picasso_gc.clearRect(0, 0,Var.Width,Var.Height);
	}
	public void setStroke(Color color,double lineWidth) {
		picasso_gc.setStroke(color);
		picasso_gc.setLineWidth(lineWidth);
	}
	public void setFill(Color color) {
		picasso_gc.setFill(color);
	}
}
