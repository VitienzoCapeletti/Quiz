package view;

import controller.QuizController;
import controller.Quiz;
import model.QuestaoDTO;
import model.entity.Alternativa;
import model.entity.Questao;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class CommandLine {

    private static final Scanner sc = new Scanner(System.in);
    private static final Quiz quiz = new QuizController();

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Super Quiz! \n");

        String opcao;
        do {
            mostrarMenu();
            opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    jogar();
                    break;
                case "2":
                    adicionarQuestao();
                    break;
                case "x":
                    System.out.println("Programa encerrado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        } while (!opcao.equals("x"));

    }

    public static void mostrarMenu(){
        System.out.println("Selecione a opção que desejar:");
        System.out.println("1 - Jogar");
        System.out.println("2 - Adicionar pergunta");
        System.out.println("X - Sair");
    }

    private static void jogar() {
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
    }

    private static void adicionarQuestao() {
        String[] codigos = new String[]{"a", "b", "c", "d", "e"};

        Questao questao = new Questao();

        System.out.println("Escreva o enunciado da Questão: ");
        questao.setEnunciado(sc.nextLine());

        System.out.println("Adicione as Alternativas: ");

        List<Alternativa> alternativas = new ArrayList<>();

        for (String cod : codigos) {
            Alternativa alternativa = new Alternativa();
            alternativa.setCodigo(cod);

            System.out.print("Questão: " + cod + ") ");
            alternativa.setEnunciado(sc.nextLine());

            alternativas.add(alternativa);
        }

        System.out.print("\nInforme o código da quetão correta: ");
        questao.setCodigo(sc.nextLine());
        System.out.println();

        questao.setAlternativas(alternativas.toArray(Alternativa[]::new));
        quiz.adicionarQuestao(questao);
    }
}
