package asiantech.nhokquay9x26.appreviewasiantech.activites;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class BaseActionBarActivity extends ActionBarActivity {
    protected String tag = this.getClass().getSimpleName();

    @AfterViews
    protected void initView(){
        this.afterView();
    }

    abstract void afterView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
