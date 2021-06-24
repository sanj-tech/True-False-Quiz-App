package com.jsstech.quizappdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewquiz;
    TextView quesText;
    Button btTrue, btfalse, bt_Next, btPrev;
    private int currentQuestionIndex = 0;


    private QuestionModel[] questionBank = new QuestionModel[]{
            new QuestionModel(R.string.question1,true),
            new QuestionModel(R.string.question2,true),
            new QuestionModel(R.string.question3,false),
            new QuestionModel(R.string.question4,false),
            new QuestionModel(R.string.question5,true),
            new QuestionModel(R.string.question6,true),
            new QuestionModel(R.string.question7,false),
            new QuestionModel(R.string.question8,false),
            new QuestionModel(R.string.question9,false),
            new QuestionModel(R.string.ques10,true),
            new QuestionModel(R.string.ques11,true),
            new QuestionModel(R.string.ques12,false),
            new QuestionModel(R.string.question9,true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quesText = findViewById(R.id.que_txt);
        btTrue = findViewById(R.id.bt_true);
        btfalse = findViewById(R.id.bt_false);

        bt_Next = findViewById(R.id.btnext);
        btPrev = findViewById(R.id.btprev);

       // getActionBar().setTitle("Quiz App");
       getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        btTrue.setOnClickListener(this);
        btfalse.setOnClickListener(this);
        btPrev.setOnClickListener(this);
        bt_Next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_true:
                Toast.makeText(MainActivity.this,"True",Toast.LENGTH_SHORT).show();
                checkAns(true);
                break;

            case R.id.bt_false:
                Toast.makeText(MainActivity.this,"false",Toast.LENGTH_SHORT).show();
                checkAns(false);
                break;

            case R.id.btnext:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                Log.d("current","onclick" + currentQuestionIndex);
                quesText.setText(questionBank[currentQuestionIndex].getAnsResult());
                //updateQues();
                break;

            case R.id.btprev:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    Log.d("current","onclick" + currentQuestionIndex);
                    quesText.setText(questionBank[currentQuestionIndex].getAnsResult());
                    updateQues();
                }
        }
    }

    private void checkAns(boolean b) {
        boolean answerisTrue = questionBank[currentQuestionIndex].isTruAns();

        int toastmsgId = 0;
        if (b == answerisTrue) {
            toastmsgId = R.string.correct_ans;
        } else {
            toastmsgId = R.string.wrong_ans;
        }
        Toast.makeText(this,toastmsgId,Toast.LENGTH_SHORT).show();
    }


    private void updateQues() {
        Log.d("current","onclick" + currentQuestionIndex);
        quesText.setText(questionBank[currentQuestionIndex].getAnsResult());
    }
}