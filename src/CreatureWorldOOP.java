import processing.core.PApplet;
import java.util.Random;
import ddf.minim.*;

public class CreatureWorldOOP extends PApplet {
    private static CreatureWorldOOP app; //used to be static PApplet

    private boolean gameOver = false;
    private CreatureWorldThing[] things;

    private Minim minim;
    private AudioPlayer beep;
    private AudioPlayer ding;

    public static void main(String[] args) {

        PApplet.main("CreatureWorldOOP");
    }

    public CreatureWorldOOP() {
        app = this;
    }

    public void settings(){
        size(500, 500);
        minim = new Minim(this);
        beep = minim.loadFile("data/beep.mp3");
        ding = minim.loadFile("data/ding.mp3");
    }

    public void setup(){
        things = new CreatureWorldThing[4];
        things[0] = new Cat(0);
        things[1] = new Dog(1);
        things[2] = new Mouse(2);
        things[3] = new Cheese(3);
    }


    public void draw(){
        background(173, 219, 255);
        if (!gameOver){
            for (int i = 0; i < things.length; i++){
                things[i].display();
                things[i].behave();
                things[i].interact(things);
            }
        }else{
            beep.play(0);
            textSize(48);
            textAlign(CENTER);
            text("Game Over!", width/2, height/2);
        }
    }

    public void keyPressed(){
        for (int i = 0; i < things.length; i++){
            things[i].handleKeyPressed();

        }

    }
    public static CreatureWorldOOP getApp() {
        return app;
    }

    public void gameOver(){
        gameOver = true;
    }

    public CreatureWorldThing getThing(int index){
        return things[index];
    }

    public void playDing(){
        ding.play(0);
    }

}