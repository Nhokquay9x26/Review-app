package asiantech.nhokquay9x26.appreviewasiantech.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentByTag;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.activites.IntializeActivity_;

/**
 * Created by nhokquay9x26 on 11/10/15.
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment {
    @FragmentByTag("RegisterFragment")
    protected RegisterFragment mRegisteFragment;

    @AfterViews
    void afterViews(){

    }

    @Click(R.id.btnRegister)
    void register(){
        if(mRegisteFragment == null){
            mRegisteFragment = RegisterFragment_.builder().build();
        }
        ((IntializeActivity_) getActivity()).replaceFragment(mRegisteFragment);
    }
    @Click(R.id.tvForgetPassword)
    void forgetPassword(){
        final Dialog dialog = new Dialog(getContext(), R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.forget_password);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
