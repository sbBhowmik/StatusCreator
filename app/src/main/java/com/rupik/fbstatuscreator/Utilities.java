package com.rupik.fbstatuscreator;

import android.content.Context;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by macmin5 on 13/02/17.
 */

public class Utilities {


    public ArrayList<Font> fontsArrayList(Context context)
    {
        ArrayList<Font> fontsArrayList = new ArrayList<>();

        Font font = new Font("robotoThin", EasyFonts.robotoThin(context));
        fontsArrayList.add(font);
        font = new Font("robotoItalic", EasyFonts.robotoItalic(context));
        fontsArrayList.add(font);
        font = new Font("robotoBlack", EasyFonts.robotoBlack(context));
        fontsArrayList.add(font);
        font = new Font("robotoBlackItalic", EasyFonts.robotoBlackItalic(context));
        fontsArrayList.add(font);
        font = new Font("robotoBlackItalic", EasyFonts.robotoBold(context));
        fontsArrayList.add(font);
        font = new Font("robotoBlackItalic", EasyFonts.robotoBoldItalic(context));
        fontsArrayList.add(font);

        return fontsArrayList;

    }

    public int[] populateBgDataset()
    {
        int bgDataset[] = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5, R.drawable.bg6, R.drawable.bg7};
        return bgDataset;
    }
}
