package conduz.rodrigues.joaor.co.mz.conduz.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Random;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.ExameActivity;
import conduz.rodrigues.joaor.co.mz.conduz.model.Exame;


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

    private TextView tvAlinea1;
    private TextView tvAlinea2;
    private TextView tvAlinea3;
    private TextView tvAlinea4;

    private ImageView ivImagem;
    private Button enviarResposta;
    private int selectedAnswerIndex;


    private String pergunta;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String respostaCerta;
    private int imageResource;
    private int indiceDaPergunta;

    public static final String PERGUNTA = "pergunta";
    public static final String RESPOSTA1 = "resposta1";
    public static final String RESPOSTA2 = "resposta2";
    public static final String RESPOSTA3 = "resposta3";
    public static final String RESPOSTA4 = "resposta4";
    public static final String RESPOSTA_CERTA = "respostaCerta";
    public static final String IMAGE_RESOURCE = "imageResource";
    public static final String INDICE_PERGUNTA = "indicePergunta";

    private boolean showCorrectAnswer;
    private String selectedAnswerValue;
    private LinearLayout selectedAnswer;
    private TextView selectAnswerText;
    private TextView selectedAlinea;

    private View.OnClickListener answerOnClickListene1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickAnswer(0);
        }
    };

    private View.OnClickListener answerOnClickListene2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickAnswer(1);
        }
    };

    private View.OnClickListener answerOnClickListene3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickAnswer(2);
        }
    };

    private View.OnClickListener answerOnClickListene4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickAnswer(3);
        }
    };

    private Button.OnClickListener enviarRespostaClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            enviarResposta();
        }
    };

    private void enviarResposta() {
        ExameActivity exameActivity = (ExameActivity) getActivity();
        exameActivity.sendAnswer();
    }

    private void onClickAnswer(int selectedAnswerIn) {
        if (selectedAnswer != null) {
            selectedAnswer.setBackgroundColor(Color.WHITE);
            selectAnswerText.setTextColor(getContext().getResources().getColor(R.color.body));
            selectAnswerText.setTypeface(null, Typeface.NORMAL);
            selectedAlinea.setTypeface(null, Typeface.NORMAL);
        }
        selectedAnswerIndex = selectedAnswerIn;
        selectedAnswerValue = null;

        switch (selectedAnswerIn) {
            case 0:
                selectedAnswer = llResposta1;
                selectAnswerText = tvResposta1;
                selectedAlinea = tvAlinea1;
                selectedAnswerValue = resposta1;
                break;
            case 1:
                selectedAnswer = llResposta2;
                selectAnswerText = tvResposta2;
                selectedAlinea = tvAlinea2;
                selectedAnswerValue = resposta2;
                break;
            case 2:
                selectedAnswer = llResposta3;
                selectAnswerText = tvResposta3;
                selectedAlinea = tvAlinea3;
                selectedAnswerValue = resposta3;
                break;
            case 3:
                selectedAnswer = llResposta4;
                selectAnswerText = tvResposta4;
                selectedAlinea = tvAlinea4;
                selectedAnswerValue = resposta4;
                break;
        }


        selectedAnswer.setBackground(getResources().getDrawable(R.drawable.option_choosen));
        selectAnswerText.setTextColor(Color.WHITE);
        selectAnswerText.setTypeface(null, Typeface.BOLD);
        selectedAlinea.setTypeface(null, Typeface.BOLD);

        setSelectedAnswer(selectedAnswerIn, selectedAnswerValue);

    }

    private void setSelectedAnswer(int option, String answer) {
        ExameActivity exameActivity = (ExameActivity) getActivity();
        exameActivity.setChoosenOption(indiceDaPergunta, option + 1, answer);
    }

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
        setListeners();
        tvPergunta = (TextView) view.findViewById(R.id.tv_pergunta);
        tvResposta1 = (TextView) view.findViewById(R.id.tv_resposta_1);
        tvResposta2 = (TextView) view.findViewById(R.id.tv_resposta_2);
        tvResposta3 = (TextView) view.findViewById(R.id.tv_resposta_3);
        tvResposta4 = (TextView) view.findViewById(R.id.tv_resposta_4);
        tvAlinea1 = (TextView) view.findViewById(R.id.tv_alinea_1);
        tvAlinea2 = (TextView) view.findViewById(R.id.tv_alinea_2);
        tvAlinea3 = (TextView) view.findViewById(R.id.tv_alinea_3);
        tvAlinea4 = (TextView) view.findViewById(R.id.tv_alinea_4);
        ivImagem = (ImageView) view.findViewById(R.id.iv_pergunta_imagem);
        enviarResposta = (Button) view.findViewById(R.id.bt_enviar_resposta);
        enviarResposta.setOnClickListener(enviarRespostaClickListener);

        Bundle arguments = getArguments();
        resposta1 = arguments.getString(RESPOSTA1);
        resposta2 = arguments.getString(RESPOSTA2);
        resposta3 = arguments.getString(RESPOSTA3);
        resposta4 = arguments.getString(RESPOSTA4);
        respostaCerta = arguments.getString(RESPOSTA_CERTA);
        pergunta = arguments.getString(PERGUNTA);
        imageResource = arguments.getInt(IMAGE_RESOURCE);
        respostaCerta = arguments.getString(RESPOSTA_CERTA);
        indiceDaPergunta = arguments.getInt(INDICE_PERGUNTA);

        setPerguntas();

        return view;
    }

    private void setListeners() {
        llResposta1.setOnClickListener(answerOnClickListene1);
        llResposta2.setOnClickListener(answerOnClickListene2);
        llResposta3.setOnClickListener(answerOnClickListene3);
        llResposta4.setOnClickListener(answerOnClickListene4);
    }

    private void setPerguntas() {
        tvPergunta.setText(pergunta);
        tvResposta1.setText(resposta1);
        tvResposta2.setText(resposta2);
        tvResposta3.setText(resposta3);
        tvResposta4.setText(resposta4);
        ivImagem.setImageResource(imageResource);

        int selectedOption = ((ExameActivity) getActivity()).getChoosenOption(indiceDaPergunta);
        if (selectedOption > 0)
            onClickAnswer(selectedOption - 1);
    }


    public void showCorrectAndCorrectAnswers() {
        if (selectedAnswerValue.equalsIgnoreCase(respostaCerta)) {
            selectedAnswer.setBackground(getContext().getResources().getDrawable(R.drawable.right_option_choosen));
            selectedAlinea.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_right));
        } else {
            selectedAnswer.setBackground(getContext().getResources().getDrawable(R.drawable.wrong_option_choosen));
            selectedAlinea.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_wrong));
            if (respostaCerta.equalsIgnoreCase(resposta1)) {
                llResposta1.setBackground(getContext().getResources().getDrawable(R.drawable.right_option_choosen));
                tvAlinea1.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_right));
            } else if (respostaCerta.equalsIgnoreCase(resposta2)) {
                llResposta2.setBackground(getContext().getResources().getDrawable(R.drawable.right_option_choosen));
                tvAlinea2.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_right));
            } else if (respostaCerta.equalsIgnoreCase(resposta3)) {
                llResposta3.setBackground(getContext().getResources().getDrawable(R.drawable.right_option_choosen));
                tvAlinea3.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_right));
            } else if (respostaCerta.equalsIgnoreCase(resposta4)) {
                llResposta4.setBackground(getContext().getResources().getDrawable(R.drawable.right_option_choosen));
                tvAlinea4.setBackground(getContext().getResources().getDrawable(R.drawable.exame_circle_right));
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        ExameActivity exameActivity = (ExameActivity) getActivity();
        if (exameActivity.showCorrectAnswers())
            showCorrectAndCorrectAnswers();
    }
}
