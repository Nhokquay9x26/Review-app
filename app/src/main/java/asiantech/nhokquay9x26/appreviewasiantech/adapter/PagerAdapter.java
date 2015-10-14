package asiantech.nhokquay9x26.appreviewasiantech.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import asiantech.nhokquay9x26.appreviewasiantech.R;
import asiantech.nhokquay9x26.appreviewasiantech.eventbus.BusProvider;
import asiantech.nhokquay9x26.appreviewasiantech.eventbus.PopToTopSameTabClickEvent;
import asiantech.nhokquay9x26.appreviewasiantech.models.HomePageItem;
import asiantech.nhokquay9x26.appreviewasiantech.views.PagerSlidingTabStrip;


/**
 * Copyright © 2015 AsianTech inc.
 * Created by nhokquay9x26 on 10/11/15.
 */
public class PagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    private ArrayList<HomePageItem> tabItems = new ArrayList<>();
    private Fragment mContext;

    public PagerAdapter(Fragment context,
                        ArrayList<HomePageItem> items) {
        super(context.getChildFragmentManager());
        this.mContext = context;
        this.tabItems = items;
    }

    @Override
    public Fragment getItem(final int position) {
        Fragment item = tabItems.get(position).getFragment();
        return item;
    }

    @Override
    public int getCount() {
        return tabItems.size();
    }

    @Override
    public int getItemPosition(Object item) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabItems.get(position).getTitle();
    }

    @Override
    public int getPageIconResId(int i) {
        return tabItems.get(i).getDrawableResource();
    }

    @Override
    public View getView(int position) {
        View v = LayoutInflater.from(mContext.getActivity()).inflate(R.layout.custom_item_tab, null, false);
        TextView title = (TextView) v.findViewById(R.id.title);
        ImageView icon = (ImageView) v.findViewById(R.id.thumb);

        icon.setImageResource(tabItems.get(position).getDrawableResource());
        title.setText(tabItems.get(position).getTitle());
        return v;
    }

    @Override
    public void onTabClick(int position, boolean isSameTab) {
        if (isSameTab) {
            BusProvider.getInstance().post(new PopToTopSameTabClickEvent());
        }
    }

}
