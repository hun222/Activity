package com.hoonyeee.android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView valueText;
    Button finish;
    EditText toMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        valueText = findViewById(R.id.valueText);
        finish = findViewById(R.id.finish);
        toMain = findViewById(R.id.toMain);

        //1.Main Activity에서 전달된 intent꺼내기
        Intent intent = getIntent();
        //2.intent에 담긴 값 중에 key01을 가진 값 꺼내기
        String value  = intent.getStringExtra("key01");
        //3.intent에 꺼낸 값 화면에 표시
        valueText.setText(value);

        //4.second activity 종료
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //second activitydml editText에 있는 값을 나를 호출한 곳으로 돌려주기
                    //4.1 값 가져오기
                    String temp = toMain.getText().toString();
                    //4.2 intent 생성
                    Intent intent = new Intent();
                    //4.3 intent 값 넣고
                    intent.putExtra("key02", temp);
                    //4.4 결과 메시지 전달
                    setResult(RESULT_OK, intent);
                }catch(Exception e){
                    setResult(RESULT_CANCELED);
                }

                finish();
            }
        });
    }
}
