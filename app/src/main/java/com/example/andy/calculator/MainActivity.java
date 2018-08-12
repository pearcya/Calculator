package com.example.andy.calculator;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.faendir.rhino_android.RhinoAndroidHelper;

import org.w3c.dom.Text;

import java.math.*;
import java.util.*;



public class MainActivity extends Activity {
    public RhinoAndroidHelper getRhinoAndroidHelper() {
        return rhinoAndroidHelper;
    }


    public void setRhinoAndroidHelper(RhinoAndroidHelper rhinoAndroidHelper) {
        this.rhinoAndroidHelper = rhinoAndroidHelper;
    }

    private RhinoAndroidHelper rhinoAndroidHelper;

    Button clear_button;
    TextView screen_process, screen_result;

    Button zero_btn, one_btn, two_btn, three_btn, four_btn, five_btn, six_btn, seven_btn, eight_btn, nine_btn;
    String processor;
    Boolean isbracketsOpen;
    Button multiply_btn, add_btn, subtract_btn, divide_btn, dot_btn, back_btn, bracket_btn, equal_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rhinoAndroidHelper = new RhinoAndroidHelper(this);



        isbracketsOpen = false;

        /*****assigning variables***/
        clear_button = (Button) findViewById(R.id.clear_btn);
        screen_process = (TextView) findViewById(R.id.process);
        screen_result = (TextView) findViewById(R.id.process_results);

        screen_process.setText("");
        screen_result.setText("");


        zero_btn = (Button) findViewById(R.id.zero_btn);
        one_btn = (Button) findViewById(R.id.one_btn);
        two_btn = (Button) findViewById(R.id.two_btn);
        three_btn = (Button) findViewById(R.id.three_btn);
        four_btn = (Button) findViewById(R.id.four_btn);
        five_btn = (Button) findViewById(R.id.five_btn);
        six_btn = (Button) findViewById(R.id.six_btn);
        seven_btn = (Button) findViewById(R.id.seven_btn);
        eight_btn = (Button) findViewById(R.id.eight_btn);
        nine_btn = (Button) findViewById(R.id.nine_btn);



        multiply_btn = (Button)findViewById(R.id.multiply_btn);
        add_btn = (Button)findViewById(R.id.add_btn);
        divide_btn = (Button)findViewById(R.id.subtract_btn);
        subtract_btn = (Button)findViewById(R.id.subtract_btn);

        dot_btn = (Button) findViewById(R.id.dot_btn);
        back_btn = (Button) findViewById(R.id.back_btn);
        bracket_btn = (Button) findViewById(R.id.bracket_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);


        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen_process.setText("");
                screen_result.setText("");
            }
        });




        /********Numbers Button on click**********/

        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "1");
            }
        });

        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "2");
            }
        });

        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "3");
            }
        });

        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "4");
            }
        });
        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "5");
            }
        });

        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "6");
            }
        });
        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "7");
            }
        });

        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "8");
            }
        });

        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "9");
            }
        });

        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "0");
            }
        });


        /*******functions button*****/
        multiply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "X");
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "+");
            }
        });

        subtract_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "-");
            }
        });

        divide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + "/");
            }
        });

        dot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                screen_process.setText(processor + ".");
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = screen_process.getText().toString();
                if (processor.length() > 0) {
                    processor = processor.substring(0, (processor.length() - 1));
                    screen_process.setText(processor);


                }
            }
        });

        bracket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isbracketsOpen){
                    processor = screen_process.getText().toString();
                    screen_process.setText(processor + ")");
                    isbracketsOpen = false;

            }else{
                    processor = screen_process.getText().toString();
                    screen_process.setText(processor + "(");
                    isbracketsOpen = true;
                }
                }
        });

        final MathEval ans = new MathEval();

        /*******Equal Button***********/

        equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result = ans.evaluate(screen_process.getText().toString());
                screen_result.setText(result.toString());
            }


            });
        };

    }

