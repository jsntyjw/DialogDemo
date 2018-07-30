package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button  btnDemo1;
    Button  btnDemo2;
    TextView tvDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button btnDemo4;
    TextView tvDemo4;
    Button btnDemo5;
    TextView tvDemo5;
    Button btnDemo6;
    TextView tvDemo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        btnDemo6 = findViewById(R.id.buttonDemo6);
        tvDemo6 = findViewById(R.id.textViewDemo6);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below");
                myBuilder.setCancelable(false);

                /*
                myBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Postive");
                    }
                });

                myBuilder.setNegativeButton("Nagative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });
                */
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Yes");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected No");
                    }
                });


                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                final EditText etInout = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = etInout.getText().toString();

                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2,null);

                final EditText num1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText num2 = viewDialog.findViewById(R.id.editTextNum2);


                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        double  getNumber1 = Double.parseDouble(num1.getText().toString());
                        double  getNumber2 = Double.parseDouble(num2.getText().toString());
                        double sum = getNumber1 + getNumber2;
                        tvDemo4.setText("The sum is: "+sum);

                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo5.setText("Date: "+ dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                };

                Calendar calendar = Calendar.getInstance();

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
                        ,(calendar.get(Calendar.DAY_OF_MONTH)));
                myDateDialog.show();

            }
        });

        btnDemo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo6.setText("Time: "+ hourOfDay+":"+minute);
                    }
                };


                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,hour,minute,true);
                myTimeDialog.show();
            }
        });



    }
}
