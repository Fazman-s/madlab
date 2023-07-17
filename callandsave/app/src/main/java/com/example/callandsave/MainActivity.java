package com.example.callandsave;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0, star, hash, del, save, call;
    EditText input;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);

        call=findViewById(R.id.call);
        save=findViewById(R.id.save);

        star=findViewById(R.id.bstar);
        hash=findViewById(R.id.bhash);
        del=findViewById(R.id.bdel);
        input=findViewById(R.id.input);

        b0.setOnClickListener(this::createnum);
        b1.setOnClickListener(this::createnum);
        b2.setOnClickListener(this::createnum);
        b3.setOnClickListener(this::createnum);
        b4.setOnClickListener(this::createnum);
        b5.setOnClickListener(this::createnum);
        b6.setOnClickListener(this::createnum);
        b7.setOnClickListener(this::createnum);
        b8.setOnClickListener(this::createnum);
        b9.setOnClickListener(this::createnum);
        star.setOnClickListener(this::createnum);
        hash.setOnClickListener(this::createnum);
        del.setOnClickListener(this::createnum);

        call.setOnClickListener(this::createnum);
        save.setOnClickListener(this::createnum);
    }

    private void createnum(View view){
        Editable str;
        str=input.getText();
        switch(view.getId()){
            case R.id.b0:
                str=str.append(b0.getText());
                input.setText(str);
                break;
            case R.id.b1:
                str=str.append(b1.getText());
                input.setText(str);
                break;
            case R.id.b2:
                str=str.append(b2.getText());
                input.setText(str);
                break;
            case R.id.b3:
                str=str.append(b3.getText());
                input.setText(str);
                break;
            case R.id.b4:
                str=str.append(b4.getText());
                input.setText(str);
                break;
            case R.id.b5:
                str=str.append(b5.getText());
                input.setText(str);
                break;
            case R.id.b6:
                str=str.append(b6.getText());
                input.setText(str);
                break;
            case R.id.b7:
                str=str.append(b7.getText());
                input.setText(str);
                break;
            case R.id.b8:
                str=str.append(b8.getText());
                input.setText(str);
                break;
            case R.id.b9:
                str=str.append(b9.getText());
                input.setText(str);
                break;
            case R.id.bstar:
                str=str.append(star.getText());
                input.setText(str);
                break;
            case R.id.bhash:
                str=str.append(hash.getText());
                input.setText(str);
                break;
            case R.id.bdel:
                str = (Editable) str.subSequence(0, str.length()-1);
                input.setText(str);
                break;


            case R.id.call:

                    String phoneno=input.getText().toString();
                    Intent intentcall=new Intent(Intent.ACTION_CALL);
                    intentcall.setData(Uri.parse("tel:"+phoneno));
                    startActivity(intentcall);
                    break;

            case R.id.save:
                String contact = input.getText().toString();
                Intent intentsave = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+contact));
                startActivity(intentsave);
                break;
        }
    }

}