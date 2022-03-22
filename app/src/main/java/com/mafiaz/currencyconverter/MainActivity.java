package com.mafiaz.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.mafiaz.currencyconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding _binding;

    private String[] currency_code;
    private ArrayAdapter currencyAdapter;
    private int fromId = 0;
    private int toId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());

        currency_code = getResources().getStringArray(R.array.currency_code);
        currencyAdapter = new ArrayAdapter(this, R.layout.dropdown_items, currency_code);
        _binding.edtFromCurrency.setAdapter(currencyAdapter);
        _binding.edtToCurrency.setAdapter(currencyAdapter);

        _binding.edtFromCurrency.setText(currencyAdapter.getItem(fromId).toString(),false);
        _binding.edtToCurrency.setText(currencyAdapter.getItem(toId).toString(),false);

        _binding.edtFromCurrency.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                fromId = position;
            }
        });
        _binding.edtToCurrency.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                toId = position;
            }
        });

        numPadPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        currency_code = getResources().getStringArray(R.array.currency_code);
        currencyAdapter = new ArrayAdapter(this, R.layout.dropdown_items, currency_code);
        _binding.edtFromCurrency.setAdapter(currencyAdapter);
        _binding.edtToCurrency.setAdapter(currencyAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _binding = null;
    }

    private void numPadPressed(){
        _binding.numPad.numDot.setOnClickListener(view -> {
            _binding.edtAmount.append(".");
        });
        _binding.numPad.num0.setOnClickListener(view -> {
            _binding.edtAmount.append("0");
        });
        _binding.numPad.num00.setOnClickListener(view -> {
            _binding.edtAmount.append("00");
        });
        _binding.numPad.num1.setOnClickListener(view -> {
            _binding.edtAmount.append("1");
        });
        _binding.numPad.num2.setOnClickListener(view -> {
            _binding.edtAmount.append("2");
        });
        _binding.numPad.num3.setOnClickListener(view -> {
            _binding.edtAmount.append("3");
        });
        _binding.numPad.num4.setOnClickListener(view -> {
            _binding.edtAmount.append("4");
        });
        _binding.numPad.num5.setOnClickListener(view -> {
            _binding.edtAmount.append("5");
        });
        _binding.numPad.num6.setOnClickListener(view -> {
            _binding.edtAmount.append("6");
        });
        _binding.numPad.num7.setOnClickListener(view -> {
            _binding.edtAmount.append("7");
        });
        _binding.numPad.num8.setOnClickListener(view -> {
            _binding.edtAmount.append("8");
        });
        _binding.numPad.num9.setOnClickListener(view -> {
            _binding.edtAmount.append("9");
        });
        _binding.numPad.funcBackspace.setOnClickListener(view -> {
            int length;
            length = _binding.edtAmount.length();
            if(length > 0){
                _binding.edtAmount.setText(_binding.edtAmount.getText().delete(length - 1, length));
            }
        });
        _binding.numPad.funcClear.setOnClickListener(view -> {
            _binding.edtAmount.setText("");
        });
        _binding.numPad.funcSwap.setOnClickListener(view -> {
            _binding.edtFromCurrency.setText(currencyAdapter.getItem(toId).toString(),false);
            _binding.edtToCurrency.setText(currencyAdapter.getItem(fromId).toString(),false);

            int tempId;
            tempId = fromId;
            fromId = toId;
            toId = tempId;

        });
        _binding.numPad.funcEqual.setOnClickListener(view -> {

        });
    }
}