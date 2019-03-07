package ru.imkovach.coloreffect;

public class Color {

    public static Color[] colors;

    private final String colorName;
    private final String colorEffect;

    public String getColorName() {
        return colorName;
    }

    public String getColorEffect() {
        return colorEffect;
    }

    public Color(String colorName, String colorEffect) {
        this.colorName = colorName;
        this.colorEffect = colorEffect;
    }
}
