package asiantech.nhokquay9x26.appreviewasiantech.fragments;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentByTag;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.activites.IntializeActivity_;

/**
 * Created by nhokquay9x26 on 11/10/15.
 */
@EFragment(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment {
    @FragmentByTag("LoginFragments")
    protected LoginFragment mLoginFragment;

    @AfterViews
    void afterViews(){

    }

    @Click(R.id.btnLogin)
    void login(){
        if(mLoginFragment == null){
            mLoginFragment = LoginFragment_.builder().build();
        }
        ((IntializeActivity_) getActivity()).replaceFragment(mLoginFragment);
    }
}
