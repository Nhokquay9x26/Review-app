package asiantech.nhokquay9x26.appreviewasiantech.fragments;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentByTag;
import org.androidannotations.annotations.ViewById;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.activites.IntializeActivity_;

/**
 * Created by nhokquay9x26 on 11/10/15.
 */
@EFragment(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment {
    @FragmentByTag("LoginFragments")
    protected LoginFragment mLoginFragment;

    @ViewById(R.id.edtUsername)
    EditText mEdtUsername;

    @ViewById(R.id.edtEmail)
    EditText mEdtEmail;

    @ViewById(R.id.edtPassword)
    EditText mEdtPassword;

    @ViewById(R.id.edtConfirmPassword)
    EditText mEdtConfirmPassword;

    @ViewById(R.id.tvError)
    TextView mTvError;

    @ViewById(R.id.checkBoxAgree)
    CheckBox mCheckBoxAgree;

    @AfterViews
    void afterViews() {

    }

    @Click(R.id.btnLogin)
    void login() {
        if (mLoginFragment == null) {
            mLoginFragment = LoginFragment_.builder().build();
        }
        ((IntializeActivity_) getActivity()).replaceFragment(mLoginFragment);
    }

    @Click(R.id.btnRegister)
    void register() {
        String mUsername = mEdtUsername.getText().toString();
        String mEmail = mEdtEmail.getText().toString();
        String mPassword = mEdtPassword.getText().toString();
        String mConfirmPassword = mEdtConfirmPassword.getText().toString();

        if (mUsername.equals("") || mEmail.equals("") || mPassword.equals("") || mConfirmPassword.equals("")){
            mTvError.setText(getResources().getString(R.string.textview_text_error_empty));
        }else if(mCheckBoxAgree.isChecked()){
            Toast.makeText(getActivity(), getResources().getString(R.string.textview_text_register_successfully), Toast.LENGTH_SHORT).show();
            login();
        }else {
            mTvError.setText(getResources().getString(R.string.textview_text_error_no_check_agree));
        }
    }
}
