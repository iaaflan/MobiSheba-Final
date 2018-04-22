package com.mobisheba.aflan.mobisheba;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class LoginActivity extends AbsRuntimeAcitivty {
    //fixedmobile="01954790638" 01754337576
    final String fixedpassword="123456",fixedmobile="01954790638";
    EditText mobileNumber,password;
    TextView signupTextView;
    Button login,facebook,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        requestAppPermissions(new String[]{
                        Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, R.string.msg
                , 1);
        final View view = findViewById(R.id.login_Layout);
        mobileNumber = findViewById(R.id.mobile_no);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        // SIGN UP ACTIVITY
        signupTextView = findViewById(R.id.registernow);
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(LoginActivity.this, SignupPersonalActivity.class);
                LoginActivity.this.startActivity(myIntent);
            }

        });


        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String mobilenumber= mobileNumber.getText().toString();
                final String pass = password.getText().toString();
                boolean status = checkDetails(mobilenumber,pass);

                if (status)
                {
                    int randomnumber = sendVerification(mobilenumber);
                    String rnumber = String.valueOf(randomnumber);
                    Intent myIntent = new Intent(LoginActivity.this, VerificationActivity.class);
                    myIntent.putExtra("verificationCode", rnumber); //Optional parameters
                    LoginActivity.this.startActivity(myIntent);

                }
                else
                {
                    Snackbar snackbar = Snackbar
                            .make(view, "Wrong Information! " + mobilenumber +" " + pass, Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        //Do anything when permisson granted
        Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
    }

    public boolean checkDetails(String mobile, String password)
    {
        boolean mstatus,pstatus;
        return (mobile.equals(fixedmobile)) && (password.equals(fixedpassword));
    }

    public int sendVerification(String mobile)
    {
        Random rNumber = new Random();
        int randomNumber = rNumber.nextInt(80 - 65) + 65;
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mobile, null, "Hello, Your verification code is: "+ randomNumber, null, null);
        return randomNumber;
    }


}
