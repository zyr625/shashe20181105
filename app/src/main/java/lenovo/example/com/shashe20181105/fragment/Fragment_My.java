package lenovo.example.com.shashe20181105.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import lenovo.example.com.shashe20181105.CacheCar;
import lenovo.example.com.shashe20181105.R;
import lenovo.example.com.shashe20181105.SqliteUtils;
import lenovo.example.com.shashe20181105.adapter.CarAdapter;
import lenovo.example.com.shashe20181105.adapter.MyAdapter;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class Fragment_My extends Fragment {
    private RecyclerView mRecyclerview;
    private SimpleDraweeView simple;
    private String img_url="https://img.huxiucdn.com/article/cover/201810/29/153108448766.jpg";
    private String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        mRecyclerview=view.findViewById(R.id.recylerview);
        simple=view.findViewById(R.id.simple_img);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        simple.setImageURI(img_url);
        EventBus.getDefault().register(this);
        List<CacheCar> list = SqliteUtils.getSqliteUtils().queryAll();
        myAdapter = new MyAdapter(list,getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerview.setAdapter(myAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String msg){
        List<CacheCar> list = SqliteUtils.getSqliteUtils().queryAll();
        myAdapter.setList(list);
    }
}
