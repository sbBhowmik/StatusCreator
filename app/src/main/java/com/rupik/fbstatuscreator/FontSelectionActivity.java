package com.rupik.fbstatuscreator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

public class FontSelectionActivity extends AppCompatActivity {

    ArrayList<Font> fontsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_selection);

        populateFontsList();

        ListView lv = (ListView) findViewById(R.id.fontListView);
        FontAdapter adapter = new FontAdapter(this, fontsArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row

                Intent output = new Intent();
                output.putExtra("Position", position);
//                output.putExtra(ActivityOne.Number2Code, num2);
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }

    void populateFontsList()
    {
        fontsArrayList = new Utilities().fontsArrayList(this);
    }
}
