package fr.esilv.s8.youtube.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import fr.esilv.s8.youtube.R;


public class MainActivity extends AppCompatActivity {

    private Button go;
    private AutoCompleteTextView textSearch;
    private ArrayList<String> list;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button) findViewById(R.id.buttonSearch);

        textSearch = (AutoCompleteTextView) findViewById(R.id.textSearch);

        list = new ArrayList<String>();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        textSearch.setAdapter(adapter);
        textSearch.setThreshold(1);
    }



    public void onGo(View view) {
        list.add(textSearch.getText().toString());
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        textSearch.setAdapter(adapter);
        textSearch.setThreshold(1);
        System.out.println(list.toString());
        ListItems.start(this, textSearch.getText().toString());
    }



}
