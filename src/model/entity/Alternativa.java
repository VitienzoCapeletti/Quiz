package model.entity;

public class Alternativa implements Entity<Alternativa> {

    private String enunciado;
    private String codigo;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public Alternativa fromFile(String[] input) {
        this.setEnunciado(input[1]);
        this.setCodigo(input[0]);
        return this;
    }

    @Override
    public String[] toFile() {
        String[] pedacos = new String[2];
        pedacos[1] = this.getEnunciado();
        pedacos[0] = this.getCodigo();

        return pedacos;
    }
}
