package ru.nstu.lab01.Entities;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import ru.nstu.lab01.Smth.Time;

import java.util.ArrayList;
import java.util.Random;

public class MegaMatka {
    private final ArrayList<Motorbike> motors = new ArrayList<>();
    private final ArrayList<Car> cars = new ArrayList<>();

    AnchorPane pane;

    private double motoSpawnChance = 15;
    private double carSpawnChance = 8;

    private int motoSpawnPeriod = 8;
    private int carSpawnPeriod = 12;

    private long framesPassed = 0;
    Random rand = new Random();

    private int motoType1 = 0;
    private int motoType2 = 0;
    private int carType1 = 0;
    private int carType2 = 0;

    public boolean isPaused = true;

    public MegaMatka(AnchorPane aPane){
        pane = aPane;
        motoSpawnChance = 15;
        carSpawnChance = 8;
        motoSpawnPeriod = 8;
        carSpawnPeriod = 12;
    }

    private final Timeline timerRodov = new Timeline(
            new KeyFrame(Duration.millis(16.667),
                    e ->{
                        if(framesPassed % motoSpawnPeriod == 0){
                            if(rand.nextInt(100) <= motoSpawnChance){
                                motoRojat();
                            }
                        }
                        if(framesPassed % carSpawnPeriod == 0){
                            if(rand.nextInt(100) < carSpawnChance){
                                carRojat();
                            }
                        }
                        framesPassed++;
                    }
            )
    );

    Time time = new Time("0:0:0:0");

    private final Timeline basicTimer = new Timeline(
            new KeyFrame(Duration.millis(1),
                    e ->{
                        time.oneMillisecondPassed();
                    }
            )
    );

    public void motoRojat(){
        motors.add(new Motorbike(pane));
        if(motors.getLast().getType() == 0) motoType1++;
        else motoType2++;
    }

    public void motoKill(){
        for(int i = 0; i < motors.toArray().length; i++){
            motors.get(i).clear(pane);
        }
        motoType1 = 0;
        motoType2 = 0;
        motors.clear();
    }

    public void carRojat(){
        cars.add(new Car(pane));
        if(cars.getLast().getType() == 0) carType1++;
        else carType2++;
    }

    public void carKill(){
        for(int i = 0; i < cars.toArray().length; i++){
            cars.get(i).clear(pane);
        }
        carType1 = 0;
        carType2 = 0;
        cars.clear();
    }

    public void playTimerFromStart(){
        timerRodov.setCycleCount(Animation.INDEFINITE);
        timerRodov.playFromStart();

        basicTimer.setCycleCount(Animation.INDEFINITE);
        basicTimer.playFromStart();
        time.setTimeZero();
        isPaused = false;
    }

    public void playTimer(){
        timerRodov.setCycleCount(Animation.INDEFINITE);
        timerRodov.play();

        basicTimer.setCycleCount(Animation.INDEFINITE);
        basicTimer.play();
        isPaused = false;
    }

    public void pauseTimer(){
        timerRodov.pause();
        basicTimer.pause();
        isPaused = true;
    }

    public void endTimer(){
        timerRodov.stop();
        basicTimer.stop();
        isPaused = true;
    }

    public long getFramesPassed(){
        return framesPassed;
    }

    public Time getTime(){
        return time;
    }

    public int getCarType1() {
        return carType1;
    }
    public int getCarType2(){
        return carType2;
    }
    public int getMotoType1() {
        return motoType1;
    }
    public int getMotoType2(){
        return motoType2;
    }

    public ArrayList<Motorbike> getMotors() {
        return motors;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setPane(AnchorPane pane) {
        this.pane = pane;
    }
    public AnchorPane getPane(){
        return pane;
    }


}
