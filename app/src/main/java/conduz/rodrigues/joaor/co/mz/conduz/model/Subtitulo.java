package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Subtitulo {
    private int id;
    private String nome;
    private String descricao;
    private int ordemDaSubseccao;

    public Subtitulo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdemDaSubseccao() {
        return ordemDaSubseccao;
    }

    public void setOrdemDaSubseccao(int ordemDaSubseccao) {
        this.ordemDaSubseccao = ordemDaSubseccao;
    }
}
