package com.hnudeal.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hnudeal.main.MainActivity;
import com.hnudeal.main.R;

public class LoginActivity extends AppCompatActivity {
   //커밋 테스트 by bjy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    //메인으로 가기
    public void moveMainActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }


}
