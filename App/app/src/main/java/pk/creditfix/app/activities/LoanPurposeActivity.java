package pk.creditfix.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pk.creditfix.app.R;

public class LoanPurposeActivity extends AppCompatActivity {

    private Button personalLoanBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_purpose);

        initView();
        initListener();

    }

    private void initView(){
        personalLoanBtn = (Button) findViewById(R.id.loan_purpose_btn);
    }

    private void initListener(){

        personalLoanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoanPurposeActivity.this, PersonalDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
