package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Questao {
    private int id;
    private String pergunta;
    private String imagem;
    private int imagemResource;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private String opcao4;
    private String opcaoCorrecta;

    public Questao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public int getImagemResource() {
        return imagemResource;
    }

    public void setImagemResource(int imagemResource) {
        this.imagemResource = imagemResource;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public String getOpcao4() {
        return opcao4;
    }

    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public String getOpcaoCorrecta() {
        return opcaoCorrecta;
    }

    public void setOpcaoCorrecta(String opcaoCorrecta) {
        this.opcaoCorrecta = opcaoCorrecta;
    }
}
