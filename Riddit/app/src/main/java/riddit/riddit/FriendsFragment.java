package riddit.riddit;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by GILBERT on 14-11-04.
 */
public class FriendsFragment extends ListFragment {

    public static final String TAG = FriendsFragment.class.getSimpleName();

    protected List<ParseUser> mFriends;
    protected ParseRelation<ParseUser> mFriendsRelation;
    protected ParseUser mCurrentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        mCurrentUser = ParseUser.getCurrentUser();
        mFriendsRelation = mCurrentUser.getRelation(ParseConstants.KEY_FRIENDS_RELATION);
        getActivity().setProgressBarIndeterminateVisibility(true);
//        we create a query variable to sort it before

        ParseQuery<ParseUser> query = mFriendsRelation.getQuery();
        query.addAscendingOrder(ParseConstants.KEY_USERNAME);

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> friends, ParseException e) {
        getActivity().setProgressBarIndeterminateVisibility(false);
                if (e != null){
                    // There was an error
                    Log.e(TAG, e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(getListView().getContext());
                    builder.setMessage(e.getMessage())
                            .setTitle(R.string.error_title)
                            .setPositiveButton(android.R.string.ok, null);

//                    now we show the message of the dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else {
                    // results have all the friend the current user liked.

                    mFriends = friends;
                    String[] usernames = new String[mFriends.size()];
                    int i = 0;
//                 : mean in it's like the for in loop
                    for (ParseUser user : mFriends) {
                        usernames[i] = user.getUsername();
                        i++;
                    }
//                    here we hook the adapter with the array
                    ArrayAdapter adapter = new ArrayAdapter(
//                   in fragment the list view know his context that why we didnt use this
                            getListView().getContext(), android.R.layout.simple_list_item_1,
                            usernames);

                    setListAdapter(adapter);
                }


            }
        });


    }
}
