package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Quadro {

    private int id;
    private String nome;
    private int ordemDoQuadro;
    private String descricao;

    public Quadro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdemDoQuadro() {
        return ordemDoQuadro;
    }

    public void setOrdemDoQuadro(int ordemDoQuadro) {
        this.ordemDoQuadro = ordemDoQuadro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
