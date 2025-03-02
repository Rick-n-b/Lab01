package ru.nstu.lab01.Entities;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Car implements SetLocation{

    private Random rand = new Random();
    private String[] motoPng = {"CarToad1.png", "CarToad2.png"};
    private int type = rand.nextInt(2);
    Image image = new Image("file:src/main/resources/ru/nstu/lab01/Cars/" + motoPng[type], 180, 180, true, true);

    ImageView motoImageView = new ImageView(image);
    private int sizeX = (int)image.getWidth();
    private int sizeY = (int)image.getHeight();
    private int x = 0, y = 0;

    public Car(int x, int y, AnchorPane aPane){
        this.x = x;
        this.y = y;
        ImageView motoImageView = new ImageView(image);
        motoImageView.setX(x);
        motoImageView.setY(y);
    }

    public Car(AnchorPane aPane){
        setRandLocation();
        setRandLocationWithBounds((int)(aPane.getWidth() - image.getWidth()), (int)(aPane.getHeight() - image.getHeight()));
        motoImageView.setX(x);
        motoImageView.setY(y);

        aPane.getChildren().add(motoImageView);
    }

    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getType(){
        return type;
    }

    public void clear(AnchorPane aPane){
        aPane.getChildren().remove(motoImageView);
    }

    public void setRandLocation(){
        setX(rand.nextInt(880));
        setY(rand.nextInt(640));
    }
    public void setRandLocationWithBounds(int x, int y){
        setX(rand.nextInt(x));
        setY(rand.nextInt(y));
    }
    public void setLocation(int x, int y){
        setY(y);
        setX(x);
    }

}
