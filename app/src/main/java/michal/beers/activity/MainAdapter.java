package michal.beers.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import michal.beers.R;
import michal.beers.data.Beer;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Beer> beers = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_beer, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setup(beers.get(position));
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_imageView)
        ImageView imageView;

        @BindView(R.id.item_title)
        TextView textView_title;

        @BindView(R.id.item_description)
        TextView textView_description;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setup(Beer beer) {

            Glide.with(itemView.getContext())
                    .load(beer.getImageUrl().getImageUrl())
                    .into(imageView);

            textView_title.setText(beer.getName());

            textView_description.setText(beer.getDescription());
        }

    }


}

