package conduz.rodrigues.joaor.co.mz.conduz.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class ModelFactory {

    private Context context;

    public ModelFactory(Context context) {
        this.context = context;
    }

    private LinkedList<Integer> imageResources() {
        LinkedList<Integer> imageResources = new LinkedList<>();
        imageResources.add(R.drawable.sample_1);
        imageResources.add(R.drawable.sample_2);
        imageResources.add(R.drawable.sample_3);
        imageResources.add(R.drawable.sample_4);
        imageResources.add(R.drawable.sample_5);
        imageResources.add(R.drawable.sample_6);
        imageResources.add(R.drawable.sample_7);
        imageResources.add(R.drawable.sample_8);
        imageResources.add(R.drawable.sample_9);
        imageResources.add(R.drawable.sample_10);
        imageResources.add(R.drawable.sample_11);
        imageResources.add(R.drawable.sample_12);
        imageResources.add(R.drawable.sample_13);
        imageResources.add(R.drawable.sample_14);
        imageResources.add(R.drawable.sample_15);

        return imageResources;
    }

    private LinkedList<Integer> iconeResources() {
        LinkedList<Integer> iconeResources = new LinkedList<>();

        iconeResources.add(R.drawable.a1);
        iconeResources.add(R.drawable.a2);
        iconeResources.add(R.drawable.a3);
        iconeResources.add(R.drawable.a4);
        iconeResources.add(R.drawable.a5);
        iconeResources.add(R.drawable.a6);
        iconeResources.add(R.drawable.a7);
        iconeResources.add(R.drawable.a8);
        iconeResources.add(R.drawable.a9);
        iconeResources.add(R.drawable.a10);
        iconeResources.add(R.drawable.a11);
        iconeResources.add(R.drawable.a12);
        iconeResources.add(R.drawable.a13);
        iconeResources.add(R.drawable.a14);
        iconeResources.add(R.drawable.a15);
        iconeResources.add(R.drawable.a16);
        iconeResources.add(R.drawable.a17);
        iconeResources.add(R.drawable.a18);
        iconeResources.add(R.drawable.a19);
        iconeResources.add(R.drawable.a20);


        return iconeResources;
    }

    public List<Capitulo> SampleCapitulo() {
        int id;
        Capitulo capitulo;

        String[] arrayCapitulos = context.getResources().getStringArray(R.array.capitulos_tema);

        List<Capitulo> capitulos = new ArrayList<Capitulo>();

        for (int i = 0; i < arrayCapitulos.length; i++) {
            capitulo = new Capitulo();
            capitulo.setId(i);
            capitulo.setNome(arrayCapitulos[i]);
            capitulos.add(capitulo);
        }

        return capitulos;
    }

    public List<Artigo> SampleArtigo(int seccao, int subtituloId, int tituloId) {
        int id;
        int numero;
        String titulo;
        String conteudo;

        String [] titulos;
        int [] numeros;
        String [] conteudos;

        if (subtituloId==0 && seccao ==0 && tituloId==0)
        {
            titulos = context.getResources().getStringArray(R.array.artigos_0_0_0_title);
            numeros = context.getResources().getIntArray(R.array.artigos_0_0_0_number);
            conteudos = context.getResources().getStringArray(R.array.artigos_0_0_0_content);
        }
        else
        {
            titulos = context.getResources().getStringArray(R.array.artigo_sample_title);
            numeros = context.getResources().getIntArray(R.array.artigo_sample_number);
            conteudos = context.getResources().getStringArray(R.array.artigo_sample_content);
        }

        Artigo artigo;
        List<Artigo> artigos = new ArrayList<Artigo>();

        for (int i = 0; i < titulos.length; i++) {
            id = (i);
            numero = numeros[i];
            titulo = titulos[i];
            conteudo = conteudos[i];
            artigo = new Artigo();
            artigo.setId(id);
            artigo.setNumero(numero);
            artigo.setTitulo(titulo);
            artigo.setConteudo(conteudo);

            artigos.add(artigo);
        }

        return artigos;
    }

    public List<Artigo> SampleArtigo(int cont) {
        int id;
        int numero;
        String titulo;
        String conteudo;

        Artigo artigo;
        List<Artigo> artigos = new ArrayList<Artigo>();

        for (int i = 0; i < 15; i++) {
            id = (i + 1);
            numero = (i + 1 + cont);
            titulo = "Título " + (i + 1 + cont);
            conteudo = "Aqui vai aparecer o conteúdo do artigo. " + (i + 1 + cont);
            artigo = new Artigo();
            artigo.setId(id);
            artigo.setNumero(numero);
            artigo.setTitulo(titulo);
            artigo.setConteudo(conteudo);

            artigos.add(artigo);
        }

        return artigos;
    }

    public List<ExameDoInatter> SampleExame() {
        int id;
        int numeroDeQuestoes;
        int numeroDeExame;
        return null;
    }

    public List<ExameAleatorio> SampleExameAleatorio() {
        int id;
        int numeroDeQuestoes;
        int numeroDeExame;

        return null;
    }

    public List<Quadro> SampleQuadro(int capituloId) {
        int id;
        String nome;
        int ordemDoQuadro;
        String descricao;

        int [] quadroArrays = {R.array.seccao_sinal_0,R.array.seccao_sinal_1,R.array.seccao_sinal_2,R.array.seccao_sinal_3,R.array.seccao_sinal_4,
                R.array.seccao_sinal_5,R.array.seccao_sinal_6,R.array.seccao_sinal_7,R.array.seccao_sinal_8,R.array.seccao_sinal_9,R.array.seccao_sinal_10};
        String [] quadroContent = context.getResources().getStringArray(quadroArrays[capituloId]);

        List<Quadro> quadros = new ArrayList<>();
        Quadro quadro;

        for (int i = 0; i < quadroContent.length; i++) {
            quadro = new Quadro();
            id = i;
            nome = quadroContent[i];
            ordemDoQuadro = i;
            quadro.setId(id);
            quadro.setNome(nome);
            quadro.setOrdemDoQuadro(ordemDoQuadro);

            quadros.add(quadro);
        }

        return quadros;
    }

    public List<Questao> SampleQuestao() {
        int id;
        String pergunta;
        String imagem;
        int [] imagemResources = {R.drawable.pergunta1,R.drawable.pergunta2,R.drawable.pergunta3,R.drawable.pergunta4,
                R.drawable.pergunta5,R.drawable.pergunta6,R.drawable.pergunta7,R.drawable.pergunta8,R.drawable.pergunta9,
                R.drawable.pergunta10,R.drawable.pergunta11};

        String [] perguntas = context.getResources().getStringArray(R.array.questao_pergunta);
        String [] respostas1 = context.getResources().getStringArray(R.array.questao_resposta1);
        String [] respostas2 = context.getResources().getStringArray(R.array.questao_resposta2);
        String [] respostas3 = context.getResources().getStringArray(R.array.questao_resposta3);
        String [] respostas4 = context.getResources().getStringArray(R.array.questao_resposta4);
        String [] respostasCerta = context.getResources().getStringArray(R.array.questao_resposta_correcta);

        int imagemResource;
        String opcao1;
        String opcao2;
        String opcao3;
        String opcao4;
        String opcaoCorrecta;

        List<Questao> questoes = new ArrayList<>();

        Questao questao;

        for (int i = 0; i < 10; i++) {
            questao = new Questao();
            id = i;
            imagemResource = R.drawable.a1;
            opcao1 = respostas1[i];
            opcao2 = respostas2[i];
            opcao3 = respostas3[i];
            opcao4 = respostas4[i];
            opcaoCorrecta =respostasCerta[i];
            pergunta = perguntas[i];
            imagemResource = imagemResources[i];
            questao.setId(id);
            questao.setOpcao1(opcao1);
            questao.setOpcao2(opcao2);
            questao.setOpcao3(opcao3);
            questao.setOpcao4(opcao4);
            questao.setOpcaoCorrecta(opcaoCorrecta);
            questao.setPergunta(pergunta);
            questao.setImagemResource(imagemResource);

            questao = questoesAleatorias(questao);
            questoes.add(questao);
        }

        return questoes;
    }

    private Questao questoesAleatorias(Questao questao) {
        String opcao1;
        String opcao2;
        String opcao3;
        String opcao4;
        opcao1 = questao.getOpcao1();
        opcao2 = questao.getOpcao2();
        opcao3 = questao.getOpcao3();
        opcao4 = questao.getOpcao4();

        int random = new Random().nextInt(4);

        switch (random) {
            case 0:
                questao.setOpcao1(opcao1);
                questao.setOpcao2(opcao2);
                questao.setOpcao3(opcao3);
                questao.setOpcao4(opcao4);
                break;
            case 1:
                questao.setOpcao1(opcao2);
                questao.setOpcao2(opcao3);
                questao.setOpcao3(opcao4);
                questao.setOpcao4(opcao1);
                break;
            case 2:
                questao.setOpcao1(opcao3);
                questao.setOpcao2(opcao4);
                questao.setOpcao3(opcao1);
                questao.setOpcao4(opcao2);
                break;
            case 3:
                questao.setOpcao1(opcao4);
                questao.setOpcao2(opcao1);
                questao.setOpcao3(opcao2);
                questao.setOpcao4(opcao3);
        }

        return questao;
    }

    public List<Regulamento> SampleRegulamento() {
        int id;
        String nome;
        String descricao;

        return null;
    }

    public List<Seccao> SampleSeccao(int subtituloId, int chapterId) {
        int id;
        String nome;
        String descricao;
        int ordemDaSeccao;

        Seccao seccao;
        String [] seccaoContent = context.getResources().getStringArray(getSubtituloArrayResource(subtituloId,chapterId));
        List<Seccao> seccaos = new ArrayList<Seccao>();

        for (int i = 0; i < seccaoContent.length; i++) {
            seccao = new Seccao();
            id = i;
            nome = seccaoContent[i];
            descricao = "Descrição " + (i + 1);
            ordemDaSeccao = i;

            seccao.setId(id);
            seccao.setNome(nome);
            seccao.setDescricao(descricao);
            seccao.setOrdemDaSeccao(ordemDaSeccao);
            seccaos.add(seccao);
        }

        return seccaos;
    }

    public List<Sinal> SampleSinal(int quadroId, int capituloId) {
        int id;
        String nome;
        String descricao;
        String codigo;
        int iconeResource;
        List<Sinal> sinais = new ArrayList<Sinal>();
        String [] sinaisTitleContent=null;
        String [] sinaisCodigoContent=null;
        String [] sinaisDescricaoContent=null;
        int [] sinaisIconeResourcesContent = null;
        int [] sinaisIconeResources00= {R.drawable.e1,R.drawable.e2,R.drawable.e8,R.drawable.e12,R.drawable.e17,R.drawable.e29,R.drawable.e30,
                R.drawable.e50};
        int [] sinaisIconeResources01 = {R.drawable.f1,R.drawable.f5,R.drawable.f6,R.drawable.f7,R.drawable.f11,R.drawable.f14,R.drawable.f17,R.drawable.f55};
        int [] sinaisTitle = {R.array.sinais_title_0_0,R.array.sinais_title_0_1};
        int [] sinaisCodigo = {R.array.sinais_codigo_0_0,R.array.sinais_codigo_0_1};
        int [] sinaisDescricao = {R.array.sinais_descricao_0_0,R.array.sinais_descricao_0_1};
        int [] sinaisIconeResources = {R.array.icone_resources_0_0,R.array.icone_resources_0_1};


        if(capituloId==0 && quadroId==0) {
            sinaisTitleContent = context.getResources().getStringArray(sinaisTitle[0]);
            sinaisCodigoContent = context.getResources().getStringArray(sinaisCodigo[0]);
            sinaisDescricaoContent = context.getResources().getStringArray(sinaisDescricao[0]);
            sinaisIconeResourcesContent = sinaisIconeResources00;
        }
        else if (capituloId==0 && quadroId==1){
            sinaisTitleContent = context.getResources().getStringArray(sinaisTitle[1]);
            sinaisCodigoContent = context.getResources().getStringArray(sinaisCodigo[1]);
            sinaisDescricaoContent = context.getResources().getStringArray(sinaisDescricao[1]);
            sinaisIconeResourcesContent = sinaisIconeResources01;
        }


        Sinal sinal;
        LinkedList<Integer> iconeResources = iconeResources();
        if(sinaisTitleContent!=null)
        for (int i = 0; i < sinaisTitleContent.length; i++) {
            sinal = new Sinal();
            id = i;
            nome = sinaisTitleContent[i];
            descricao = sinaisDescricaoContent[i];
            codigo = sinaisCodigoContent[i];
            iconeResource = sinaisIconeResourcesContent[i];

            sinal.setId(id);
            sinal.setCodigo(codigo);
            sinal.setDescricao(descricao);
            sinal.setIconeResource(iconeResource);
            sinal.setNome(nome);

            sinais.add(sinal);
        }

        return sinais;
    }

    public List<Subseccao> SampleSubseccao() {
        int id;
        String nome;
        String codigo;
        String descricao;
        String icone;
        String iconeResource;

        return null;
    }

    public List<Subtitulo> SampleSubtitulo(int tituloId) {
        int id;
        String nome;
        String descricao;
        int ordemDoSubtitulo;
        int [] arraySubtitulos = {R.array.subtitulo_0,R.array.subtitulo_1,R.array.subtitulo_2,R.array.subtitulo_3,R.array.subtitulo_4,R.array.subtitulo_5,
                R.array.subtitulo_6,R.array.subtitulo_7};

        String [] subtituloContent = context.getResources().getStringArray(arraySubtitulos[tituloId]);

        Subtitulo subtitulo;
        List<Subtitulo> subtitulos = new ArrayList<Subtitulo>();
        for (int i = 0; i < subtituloContent.length; i++) {
            subtitulo = new Subtitulo();
            id = i;
            nome = subtituloContent[i];
            descricao = "Descrição " + (i + 1);
            ordemDoSubtitulo = 0;

            subtitulo.setNome(nome);
            subtitulo.setDescricao(descricao);
            subtitulo.setId(id);
            subtitulo.setOrdemDaSubseccao(ordemDoSubtitulo);
            subtitulos.add(subtitulo);
        }

        return subtitulos;

    }

    public List<Tema> SampleTema(int chapterId) {
        int id;
        String nome;
        String icone;
        String conteudo;
        String tipo;
        int ordemDoTema;

        List<Integer> images = imageResources();

        int[] themesArray = {R.array.tema_0, R.array.tema_1, R.array.tema_2, R.array.tema_3, R.array.tema_4};
        int[] themesContentArray = {R.array.temas_0_content, R.array.temas_1_content, R.array.temas_2_content, R.array.temas_3_content, R.array.temas_4_content};

        String[] temasArray = context.getResources().getStringArray(themesArray[chapterId]);
        String[] temaContentArray = context.getResources().getStringArray(themesContentArray[chapterId]);
        List<Tema> temas = new ArrayList<Tema>();
        Tema tema;

        for (int i = 0; i < temasArray.length; i++) {
            tema = new Tema();

            tema.setId(i);
            tema.setNome(temasArray[i]);
            tema.setConteudo(temaContentArray[i]);
            tema.setTipo("simples");
            tema.setIconeResource(getThemeImageResource(i,chapterId));
            tema.setOrdemDoTema(i);
            temas.add(tema);

        }


        return temas;
    }

    public List<Titulo> SampleTitulo() {
        int id;
        String nome;
        String descricao;
        int ordemDoTitulo;
        String [] titulosArray = context.getResources().getStringArray(R.array.titulos);
        Titulo titulo;
        List<Titulo> titulos = new ArrayList<Titulo>();
        for (int i = 0; i < titulosArray.length; i++) {
            titulo = new Titulo();
            id = i;
            nome = titulosArray[i];
            descricao = "Descrição " + (i + 1);

            titulo.setNome(nome);
            titulo.setDescricao(descricao);
            titulo.setId(id);
            titulos.add(titulo);
        }

        return titulos;
    }

    public List<CapituloSinal> SampleCapituloSinal() {
        int id;
        CapituloSinal capitulo;

        String [] capituloArray = context.getResources().getStringArray(R.array.capitulo_sinal);

        List<CapituloSinal> capitulos = new ArrayList<CapituloSinal>();

        for (int i = 0; i <capituloArray.length; i++) {
            capitulo = new CapituloSinal();
            capitulo.setId(i);
            capitulo.setNome(capituloArray[i]);
            capitulo.setDescricao("Descrição " + i);
            capitulo.setOrdemDoCapitulo(i);
            capitulos.add(capitulo);
        }

        return capitulos;
    }

    private int getThemeImageResource(int temaId, int chapterId) {
        int[] imageResources0 = {R.drawable.sample_5, R.drawable.sample_4, R.drawable.sample_11, R.drawable.sample_3};
        int[] imageResources1 = {R.drawable.sample_5, R.drawable.sample_15, R.drawable.sample_5};
        int[] imageResources2 = {R.drawable.sample_8, R.drawable.sample_13, R.drawable.sample_3, R.drawable.sample_15};
        int[] imageResources3 = {R.drawable.sample_7, R.drawable.sample_8, R.drawable.sample_14};
        int[] imageResources4 = {R.drawable.sample_2, R.drawable.sample_14, R.drawable.sample_12};

        int resource = R.drawable.sample_1;
        switch (chapterId) {
            case 0:resource = imageResources0[temaId]; break;
            case 1:resource = imageResources1[temaId]; break;
            case 2:resource = imageResources2[temaId]; break;
            case 3:resource = imageResources3[temaId]; break;
            case 4:resource = imageResources4[temaId]; break;
        }

        return resource;
    }

    private int getSubtituloArrayResource (int subtituloId, int tituloId){
        int [] subtituleSeccao0 = {R.array.seccao_0_0};
        int [] subtituleSeccao1 = {R.array.seccao_1_0,R.array.seccao_1_1,R.array.seccao_1_2};
        int [] subtituleSeccao2 = {R.array.seccao_2_0};
        int [] subtituleSeccao3 = {R.array.seccao_3_0,R.array.seccao_3_1};
        int [] subtituleSeccao4 = {R.array.seccao_4_0};
        int [] subtituleSeccao5 = {R.array.seccao_5_0,R.array.seccao_5_1,R.array.seccao_5_2,R.array.seccao_5_3};
        int [] subtituleSeccao6 = {R.array.seccao_6_0,R.array.seccao_6_1};
        int [] subtituleSeccao7 = {R.array.seccao_7_0,R.array.seccao_7_1,R.array.seccao_7_2,R.array.seccao_7_3};

        int resource = R.array.seccao_0_0;

        switch (tituloId){
            case 0: resource = subtituleSeccao0[subtituloId]; break;
            case 1: resource = subtituleSeccao1[subtituloId]; break;
            case 2: resource = subtituleSeccao2[subtituloId]; break;
            case 3: resource = subtituleSeccao3[subtituloId]; break;
            case 4: resource = subtituleSeccao4[subtituloId]; break;
            case 5: resource = subtituleSeccao5[subtituloId]; break;
            case 6: resource = subtituleSeccao6[subtituloId]; break;
            case 7: resource = subtituleSeccao7[subtituloId]; break;
        }

        return  resource;
    }

    private int getArtigoResource (int seccao, int subtituloId, int titulo){
        String [] titulos;
        String [] numeros;
        String [] conteudo;

        if (subtituloId==0 && seccao ==0 && titulo==0)
        {
            titulos = context.getResources().getStringArray(R.array.artigos_0_0_0_title);
            numeros = context.getResources().getStringArray(R.array.artigos_0_0_0_number);
            conteudo = context.getResources().getStringArray(R.array.artigos_0_0_0_content);
        }
        else
        {
            titulos = context.getResources().getStringArray(R.array.artigo_sample_title);
            numeros = context.getResources().getStringArray(R.array.artigo_sample_number);
            conteudo = context.getResources().getStringArray(R.array.artigo_sample_content);
        }

        return 0;
    }
}