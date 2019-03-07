package ru.imkovach.coloreffect;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorEffectFragment extends Fragment {

    private int colorId;

    private final static String THANKS_FRAGMENT_TAG = "GreateGUID";

    public void setColorEffect(int id) {

        this.colorId = id;

    }

    public ColorEffectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_color_effect, container, false);

        TextView description = view.findViewById(R.id.color_effect_description);

        description.setText(Color.colors[colorId].getColorEffect());

//        //Внимание!ChildFragmentManager!
//        FragmentManager fragmentManager = getChildFragmentManager();
//
//        // Ищем фрагмент по тегу, и если его нет, то создаем фрагмент с этим тегом
//        ThanksFragment thanksFragment = (ThanksFragment)
//                fragmentManager.findFragmentByTag(THANKS_FRAGMENT_TAG);
//        if (thanksFragment == null) {
//            FragmentTransaction fragmentTransaction =
//                    fragmentManager.beginTransaction();
//            thanksFragment = new ThanksFragment();
//            fragmentTransaction.replace(R.id.thanks_fragment_container,
//                    thanksFragment, THANKS_FRAGMENT_TAG);
//            fragmentTransaction.commit();
//        }

        // Возвращаем нашей Activity, в которой фрагмент и создается
        return view;
    }

}
