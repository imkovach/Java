package ru.imkovach.coloreffect;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ColorListFragment.ColorListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] color_selection = getApplicationContext().getResources().getStringArray(R.array.color_selection);
        String[] effect = getApplicationContext().getResources().getStringArray(R.array.effect);

        int colorsCount = color_selection.length;
        Color.colors = new Color[colorsCount];
        for(int i = 0; i <colorsCount; i++)
            Color.colors[i] = new Color(color_selection[i], effect[i]);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int id = R.string.undefined;
        switch (newConfig.orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                id = R.string.landscape;
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                id = R.string.portrait;
                break;
        }
        Resources res = getResources();
        Toast.makeText(this, res.getString(R.string.orientation, res.getString(id)),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(int id) {
        // Находим Layout
        View fragmentContainer = findViewById(R.id.color_effect_fragment_container);

        // Проверяем: если он не null, значит у нас загружен макет для больших экранов
        // и мы можем показывать два фрагмента рядом
        if (fragmentContainer != null) {
            ColorEffectFragment detailFragment = new ColorEffectFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            detailFragment.setColorEffect(id);
            transaction.addToBackStack(null);
            transaction.replace(R.id.color_effect_fragment_container, detailFragment);
            transaction.commit();
        }
        else {
            // Если же R.id.fragment_container == null, значит у нас загружен макет для маленьких экранов
            // и детали мы открываем в отдельной Activity
            Intent intent = new Intent(this, ColorEffectActivity.class);
            // Передаем нужный id через Intent
            intent.putExtra(ColorEffectActivity.EXTRA_COLOR_ID, id);
            startActivity(intent);
        }
    }


}
