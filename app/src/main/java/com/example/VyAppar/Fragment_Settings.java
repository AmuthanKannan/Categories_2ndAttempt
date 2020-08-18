package com.example.VyAppar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Fragment_Settings extends Fragment {

    View view;
    ConstraintLayout cl1,cl2,cl3,cl4,cl5,dropdownprofile,dropdownsetting;
    TextView name,address,phoneno,payment,language,accessibility;
    Button btnswitch;
    SharedPreferences preferences;

    public Fragment_Settings() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_settings, container, false);
        cl1=view.findViewById(R.id.cl1);
        cl2=view.findViewById(R.id.cl2);
        cl3=view.findViewById(R.id.cl3);
        cl4=view.findViewById(R.id.cl4);
        cl5=view.findViewById(R.id.cl5);
        dropdownsetting=view.findViewById(R.id.dropdownsettings);
        dropdownprofile=view.findViewById(R.id.dropdownaccount);
        dropdownprofile.setVisibility(View.GONE);
        dropdownsetting.setVisibility(View.GONE);
        btnswitch=view.findViewById(R.id.btnswitchtovendor);
        name=view.findViewById(R.id.tvName);
        address=view.findViewById(R.id.TvAdress);
        accessibility=view.findViewById(R.id.TvAccessibility);
        payment=view.findViewById(R.id.tvPayment);
        language=view.findViewById(R.id.tvLanguage);
        phoneno=view.findViewById(R.id.tvPhonenumber);

        preferences= PreferenceManager.getDefaultSharedPreferences(getContext());


        cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dropdownprofile.getVisibility()==view.GONE)
                {
                    dropdownprofile.setVisibility(View.VISIBLE);
                }
                else {
                    dropdownprofile.setVisibility(View.GONE);
                }


            }
        });

        cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dropdownsetting.getVisibility()==view.GONE)
                {
                    dropdownsetting.setVisibility(View.VISIBLE);
                }
                else {
                    dropdownsetting.setVisibility(View.GONE);
                }




            }
        });

        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth=FirebaseAuth.getInstance();
                auth.signOut();
                Intent intent=new Intent(getContext(),Activity_LOGIN.class);
                startActivity(intent);

            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesetter("Name","Name");

            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesetter("address","Address");
            }
        });

        phoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesetter("phno","Phone Number");
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });

        accessibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });



        return view;

    }

    private void preferencesetter(final String key, String enter){
        final AlertDialog.Builder dialoguebuilder= new AlertDialog.Builder(getContext());
        dialoguebuilder.setTitle(enter);
        final EditText tempadr=new EditText(getContext());
        tempadr.setText(preferences.getString(key,""));

        FrameLayout container = new FrameLayout(getContext());
        FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 50;
        params.rightMargin=50;
        tempadr.setLayoutParams(params);
        container.addView(tempadr);

        dialoguebuilder.setView(container);
        dialoguebuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                preferences.edit().putString(key,tempadr.getText().toString().trim()).apply();


            }

        });
        dialoguebuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        dialoguebuilder.show();
    }
}