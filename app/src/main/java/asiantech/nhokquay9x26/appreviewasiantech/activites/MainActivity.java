package asiantech.nhokquay9x26.appreviewasiantech.activites;

import android.support.v4.app.FragmentTransaction;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentByTag;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.fragments.MainFragment;
import asiantech.nhokquay9x26.appreviewasiantech.fragments.MainFragment_;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActionBarActivity {

    @FragmentByTag("MainFragment")
    protected MainFragment mMainFragment;

    @Override
    void afterView() {
        if (mMainFragment == null) {
            mMainFragment = MainFragment_.builder().build();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, mMainFragment, "MainFragment");
        ft.commit();
    }
}
