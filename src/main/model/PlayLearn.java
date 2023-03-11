package model;
//

public class PlayLearn {

    private int score = 0;
    Learn learn = new Learn();
    String pattern;
//Constructs a game with score and pattern.

    public PlayLearn(int score, String pattern) {
        this.score = score;
        this.pattern = pattern;

    }
    //EFFECTS: Sets pattern value according to the input string then returns the pattern.

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
    //EFFECTS: Returns "nice!" if input string p equals pattern substring at index i, also increases scores by 1, else
    // returns "wrong!"

    public String niceOrWrong(String p, int i) {
        String output;

        if (p.equals(pattern.substring(i,i + 1))) {
            output = "nice!";
            addScore();
        } else {
            output = "wrong!";
        }

        return output;
    }
    //EFFECTS: Returns particular string for certain range of score.

    public String scorer() {
        String output;
        if (score > 5) {
            output = "Nice score";
        } else {
            output = "\n YOU NEED MORE PRACTICE!! \n play again \n";
        }
        return output;
    }
    //EFFECTS: increases score by 1 unit.
    //MODIFIES: this

    public int addScore() {
        this.score++;
        return score;
    }
    //EFFECTS returns score you achieved.

    public int getScore() {
        return score;
    }
    //EFFECTS: Returns pattern that will be used.

    public String getPattern() {
        return pattern;
    }
    //EFFECTS: sets pattern to str and returns the pattern.
    //MODIFIES: this

    public String setPattern(String str) {
        this.pattern = str;
        return pattern;
    }

    public int setScore(int i) {
        this.score = i;
        return score;
    }
}
