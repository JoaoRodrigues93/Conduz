package conduz.rodrigues.joaor.co.mz.conduz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExercicioFragment extends Fragment {

    public ExercicioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercicio, container, false);
    }
}
