package fr.esilv.s8.youtube.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.esilv.s8.youtube.R;
import fr.esilv.s8.youtube.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.youtube.model.YoutubeData;
import fr.esilv.s8.youtube.viewholders.VideosViewHolder;

/**
 * Created by hope on 17/03/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosViewHolder>  {

    private final YoutubeData videos;
    private OnVideoSelectedListener onVideoSelectedListener;
    Context context;

    public VideosAdapter(YoutubeData videos,Context context) {
        this.videos = videos;
        this.context = context;

    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(videos.getItems().get(position),context);
    }

    @Override
    public int getItemCount() {
        return videos.getItems() != null ? videos.getItems().size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
