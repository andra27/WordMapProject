package com.example.worldmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class File2 extends AppCompatActivity {

    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file2);
        tv= (TextView)findViewById(R.id.textViewFile2);
        btn=(Button)findViewById(R.id.buttonCancelFile2);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String s=(String)bundle.getSerializable("files");
        tv.setText(s);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
