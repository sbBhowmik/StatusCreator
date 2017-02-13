package com.rupik.fbstatuscreator;

import android.graphics.Typeface;

/**
 * Created by macmin5 on 13/02/17.
 */

public class Font {
    String fontName;
    Typeface fontTypeface;

    public Font(String fName, Typeface fTypeface)
    {
        fontName = fName;
        fontTypeface = fTypeface;
    }

    public String getFontName() {
        return fontName;
    }

    public Typeface getFontTypeface() {
        return fontTypeface;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontTypeface(Typeface fontTypeface) {
        this.fontTypeface = fontTypeface;
    }
}
