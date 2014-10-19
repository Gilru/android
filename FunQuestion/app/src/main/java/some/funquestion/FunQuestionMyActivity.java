package some.funquestion;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FunQuestionMyActivity extends Activity {

    public static final String Tag = FunQuestionMyActivity.class.getSimpleName();
    private QuestionBook questionB = new QuestionBook();
    private  ColorGenerator newColor = new ColorGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_question_my);

//        Declare our view variable and assign them the views from the layout file
        final TextView funQuestion = (TextView) findViewById(R.id.factTextView);
        final Button showQuestion = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout changeBackground = (RelativeLayout) findViewById(R.id.backgroundQuestion);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

                String question = questionB.getQuestion();
                int applyNewBackground = newColor.changeBackground();
                funQuestion.setText(question);
                changeBackground.setBackgroundColor(applyNewBackground);
                showQuestion.setTextColor(applyNewBackground);


            }
        };
        showQuestion.setOnClickListener(listener);


//        Toast.makeText(this,"hey the toaster",Toast.LENGTH_LONG).show();
        Log.d(Tag,"hello second");

    }



}
