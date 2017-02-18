package pk.creditfix.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pk.creditfix.app.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mobileNoEt;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initView();
        initListener();

    }

    private void initView(){
        mobileNoEt = (EditText) findViewById(R.id.mobile_no_et);
        signupBtn = (Button) findViewById(R.id.signup_btn);

    }

    private void initListener(){
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, AuthenticationActivity.class);
                startActivity(intent);
            }
        });
    }
}
