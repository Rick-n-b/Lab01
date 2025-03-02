package ru.nstu.lab01.Entities;

import java.net.StandardSocketOptions;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import ru.nstu.lab01.App;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class Motorbike extends Entity implements SetLocation{

    private Random rand = new Random();
    private String[] motoPng = {"MotoToad1.png", "MotoToad2.png"};
    private int type = rand.nextInt(2);
    Image image = new Image("file:src/main/resources/ru/nstu/lab01/Motos/" + motoPng[type], 150, 150, true, true);

    ImageView motoImageView = new ImageView(image);
    private int sizeX = (int)image.getWidth();
    private int sizeY = (int)image.getHeight();
    private int x = 0, y = 0;

    public Motorbike(int x, int y, Group pack){
        this.x = x;
        this.y = y;
        ImageView motoImageView = new ImageView(image);
        motoImageView.setX(x);
        motoImageView.setY(y);
    }

    public Motorbike(AnchorPane aPane){
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
