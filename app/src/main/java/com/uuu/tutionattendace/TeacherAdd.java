package com.uuu.tutionattendace;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class TeacherAdd extends AppCompatActivity {

    Button Tregister, Tbatcheslist;
    TextInputLayout Tfullname, Temail, Tcontactno,Taddress, Tpassword, Tconfirmpassword;
    String Tname, Tmail, Tcontact, Tadd, Tbatches, Tpass,Tconfirmpass;
    String[] Blist;//Batches list
    boolean[] checkedBatches;
    ArrayList<Integer> b =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_add);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Tfullname=findViewById(R.id.Tfullname);
        Temail =findViewById(R.id.Temail);
        Tcontactno =findViewById(R.id.Tcontact);
        Taddress=findViewById(R.id.Taddress);
        Tbatcheslist =findViewById(R.id.Tbatches);
        Tpassword =findViewById(R.id.Tpassword);
        Tconfirmpassword =findViewById(R.id.Tconfirmword);
        Tregister =findViewById(R.id.Tregister);

        Blist = getResources().getStringArray(R.array.batchesList);
        checkedBatches = new boolean[Blist.length];

        Tbatcheslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Bbuilder= new AlertDialog.Builder(getApplicationContext());
                Bbuilder.setTitle("Batches");
                Bbuilder.setMultiChoiceItems(Blist, checkedBatches, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if(isChecked){
                           if(!b.contains(position)) {
                               b.add(position);
                           }}
//                           else{
//                               b.remove(position);
//                           }

                           else if(b.contains(position)){
                                b.remove(position);
                            }

                        }


                });

                Bbuilder.setCancelable(false);
                Bbuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String batch="";
                        for(int i=0;i<b.size();i++){
                            batch=batch+Blist[b.get(i)];
                        }
                    }
                });

                Bbuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                Bbuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i=0;i<checkedBatches.length;i++){
                            checkedBatches[i]=false;
                            b.clear();
                        }
                    }
                });

                AlertDialog bDialog= Bbuilder.create();
                bDialog.show();

            }
        });

        Tregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tname =Tfullname.getEditText().getText().toString();
                Tmail = Temail.getEditText().getText().toString();
                Tcontact = Tcontactno.getEditText().getText().toString();
                Tadd =Taddress.getEditText().getText().toString();
                Tpass = Tpassword.getEditText().getText().toString();
                Tconfirmpass= Tconfirmpassword.getEditText().getText().toString();

                checkDataEntered();

            }
        });


    }

    public void checkDataEntered(){

        if(Tfullname.getEditText().getText().toString().trim().length()>1){
            Tfullname.setError(null);
        }

        if(isEmail(Temail)){
            Temail.setError(null);
        }

        if(Taddress.getEditText().getText().toString().trim().length()>1){
            Taddress.setError(null);
        }

        if(isValidPhoneNumber(Tcontactno)){
            Tcontactno.setError(null);
        }

        if(Tpassword.getEditText().getText().toString().trim().length()>1){
            Tpassword.setError(null);
        }

        if(Tconfirmpassword.getEditText().getText().toString().trim().length()>1){
            Tconfirmpassword.setError(null);
        }



        if(Taddress.getEditText().getText().toString().trim().length()>1){
            Taddress.setError(null);
        }

        if(isEmpty(Tfullname)){
            Tfullname.setError("fullname is required");
        }

        if(isEmpty(Tpassword)){
            Tpassword.setError("Password is required");
        }

        if(!isEmail(Temail)){
            Temail.setError("Enter valid Email");
        }



        if(isEmpty(Tfullname)&&isEmpty(Temail)&&isEmpty(Tconfirmpassword)&&isEmpty(Tcontactno)&&isEmpty(Tpassword)&&isEmpty(Taddress)) {
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
