package some.funquestion;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by GILBERT on 14-10-04.
 */
public class ColorGenerator {

    public String[] changeBackQuestion = {
            "#39add1",
            "#7d669e",
            "#f092b0",
            "#e0ab18",
            "#c25975"
    };

    public int changeBackground(){
        //                the button was click update the question label with a new question
        String newBackground = "";


//                we wanna show random question
        Random randomGeneratorBackground = new Random();
        int generator = randomGeneratorBackground.nextInt(changeBackQuestion.length);



        newBackground = changeBackQuestion[generator];
        int newBackgroundAsInt = Color.parseColor(newBackground);



        return newBackgroundAsInt;
    }
}
