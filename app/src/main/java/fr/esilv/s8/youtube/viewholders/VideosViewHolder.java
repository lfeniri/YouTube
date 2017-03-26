package fr.esilv.s8.youtube.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.s8.youtube.R;
import fr.esilv.s8.youtube.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.youtube.model.Item;
import fr.esilv.s8.youtube.model.MediumUrl;
import fr.esilv.s8.youtube.model.Video;

public class VideosViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView date;
    private OnVideoSelectedListener onVideoSelectedListener;
    private ImageView image;
    public VideosViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        date = (TextView) itemView.findViewById(R.id.date);
        image = (ImageView) itemView.findViewById(R.id.imageView);
    }

    public void bind(final Item itemVideo,Context context) {
        title.setText(itemVideo.getTitle());
        date.setText(itemVideo.getSnippet().getPublishedAt());

        MediumUrl tmp = itemVideo.getSnippet().getThumbnails().getMedium_url();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(140, tmp.getHeight());
        image.setLayoutParams(layoutParams);
        Picasso.with(context).load(tmp.getUrl()).into(image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(itemVideo);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }

}
