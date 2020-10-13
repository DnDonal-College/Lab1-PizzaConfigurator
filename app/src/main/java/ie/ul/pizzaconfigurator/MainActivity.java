package ie.ul.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "ie.ul.myfirstapp.EXTRA_MESSAGE";
    RadioGroup radioGroup;
    RadioButton radioButton;
    Switch aSwitch;
    String sSwitch = "No Stuffed Crust";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        aSwitch = findViewById(R.id.switch_one);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    sSwitch = "Stuffed Crust";
                    }
                else {
                    sSwitch = "No Stuffed Crust";
                    }
                }
        });
    }

    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString() + ", " + radioButton.getText() + ", " + sSwitch;

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);
        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}