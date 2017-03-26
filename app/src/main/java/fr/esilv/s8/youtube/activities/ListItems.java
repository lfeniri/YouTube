package fr.esilv.s8.youtube.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.esilv.s8.youtube.Constants;
import fr.esilv.s8.youtube.R;
import fr.esilv.s8.youtube.adapters.VideosAdapter;
import fr.esilv.s8.youtube.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.youtube.model.Item;
import fr.esilv.s8.youtube.model.Video;
import fr.esilv.s8.youtube.model.YoutubeData;

public class ListItems extends AppCompatActivity implements OnVideoSelectedListener {

    private static final String WORDSEARCH = "WORDSEARCH";
    private static final String YOUTUBE_URL = "https://www.googleapis.com/youtube/v3/search";
    private RecyclerView recyclerView;
    private String wordSearch;
    private int maxResults = 40;
    public static void start(Context context, String search) {
        Intent intent = new Intent(context, ListItems.class);
        intent.putExtra(WORDSEARCH, search);
        context.startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        wordSearch = getIntent().getStringExtra(WORDSEARCH);
        wordSearch = wordSearch.replaceAll(" ", ",");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        StringRequest youtubeRequest = new StringRequest(YOUTUBE_URL + "?part=snippet&maxResults="+maxResults+"&q="+wordSearch+"&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                YoutubeData data = new Gson().fromJson(response, YoutubeData.class);
                setAdapter(data);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Youtube", "Error");
            }
        });

        Volley.newRequestQueue(this).add(youtubeRequest);
    }

    private void setAdapter(YoutubeData videos) {
        VideosAdapter adapter = new VideosAdapter(videos,this);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(Item itemVideo) {
        VideoDetail.start(this,itemVideo);

        //Main2Activity.start(this);
        //System.out.println(itemVideo.getTitle());
    }

}
