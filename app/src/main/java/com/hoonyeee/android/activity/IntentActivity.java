package com.hoonyeee.android.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {
    Button btnCall, btnSms, btnUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);
        btnUrl = findViewById(R.id.btnUrl);

        /*Andoid Intent*/
        //1.명시적 Explicit
        //new Intent(context, 호출할 대상 명시.class);


        //2.묵시적 Explicit
        //호출할 대상이 값으로(ACTION_XXXX) 정의되어 있음
        //가. 전화거는 화면 호출
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9746-9146"));
                startActivity(intent);
            }
        });

        //나. 문자보내는 화면 호출
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-9746-9146"));
                startActivity(intent);
            }
        });

        //다. 웹사이트 화면 호출
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com")); //network permission need
                startActivity(intent);
            }
        });

    }
}
