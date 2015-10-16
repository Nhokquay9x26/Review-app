package asiantech.nhokquay9x26.appreviewasiantech.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentByTag;
import org.androidannotations.annotations.ViewById;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.activites.IntializeActivity_;
import asiantech.nhokquay9x26.appreviewasiantech.activites.MainActivity_;

/**
 * Created by nhokquay9x26 on 11/10/15.
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment {
    @FragmentByTag("RegisterFragment")
    protected RegisterFragment mRegisteFragment;

    @ViewById(R.id.edtUsername)
    EditText mEdtUsername;

    @ViewById(R.id.edtPassword)
    EditText mEdtPassword;

    @ViewById(R.id.tvError)
    TextView mTvError;

    @AfterViews
    void afterViews() {

    }

    @Click(R.id.btnRegister)
    void register() {
        if (mRegisteFragment == null) {
            mRegisteFragment = RegisterFragment_.builder().build();
        }
        ((IntializeActivity_) getActivity()).replaceFragment(mRegisteFragment);
    }

    @Click(R.id.btnLogin)
    void Login() {
        String mUsername = mEdtUsername.getText().toString();
        String mPassword = mEdtPassword.getText().toString();
        if (mUsername.equals("") || mPassword.equals("")) {
            mTvError.setText(getResources().getString(R.string.textview_text_error_empty));
        } else if (mUsername.equals("admin") && mPassword.equals("admin")) {
            MainActivity_.intent(getActivity()).start();
            getActivity().finish();
        } else {
            mTvError.setText(getResources().getString(R.string.textview_text_error_fail));
        }
    }

    @Click(R.id.tvForgetPassword)
    void forgetPassword() {
        final Dialog dialog = new Dialog(getContext(), R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_forget_password);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        Button mBtnOk, mBtnCancel;
        mBtnOk = (Button) dialog.findViewById(R.id.btnOk);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mBtnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
