package com.hoonyeee.android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText toSecond, fromSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSecond = findViewById(R.id.toSecond);
        fromSecond = findViewById(R.id.fromSecond);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다른 액티비티 호출하기 - 시스템에 다른 액티비티를 호출하라고 메시지 전달
                //1. intent 생성
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);

                //1.1 intent에 값 담아서 전달하기
                String value = toSecond.getText().toString();
                intent.putExtra("key01",value);

                //2. 안드로이드에게 액티비니 실행해달라고 intent 전달
                startActivityForResult(intent, 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //1. requestCode check : 실제 내가 호출한 결과처리인지 확인
        if(requestCode==999){
            //2. 정상적으로 넘어왔는지 확인
            if(resultCode==RESULT_OK){
                //3. 넘어온 값 꺼내서 확인
                String tmp = data.getStringExtra("key02");
                fromSecond.setText(tmp);
            }
        }
    }
}
