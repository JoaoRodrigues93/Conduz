package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Seccao {
    private int id;
    private String nome;
    private String descricao;
    private int ordemDaSeccao;

    public Seccao() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemDaSeccao() {
        return ordemDaSeccao;
    }

    public void setOrdemDaSeccao(int ordemDaSeccao) {
        this.ordemDaSeccao = ordemDaSeccao;
    }
}
