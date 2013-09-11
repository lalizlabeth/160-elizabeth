package cs160.elizabethlin.unitconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;

public class UnitConverter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);        
        changeSpinners(R.array.lengths_array);
        
        EditText textInput1 = (EditText) findViewById(R.id.textInput1);
        
        textInput1.addTextChangedListener(new TextWatcher() {
        	
			@Override
			public void afterTextChanged(Editable arg0) {
		        EditText textConverted = (EditText) findViewById(R.id.textInput2);
		    	Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		        
		        String original_unit = spinner1.getSelectedItem().toString();
		        String new_unit = spinner2.getSelectedItem().toString();
		        
		        System.out.println("here");
		        
		        textConverted.setText("1.2");
		        
		        if (original_unit == "kilometers") {
		        	textConverted.setText("1.2");
		        }
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
        
        });
       
    	Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
    }
    
    public void changeToLength(View view) {
    	changeSpinners(R.array.lengths_array);
    }
    
    public void changeToTemperature(View view) {
    	changeSpinners(R.array.temperatures_array);
    }
    
    public void changeToWeight(View view) {
    	changeSpinners(R.array.weights_array);
    }
    
    public void changeSpinners(int choices) {
    	Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, choices, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner1.setAdapter(adapter);
		spinner2.setAdapter(adapter);	
		spinner2.setSelection(1);
    }

}
