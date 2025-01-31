package fr.android.eurodollar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button button;
    RadioButton euroButton;
    RadioButton dollarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        euroButton = (RadioButton) findViewById(R.id.radio0);
        dollarButton = (RadioButton) findViewById(R.id.radio1);
    }

    public void myClickHandler(View view) {
        if (view.getId() == R.id.button1) {
            if (text.getText().length() == 0) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                return;
            }

            float inputValue = Float.parseFloat(text.getText().toString());
            if (euroButton.isChecked()) {
                text.setText(String.valueOf(convertDollarToEuro(inputValue)));
                euroButton.setChecked(false);
                dollarButton.setChecked(true);
            } else {
                text.setText(String.valueOf(convertEuroToDollar(inputValue)));
                dollarButton.setChecked(false);
                euroButton.setChecked(true);
            }
        }
    }

    // Convert Dollar to Euro
    private float convertDollarToEuro(float dollar) {
        return (float) (dollar * 0.93); // Example conversion rate
    }

    // Convert Euro to Dollar
    private float convertEuroToDollar(float euro) {
        return (float) (euro * 1.07); // Example conversion rate
    }
}