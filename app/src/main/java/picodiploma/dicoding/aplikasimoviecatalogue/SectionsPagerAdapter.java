package picodiploma.dicoding.aplikasimoviecatalogue;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.movie,R.string.tv_show};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super( fm );
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentMovie();
                break;

            case 1:
                fragment = new FragmentTvShow();
                break;

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString( TAB_TITLES[position] );
    }

    @Override
    public int getCount() {
        return 2;
    }
}
