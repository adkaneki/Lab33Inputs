package my.edu.tarc.lab33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);

        //Create an adapter and link to the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group,
                                                                                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);

        spinnerAge.setOnItemSelectedListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "Position =" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int position;
        float premium = 0;
        position = spinnerAge.getSelectedItemPosition();
        switch (position) {
            case 0:
                //Calculate premium
                premium = 50;
                break;
            case 1:

                premium = 55;
                break;
            case 2:

                premium = 60;
                break;
            case 3:

                premium = 70;
                break;
            case 4:

                premium = 120;
                break;
            case 5:

                premium = 160;
                break;
            case 6:

                premium = 200;
                break;
            case 7:

                premium = 250;
                break;
        }

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            //TODO calculate premium of male
            if(position == 2 || position == 5){
                premium += 50;
            }else if(position == 3 || position == 4){
                premium += 100;
            }
        }

        if(checkBoxSmoker.isChecked()){
            //TODO calculate premium of smoker
            if(position == 3){
                premium += 100;
            }else if(position == 4 || position == 5){
                premium += 150;
            }else if(position == 6 || position == 7){
                premium += 250;
            }
        }

        textViewPremium.setText(getString(R.string.premium) + " " + premium);
    }

    public void resetPremium(View view){
        spinnerAge.setSelection(0);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("Premium");
    }
}
