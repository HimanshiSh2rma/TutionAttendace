package com.uuu.tutionattendace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button go,forgotpass;
    TextInputLayout username,password;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username =findViewById(R.id.username);
        password=findViewById(R.id.password);
        go=findViewById(R.id.go);
        forgotpass=findViewById(R.id.forgotPass);

        go.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.go:
                user= username.getEditText().getText().toString();
                pass=password.getEditText().getText().toString();
                checkDataOfLogin();
                break;

            case R.id.forgotPass:
                Toast.makeText(getApplicationContext(), "Link is send to Your Registered email", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public void checkDataOfLogin(){
        if(isEmpty(username)||isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Enter Corret Information", Toast.LENGTH_SHORT).show();
            username.setError("Enter Correct Username");
            password.setError("Enter correct Password");
        }

        else{
            username.setError(null);
            password.setError(null);
        }

    }


    boolean isEmpty(TextInputLayout text){
        //charSequence ia a readable sequence of characters
        CharSequence str=text.getEditText().getText().toString();//it canv read empty string//important
        return TextUtils.isEmpty(str);
    }
}
