package some.funquestion;



import java.util.Random;

/**
 * Created by GILBERT on 14-10-04.
 */
public class QuestionBook {

    public String[] manswerQuestion = {
            "this my first question",
            "hello second question",
            "that are my last question",
            "and then hello that are the one question i love",
            "and you can number 4",
            "some sintax"

    };



    public String getQuestion(){

//                the button was click update the question label with a new question
        String newQuestion = "";


//                we wanna show random question
        Random randomGenerator = new Random();
        int generator = randomGenerator.nextInt(manswerQuestion.length);

        newQuestion = manswerQuestion[generator];

        return newQuestion;
    }


}
