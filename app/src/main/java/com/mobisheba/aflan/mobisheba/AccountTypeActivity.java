package com.mobisheba.aflan.mobisheba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Aflan on 4/21/2018.
 */

public class AccountTypeActivity extends AppCompatActivity {
    Button digitalButton, personalButton;
    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean flag = isFirstTime();
        if (flag == false) {
            startActivity(new Intent(AccountTypeActivity.this, LoginActivity.class));
        } else {

            // Checking for first time launch - before calling setContentView()
            setContentView(R.layout.account_type);
            digitalButton = findViewById(R.id.digital_enterpriseBttn);
            personalButton = findViewById(R.id.persona_Bttn);
            personalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AccountTypeActivity.this, SignupPersonalActivity.class));
                    finish();
                }
            });
            digitalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AccountTypeActivity.this, SignupEnterpriseActivity.class));
                    finish();
                }
            });
        }
    }

    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;

    }

}