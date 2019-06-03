package main;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Canoa {
    private int posX;
    private int posY;
    private Image canoaIMG;
    public Canoa(int posX,int posY){
        ImageIcon ref = new ImageIcon("src//img//canoa.png");
        canoaIMG = ref.getImage();
        this.posX=posX;
        this.posY=posY;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public void setPosX(int x){
        this.posX=x;
    }
    public void setPosY(int y){
        this.posY=y;
    }
    public Image getImage() {
    	return canoaIMG;
    }
}
