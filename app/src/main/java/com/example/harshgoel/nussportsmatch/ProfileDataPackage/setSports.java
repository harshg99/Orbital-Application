package com.example.harshgoel.nussportsmatch.ProfileDataPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.harshgoel.nussportsmatch.AppLoginPage;
import com.example.harshgoel.nussportsmatch.Logic.Player;
import com.example.harshgoel.nussportsmatch.Logic.sportsPlayer;
import com.example.harshgoel.nussportsmatch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Harsh Goel on 7/18/2017.
 */

public class setSports extends AppCompatActivity {

    public CheckBox tennisbox;
    public CheckBox Badmintonbox;
    public CheckBox squashbox;
    public CheckBox ttbox;
    public Button confirmBUT;
    FirebaseAuth auth;
    DatabaseReference userref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_sports);
        confirmBUT=(Button)findViewById(R.id.Confirm);
        tennisbox=(CheckBox)findViewById(R.id.Tennis);
        Badmintonbox=(CheckBox)findViewById(R.id.badminton);
        ttbox=(CheckBox)findViewById(R.id.TableTennis);
        squashbox=(CheckBox)findViewById(R.id.Squash);
        auth=FirebaseAuth.getInstance();
        userref= FirebaseDatabase.getInstance().getReference();

    }
    public void ConfirmSports(View v){
        sportsPlayer Tennis=new sportsPlayer();
        sportsPlayer squash =new sportsPlayer();
        sportsPlayer TT=new sportsPlayer();
        sportsPlayer badminton=new sportsPlayer();
        if(tennisbox.isChecked()==true)
            Tennis.setAdded(true);
        if(squashbox.isChecked()==true)
            squash.setAdded(true);
        if(ttbox.isChecked()==true)
            TT.setAdded(true);
        if(Badmintonbox.isChecked()==true)
            badminton.setAdded(true);
        Map<String,Object>values=new HashMap<String,Object>();
        values.put("tennis",Tennis);
        values.put("squash",squash);
        values.put("badminton",badminton);
        values.put("tt",TT);
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tennis").child("SportsRate").setValue(Tennis.getRating());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tennis").child("isAdded").setValue(Tennis.getisAdded());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tennis")
                .child("questionaireCompleted").setValue(Tennis.isQuestionaireCompleted());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("squash").child("SportsRate").setValue(squash.getRating());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("squash").child("isAdded").setValue(squash.getisAdded());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("squash")
                .child("questionaireCompleted").setValue(squash.isQuestionaireCompleted());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tt").child("SportsRate").setValue(TT.getRating());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tt").child("isAdded").setValue(TT.getisAdded());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("tt")
                .child("questionaireCompleted").setValue(TT.isQuestionaireCompleted());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("badminton").child("SportsRate").setValue(badminton.getRating());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("badminton").child("isAdded").setValue(badminton.getisAdded());
        userref.child("users").child(auth.getCurrentUser().getUid()).child("badminton")
                .child("questionaireCompleted").setValue(badminton.isQuestionaireCompleted());

        this.finish();
        Intent intent=new Intent().setClass(this, AppLoginPage.class);
        startActivity(intent);
    }

}
