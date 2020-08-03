package com.devnat.coinconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //maping the elements
        this.mViewHolder.edit_value = findViewById(R.id.edit_value);
        this.mViewHolder.text_dolar = findViewById(R.id.text_dolar);
        this.mViewHolder.text_euro = findViewById(R.id.text_euro);
        this.mViewHolder.button_calculate = findViewById(R.id.button_calculate);

        //"this" is the MainActivity
        this.mViewHolder.button_calculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.edit_value.getText().toString();
            if ("".equals(value)) {
                Toast.makeText(this, R.string.type_value, Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                //converting the value to Euro and Dolar
                this.mViewHolder.text_dolar.setText(String.format("%.2f", real / 5.30));
                this.mViewHolder.text_euro.setText(String.format("%.2f", real / 6.20));
            }
        }
    }


    public void clearValues() {
        this.mViewHolder.text_dolar.setText("");
        this.mViewHolder.text_euro.setText("");
    }

    // ViewHolder to break the find for the id when it was find
    private static class ViewHolder {
        EditText edit_value;
        TextView text_dolar;
        TextView text_euro;
        Button button_calculate;
    }
}
