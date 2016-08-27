package conduz.rodrigues.joaor.co.mz.conduz;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by João Rodrigues on 8/19/2016.
 */
public class Utility {

    public static int calculateNoOfColumns (Context context,int minimumWidth){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float width = displayMetrics.widthPixels / displayMetrics.density;
        width = width - 32;
        int noOfcolumns = (int)width /minimumWidth;

        return noOfcolumns;
    }
}
