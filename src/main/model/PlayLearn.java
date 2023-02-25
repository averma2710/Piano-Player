package model;

import java.util.Scanner;

public class PlayLearn {

    private int score = 0;
    Learn learn = new Learn();
    String pattern;

    public PlayLearn(int score, String pattern) {
        this.score = score;
        this.pattern = pattern;

    }

    public String checks(String str) {
        if (str.equals("MOOSE")) {
            pattern = learn.moos();
        } else if (str.equals("FUR")) {
            pattern = learn.fur();
        } else if (str.equals("AVR")) {
            pattern = learn.avr();
        } else  {
            pattern = learn.def();
        }

        return pattern;
    }

    public String niceOrWrong(String p, int i) {
        String output;

        if (p.equals(pattern.substring(i,i + 1))) {
            output = "nice!";
            setScore();
        } else {
            output = "wrong!";
        }

        return output;
    }

    public String scorer() {
        String output = "";
        if (score > 5) {
            output = "Nice score";
        } else {
            output = "\n YOU NEED MORE PRACTICE!! \n play again \n";
        }
        return output;
    }

    public int setScore() {
        this.score++;
        return score;
    }

    public int getScore() {
        return score;
    }

    public String getPattern() {
        return pattern;
    }

    public String setPattern(String str) {
        this.pattern = str;
        return pattern;
    }
}
