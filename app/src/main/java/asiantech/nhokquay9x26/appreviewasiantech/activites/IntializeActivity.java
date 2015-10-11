package asiantech.nhokquay9x26.appreviewasiantech.activites;

import android.support.v4.app.FragmentTransaction;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentByTag;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.core.fragment.Fragment;
import asiantech.nhokquay9x26.appreviewasiantech.fragments.LoginFragment;
import asiantech.nhokquay9x26.appreviewasiantech.fragments.LoginFragment_;

/**
 * Created by nhokquay9x26 on 10/10/15.
 */
@EActivity(R.layout.activity_initialize)
public class IntializeActivity extends BaseActionBarActivity {
    @FragmentByTag("LoginFragment")
    protected LoginFragment mLoginFragment;

    @Override
    void afterView() {
        if(mLoginFragment == null){
            mLoginFragment = LoginFragment_.builder().build();
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout, mLoginFragment, "LoginFragment");
        ft.commit();
    }

    public void replaceFragment(Fragment layoutID){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, layoutID);
        ft.commit();
    }

}
