package com.example.android.quizlearning;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper viewFlipper;
    Button next;
    Button prev;
    TextView displayText, displayText1;

    int scoredPointsView =0;
    int scoredPointsView1 =0;
    int scoredPointsView2 =0;
    int scoredPointsView3 =0;
    int scoredPointsView4 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        next = (Button) findViewById(R.id.next_button);

        prev = (Button) findViewById(R.id.prev_button);

        next.setOnClickListener(this);
        prev.setOnClickListener(this);

        displayText = (TextView) findViewById(R.id.display_text_view);
        displayText.setEnabled(false);

        displayText1 = (TextView) findViewById(R.id.display_text_view1);
        displayText1.setEnabled(false);

        Button showScore = (Button) findViewById(R.id.view_score_view2);
        showScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editAnswer = (EditText) findViewById(R.id.edit_answer_view2); {
                    if (editAnswer.getText().toString().isEmpty()) {
                        scoredPointsView2 = 0;
                        Toast.makeText(MainActivity.this, R.string.selection_option_message, Toast.LENGTH_LONG).show();
                    }
                    else if (!editAnswer.getText().toString().isEmpty() && editAnswer.getText().toString()
                            .trim().equalsIgnoreCase("Gold")) {
                        scoredPointsView2 = +5;
                        Toast.makeText(MainActivity.this, R.string.correct_option_message, Toast.LENGTH_LONG).show();
                    } else {
                        scoredPointsView2 = 0;
                        Toast.makeText(MainActivity.this, R.string.wrong_option_message, Toast.LENGTH_LONG).show();
                    }
                }

                EditText playerNameInput = (EditText) findViewById(R.id.edit_text_view2);
                String name = playerNameInput.getText().toString();
                int score = scoredPointsView2;
                String scoreMessage = QuizResult2 (score, name);
                Toast.makeText(MainActivity.this,scoreMessage, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String QuizResult2 (int score, String name) {
        String allMessages = getString(R.string.quiz_player_name, name);
        allMessages += "\n" + getString(R.string.quiz_result_score_info, score);
        allMessages += "\n"+ getString(R.string.quiz_result_greeting_message);

        return allMessages;
    }

    //    This shows the options selected when clicked on.
    public void radioClick (View view)
    {
        boolean checked =((RadioButton) view) .isChecked();
        switch (view.getId())
        {
            case R.id.option_a_radio_button:
            if (checked)
            {
                scoredPointsView =+5;
                displayText.setText(R.string.correct_option_message);
            }
             break;

            case R.id.option_b_radio_button:
                if (checked)
                {
                    scoredPointsView=0;
                    displayText.setText(R.string.wrong_option_message);
                }
                break;

            case R.id.option_c_radio_button:
                if (checked)
                {
                    scoredPointsView=0;
                    displayText.setText(R.string.wrong_option_message);

                }
                break;

            case R.id.option_a_radio_button1:
                if (checked)
                {
                    displayText1.setText(R.string.wrong_option_message);
                    scoredPointsView1 =0;
                    displayText1.setEnabled(true);
                }
                break;

            case R.id.option_b_radio_button1:
                if (checked)
                {
                    displayText1.setText(R.string.wrong_option_message);
                    scoredPointsView1=0;
                    displayText1.setEnabled(true);
                }
                break;

            case R.id.option_c_radio_button1:
                if (checked)
                {
                    displayText1.setText(R.string.correct_option_message);
                    scoredPointsView1= +5;
                }
                break;
        }

    }
    //    This shows the options selected when clicked on.
    public void showScore (View view)
    {
        // This is for the name input.
        EditText playerNameInput = (EditText) findViewById(R.id.edit_text_view4);
        String name = playerNameInput.getText().toString();

        CheckBox optionACheckBox =(CheckBox)findViewById(R.id.option_a_checkbox_view4);
        boolean isForOptionA = optionACheckBox.isChecked();

        CheckBox optionBCheckBox =(CheckBox)findViewById(R.id.option_b_checkbox_view4);
        boolean isForOptionB = optionBCheckBox.isChecked();

        CheckBox optionCCheckBox =(CheckBox)findViewById(R.id.option_c_checkbox_view4);
        boolean isForOptionC = optionCCheckBox.isChecked();

        CheckBox optionDCheckBox =(CheckBox)findViewById(R.id.option_d_checkbox_view4);
        boolean isForOptionD = optionDCheckBox.isChecked();

        if (!isForOptionA && !isForOptionB && !isForOptionC && !isForOptionD)
        {
            scoredPointsView4 =0;
        }

        else if (!isForOptionB && !isForOptionD)
        {
            scoredPointsView4 =0;
        }

        else if (!isForOptionA && !isForOptionC)
        {
            scoredPointsView4 =+5;
            Toast.makeText(MainActivity.this,R.string.correct_option_message,Toast.LENGTH_SHORT).show();
        }

        else
        {
            scoredPointsView4=0;
            Toast.makeText(MainActivity.this,R.string.wrong_option_message,Toast.LENGTH_SHORT).show();
        }

        int score = scoredPointsView4;
        String scoreMessage = QuizResult4 (score, name);
        Toast.makeText(this,scoreMessage, Toast.LENGTH_LONG).show();
    }

    //    This shows the CheckBox options selected when clicked on.
    public void clickMe (View view)
    {
        boolean checked =((CheckBox) view) .isChecked();
        switch (view.getId()) {
            case R.id.option_a_checkbox_view3:
                if (checked) {
                    scoredPointsView3 =+5;
                    Toast.makeText(MainActivity.this,R.string.correct_option_message, Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.option_b_checkbox_view3:
                if (checked) {
                    scoredPointsView3 =0;
                    Toast.makeText(MainActivity.this,R.string.wrong_option_message, Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.option_c_checkbox_view3:
                if (checked) {
                    scoredPointsView3 =+5;
                    Toast.makeText(MainActivity.this,R.string.correct_option_message, Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.option_d_checkbox_view3:
                if (checked) {
                    scoredPointsView3 =0;
                    Toast.makeText(MainActivity.this,R.string.wrong_option_message, Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    /**

     This method is called when the view score button is clicked.
     */
    public void submitScore (View view) {
     // This is for the name input.
        EditText playerNameInput = (EditText) findViewById(R.id.edit_text_view);
        String name = playerNameInput.getText().toString();

        int score = scoredPointsView;
        String scoreMessage = QuizResult (score, name);
        displayText.setText(scoreMessage);
    }

    /**
     This method is called when the view score button is clicked.
     */
    public void submitScore1 (View view) {
        // This is for the name input.
        EditText playerNameInput = (EditText) findViewById(R.id.edit_text_view1);
        String name = playerNameInput.getText().toString();

        int score = scoredPointsView1;
        String scoreMessage = QuizResult1 (score, name);
        displayText1.setEnabled(true);
        Toast.makeText(this,scoreMessage, Toast.LENGTH_LONG).show();
    }

    /**
     This method is called when the view score button is clicked.
     */
    public void submitScore3 (View view) {
        // This is for the name input.
        EditText playerNameInput = (EditText) findViewById(R.id.edit_text_view3);
        String name = playerNameInput.getText().toString();

        int score = scoredPointsView3;
        String scoreMessage = QuizResult3 (score, name);
        Toast.makeText(this,scoreMessage, Toast.LENGTH_LONG).show();
    }

    private String QuizResult (int score, String name) {
        String scoreMessage = getString(R.string.quiz_player_name, name);
        scoreMessage += "\n" + getString(R.string.quiz_result_score_info, score);
        scoreMessage += "\n"+ getString(R.string.quiz_result_greeting_message);
        return scoreMessage;
    }

    private String QuizResult1 (int score, String name) {
        String scoreMessage = getString(R.string.quiz_player_name, name);
        scoreMessage += "\n" + getString(R.string.quiz_result_score_info, score);
        scoreMessage += "\n"+ getString(R.string.quiz_result_greeting_message);
        return scoreMessage;
    }

    private String QuizResult3 (int score, String name) {
        String scoreMessage = getString(R.string.quiz_player_name, name);
        scoreMessage += "\n" + getString(R.string.quiz_result_score_info, score);
        scoreMessage += "\n"+ getString(R.string.quiz_result_greeting_message);
        return scoreMessage;
    }

    private String QuizResult4 (int score, String name) {
        String scoreMessage = getString(R.string.quiz_player_name, name);
        scoreMessage += "\n" + getString(R.string.quiz_result_score_info, score);
        scoreMessage += "\n"+ getString(R.string.quiz_result_greeting_message);
        return scoreMessage;
    }

    @Override
    public void onClick (View v) {

        if (v==next) {
            viewFlipper.showNext ();
        }

        else  if (v==prev){
            viewFlipper.showPrevious();
            scoredPointsView =0;
            scoredPointsView1 =0;
            scoredPointsView2 =0;
            scoredPointsView3 =0;
            scoredPointsView4 =0;
        }

    }

}

