package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Capitulo {
    private int id;
    private String nome;
    private String descricao;
    private int ordemDoCapitulo;

    public Capitulo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdemDoCapitulo() {
        return ordemDoCapitulo;
    }

    public void setOrdemDoCapitulo(int ordemDoCapitulo) {
        this.ordemDoCapitulo = ordemDoCapitulo;
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


}
