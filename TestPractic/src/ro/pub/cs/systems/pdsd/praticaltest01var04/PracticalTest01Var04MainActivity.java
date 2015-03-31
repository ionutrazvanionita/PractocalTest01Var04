package ro.pub.cs.systems.pdsd.praticaltest01var04;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PracticalTest01Var04MainActivity extends Activity {

	int total_tries=0;
	int correct_tries=0;
	int missed_tries=0;
	
	int currSequence=0;
	
private KeypadButtonClickListener buttonClickListener = new KeypadButtonClickListener();
	
	private class KeypadButtonClickListener implements View.OnClickListener {

		@Override
		@SuppressWarnings("all")
		public void onClick(View view) {
			EditText notesEditText = (EditText)findViewById(R.id.edit_text_notes);
			String notes = notesEditText.getText().toString();
			
			if (view instanceof Button) {
				//phoneNumberEditText.setText(phoneNumber+((Button)view).getText().toString());
				Button button = ((Button)view);
				String text = button.getText().toString();
				if (text.length() < 5) {
					if (notes.length() < 2)
						notesEditText.setText(notes+button.getText());
					else
						notesEditText.setText(notes+"," + button.getText());
				}
				
				Log.d("Test",text.substring(0,2));
				
				if (text.substring(0, 2).compareTo("Do")==0 &&
						(currSequence == 0 || currSequence == 3)) {
					currSequence++;
					
					if (currSequence == 4) {
						correct_tries++;
						total_tries++;
						Log.d("Test","Total: " + total_tries +
									 ";Success: " + correct_tries +
									 ";Fail: " + missed_tries);
						currSequence=0;
					}
						
					return;
				}
				
				if (text.substring(0, 2).compareTo("Mi")==0 &&
						currSequence == 1) {
					currSequence++;
					return;
				}
				
				if (text.substring(0, 2).compareTo("Sol")==0 &&
						currSequence == 2) {
					currSequence++;
					return;
				}
				missed_tries++;
				currSequence=0;
				Log.d("Test","Total: " + total_tries +
						 ";Success: " + correct_tries +
						 ";Fail: " + missed_tries);
					
			}
		}

	}
	
	  @Override
	    protected void onStart() {
	      super.onStart();
	      Log.d("Test", "onStart");
	    }
	   
	    @Override
	    protected void onResume() {
	      super.onResume();
	      Log.d("Test", "onResume");
	    }
	   
	    @Override
	    protected void onPause() {
	      super.onPause();
	      Log.d("Test", "onPause");
	    }
	   
	    @Override
	    protected void onStop() {
	      super.onStop();
	      Log.d("Test", "onStop");
	    }
	   
	    @Override
	    protected void onDestroy() {
	      super.onDestroy();
	      Log.d("Test", "onDestroy");
	     
	    }
	   
	    @Override
	    protected void onRestart() {
	      super.onRestart();
	      Log.d("Test", "onRestart");
	    }

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var04_main);
		ArrayList<? super View> buttons = new ArrayList<View>();

		
		Button textButton = (Button)findViewById(R.id.Button1);
		textButton.setOnClickListener(buttonClickListener);
		buttons.add(textButton);
		
		textButton = (Button)findViewById(R.id.Button2);
		textButton.setOnClickListener(buttonClickListener);
		buttons.add(textButton);
		
		textButton = (Button)findViewById(R.id.Button3);
		textButton.setOnClickListener(buttonClickListener);
		buttons.add(textButton);
		
		textButton = (Button)findViewById(R.id.Button4);
		textButton.setOnClickListener(buttonClickListener);
		buttons.add(textButton);
		
		if (savedInstanceState != null){
		Log.d("Test", "XXX");
		this.total_tries = savedInstanceState.getInt("total");
    	this.missed_tries = savedInstanceState.getInt("missed");
    	this.correct_tries = savedInstanceState.getInt("correct");
    			
    	Log.d("Test","onCreate:Total: " + total_tries +
				 ";Success: " + correct_tries +
				 ";Fail: " + missed_tries);
		}
	}


	@Override
    protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("total", this.total_tries);
    	outState.putInt("missed", this.missed_tries);
    	outState.putInt("correct", this.correct_tries);
    	
    	Log.d("Test","onSave:Total: " + total_tries +
				 ";Success: " + correct_tries +
				 ";Fail: " + missed_tries);
	}
	
    @Override
    protected void onRestoreInstanceState(Bundle inState) {
    	super.onRestoreInstanceState(inState);
    	this.total_tries = inState.getInt("total");
    	this.missed_tries = inState.getInt("missed");
    	this.correct_tries = inState.getInt("correct");
    			
    	Log.d("Test","onRestore:Total: " + total_tries +
				 ";Success: " + correct_tries +
				 ";Fail: " + missed_tries);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
