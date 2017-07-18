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
    public void setTennis(sportsPlayer K){tennis=K;}
    public void setTt(sportsPlayer K){tt=K;}
    public void setSquash(sportsPlayer K){squash=K;}
    public void setBadminton(sportsPlayer K){badminton=K;}

    @Override
    public String toString() {
        return(" Name: "+getName()+" email: "+getEmail()+" password: "+getpassword()+" tennis: "+tennis.toString()+
                " squash: "+squash.toString()+" badminton: "+badminton.toString()+" Tt: "+tt.toString());
    }
}
