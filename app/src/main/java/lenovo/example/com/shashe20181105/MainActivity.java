package lenovo.example.com.shashe20181105;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lenovo.example.com.shashe20181105.fragment.Fragment_Main;
import lenovo.example.com.shashe20181105.fragment.Fragment_My;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Main)
    TextView mMain;
    @BindView(R.id.My)
    TextView mMy;
    @BindView(R.id.vp)
    ViewPager mVp;

    @OnClick(R.id.Main)
    public void Onclick_1() {
        mVp.setCurrentItem(0);
    }

    @OnClick(R.id.My)
    public void Onclick_2() {
        mVp.setCurrentItem(1);
    }

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定ButterKnife
        fragments.add(new Fragment_Main());
        fragments.add(new Fragment_My());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }
}
