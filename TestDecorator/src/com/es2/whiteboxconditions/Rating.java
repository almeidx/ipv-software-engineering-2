package com.es2.whiteboxconditions;

public class Rating {
    public String evaluateScoreTemperature(int score, int temperature) {
        if (score >= 10 && temperature >= 35) {
            return "It's hot out, and so am I";
        } else if (score < 5 || temperature <= 20) {
            return "I'm in a bad mood";
        } else {
            return "I'm balanced";
        }
    }

    public String evaluateIfCouldBeAcceptedAtDisco(int dressStyle, int talkSkill) {
        if (dressStyle >= 8 && talkSkill >= 5) {
            return "Accepted";
        } else {
            return "Not Accepted";
        }
    }
}
