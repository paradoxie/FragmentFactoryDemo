package cf.paradoxie.fragmentfactorydemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import cf.paradoxie.fragmentfactorydemo.fragment.BaseFragment;
import cf.paradoxie.fragmentfactorydemo.fragment.FragmentFactory;

public class MainActivity extends AppCompatActivity {
    private String tabTitles[] = new String[]{"绿水无忧", "因风皱面", "青山不老", "为雪白头"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tl);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //这里可以对标题做一些工作，比如添加图标什么的
            return tabTitles[position];//标题
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;//工厂模式生产返回第position个fragment对象
        }

        @Override
        public int getCount() {
            return tabTitles.length;//fragment数量就是标题的个数
        }
    }
}
