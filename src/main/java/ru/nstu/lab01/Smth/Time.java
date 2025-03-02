package ru.nstu.lab01.Smth;

public class Time {
    private int hour;
    private int minute;
    private int second;
    private int mills;

    public Time(int hour, int minute, int second, int mills) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.mills = mills;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.mills = 0;
    }

    public Time(String currentTime) {
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);
        mills = Integer.parseInt(time[3]);
    }

    public String getCurrentTime() {
        return hour + ":" + minute + ":" + second + ":" + mills;
    }

    public void oneMillisecondPassed() {
        mills++;
        if (mills > 1000) {
            oneSecondPassed();
            mills = 0;
        }

    }

    public void oneSecondPassed() {
        second++;
        if (second == 60) {
            minute++;
            second = 0;
            if (minute == 60) {
                hour++;
                minute = 0;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }

    public void setTimeZero() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.mills = 0;
    }
}
