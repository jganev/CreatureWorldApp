import processing.core.PApplet;
import processing.core.PImage;

public class Cheese extends CreatureWorldThing {
    private PImage img;
    private float ydirection;

    public Cheese(int _id) {
        super(_id, CreatureWorldOOP.getApp().width/2, CreatureWorldOOP.getApp().height/2, 1);
        //  myColor = color(255, 0, 0);
        img = app.loadImage("data/Cheese.png");
        ydirection = 5;
    }

    public void display(){
        PApplet app = CreatureWorldOOP.getApp();
        app.imageMode(app.CENTER);
        app.image(img, getX(), getY(), 75, 75);
    }

    public void behave(){
        setX(getX() + getDirection());
        setY(getY() + getYDirection());

        if ((getX() > app.width) || (getX() < 0)) {
            setDirection(getDirection()*-1);
        }

        if ((getY() > app.height) || (getY() < 0)){
            setYDirection(getYDirection()*-1);
        }
    }

    public void interact(CreatureWorldThing[] things){

    }

    private void setYDirection(float direction){
        ydirection = direction;
    }

    private float getYDirection(){
        return ydirection;
    }

}