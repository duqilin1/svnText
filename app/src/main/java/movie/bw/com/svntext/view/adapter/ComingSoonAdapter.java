package movie.bw.com.svntext.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.model.bean.ComingSoonBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:20:45
 *@Description:${DESCRIPTION}
 * */
public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.MyViewHolder> {

    private List<ComingSoonBean.ResultBean> result;

    public ComingSoonAdapter(List<ComingSoonBean.ResultBean> result) {

        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comingsoon, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ComingSoonBean.ResultBean resultBean = result.get(position);
//        Glide.with(holder.img)
//                .load(resultBean.getImageUrl())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
//                .error(R.mipmap.ic_launcher)
//                .into(holder.img);
        holder.name.setText(resultBean.getName());
        holder.img.setImageURI(resultBean.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.img)
//        ImageView img;
//        @BindView(R.id.name)
//        TextView name;

        @BindView(R.id.img)
        SimpleDraweeView img;
        @BindView(R.id.name)
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

