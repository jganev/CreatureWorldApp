import java.util.ArrayList;

public class CreatureWorldThing {
    private int id;
    private float x;
    private float y;
    private float direction;
    protected final CreatureWorldOOP app = CreatureWorldOOP.getApp();

    public CreatureWorldThing(int _id, float _x, float _y, float _direction){
        id = _id;
        x = _x;
        y = _y;
        direction = _direction;
    }

    public int getID(){
        return id;
    }

    public float getX(){
        return x;
    }

    public void setX(float _x){
        x = _x;
    }

    public float getY(){
        return y;
    }

    public void setY(float _y){
        y = _y;
    }

    public float getDirection(){
        return direction;
    }

    public void setDirection(float _direction){
        direction = _direction;
    }

    public void display(){

    }

    public void behave(){

    }

    public void interact(ArrayList<CreatureWorldThing> things){

    }

    public void handleKeyPressed(){
    }
}
