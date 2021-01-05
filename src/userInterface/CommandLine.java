package userInterface;

import program.Program;
import program.Quiz;
import program.objetos.Alternativa;
import program.objetos.QuestaoDTO;

import java.util.Scanner;

public class CommandLine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Super Quiz! \n");

        Quiz quiz = new Program();

        String opcao = null;
        do {
            System.out.println("Selecione a opção que desejar: \n" +
                    "1 - Jogar \n" +
                    "2 - Adicionar perguntas \n" +
                    "X - Sair");
            opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    QuestaoDTO questao = quiz.proximaQuestao();
                    while (questao != null) {
                        System.out.println("Pergunta: " + questao.getEnunciado());
                        boolean respostaCorreta = false;
                        while (respostaCorreta == false) {
                            for (Alternativa alternativa : questao.getAlternativas()) {
                                System.out.println(alternativa.getCodigo() + ") " + alternativa.getEnunciado());
                            }
                            System.out.println("Qual a resposta correta: ");
                            String codigo = sc.nextLine();
                            respostaCorreta = quiz.validarResposta(codigo);
                            if (respostaCorreta == true) {
                                System.out.println("Resposta correta.");
                            } else {
                                System.out.println("Resposta errada, tente novamente!");
                            }
                        }
                        questao = quiz.proximaQuestao();
                    }
                    System.out.println("Você fez o total de: "+ quiz.resultadoFinal()+" Pontos.");

                    break;
                case "2":
                    System.out.println("Não implementado (ainda). ");
                    break;
                case "x":
                    System.out.println("Programa encerrado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        } while (!opcao.equals("x"));

    }
}
