package riddit.riddit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by GILBERT on 14-10-26.
 */
public class RibbitApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "Rj6RQ6sBBq60RFVibjv6ZjxTNtWAYe1Vc4mO9CcL", "v9qnl3UHfoaf29lVLUiGHbb2nRyxdDrboYj3wW1P");

    }

}
