package com.rupik.fbstatuscreator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import com.example.fontometrics.Fontometrics;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by macmin5 on 13/02/17.
 */

public class Utilities {


    public GradientDrawable getDrawableButtonBg1(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#f4aa42"), Color.parseColor("#f48642"), Color.parseColor("#f46242"), Color.parseColor("#f45642") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg2(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#f44248"), Color.parseColor("#f4426b"), Color.parseColor("#f4427d"), Color.parseColor("#f442a1") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg3(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#f442a1"), Color.parseColor("#a82d85"), Color.parseColor("#a82d99"), Color.parseColor("#a42da8") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg4(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#a42da8"), Color.parseColor("#832da8"), Color.parseColor("#6a2da8"), Color.parseColor("#502da8") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg5(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#2d2da8"), Color.parseColor("#2d50a8"), Color.parseColor("#2d6ca8"), Color.parseColor("#2d85a8") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg6(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#2d9ea8"), Color.parseColor("#2da88f"), Color.parseColor("#2da86e"), Color.parseColor("#2da852") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public GradientDrawable getDrawableButtonBg7(boolean isSelected, boolean isForButton)
    {
        int colors[] = { Color.parseColor("#54a82d"), Color.parseColor("#7da82d"), Color.parseColor("#9ea82d"), Color.parseColor("#a8832d") };

        GradientDrawable gd = new GradientDrawable();
        if(isForButton) {
            gd.setShape(GradientDrawable.OVAL);
        }
        else {
            gd.setShape(GradientDrawable.RECTANGLE);
        }
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);

        if(isSelected) {
            gd.setStroke(5, Color.BLACK);
        }

        return gd;
    }

