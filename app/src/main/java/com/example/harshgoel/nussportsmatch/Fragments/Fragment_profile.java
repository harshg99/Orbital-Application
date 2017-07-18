package com.example.harshgoel.nussportsmatch.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harshgoel.nussportsmatch.Logic.Player;
import com.example.harshgoel.nussportsmatch.ProfileDataPackage.EditProfile;
import com.example.harshgoel.nussportsmatch.ProfileDataPackage.handlephoto;
import com.example.harshgoel.nussportsmatch.R;
import com.example.harshgoel.nussportsmatch.SignIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Harsh Goel on 7/17/2017.
 */

public class Fragment_profile extends Fragment {
    public ImageView profilephoto;
    public Button addphoto;
    public TextView profilename;
    public Button editprofile;
    public Button setsports;
    public Button Logout;
    public Button questionnaire;
    public static final int photo=10;
    private FirebaseAuth auth;
    private DatabaseReference userref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View fragment_profile =inflater.inflate(R.layout.activity_profile,container,false);
        profilephoto=(ImageView)fragment_profile.findViewById(R.id.ProfilePhoto);
        auth=FirebaseAuth.getInstance();
        profilename=(TextView)fragment_profile.findViewById(R.id.Name);
        userref= FirebaseDatabase.getInstance().getReference();
        userref=userref.child("users").child(auth.getCurrentUser().getUid());
        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Player user=dataSnapshot.getValue(Player.class);
                profilename.setText(user.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Database Reference:","Read ERROR");
            }
        });

        addphoto=(Button)fragment_profile.findViewById(R.id.addphoto);
        editprofile=(Button)fragment_profile.findViewById(R.id.edit_profile);
        setsports=(Button)fragment_profile.findViewById(R.id.selectsports);
        Logout=(Button)fragment_profile.findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                getActivity().finish();
                Intent intent=new Intent()
                        .setClass(getActivity(),SignIn.class);
                startActivity(intent);
            }
        });
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getActivity().finish();
                    Intent intent=new Intent()
                            .setClass(getActivity(),handlephoto.class);
                    startActivity(intent);

            }
        });
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                Intent intent=new Intent()
                        .setClass(getActivity(), EditProfile.class);
                startActivity(intent);

            }
        });
        setsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return fragment_profile;
    }

    /*
    public List<Integer> sportsCreate(){
        final List<Integer> itemssel=new ArrayList<>();
        AlertDialog.Builder dialogbox = new AlertDialog.Builder(ProfileData.this);
        CharSequence[] sports={"Tennis","Badminton","Table Tennis","Squash"};
        dialogbox.setTitle(" Select Sports ")
                .setMultiChoiceItems(sports, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            itemssel.add(which);
                        }
                        else if(itemssel.contains(which)){
                            itemssel.remove(which);
                        }
                    }
                });
        AlertDialog alert = dialogbox.create();
        alert.show();
        return itemssel;
    }

}
*/

}