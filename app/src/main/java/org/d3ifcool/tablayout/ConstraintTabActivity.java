package org.d3ifcool.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import org.d3ifcool.tablayout.DayFragment.FiveFragment;
import org.d3ifcool.tablayout.DayFragment.FourFragment;
import org.d3ifcool.tablayout.DayFragment.OneFragment;
import org.d3ifcool.tablayout.DayFragment.SevenFragment;
import org.d3ifcool.tablayout.DayFragment.SixFragment;
import org.d3ifcool.tablayout.DayFragment.ThreeFragment;
import org.d3ifcool.tablayout.DayFragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class ConstraintTabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_tab);

        viewPager = (ViewPager) findViewById(R.id.viewpager2);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Senin");
        adapter.addFragment(new TwoFragment(), "Selasa");
        adapter.addFragment(new ThreeFragment(), "Rabu");
        adapter.addFragment(new FourFragment(), "Kamis");
        adapter.addFragment(new FiveFragment(), "Jum'at");
        adapter.addFragment(new SixFragment(), "Sabtu");
        adapter.addFragment(new SevenFragment(), "Minggu");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
