package com.mobisheba.aflan.mobisheba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Aflan on 4/16/2018.
 */

public class SignupEnterpriseActivity extends AppCompatActivity {
    TextView loginTextView;
    EditText nameEditText, mobileEditText, nidEditText, emailEditText, passwordEditText;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen_enterprise);
        final View view = findViewById(R.id.login_Layout);
        signupButton = findViewById(R.id.sign_up);

        nameEditText = findViewById(R.id.your_name);
        mobileEditText = findViewById(R.id.your_mobile);
        nidEditText = findViewById(R.id.your_nid);
        emailEditText = findViewById(R.id.your_email);
        passwordEditText = findViewById(R.id.your_password);

        loginTextView = findViewById(R.id.login_activity);

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignupEnterpriseActivity.this, LoginActivity.class);
                SignupEnterpriseActivity.this.startActivity(myIntent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VARIABLE TO SEE SNACKBAR
                final String name, mobile, nid, email, password;
                name = nameEditText.getText().toString();
                mobile = mobileEditText.getText().toString();
                nid = nidEditText.getText().toString();
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();

                Snackbar snackbar = Snackbar
                        .make(view, "You Typed: " + name + " " + mobile + " " + nid + " " + email + " " + password, Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

    }
}
