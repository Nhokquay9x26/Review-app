package asiantech.nhokquay9x26.appreviewasiantech.models;

import android.support.v4.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Copyright © 2015 AsianTech inc.
 * Created by nhokquay9x26 on 10/11/15.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class HomePageItem {
    private Fragment fragment;
    private String title;
    private int drawableResource;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}
