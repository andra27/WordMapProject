package com.example.worldmap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

//import static androidx.core.graphics.TypefaceCompatApi21Impl.init;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtPhone;
    EditText txtPassword;
    Button btnLog;
    Button  btnSign;
    ArrayList<User> list;
    ArrayList<VisitedCountries> visitedCountries;
    SharedPreferences sharedpreferences;
    private FirebaseAuth myFirebase;


    public static final String mypreference = "MyPrefs" ;
    public static final String Phone = "phoneKey";
    public static final String Passw="passKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirebase = FirebaseAuth.getInstance();
        txtPhone=(EditText)findViewById(R.id.txtPhoneNumber);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnLog=(Button)findViewById(R.id.btnLogIn);
        btnSign=(Button)findViewById(R.id.btnSignUp);


        btnSign.setOnClickListener(this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if(sharedpreferences.contains(Phone)){
            txtPhone.setText(sharedpreferences.getString(Phone,""));
        }
        if(sharedpreferences.contains(Passw)){
            txtPassword.setText(sharedpreferences.getString(Passw,""));
        }


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txtPhone.getText().toString())||TextUtils.isEmpty(txtPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please fill in all the fields!",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                    {

//                        Intent intent1 = new Intent(getApplicationContext(), WorldMapPage.class);
//                                            intent1.putExtra("PhoneNumber", txtPhone.getText().toString());
//                                           intent1.putExtra("Password", txtPassword.getText().toString());
//                                            startActivity(intent1);

                        myFirebase.signInWithEmailAndPassword(txtPhone.getText().toString(), txtPassword.getText().toString())
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent1 = new Intent(getApplicationContext(), WorldMapPage.class);
                                            intent1.putExtra("PhoneNumber", txtPhone.getText().toString());
                                            intent1.putExtra("Password", txtPassword.getText().toString());
                                            startActivity(intent1);
                                        } else {
                                            Log.e("LOGVVV:: ", "onComplete: Failed=" + task.getException().getMessage());
                                            Toast.makeText(getApplicationContext(), "Not succed to login!Try again ", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                   }





            }
        });



    }

    @Override
    public void onClick(View v) {
        //asat este handle click for sign in -care am trimite intr o noua pagina

        Intent intent=new Intent(this,SignInPage.class);
        startActivity(intent);


    }


    @Override
    protected void onResume() {
        super.onResume();
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if(sharedpreferences.contains(Phone)){
            txtPhone.setText(sharedpreferences.getString(Phone,""));
        }
        if(sharedpreferences.contains(Passw)){
            txtPassword.setText(sharedpreferences.getString(Passw,""));
        }

    }


}
