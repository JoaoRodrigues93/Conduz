package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Tema {
    private int id;
    private String nome;
    private String icone;
    private int iconeResource;
    private String conteudo;
    private String tipo;
    private int ordemDoTema;

    public Tema() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getOrdemDoTema() {
        return ordemDoTema;
    }

    public void setOrdemDoTema(int ordemDoTema) {
        this.ordemDoTema = ordemDoTema;
    }

    public int getIconeResource() {
        return iconeResource;
    }

    public void setIconeResource(int iconeResource) {
        this.iconeResource = iconeResource;
    }
}
