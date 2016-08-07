package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import conduz.rodrigues.joaor.co.mz.conduz.fragment.CodigoFragment;
import conduz.rodrigues.joaor.co.mz.conduz.fragment.PraticaFragment;
import conduz.rodrigues.joaor.co.mz.conduz.fragment.SinalFragment;
import conduz.rodrigues.joaor.co.mz.conduz.fragment.TeoriaFragment;

/**
 * Created by João Rodrigues on 6/19/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return TeoriaFragment.newInstance(null,null);
            case 1:
                return CodigoFragment.newInstance(null,null);
            case 2:
                return SinalFragment.newInstance(null,null);
            case 3:
                return PraticaFragment.newInstance(null,null);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TEÓRIA";
            case 1:
                return "CÓDIGO";
            case 2:
                return "SINAIS";
            case 3:
                return "PRÁTICA";
        }
        return null;
    }
}
