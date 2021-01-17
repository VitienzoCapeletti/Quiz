package model.entity;

public class Questao implements Entity<Questao> {

    private String enunciado;
    private String codigo;
    private Alternativa[] alternativas;

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

    public Alternativa[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(Alternativa[] alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public Questao fromFile(String[] input) {
        //Captura o pedaço zero para Enunciado
        this.setEnunciado(input[0]);
        //Captura o pedaço 1 para Código
        this.setCodigo(input[1]);

        Alternativa[] alternativas = new Alternativa[input.length - 2];
        for (int i = 2; i < input.length; i++) {
            String[] pedacoAlternativa = input[i].split("\\|");
            Alternativa alternativa = new Alternativa().fromFile(pedacoAlternativa);
            alternativas[i - 2] = alternativa;

        }
        this.setAlternativas(alternativas);
        return this;
    }

    @Override
    public String[] toFile() {
        String[] pedacos = new String[this.getAlternativas().length + 2];
        pedacos[0] = this.getEnunciado();
        pedacos[1] = this.getCodigo();

        for( int i=0 ; i < alternativas.length ; i++ ){
            pedacos[i + 2] = String.join("|", alternativas[i].toFile());
        }

        return pedacos;
    }

}

