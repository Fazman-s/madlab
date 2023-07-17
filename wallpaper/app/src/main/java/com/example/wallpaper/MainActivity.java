package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    View screenView;
    int [] back_images;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back_images=new int[]{R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4};
        button=findViewById(R.id.b1);
        screenView=findViewById(R.id.c1);
        handler=new Handler();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable,0);
                button.setVisibility(View.GONE);
            }
        });
    }

    public Runnable runnable=new Runnable() {
        @Override
        public void run() {
            int a_len= back_images.length;
            Random random=new Random();
            int r_no=random.nextInt(a_len);
            screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),back_images[r_no]));
            handler.postDelayed(this,3000);
        }
    };
}