package com.example.harshgoel.nussportsmatch.Logic;

/**
 * Created by Harsh Goel on 7/13/2017.
 */

public class sportsPlayer {
    private Rating SportsRate;
    private boolean isAdded;
    private boolean questionaireCompleted;
    public sportsPlayer(Rating a){
        SportsRate=a;
    }
    public void setAdded(boolean a){
        isAdded=a;
    }
    public void setQuestionaireCompleted(boolean a){
        questionaireCompleted=a;
    }
}
