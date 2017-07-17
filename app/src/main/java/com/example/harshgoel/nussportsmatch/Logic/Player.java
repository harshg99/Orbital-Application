package com.example.harshgoel.nussportsmatch.Logic;


import android.net.Uri;

/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declration of the player class
public class Player implements PlayerInterface{
    //class contains name,password ans string
    private Uri profilephoto;
    private String email;
    private String name;
    public static boolean addedplayer=false;
    public static int playerselect;
    private String password;
    private sportsPlayer tennis;
    private sportsPlayer squash;
    private sportsPlayer tt;
    private sportsPlayer badminton;
    // functions overriden from the interface
    public void setEmail(String s){
        email=s;
    }
    public String getEmail(){
        return email;
    }
    public void setpassword(String s){
        password=s;
    }
    public String getpassword(){
        return password;
    }
    //static function tht initialises the random player data useing list interface and arraylist framework


    public String getName(){
        return name;
    }
    public void setName(String k){
        name=k;
    }
    public Uri getProfilephoto(){
        return profilephoto;
    }
    public void setProfilephoto(Uri photo){
        profilephoto=photo;
    }
    public sportsPlayer getTennis(){return tennis;}
    public sportsPlayer getTt(){return tt;}
    public sportsPlayer getSquash(){return squash;}
    public sportsPlayer getBadminton(){return badminton;}
    /*
    public Rating getRating(){
        return rating;
    }
    public void setRating(Rating k){
        rating = k;
    }
*/
}
