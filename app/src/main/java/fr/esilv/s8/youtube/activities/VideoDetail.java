package fr.esilv.s8.youtube.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;

import fr.esilv.s8.youtube.Constants;
import fr.esilv.s8.youtube.R;
import fr.esilv.s8.youtube.model.Item;

public class VideoDetail extends YouTubeBaseActivity  implements YouTubePlayer.OnInitializedListener {

    private static final String ITEM_VIDEO = "ITEM_VIDEO";
    private Item item;

    private TextView titleField;
    private TextView descriptionField;
    private TextView dateField;

    public static void start(Context context, Item itemVideo) {
        Intent intent = new Intent(context, VideoDetail.class);
        intent.putExtra(ITEM_VIDEO,itemVideo);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        titleField = (TextView) findViewById(R.id.title);
        descriptionField = (TextView) findViewById(R.id.description);
        dateField = (TextView) findViewById(R.id.date);

        item = (Item) getIntent().getSerializableExtra(ITEM_VIDEO);
        System.out.println(item.getTitle());
        titleField.setText(item.getTitle());
        descriptionField.setMovementMethod(new ScrollingMovementMethod());
        descriptionField.setText(item.getDescription());
        dateField.setText(item.getSnippet().getPublishedAt());


        /** Initializing YouTube player view **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(Constants.API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(item.getId().getVideoId());
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {

        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }

    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {

        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };
}
