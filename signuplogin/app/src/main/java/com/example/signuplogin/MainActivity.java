package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signup;
    EditText etusername;
    EditText etpassword;
    String username , password;
    String regex ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername=findViewById(R.id.usn);
        etpassword=findViewById(R.id.pass);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username =etusername.getText().toString();
                password=etpassword.getText().toString();
                if(password.matches(regex)){
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);

                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"your password does not match the validation criteria",Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
