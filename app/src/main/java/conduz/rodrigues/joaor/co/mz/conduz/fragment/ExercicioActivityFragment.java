package conduz.rodrigues.joaor.co.mz.conduz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Random;

import conduz.rodrigues.joaor.co.mz.conduz.R;


public class ExercicioActivityFragment extends Fragment {

    private LinearLayout llResposta1;
    private LinearLayout llResposta2;
    private LinearLayout llResposta3;
    private LinearLayout llResposta4;

    private TextView tvPergunta;
    private TextView tvResposta1;
    private TextView tvResposta2;
    private TextView tvResposta3;
    private TextView tvResposta4;

    private String pergunta;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String respostaCerta;

    public static final String PERGUNTA = "pergunta";
    public static final String RESPOSTA1 = "resposta1";
    public static final String RESPOSTA2 = "resposta2";
    public static final String RESPOSTA3 = "resposta3";
    public static final String RESPOSTA4 = "resposta4";
    public static final String RESPOSTA_CERTA = "respostaCerta";

    public ExercicioActivityFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questao, container, false);
        llResposta1 = (LinearLayout) view.findViewById(R.id.ll_resposta_1);
        llResposta2 = (LinearLayout) view.findViewById(R.id.ll_resposta_2);
        llResposta3 = (LinearLayout) view.findViewById(R.id.ll_resposta_3);
        llResposta4 = (LinearLayout) view.findViewById(R.id.ll_resposta_4);
        tvPergunta = (TextView) view.findViewById(R.id.tv_pergunta);
        tvResposta1 = (TextView) view.findViewById(R.id.tv_resposta_1);
        tvResposta2 = (TextView) view.findViewById(R.id.tv_resposta_1);
        tvResposta3 = (TextView) view.findViewById(R.id.tv_resposta_1);
        tvResposta4 = (TextView) view.findViewById(R.id.tv_resposta_1);

        Bundle arguments = getArguments();
        resposta1 = arguments.getString(RESPOSTA1);
        resposta2 = arguments.getString(RESPOSTA2);
        resposta3 = arguments.getString(RESPOSTA3);
        resposta4 = arguments.getString(RESPOSTA4);
        respostaCerta = arguments.getString(RESPOSTA_CERTA);
        pergunta = arguments.getString(PERGUNTA);

        setPerguntas();

        return view;
    }

    private void setPerguntas() {

        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                tvResposta1.setText(resposta2);
                tvResposta2.setText(resposta3);
                tvResposta3.setText(resposta4);
                tvResposta4.setText(resposta1);
                break;
            case 1:
                tvResposta1.setText(resposta3);
                tvResposta2.setText(resposta4);
                tvResposta3.setText(resposta1);
                tvResposta4.setText(resposta2);
                break;
            case 2:
                tvResposta1.setText(resposta4);
                tvResposta2.setText(resposta1);
                tvResposta3.setText(resposta2);
                tvResposta4.setText(resposta3);
                break;
            case 3:
                tvResposta1.setText(resposta1);
                tvResposta2.setText(resposta2);
                tvResposta3.setText(resposta3);
                tvResposta4.setText(resposta4);
                break;
            default:
                tvResposta1.setText(resposta2);
                tvResposta2.setText(resposta3);
                tvResposta3.setText(resposta1);
                tvResposta4.setText(resposta4);
                break;
        }
    }


}
