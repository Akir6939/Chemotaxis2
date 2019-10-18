import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis2 extends PApplet {

ArrayList<Bacteria> colony = new ArrayList<Bacteria>();
boolean up, down, left, right;

public void setup() {
  background(122);
  
  //right=true;
}
Bacteria b = new Bacteria(mouseX, mouseY);
public void draw() {
  background(122);
  for(int i = 0;i<colony.size();i++){
    colony.get(i).show();
    colony.get(i).colorChange();
    colony.get(i).move();
    colony.get(i).reset();
  }
}
public void mousePressed(){
  Bacteria b = new Bacteria(mouseX,mouseY);
  colony.add(b);
}
public void keyPressed() {
  if (keyCode==RIGHT||key=='d'||key=='D'){
    right=true;
    left=false;
    up=false;
    down=false;
  }
  if (keyCode==LEFT||key=='a'||key=='A'){
    left=true;
    right=false;
    up=false;
    down=false;
  }
  if (keyCode==DOWN||key=='s'||key=='S'){
    down=true;
    up=false;
    left=false;
    right=false;
  }
  if (keyCode==UP||key=='w'||key=='W'){
    up=true;
    left=false;
    right=false;
    down=false;
  }
  if(key=='r'||key=='R')
    colony.clear();
}

public class Bacteria {
  int x, y, r, g, b;
  public Bacteria(int x, int y) {
    this.x=x;
    this.y=y;
    r = (int)(Math.random()*255);
    g = (int)(Math.random()*255);
    b = (int)(Math.random()*255);
  }
  public void show() {
    fill(r, g, b);
    stroke(r, g, b);
    ellipse(x, y, 10, 10);
  }
  public void colorChange() {
    r = (int)(Math.random()*255);
    g = (int)(Math.random()*255);
    b = (int)(Math.random()*255);
  }
  public void move() {
    if (up)
      y-=(int)(Math.random()*3)+1;
    if (down)
      y+=(int)(Math.random()*3)+1;
    if (left)
      x-=(int)(Math.random()*3)+1;
    if (right)
      x+=(int)(Math.random()*3)+1;
  }
  public void reset(){
    if(x>500)
      x=0;
    if(y>500)
      y=0;
    if(y<0)
      y=500;
    if(x<0)
      x=500;
  }
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}