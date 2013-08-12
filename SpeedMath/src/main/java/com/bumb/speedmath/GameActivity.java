package com.bumb.speedmath;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.io.Console;


public class GameActivity extends Activity {

    public GridView keypadGrid;
    TextView question;
    TextView answer;
    TextView score;
    TextView timer;
    KeypadAdapter keypadGridAdapter;
    Problem currentProblem = null;
    Level level = null;
    CountDownTimer countDownTimer = null;
    private Context context = this;
    public static final int NUM_COLUMNS_IN_KEYPAD = 3;
    private int currentScore = 0;

    public float getVerticalSpacingInKeypad() {
        Resources r = getResources();
        return TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_DIP, 5, r.getDisplayMetrics());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get reference to the keypad button GridView
        keypadGrid = (GridView) findViewById(R.id.keypadGrid);
        question = (TextView)findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);
        score = (TextView) findViewById(R.id.score);
        timer = (TextView) findViewById(R.id.timer);
        // Create Keypad Adapter
        keypadGridAdapter = new KeypadAdapter(this);

        // Set adapter of the keypad grid
        keypadGrid.setAdapter(keypadGridAdapter);
        setInitialVars();
        keypadGridAdapter.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                // Get the KeypadButton value which is used to identify the
                // keypad button from the Button's tag
                KeypadButtonEnum keypadButton = (KeypadButtonEnum) btn.getTag();

                // Process keypad button
                ProcessKeypadInput(keypadButton);
            }
        });
    }

    /*@Override
    public void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.countDownTimer.start();
    }*/

    private void setInitialVars() {
        score.setText(getString(R.string.score) + "0");
        currentScore = 0;
        answer.setText("");
        level = new LevelOne();
        for (Problem problem : level.getProblems()) {
            System.out.println(problem.getProblemStatement());
        }
        setQuestion();
        startTimer();
    }

    private void startTimer() {
        if (null == this.countDownTimer) {
            this.countDownTimer = new CountDownTimer(60000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    timer.setText(getString(R.string.time) + " " + millisUntilFinished / 1000 + "s");
                }

                @Override
                public void onFinish() {
                    //Todo: create new activity
                    timer.setText("Done!");
                    showFinishDialog();
                }
            };
        }
        this.countDownTimer.start();
    }

    private void showFinishDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Time up");

        // set dialog message
        alertDialogBuilder
                .setMessage("Your score is: " + currentScore)
                .setCancelable(false)
                .setPositiveButton("Play Again",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        setInitialVars();
                        //MainActivity.this.finish();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE).
                        setTextAppearance(context, android.R.style.TextAppearance_Large);
            }
        });
        // show it
        alertDialog.show();
    }

    private void ProcessKeypadInput(KeypadButtonEnum keypadButton) {
        String text = keypadButton.getText().toString();
        String currentInput = answer.getText().toString();

        int currentInputLen = currentInput.length();

        switch (keypadButton) {
            case DELETE:
                if (0 == currentInputLen) {
                    return;
                }
                int endIndex = currentInputLen - 1;
                answer.setText(currentInput.subSequence(0, endIndex));
                break;
            case CLEAR:
                answer.setText("");
                break;
            case GO:
                handleGo();
                break;
            default:
                if(!(text.equals(".") && currentInput.contains(".")) && currentInput.length() < 6)
                {
                    answer.setText(currentInput + text);
                }
                break;
        }
    }

    private void handleGo() {
        if (isAnswerEntered()) {
            checkAnswerAndSetScore();
            answer.setText("");
            setQuestion();
        }
    }

    private boolean isAnswerEntered() {
        if (answer.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
    private void checkAnswerAndSetScore() {
        //Todo: Handle last dot, handle integers separately
        double result = Double.parseDouble(answer.getText().toString());
        if(Math.abs(result - currentProblem.getResult()) < 0.1) {
            this.currentScore += currentProblem.getScore();
            score.setText(getString(R.string.score) + " " + String.valueOf(currentScore));
        }
    }

    private void setQuestion(){
        currentProblem = level.getNextProblem();
        if (null == currentProblem) {
            this.countDownTimer.cancel();
            this.countDownTimer.onFinish();
        } else {
            question.setText(currentProblem.getProblemStatement());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }
    
}
