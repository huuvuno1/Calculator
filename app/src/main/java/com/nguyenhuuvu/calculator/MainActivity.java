package com.nguyenhuuvu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    TextView txtExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtExpression = findViewById(R.id.expression);
    }

    public void btnClick(View view) {
        TextView button = (TextView) view;
        String oldExpress = txtExpression.getText().toString();
        switch (button.getText().toString()) {
            case "=":
                try {
                    double result = new ExpressionBuilder(oldExpress).build().evaluate();
                    txtExpression.setText("" + result);
                }
                catch (Exception e) {}
                break;
            case "C":
                txtExpression.setText("");
                break;
            default:
                txtExpression.setText(oldExpress +  button.getText().toString());
        }
    }
}