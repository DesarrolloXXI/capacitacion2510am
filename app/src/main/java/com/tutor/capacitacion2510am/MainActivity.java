package com.tutor.capacitacion2510am;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText etemail, etpassword;
Button boton_login,buton_registro;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail= findViewById(R.id.editTextTextEmailAddress);
        etpassword = findViewById(R.id.editTextTextPassword);
        boton_login= findViewById(R.id.button);
        buton_registro = findViewById(R.id.btnregistro);
        mAuth = FirebaseAuth.getInstance();
        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();

                singIn(email, password);

            }
        });



        buton_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();

                registrarse(email, password);

            }
        });

    }



    public void singIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                          Intent i = new Intent(MainActivity.this, DatabaseActivity.class);
                          startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


    public void registrarse(String email, String password){


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, DatabaseActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }


}