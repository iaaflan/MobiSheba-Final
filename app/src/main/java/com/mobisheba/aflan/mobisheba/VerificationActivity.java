package com.mobisheba.aflan.mobisheba;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerificationActivity extends AppCompatActivity {

     TextView verificationTextView;
     Button verificationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);
        final View view = findViewById(R.id.verification_Layout);
        Intent intent = getIntent();
        final String receivedCode = intent.getStringExtra("verificationCode"); //if it's a string you stored.
        verificationTextView = (TextView)findViewById(R.id.verificationcode);
        verificationButton = (Button)findViewById(R.id.verify);
        Snackbar snackbar = Snackbar
                .make(view, receivedCode, Snackbar.LENGTH_LONG);

        snackbar.show();

        verificationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String verificationCode = verificationTextView.getText().toString();
                int status = Verification(verificationCode,receivedCode);
                if(status == 1)
                {
                    Intent myIntent = new Intent(VerificationActivity.this, MainActivity.class);
                    VerificationActivity.this.startActivity(myIntent);
                }
                else
                {
                    Snackbar snackbar1 = Snackbar
                            .make(view, "WRONG", Snackbar.LENGTH_LONG);

                    snackbar1.show();
                }
            }
        });




    }
    public int Verification(String sentCode, String recivedCode)
    {
        if(sentCode.equals(recivedCode))
        {
            return 1;
        }
        else return 0;
    }

}
