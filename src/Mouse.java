import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Mouse extends CreatureWorldThing{
    private PImage[] images;
    private int imageIndex;

    public Mouse(int id){
        super (id, 0, 0, 1);
        images = new PImage[3];
        imageIndex = 0;
        images[0] = app.loadImage ("data/Mouse.png");
        images[1] = app.loadImage ("data/FatMouse.png");
        images[2] = app.loadImage ("data/DeadMouse.png");
    }

    //getting the mouse to be controlled by the arrow keys
    public void handleKeyPressed(){
        if (app.key == app.CODED) {
            if (app.keyCode == app.UP) {
                setY(getY()-10);
            } else if (app.keyCode == app.DOWN) {
                setY(getY()+10);
            } else if (app.keyCode == app.LEFT) {
                setX(getX()-10);
            } else if (app.keyCode == app.RIGHT) {
                setX(getX()+10);
            }
        }
    }
    public void display(){
        app.imageMode(app.CENTER);
        app.image(images[imageIndex], getX(), getY(), 75, 75);
        if (imageIndex == 2){
            app.gameOver();
        }
    }

    public void behave(){
    }

    public void interact(ArrayList<CreatureWorldThing> things){ //how do I change this?
        for (int i = 0; i < things.size(); i++){
            if (app.dist(getX(), getY(), things.get(i).getX(), things.get(i).getY())< 25){
                if (things.get(i).getID()== 3){
                    imageIndex = 1;
                    app.playDing();
                } else if (things.get(i).getID()== 0 || things.get(i).getID()== 1){
                    imageIndex = 2;
                }
            }
        }
    }
}