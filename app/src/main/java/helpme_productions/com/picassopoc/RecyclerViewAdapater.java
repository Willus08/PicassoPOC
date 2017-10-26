package helpme_productions.com.picassopoc;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.ViewHolder> {
    private List<String> urls = new ArrayList<>();
    RecyclerViewAdapater(List<String> listOfImagesURL) {
        this.urls = listOfImagesURL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_pictures,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url = urls.get(position);
        Picasso.with(holder.itemView.getContext()).load(url).into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.ivRecycleImage);
        }
    }
}
