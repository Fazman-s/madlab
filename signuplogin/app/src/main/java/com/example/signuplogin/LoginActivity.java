package com.example.signuplogin;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText etusername,etpassword;
    String username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.log);
        etusername=findViewById(R.id.lusn);
        etpassword=findViewById(R.id.lpass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              username=etusername.getText().toString();
              password=etpassword.getText().toString();

              Intent intent=getIntent();

              String iusername=intent.getStringExtra("username");
              String ipassword=intent.getStringExtra("password");

                if(username.equals(iusername)&&password.equals(ipassword)){
                    Intent intent2=new Intent(LoginActivity.this,Welcome.class);
                    startActivity(intent2);
                }else{
                    Toast.makeText(LoginActivity.this,"Password does not match ",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}