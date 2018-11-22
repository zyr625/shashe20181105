package lenovo.example.com.shashe20181105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import lenovo.example.com.shashe20181105.CacheCar;
import lenovo.example.com.shashe20181105.R;
import lenovo.example.com.shashe20181105.SqliteUtils;
import lenovo.example.com.shashe20181105.bean.CarBean;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class CarAdapter2 extends RecyclerView.Adapter<CarAdapter2.MyViewHolder>{
    private Context context;
    private List<CarBean.DataBean.ListBean> list=new ArrayList<>();

    public CarAdapter2(Context context, List<CarBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CarAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = View.inflate(context, R.layout.car2_layout, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter2.MyViewHolder myViewHolder, final int i) {
        myViewHolder.mDesc.setText(list.get(i).getTitle());
        myViewHolder.mSimple.setImageURI(list.get(i).getImages().split("\\|")[0]);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = list.get(i).getTitle();
                String image = list.get(i).getImages().split("\\|")[0];
                CacheCar cacheCar = new CacheCar();
                cacheCar.setTitle(title);
                cacheCar.setImage(image);
                SqliteUtils.getSqliteUtils().insert(cacheCar);
                EventBus.getDefault().post("0");
                Toast.makeText(context,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView mSimple;
        TextView mDesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mSimple=itemView.findViewById(R.id.simple);
            mDesc=itemView.findViewById(R.id.desc);
        }
    }
    public static interface OnClickListener{
        void OnItemClick(View view);
    }
}
