package pk.creditfix.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pk.creditfix.app.R;

public class AuthenticationActivity extends AppCompatActivity {

    private EditText mobileNoEt, pinEt;
    private Button verifyBtn;
    private TextView resendCodeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        initView();
        initListener();

    }

    private void initView(){
        mobileNoEt = (EditText) findViewById(R.id.mobile_no_et);
        pinEt = (EditText) findViewById(R.id.pin_et);
        verifyBtn = (Button) findViewById(R.id.verify_btn);
        resendCodeTxt = (TextView) findViewById(R.id.resend_code_tv);
        String note = "Note: Press " + "<font color='#EE0000'>here</font>" + ", to send the pin again.";
        resendCodeTxt.setText(Html.fromHtml(note));
    }

    private void initListener(){

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthenticationActivity.this, LoanPurposeActivity.class);
                startActivity(intent);
            }
        });
    }
}
