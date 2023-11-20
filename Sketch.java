import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  // declare variables
	PImage StarrySky; 
  PImage Ufo;
  PImage Yvetal;

  float YvetalX = 20;
  float YvetalY = 20;
  float Radius = 160;
  float Movement;

  float ufoX = 0;
  float ufoY = 50;
  float ufoXSpeed = 1;
  float ufoYSpeed = 1;

  float meteorX = 30;
  float meteorY = 0;
  float meteorSpeed = 1;

  float meteorX2 = 200;
  float meteorY2 = 0;
  float meteorSpeed2 = 1;

  public void settings() {
    // screen size
    size(400, 400);
  }

  public void setup() {
    // load in images
    StarrySky = loadImage("8-bitskywithstars.png"); 
    StarrySky.resize(400, 400);

    Ufo = loadImage("blufo-removebg-preview.png");
    Ufo.resize(150, 150);

    Yvetal = loadImage("yvetal.png");
    Yvetal.resize(70, 70);

  }

  public void draw() {
    // draws background
    image(StarrySky, 0, 0);

    // animating yvetal moving
    image(Yvetal, YvetalX + 80, YvetalY + 310);

    // animating ufo moving
    image(Ufo, ufoX, ufoY);
    ufoX += ufoXSpeed;
    ufoY += ufoYSpeed;

    // boucing and resetting collision detection ufo
    if(ufoX > 400) {
      ufoX = -120;
    }
    if(ufoY < -30 || ufoY > 50) {
      ufoYSpeed *= -1 ;
    }

    // meteor 1 falling down
    noStroke();
    fill(54, 3, 9);
    ellipse(meteorX, meteorY, 30, 30);
    meteorX += meteorSpeed;
    meteorY += meteorSpeed;

    //reset meteor 1
    if(meteorX < 0 || meteorX > width) {
      meteorX = 30;
      meteorY = -10;
    }

    // meteor 2 falling down
    noStroke();
    fill(54, 3, 9);
    ellipse(meteorX2, meteorY2, 30, 30);
    meteorX2 += meteorSpeed2;
    meteorY2 += meteorSpeed2;

    //reset meteor 2
    if(meteorY2 > 300 && meteorX2 > 400) {
      meteorX2 = 200;
      meteorY2 = -10;
    }

    // Yvetal moving in circle
    Movement += 0.5;
    
    YvetalX = (int) (Radius * Math.cos(Movement * Math.PI / 150));
    YvetalY = (int) (Radius * Math.sin(Movement * Math.PI / 150));
  }
}