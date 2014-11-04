package riddit.riddit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;
//alert !!!!!!!!!!!! see import on the top
/**
 * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

//this class has been copy and paste from mainactivity.java

public class SectionsPagerAdapter extends FragmentPagerAdapter {
//    we added the context cause the class need to know about context for the getString

    protected Context mContext;
// context added to the parameter
    public SectionsPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        MainActivity added to fixed code
//        we add swicth to return different fragment base on the position

        switch (position) {
            case 0:
                return new InboxFragment();
            case 1:
                return new FriendsFragment();
        }
//        PlaceholderFragment change to that below cause i deleted that class
        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
       //it's here we set up the number of page
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.title_section2).toUpperCase(l);
        }
        return null;
    }
}
