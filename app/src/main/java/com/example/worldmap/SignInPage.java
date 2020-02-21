package com.example.worldmap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

public class SignInPage extends AppCompatActivity {

    EditText edTxtName;
    EditText edTxtPhone;
    EditText edTxtPassword;
    Button btnSignUp;
    SharedPreferences sharedpreferences;
    private FirebaseAuth myFirebase;


    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Phone = "phoneKey";
    public static final String Passw="passKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        edTxtName=(EditText)findViewById(R.id.textViewNume);
        edTxtPhone=(EditText)findViewById(R.id.textViewTelefon);
        edTxtPassword=(EditText)findViewById(R.id.textViewParola);
        btnSignUp=(Button)findViewById(R.id.buttonSignUp);
        myFirebase = FirebaseAuth.getInstance();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               if(TextUtils.isEmpty(edTxtPhone.getText().toString())||TextUtils.isEmpty(edTxtPassword.getText().toString())){
                   Toast.makeText(getApplicationContext(),"Please fill in all the fields!",Toast.LENGTH_LONG).show();
                   return;
               }
               else
                   {
//                       Intent intent=new Intent(getApplicationContext(),WorldMapPage.class);
//                                       intent.putExtra("Phone Number SignInPage",edTxtPhone.getText().toString());
//                                       intent.putExtra("Password SingInPage",edTxtPassword.getText().toString());
//                                       SharedPreferences.Editor editor = sharedpreferences.edit();
//                                       editor.putString(Phone,edTxtPhone.getText().toString());
//                                       editor.putString(Passw,edTxtPassword.getText().toString());
//                                       editor.commit();
//                                       startActivity(intent);

                   myFirebase.createUserWithEmailAndPassword(edTxtPhone.getText().toString(), edTxtPassword.getText().toString())
                           .addOnCompleteListener(SignInPage.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                       Intent intent=new Intent(getApplicationContext(),WorldMapPage.class);
                                       intent.putExtra("Phone Number SignInPage",edTxtPhone.getText().toString());
                                       intent.putExtra("Password SingInPage",edTxtPassword.getText().toString());
                                       SharedPreferences.Editor editor = sharedpreferences.edit();
                                       editor.putString(Phone,edTxtPhone.getText().toString());
                                       editor.putString(Passw,edTxtPassword.getText().toString());
                                       editor.commit();
                                       startActivity(intent);
                                   } else {
                                       Toast.makeText(getApplicationContext(),"Not succed to register!Try again ",Toast.LENGTH_LONG).show();

                                   }
                               }
                           });
               }

            }
        });

    }
}
