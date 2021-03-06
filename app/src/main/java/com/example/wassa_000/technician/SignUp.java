package com.example.wassa_000.technician;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wassa_000.technician.beans.Customer;
import com.example.wassa_000.technician.contentprovider.SharedPreferencesDataLoader;
import com.example.wassa_000.technician.factory.BeanFactory;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private Spinner spGender;
    private EditText etName;
    private EditText etEmail;
    private EditText etMobile;
    private EditText etPassword;
    private Button btnSubmit;
    private EditText etConformPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spGender = (Spinner) findViewById(R.id.sp_gender);

        // Gender Drop down elements
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");


        ArrayAdapter<String> genderAdapter  = new ArrayAdapter<String>(this,R.layout.spinner_item,gender);
        spGender.setAdapter(genderAdapter);

        initFields();

    }

    public void initFields(){
        etConformPassword = (EditText)findViewById(R.id.et_confirm_password);
        etEmail = (EditText)findViewById(R.id.et_email);
        etMobile = (EditText)findViewById(R.id.et_contact_number);
        etName = (EditText)findViewById(R.id.et_name_sign_up);
        etPassword = (EditText)findViewById(R.id.et_password);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){

        Customer c = BeanFactory.getCustomer();

        c.setName(etName.getText().toString());
        c.setMobile(etMobile.getText().toString());
        c.setEmail(etEmail.getText().toString());
        c.setPassword(etPassword.getText().toString());
        BeanFactory.setCustomer(c);
        SharedPreferencesDataLoader.storeCustomerDataToSharedPreferences(this);

       // try{
        //    Thread.sleep(3000);
            startActivity(new Intent(SignUp.this,MainActivity.class));
            finish();
        //}catch (InterruptedException e){}
    }
}
