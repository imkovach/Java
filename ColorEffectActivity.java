package ru.imkovach.coloreffect;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorEffectActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR_ID = "colorId";

    public ColorEffectActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_effect);
        int colorID = getIntent().getIntExtra(EXTRA_COLOR_ID, 0);

        ColorEffectFragment colorEffectFragment = new ColorEffectFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        colorEffectFragment.setColorEffect(colorID);
        transaction.add(R.id.color_effect_fragment_container, colorEffectFragment);
        transaction.commit();
    }
}
