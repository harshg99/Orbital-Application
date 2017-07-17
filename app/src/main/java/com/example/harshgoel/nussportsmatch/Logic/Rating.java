package com.example.harshgoel.nussportsmatch.Logic;

/**
 * Created by Harsh Goel on 7/5/2017.
 */
//abstract class that is base class for the rating
public class Rating {
    private double ratingFitness;
    private double ratingAwareness;
    private double ratingSkill;
    private double ratingNetSkill;
    public Rating(double awareness,double skill,double fitness){
        setRatingAwareness(awareness);
        setRatingFitness(fitness);
        setRatingSkill(skill);
        setRatingNetSkill();
    }
    public void setRatingFitness(double a){
        ratingFitness=a;
    }
    public void setRatingSkill(double c){
        ratingSkill=c;
    }
    public void setRatingAwareness(double b){
        ratingAwareness=b;
    }
    private void setRatingNetSkill(){
        ratingNetSkill=0.4*ratingFitness+0.25*ratingAwareness+0.35*ratingSkill;
    }
    public double getRatingNetSkill(){
        return ratingNetSkill;
    }

}
