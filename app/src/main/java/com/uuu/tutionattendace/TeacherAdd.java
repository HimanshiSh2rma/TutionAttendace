package com.uuu.tutionattendace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class TeacherAdd extends AppCompatActivity {

    Button register;
    TextInputLayout fullname,email,contactno,address,batcheslist,password,confirmpassword;
    String name,mail,contact,add,batches,pass,confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_add);

        fullname=findViewById(R.id.fullname);
        email=findViewById(R.id.email);
        contactno=findViewById(R.id.contact);
        address=findViewById(R.id.address);
        batcheslist=findViewById(R.id.batches);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmword);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=fullname.getEditText().getText().toString();
                mail=email.getEditText().getText().toString();
                contact=contactno.getEditText().getText().toString();
                add=address.getEditText().getText().toString();
                batches=batcheslist.getEditText().getText().toString();
                pass=password.getEditText().getText().toString();
                confirmpass=confirmpassword.getEditText().getText().toString();

                checkDataEntered();

            }
        });


    }

    public void checkDataEntered(){

        if(fullname.getEditText().getText().toString().trim().length()>1){
            fullname.setError(null);
        }

        if(isEmail(email)){
            email.setError(null);
        }

        if(address.getEditText().getText().toString().trim().length()>1){
            address.setError(null);
        }

        if(isValidPhoneNumber(contactno)){
            contactno.setError(null);
        }

        if(password.getEditText().getText().toString().trim().length()>1){
            password.setError(null);
        }

        if(confirmpassword.getEditText().getText().toString().trim().length()>1){
            confirmpassword.setError(null);
        }

        if(batcheslist.getEditText().getText().toString().trim().length()>1){
            batcheslist.setError(null);
        }

        if(address.getEditText().getText().toString().trim().length()>1){
            address.setError(null);
        }

        if(isEmpty(fullname)){
            fullname.setError("fullname is required");
        }

        if(isEmpty(password)){
            password.setError("Password is required");
        }

        if(!isEmail(email)){
            email.setError("Enter valid Email");
        }



        if(isEmpty(fullname)&&isEmpty(email)&&isEmpty(confirmpassword)&&isEmpty(contactno)&&isEmpty(password)&&isEmpty(batcheslist)&&isEmpty(address)) {
            Toast.makeText(getApplicationContext(), "Please fill all Information", Toast.LENGTH_SHORT).show();
        }
        else{

//            new webRegister().execute();
        }

    }

    boolean isEmail(TextInputLayout text){
        CharSequence email= text.getEditText().getText().toString();
        //dont use third party validations
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());//patterns can use for contact ip and other inputs

    }

    boolean isValidPhoneNumber(TextInputLayout text){
        CharSequence phn = text.getEditText().getText().toString();
        if(!TextUtils.isEmpty(phn)){
            if(text.getEditText().getText().toString().trim().length()<10){
                return false;
            }
            return Patterns.PHONE.matcher(phn).matches();
        }
        return false;
    }

    boolean isEmpty(TextInputLayout text){
        //charSequence ia a readable sequence of characters

        CharSequence str=text.getEditText().getText().toString();//it canv read empty string//important

        //TextUtils --> provide set of utility function to do operations on string alwz return true or false
        //isEmpty(inbuilt function)

        return TextUtils.isEmpty(str);

    }

}
