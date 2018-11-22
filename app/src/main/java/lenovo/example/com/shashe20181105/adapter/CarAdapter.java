package lenovo.example.com.shashe20181105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lenovo.example.com.shashe20181105.R;
import lenovo.example.com.shashe20181105.bean.CarBean;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>{
    private Context context;
    private List<CarBean.DataBean> list=new ArrayList<>();
    public CarAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.car_layout, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.mTitle.setText(list.get(i).getSellerName());
        CarAdapter2 carAdapter2 = new CarAdapter2(context,list.get(i).getList());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        myViewHolder.mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        myViewHolder.mRecyclerView.setAdapter(carAdapter2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CarBean.DataBean> list) {
        list.remove(0);
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        RecyclerView mRecyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle=itemView.findViewById(R.id.title);
            mRecyclerView=itemView.findViewById(R.id.recyler_view);
        }
    }
}
