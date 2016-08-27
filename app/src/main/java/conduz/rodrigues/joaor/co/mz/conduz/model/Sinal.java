package conduz.rodrigues.joaor.co.mz.conduz.model;

/**
 * Created by João Rodrigues on 8/12/2016.
 */
public class Sinal {
    private int id;
    private String nome;
    private String codigo;
    private String descricao;
    private String icone;
    private int iconeResource;

    public Sinal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIconeResource() {
        return iconeResource;
    }

    public void setIconeResource(int iconeResource) {
        this.iconeResource = iconeResource;
    }
}
