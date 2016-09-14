package com.example.sks.viewpageranima;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.sks.viewpageranima.view.MyTabLayout;
import com.example.sks.viewpageranima.view.MyViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private View[] itemViews = new View[7];
    private int[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.GRAY, Color.BLACK, Color.BLACK, Color.GREEN};
    private String[] titles = {"one", "two", "ssdadadadwasssssssssssss", "four", "five", "six" , "sevensssssssssssssssss"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyTabLayout tabLayout = (MyTabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabMode(MyTabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);
        initViewPagerItemViews();

        mViewPager.setAdapter(new ViewPagerAdapter());


        //mViewPager.setPageTransformer(true, new ViewPagerAnim());
    }

    private void initViewPagerItemViews() {
        for (int i = 0; i < 7; i++) {
            View view = View.inflate(this, R.layout.item_view_pager, null);
            view.setBackgroundColor(colors[i]);
            itemViews[i] = view;
        }

    }
    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            container.addView(itemViews[position]);
            return itemViews[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

          @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
