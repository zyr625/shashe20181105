package lenovo.example.com.shashe20181105.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import lenovo.example.com.shashe20181105.HttpListener;
import lenovo.example.com.shashe20181105.OkHttpUtils;
import lenovo.example.com.shashe20181105.R;
import lenovo.example.com.shashe20181105.adapter.CarAdapter;
import lenovo.example.com.shashe20181105.bean.CarBean;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class Fragment_Main extends Fragment {
    private RecyclerView mRecyclerView;
    private CarAdapter carAdapter;
    private String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView=view.findViewById(R.id.recy_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        carAdapter = new CarAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(carAdapter);
        new OkHttpUtils().get(url).result(new HttpListener() {
            @Override
            public void success(String data) {
                CarBean carBean = new Gson().fromJson(data, CarBean.class);
                carAdapter.setList(carBean.getData());
            }
        });
    }
}
