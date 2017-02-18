package pk.creditfix.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;
import java.util.List;

import pk.creditfix.app.R;
import pk.creditfix.app.adapter.CustomerAcquisitionCatagoryAdapter;
import pk.creditfix.app.adapter.TypeAcquisitionCatagoryAdapter;
import pk.creditfix.app.model.CustomerAcquisitionModel;
import pk.creditfix.app.model.TypeAcquisitionModel;

public class CustomerAcquisitionActivity extends AppCompatActivity {

    private RecyclerView catagoryRecyclerView, typeRecyclerView;
    private CustomerAcquisitionCatagoryAdapter customerCatagoryAdapter;
    private TypeAcquisitionCatagoryAdapter typeCatagoryAdapter;
    private RecyclerView.LayoutManager customerLayoutManager;
    private RecyclerView.LayoutManager typeLayoutManager;
    private List<CustomerAcquisitionModel> acquisitionModelList;
    private List<TypeAcquisitionModel> typeModelList;
    private CustomerAcquisitionModel acquisitionModel;
    private TypeAcquisitionModel typeModel;
    private ImageView arrowLeft, arrowRight;

    private DiscreteSeekBar tenurePaymentSeekBar, downPaymentSeekBar;
    private TextView tenureSeekLeftTxt, tenureSeekRightTxt, downPaymentLeftTxt, downPaymentRightTxt;
    private EditText advancePaymentEt, monthlyPaymentEt;
    private Button customerAcquisitionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_acquisition);

        initView();
        recyclerView();
        initListener();

    }

    private void initView(){

        acquisitionModelList = new ArrayList<>();
        typeModelList = new ArrayList<>();

        catagoryRecyclerView = (RecyclerView) findViewById(R.id.catagory_recycler_view);
        typeRecyclerView = (RecyclerView) findViewById(R.id.type_recycler_view);

        tenurePaymentSeekBar = (DiscreteSeekBar) findViewById(R.id.tenure_payment_seek_bar);
        downPaymentSeekBar = (DiscreteSeekBar) findViewById(R.id.down_payment_seek_bar);

        tenureSeekLeftTxt = (TextView) findViewById(R.id.tenure_seek_left_txt);
        tenureSeekRightTxt = (TextView) findViewById(R.id.tenure_seek_right_txt);
        downPaymentLeftTxt = (TextView) findViewById(R.id.down_seek_left_txt);
        downPaymentRightTxt = (TextView) findViewById(R.id.down_seek_right_txt);

        advancePaymentEt = (EditText) findViewById(R.id.advance_payment_et);
        monthlyPaymentEt = (EditText) findViewById(R.id.monthly_payment_et);

        customerAcquisitionBtn = (Button) findViewById(R.id.customer_acquisition_btn);
    }

    private void initListener(){

        customerCatagoryAdapter.setOnItemClickListener(new CustomerAcquisitionCatagoryAdapter.CustomerAcquisitionClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(CustomerAcquisitionActivity.this, "Interface work "+ position, Toast.LENGTH_LONG).show();
            }
        });

        typeCatagoryAdapter.setTypeAcquisitionCatagoryListener(new TypeAcquisitionCatagoryAdapter.TypeAcquisitionCatagoryListener() {
            @Override
            public void onClickListener(View view, int position) {
                Toast.makeText(CustomerAcquisitionActivity.this, "Interface work "+ position, Toast.LENGTH_LONG).show();
            }
        });

        customerAcquisitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tenurePayment = tenurePaymentSeekBar.getProgress();
                int downPayment = downPaymentSeekBar.getProgress();
                String advance = advancePaymentEt.getText().toString();
                String monthly = monthlyPaymentEt.getText().toString();
                if(!advance.isEmpty() && advance != null){
                    int advancePayment = Integer.parseInt(advance);
                }
                if(!monthly.isEmpty() && monthly != null){
                    int monthlyPayment = Integer.parseInt(monthly);
                }

                Intent intent = new Intent(CustomerAcquisitionActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void recyclerView(){

        for(int i=0; i<10; i++) {
            acquisitionModel = new CustomerAcquisitionModel();
            typeModel = new TypeAcquisitionModel();

            acquisitionModel.setProductName("Car " + i);
            acquisitionModel.setProductImage(R.drawable.icon);

            typeModel.setProductTypeName("type " + i);
            typeModel.setProductTypeImage(R.drawable.icon);

            acquisitionModelList.add(acquisitionModel);
            typeModelList.add(typeModel);
        }

        catagoryRecyclerView.setHasFixedSize(true);
        customerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        catagoryRecyclerView.setLayoutManager(customerLayoutManager);
        customerCatagoryAdapter = new CustomerAcquisitionCatagoryAdapter(this, acquisitionModelList);
        catagoryRecyclerView.setAdapter(customerCatagoryAdapter);

        typeRecyclerView.setHasFixedSize(true);
        typeLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        typeRecyclerView.setLayoutManager(typeLayoutManager);
        typeCatagoryAdapter = new TypeAcquisitionCatagoryAdapter(this, typeModelList);
        typeRecyclerView.setAdapter(typeCatagoryAdapter);
    }
}
