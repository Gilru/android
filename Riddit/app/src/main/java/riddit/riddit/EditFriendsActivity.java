package riddit.riddit;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class EditFriendsActivity extends ListActivity {
    public final static String TAG = EditFriendsActivity.class.getSimpleName();
    protected List<ParseUser> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_edit_friends);
    }

    @Override
    protected void onResume() {
        super.onResume();
    setProgressBarIndeterminateVisibility(true);
        ParseQuery<ParseUser> query = ParseUser.getQuery();
/*        we keep all our colon name in a class call ParseConstants because the user cannot
          interact with it so that why we dont put it in string
 */
        query.orderByAscending(ParseConstants.KEY_USERNAME);
        query.setLimit(1000);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
               setProgressBarIndeterminateVisibility(false);
                if(e == null){
//                    success
                    mUsers = users;
                    String[] usernames = new String[mUsers.size()];
                    int i = 0;
//                 : mean in it's like the for in loop
                    for(ParseUser user : mUsers){
                        usernames[i] = user.getUsername();
                        i++;
                    }
//                    here we hook the adapter with the array
                    ArrayAdapter adapter = new ArrayAdapter(
                            EditFriendsActivity.this,android.R.layout.simple_list_item_checked,
                    usernames);

                    setListAdapter(adapter);


                }else{
//                    error
                    Log.e(TAG, e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditFriendsActivity.this);
                    builder.setMessage(e.getMessage())
                            .setTitle(R.string.error_title)
                            .setPositiveButton(android.R.string.ok, null);

//                    now we show the message of the dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_friends, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
