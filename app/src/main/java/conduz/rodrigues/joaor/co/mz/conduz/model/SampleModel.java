package conduz.rodrigues.joaor.co.mz.conduz.model;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class SampleModel {

    private Context context;

    public SampleModel() {
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
        String nome;
        String descricao;
        int ordemDoCapitulo;
        Capitulo capitulo;

        List<Capitulo> capitulos = new ArrayList<Capitulo>();

        for (int i = 1; i <= 10; i++) {
            capitulo = new Capitulo();
            capitulo.setId(i);
            capitulo.setNome("Capítulo " + i);
            capitulo.setDescricao("Descrição " + i);
            capitulo.setOrdemDoCapitulo(i);
            capitulos.add(capitulo);
        }

        return capitulos;
    }

    public List<Artigo> SampleArtigo() {
        int id;
        int numero;
        String titulo;
        String conteudo;

        Artigo artigo;
        List<Artigo> artigos = new ArrayList<Artigo>();

        for (int i = 0; i < 15; i++) {
            id = (i + 1);
            numero = (i + 1);
            titulo = "Título " + (i + 1);
            conteudo = "Aqui vai aparecer o conteúdo do artigo. " + (i + 1);
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

    public List<Quadro> SampleQuadro() {
        int id;
        String nome;
        int ordemDoQuadro;
        String descricao;
        List<Quadro> quadros = new ArrayList<>();
        Quadro quadro;

        for (int i = 0; i < 10; i++) {
            quadro = new Quadro();
            id = (i + 1);
            nome = "Quadro " + (i + 1);
            ordemDoQuadro = i;
            descricao = "Descrição" + (i + 1);
            quadro.setId(id);
            quadro.setNome(nome);
            quadro.setDescricao(descricao);
            quadro.setOrdemDoQuadro(ordemDoQuadro);

            quadros.add(quadro);
        }

        return quadros;
    }

    public List<Questao> SampleQuestao() {
        int id;
        String pergunta;
        String imagem;
        int imagemResource;
        String opcao1;
        String opcao2;
        String opcao3;
        String opcao4;
        String opcaoCorrecta;

        List<Questao> questoes = new ArrayList<>();

        Questao questao;

        for (int i = 0; i < 25; i++) {
            questao = new Questao();
            id = (i + 1);
            imagemResource = R.drawable.a1;
            opcao1 = "Opção 1"+i;
            opcao2 = "Opção 2"+i;
            opcao3 = "Opção 3"+i;
            opcao4 = "Opção 4"+i;
            opcaoCorrecta = "Opção 2"+i;
            pergunta = "Esta é a "+(i+1)+"a pergunta .";
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

    public List<Seccao> SampleSeccao() {
        int id;
        String nome;
        String descricao;
        int ordemDaSeccao;

        Seccao seccao;

        List<Seccao> seccaos = new ArrayList<Seccao>();

        for (int i = 0; i < 20; i++) {
            seccao = new Seccao();
            id = (i + 1);
            nome = "Secção " + (i + 1);
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

    public List<Sinal> SampleSinal() {
        int id;
        String nome;
        String descricao;
        String codigo;
        int iconeResource;
        List<Sinal> sinais = new ArrayList<Sinal>();
        Sinal sinal;
        LinkedList<Integer> iconeResources = iconeResources();

        for (int i = 0; i < 10; i++) {
            sinal = new Sinal();
            id = (i + 1);
            nome = "Sinal " + (i + 1);
            descricao = "Está será uma descrição do sinal. " + (i + 1);
            codigo = "A" + (i + 1);
            iconeResource = iconeResources.pop();
            iconeResources.addLast(iconeResource);

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

    public List<Subtitulo> SampleSubtitulo() {
        int id;
        String nome;
        String descricao;
        int ordemDoSubtitulo;

        Subtitulo subtitulo;
        List<Subtitulo> subtitulos = new ArrayList<Subtitulo>();
        for (int i = 0; i < 15; i++) {
            subtitulo = new Subtitulo();
            id = (i + 1);
            nome = "Capítulo " + (i + 1);
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

    public List<Tema> SampleTema() {
        int id;
        String nome;
        String icone;
        String conteudo;
        String tipo;
        int ordemDoTema;

        List<Integer> images = imageResources();

        List<Tema> temas = new ArrayList<Tema>();
        Tema tema;

        for (int i = 1; i < 6; i++) {
            tema = new Tema();

            tema.setId(i);
            tema.setNome("Tema " + i);
            tema.setConteudo("\"Material is the metaphor.\\n\\n\"+\n" +
                    "\n" +
                    "            \"A material metaphor is the unifying theory of a rationalized space and a system of motion.\"+\n" +
                    "            \"The material is grounded in tactile reality, inspired by the study of paper and ink, yet \"+\n" +
                    "            \"technologically advanced and open to imagination and magic.\\n\"+\n" +
                    "            \"Surfaces and edges of the material provide visual cues that are grounded in reality. The \"+\n" +
                    "            \"use of familiar tactile attributes helps users quickly understand affordances. Yet the \"+\n" +
                    "            \"flexibility of the material creates new affordances that supercede those in the physical \"+\n" +
                    "            \"world, without breaking the rules of physics.\\n\"+\n" +
                    "            \"The fundamentals of light, surface, and movement are key to conveying how objects move, \"+\n" +
                    "            \"interact, and exist in space and in relation to each other. Realistic lighting shows \"+\n" +
                    "            \"seams, divides space, and indicates moving parts.\\n\\n\"+\n" +
                    "            \"Bold, graphic, intentional.\\n\\n\"+\n" +
                    "            \"The foundational elements of print based design typography, grids, space, scale, color, \"+\n" +
                    "            \"and use of imagery guide visual treatments. These elements do far more than please the \"+\n" +
                    "            \"eye. They create hierarchy, meaning, and focus. Deliberate color choices, edge to edge \"+\n" +
                    "            \"imagery, large scale typography, and intentional white space create a bold and graphic \"+\n" +
                    "            \"interface that immerse the user in the experience.\\n\"+\n" +
                    "            \"An emphasis on user actions makes core functionality immediately apparent and provides \"+\n" +
                    "            \"waypoints for the user.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Motion provides meaning.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Motion respects and reinforces the user as the prime mover. Primary user actions are \"+\n" +
                    "            \"inflection points that initiate motion, transforming the whole design.\\n\"+\n" +
                    "            \"All action takes place in a single environment. Objects are presented to the user without \"+\n" +
                    "            \"breaking the continuity of experience even as they transform and reorganize.\\n\"+\n" +
                    "            \"Motion is meaningful and appropriate, serving to focus attention and maintain continuity. \"+\n" +
                    "            \"Feedback is subtle yet clear. Transitions are efﬁcient yet coherent.\\n\\n\"+\n" +
                    "            \"3D world.\\n\\n\"+\n" +
                    "\n" +
                    "            \"The material environment is a 3D space, which means all objects have x, y, and z \"+\n" +
                    "            \"dimensions. The z-axis is perpendicularly aligned to the plane of the display, with the \"+\n" +
                    "            \"positive z-axis extending towards the viewer. Every sheet of material occupies a single \"+\n" +
                    "            \"position along the z-axis and has a standard 1dp thickness.\\n\"+\n" +
                    "            \"On the web, the z-axis is used for layering and not for perspective. The 3D world is \"+\n" +
                    "            \"emulated by manipulating the y-axis.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Light and shadow.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Within the material environment, virtual lights illuminate the scene. Key lights create \"+\n" +
                    "            \"directional shadows, while ambient light creates soft shadows from all angles.\\n\"+\n" +
                    "            \"Shadows in the material environment are cast by these two light sources. In Android \"+\n" +
                    "            \"development, shadows occur when light sources are blocked by sheets of material at \"+\n" +
                    "            \"various positions along the z-axis. On the web, shadows are depicted by manipulating the \"+\n" +
                    "            \"y-axis only. The following example shows the card with a height of 6dp.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Resting elevation.\\n\\n\"+\n" +
                    "\n" +
                    "            \"All material objects, regardless of size, have a resting elevation, or default elevation \"+\n" +
                    "            \"that does not change. If an object changes elevation, it should return to its resting \"+\n" +
                    "            \"elevation as soon as possible.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Component elevations.\\n\\n\"+\n" +
                    "\n" +
                    "            \"The resting elevation for a component type is consistent across apps (e.g., FAB elevation \"+\n" +
                    "            \"does not vary from 6dp in one app to 16dp in another app).\\n\"+\n" +
                    "            \"Components may have different resting elevations across platforms, depending on the depth \"+\n" +
                    "            \"of the environment (e.g., TV has a greater depth than mobile or desktop).\\n\\n\"+\n" +
                    "\n" +
                    "            \"Responsive elevation and dynamic elevation offsets.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Some component types have responsive elevation, meaning they change elevation in response \"+\n" +
                    "            \"to user input (e.g., normal, focused, and pressed) or system events. These elevation \"+\n" +
                    "            \"changes are consistently implemented using dynamic elevation offsets.\\n\"+\n" +
                    "            \"Dynamic elevation offsets are the goal elevation that a component moves towards, relative \"+\n" +
                    "            \"to the component’s resting state. They ensure that elevation changes are consistent \"+\n" +
                    "            \"across actions and component types. For example, all components that lift on press have \"+\n" +
                    "            \"the same elevation change relative to their resting elevation.\\n\"+\n" +
                    "            \"Once the input event is completed or cancelled, the component will return to its resting \"+\n" +
                    "            \"elevation.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Avoiding elevation interference.\\n\\n\"+\n" +
                    "\n" +
                    "            \"Components with responsive elevations may encounter other components as they move between \"+\n" +
                    "            \"their resting elevations and dynamic elevation offsets. Because material cannot pass \"+\n" +
                    "            \"through other material, components avoid interfering with one another any number of ways, \"+\n" +
                    "            \"whether on a per component basis or using the entire app layout.\\n\"+\n" +
                    "            \"On a component level, components can move or be removed before they cause interference. \"+\n" +
                    "            \"For example, a floating action button (FAB) can disappear or move off screen before a \"+\n" +
                    "            \"user picks up a card, or it can move if a snackbar appears.\\n\"+\n" +
                    "            \"On the layout level, design your app layout to minimize opportunities for interference. \"+\n" +
                    "            \"For example, position the FAB to one side of stream of a cards so the FAB won’t interfere \"+\n" +
                    "            \"when a user tries to pick up one of cards.\\n\\n\"");
            tema.setTipo("simples");
            tema.setIconeResource(imageResources().get(i));
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

        Titulo titulo;
        List<Titulo> titulos = new ArrayList<Titulo>();
        for (int i = 0; i < 10; i++) {
            titulo = new Titulo();
            id = (i + 1);
            nome = "Titulo " + (i + 1);
            descricao = "Descrição " + (i + 1);
            ordemDoTitulo = 0;

            titulo.setNome(nome);
            titulo.setDescricao(descricao);
            titulo.setId(id);
            titulo.setOrdemDoTitulo(ordemDoTitulo);
            titulos.add(titulo);
        }

        return titulos;
    }

    public List<CapituloSinal> SampleCapituloSinal() {
        int id;
        String nome;
        String descricao;
        int ordemDoCapitulo;
        CapituloSinal capitulo;

        List<CapituloSinal> capitulos = new ArrayList<CapituloSinal>();

        for (int i = 1; i <= 10; i++) {
            capitulo = new CapituloSinal();
            capitulo.setId(i);
            capitulo.setNome("Capítulo " + i);
            capitulo.setDescricao("Descrição " + i);
            capitulo.setOrdemDoCapitulo(i);
            capitulos.add(capitulo);
        }

        return capitulos;
    }


}