    public ArrayList<Font> fontsArrayList(Context context)
    {
        ArrayList<Font> fontsArrayList = new ArrayList<>();



        Font font = new Font("Roboto Thin", EasyFonts.robotoThin(context));
        fontsArrayList.add(font);

        ///=======Fontometrics
        font = new Font("Admiration Pains", Fontometrics.admiration_pains(context));
        fontsArrayList.add(font);

        font = new Font("Amatic Bold", Fontometrics.amatic_bold(context));
        fontsArrayList.add(font);

        font = new Font("Amatic_Regular", Fontometrics.amatic_regular(context));
        fontsArrayList.add(font);

        font = new Font("Back Black", Fontometrics.back_black(context));
        fontsArrayList.add(font);

        font = new Font("Bella Donna", Fontometrics.bella_donna(context));
        fontsArrayList.add(font);

        font = new Font("Christians United", Fontometrics.christians_united(context));
        fontsArrayList.add(font);

        font = new Font("Electricity", Fontometrics.electricity(context));
        fontsArrayList.add(font);

        font = new Font("Elephant", Fontometrics.elephant(context));
        fontsArrayList.add(font);

        font = new Font("Eyes Wide", Fontometrics.eyes_wide(context));
        fontsArrayList.add(font);

        font = new Font("Labataille", Fontometrics.la_bataille(context));
        fontsArrayList.add(font);

        font = new Font("My Big Heart", Fontometrics.mybigheart(context));
        fontsArrayList.add(font);

        font = new Font("My Epicselfie", Fontometrics.myepicselfie(context));
        fontsArrayList.add(font);

        font = new Font("Pacifico", Fontometrics.pacifico(context));
        fontsArrayList.add(font);

        font = new Font("Ricard Crime", Fontometrics.ricard_crime(context));
        fontsArrayList.add(font);

        font = new Font("Safira Shine", Fontometrics.safira_shine(context));
        fontsArrayList.add(font);

        font = new Font("Seasrn", Fontometrics.seasrn(context));
        fontsArrayList.add(font);

        font = new Font("Sentimental", Fontometrics.sentimental(context));
        fontsArrayList.add(font);

        font = new Font("Too Freakin Cute", Fontometrics.too_freakin_cute(context));
        fontsArrayList.add(font);

        font = new Font("The Quest", Fontometrics.the_quest(context));
        fontsArrayList.add(font);

        font = new Font("Tunderstrike 3d", Fontometrics.tunderstrike3d(context));
        fontsArrayList.add(font);



        //----------

        font = new Font("Roboto Italic", EasyFonts.robotoItalic(context));
        fontsArrayList.add(font);
        font = new Font("Roboto Black", EasyFonts.robotoBlack(context));
        fontsArrayList.add(font);
        font = new Font("Roboto Black Italic", EasyFonts.robotoBlackItalic(context));
        fontsArrayList.add(font);
        font = new Font("Roboto Bold", EasyFonts.robotoBold(context));
        fontsArrayList.add(font);
        font = new Font("Roboto Bold Italic", EasyFonts.robotoBoldItalic(context));
        fontsArrayList.add(font);

        //

        font = new Font("Recognition", EasyFonts.recognition(context));
        fontsArrayList.add(font);

        font = new Font("Android Nation", EasyFonts.androidNation(context));
        fontsArrayList.add(font);

        font = new Font("Android Nation Bold", EasyFonts.androidNationBold(context));
        fontsArrayList.add(font);

        font = new Font("Android Nation Italic", EasyFonts.androidNationItalic(context));
        fontsArrayList.add(font);

        font = new Font("Freedom", EasyFonts.freedom(context));
        fontsArrayList.add(font);

        font = new Font("Droid Robot", EasyFonts.droidRobot(context));
        fontsArrayList.add(font);

        font = new Font("Fun Raiser", EasyFonts.funRaiser(context));
        fontsArrayList.add(font);

        font = new Font("Green Avocado", EasyFonts.greenAvocado(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Black", EasyFonts.walkwayBlack(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Bold", EasyFonts.walkwayBold(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Oblique", EasyFonts.walkwayOblique(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Oblique Black", EasyFonts.walkwayObliqueBlack(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Oblique Semi Bold", EasyFonts.walkwayObliqueSemiBold(context));
        fontsArrayList.add(font);

        font = new Font("Walkway Oblique Ultra Bold", EasyFonts.walkwayObliqueUltraBold(context));
        fontsArrayList.add(font);

        font = new Font("Wind Song", EasyFonts.windSong(context));
        fontsArrayList.add(font);

        font = new Font("Tangerine Regular", EasyFonts.tangerineRegular(context));
        fontsArrayList.add(font);

        font = new Font("Tangerine Bold", EasyFonts.tangerineBold(context));
        fontsArrayList.add(font);

        font = new Font("Ostrich Black", EasyFonts.ostrichBlack(context));
        fontsArrayList.add(font);

        font = new Font("Ostrich Bold", EasyFonts.ostrichBold(context));
        fontsArrayList.add(font);

        font = new Font("Caviar Dreams Bold", EasyFonts.caviarDreamsBold(context));
        fontsArrayList.add(font);

        font = new Font("Caviar Dreams Bold Italic", EasyFonts.caviarDreamsBoldItalic(context));
        fontsArrayList.add(font);

        font = new Font("Capture It", EasyFonts.captureIt(context));
        fontsArrayList.add(font);

        font = new Font("Capture It2", EasyFonts.captureIt2(context));
        fontsArrayList.add(font);

        font = new Font("Cac Champagne", EasyFonts.cac_champagne(context));
        fontsArrayList.add(font);



        return fontsArrayList;

    }

    public int[] populateBgDataset()
    {
        int bgDataset[] = {R.drawable.bg_40, R.drawable.bg_39, R.drawable.bg_38, R.drawable.bg_37, R.drawable.bg_36, R.drawable.bg_35, R.drawable.bg_34, R.drawable.bg_33, R.drawable.bg_32, R.drawable.bg_31, R.drawable.bg_30, R.drawable.bg_29, R.drawable.bg_28, R.drawable.bg_27, R.drawable.bg_26, R.drawable.bg_25, R.drawable.bg_24, R.drawable.bg_23, R.drawable.bg_22, R.drawable.bg_21, R.drawable.bg_20, R.drawable.bg_19, R.drawable.bg_18, R.drawable.bg_17, R.drawable.bg_16, R.drawable.bg_15, R.drawable.bg_14, R.drawable.bg_13, R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5, R.drawable.bg6, R.drawable.bg7,R.drawable.bg8,R.drawable.bg9,R.drawable.bg10,R.drawable.bg11,R.drawable.bg12};
        return bgDataset;
    }
}
