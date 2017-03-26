package fr.esilv.s8.youtube.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import fr.esilv.s8.youtube.R;

public class Main2Activity extends AppCompatActivity {

    private static final String ID_VIDEO = "ID_VIDEO";
    private static final String PUBLISHED_AT = "PUBLISHED_AT";
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private String id_video;
    private String publishedAt;
    private String channelID;
    private String title;
    private String description;

    private EditText titleField;



    public static void start(Context context, String id_video, String publishedAt,String channelID,String title,String description) {

        Intent intent = new Intent(context, Main2Activity.class);

        intent.putExtra(ID_VIDEO, id_video);
        intent.putExtra(PUBLISHED_AT, publishedAt);
        intent.putExtra(CHANNEL_ID, channelID);
        intent.putExtra(TITLE, title);
        intent.putExtra(DESCRIPTION, description);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titleField = (EditText) findViewById(R.id.editText2);

        title = getIntent().getStringExtra(TITLE);

        titleField.setText(title);
        System.out.println(title);

    }
}
