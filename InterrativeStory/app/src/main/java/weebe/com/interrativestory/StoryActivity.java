package weebe.com.interrativestory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class StoryActivity extends Activity {

    private static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null){
            name = "Friends";
        }
            Log.d(TAG, name);

    }



}
