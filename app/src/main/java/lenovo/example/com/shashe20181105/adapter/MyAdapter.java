package lenovo.example.com.shashe20181105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import lenovo.example.com.shashe20181105.CacheCar;
import lenovo.example.com.shashe20181105.R;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<CacheCar> list = new ArrayList<>();
    private Context context;

    public MyAdapter(List<CacheCar> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.car2_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.mDesc.setText(list.get(i).getTitle());
        myViewHolder.mSimple.setImageURI(list.get(i).getImage().split("\\|")[0]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CacheCar> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView mSimple;
        TextView mDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mSimple = itemView.findViewById(R.id.simple);
            mDesc = itemView.findViewById(R.id.desc);
        }
    }
}
