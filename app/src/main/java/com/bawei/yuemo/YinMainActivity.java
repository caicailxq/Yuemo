package com.bawei.yuemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YinMainActivity extends AppCompatActivity {
private Button qi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_main);
        qi= (Button) findViewById(R.id.qi);
        qi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YinMainActivity.this,MainActivity.class));
            }
        });

    }
}
