package Desafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    ArrayList<Integer> listaAleatorios = new ArrayList<>();
    String nome;
    int idade;

    public static void main(String[] args) {
        Main main = new Main();
        main.entradaNome();
        main.entradaIdade();
        int aux = 1;
        while (aux != 0) {
            System.out.println("Bem vindo(a), " + main.nome + "! Vi aqui que você tem " + main.idade + " anos.");
            System.out.println("Vamos jogar? Este programa sorteou 20 números aleatórios entre 1 e 50:");
            main.preencherLista();
            main.mostrarLista();
            System.out.println("Você decidirá o que fazer com eles no menu abaixo");
            System.out.println("-------------------------------------------");
            System.out.println("Opções disponíveis:");
            System.out.println("1) Adivinhar se existe um número na lista");
            System.out.println("2) Somar os 10 primeiros");
            System.out.println("3) Subtrair os 10 primeiros");
            System.out.println("4) Adivinhar o 1° número");
            System.out.println("5) Multiplicar os pares");
            System.out.println("6) Multiplicar os ímpares");
            System.out.println("7) Ordenar lista -> menor para o maior");
            System.out.println("8) Embaralhar lista -> randomizar");
            System.out.println("9) Criar tabuada com os 5 primeiros números");
            System.out.println("10) Somar todos os números");
            System.out.println("0) Sair");
            System.out.println("-------------------------------------------");
            System.out.println("Digite o número da opção desejada:");
            Scanner inputEscolha = new Scanner(System.in);
            int escolha = inputEscolha.nextInt();

            switch (escolha) {
                case 1:
                    main.adivinharNumero();
                    break;
                case 2:
                    main.somar10();
                    break;
                case 3:
                    main.subtrair10();
                    break;
                case 4:
                    main.adivinharPrimeiro();
                    break;
                case 5:
                    main.multiplicarPares();
                    break;
                case 6:
                    main.multiplicarImpares();
                    break;
                case 7:
                    main.ordenarListaAsc();
                    break;
                case 8:
                    main.embaralharLista();
                    break;
                case 9:
                    main.tabuada5Primeiros();
                    break;
                case 10:
                    main.somarTodos();
                    break;
                case 0:
                    main.sair();
                    aux = 0;
                    break;
            }
        }
    }

    public static int numAleatorio() {
        return (int) ((Math.random() * 51) + 1);
    }

    public void preencherLista() {
        for (int i = 0; i < 20; i++) {
            numAleatorio();
            listaAleatorios.add(numAleatorio());
        }
    }

    public void mostrarLista() {
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                System.out.print("[" + listaAleatorios.get(i) + ", ");
            } else if (i < 19) {
                System.out.print(listaAleatorios.get(i) + ", ");
            } else {
                System.out.println(listaAleatorios.get(i) + "]");
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void entradaNome() {
        boolean errado = true;
        while (errado) {
            System.out.println("Digite seu nome:");
            Scanner inputNome = new Scanner(System.in);
            nome = inputNome.nextLine();
            if (isNumeric(nome)) {
                System.out.println("Por favor, não utilize números!");
            } else {
                errado = false;
            }
        }
    }

    public void entradaIdade() {
        boolean errado = true;
        while (errado) {
            try {
                System.out.println("Digite sua idade:");
                Scanner inputIdade = new Scanner(System.in);
                idade = inputIdade.nextInt();
                errado = false;
            } catch (Exception e) {
                System.out.println("Por favor, não utilize letras!");
                errado = true;
            }
        }
    }

    public void adivinharNumero() {
        boolean errado = true;
        int adivinha = 0;
        while (errado) {
            try {
                System.out.println("Digite um número entre 1 e 50 que você acha que foi sorteado:");
                Scanner inputAdivinha = new Scanner(System.in);
                adivinha = inputAdivinha.nextInt();
                errado = false;
            } catch (Exception e) {
                System.out.println("Por favor, não utilize letras!");
                errado = true;
            }
        }
        if (listaAleatorios.contains(adivinha)) {
            System.out.println("Parabéns, você adivinhou um número que foi sorteado!");
            System.out.println("Ele está na posição " + listaAleatorios.indexOf(adivinha));
        } else {
            System.out.println("Poxa, você não adivinhou :(");
        }
    }

    public void somar10() {
        System.out.println("Números sorteados: ");
        mostrarLista();
        System.out.println();
        int i = 0;
        int soma = 0;
        while (i < 10) {
            soma += listaAleatorios.get(i);
            i++;
        }
        System.out.println("A soma dos 10 primeiros números é: " + soma);
    }

    public void subtrair10() {
        System.out.println("Números sorteados: ");
        mostrarLista();
        System.out.println();
        int subtracao = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                subtracao = listaAleatorios.get(i);
            } else {
                subtracao -= listaAleatorios.get(i);
            }
        }
        System.out.println("A subtração dos 10 primeiros números é: " + subtracao);
    }

    public void adivinharPrimeiro() {
        boolean errado;
        int tentativas = 5;
        int adivinha = 0;
        while (tentativas > 0) {
            errado = true;
            while (errado) {
                try {
                    System.out.println("Digite um número entre 1 e 50 que você acha que foi o PRIMEIRO sorteado:");
                    Scanner inputAdivinha = new Scanner(System.in);
                    adivinha = inputAdivinha.nextInt();
                    errado = false;
                } catch (Exception e) {
                    System.out.println("Por favor, não utilize letras!");
                    errado = true;
                }
            }
            tentativas--;
            if (adivinha == listaAleatorios.get(0)) {
                System.out.println("Parabéns, você acertou o primeiro número da lista!\n" +
                        "Você realmente tem muita sorte!!");
            } else {
                System.out.println("Poxa, não acertou :( Você ainda tem " + tentativas + " tentativas!");
            }
        }
    }

    public void multiplicarPares() {
        long multiplicacao = 1;
        for (Integer x : listaAleatorios) {
            if (x % 2 == 0) {
                multiplicacao *= x;
            }
        }
        System.out.println("O resultado da multiplicação entre os números pares é: " + multiplicacao);
    }

    public void multiplicarImpares() {
        long multiplicacao = 1;
        int i = 0;
        while (i < listaAleatorios.size()) {
            if (listaAleatorios.get(i) % 2 != 0) {
                System.out.println(listaAleatorios.get(i));
                multiplicacao *= listaAleatorios.get(i);
            }
            i++;
        }
        System.out.println("O resultado da multiplicação entre os números ímpares é: " + multiplicacao);
    }

    public void ordenarListaAsc() {
        System.out.println("Lista não ordenada:");
        System.out.println(listaAleatorios);
        Collections.sort(listaAleatorios);
        System.out.println("Lista ordenada:");
        System.out.println(listaAleatorios);
    }

    public void embaralharLista() {
        System.out.println("Lista inicial:");
        System.out.println(listaAleatorios);
        Collections.shuffle(listaAleatorios);
        System.out.println("Lista randomizada:");
        System.out.println(listaAleatorios);
    }

    public void tabuada5Primeiros() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Tabuada do número " + listaAleatorios.get(i) + ":");
            System.out.println(listaAleatorios.get(i) + " X 1 = " + (listaAleatorios.get(i)));
            System.out.println(listaAleatorios.get(i) + " X 2 = " + (listaAleatorios.get(i) * 2));
            System.out.println(listaAleatorios.get(i) + " X 3 = " + (listaAleatorios.get(i) * 3));
            System.out.println(listaAleatorios.get(i) + " X 4 = " + (listaAleatorios.get(i) * 4));
            System.out.println(listaAleatorios.get(i) + " X 5 = " + (listaAleatorios.get(i) * 5));
            System.out.println(listaAleatorios.get(i) + " X 6 = " + (listaAleatorios.get(i) * 6));
            System.out.println(listaAleatorios.get(i) + " X 7 = " + (listaAleatorios.get(i) * 7));
            System.out.println(listaAleatorios.get(i) + " X 8 = " + (listaAleatorios.get(i) * 8));
            System.out.println(listaAleatorios.get(i) + " X 9 = " + (listaAleatorios.get(i) * 9));
            System.out.println("-------------------------------------------------------");
            System.out.println();
        }
    }

    public void somarTodos() {
        System.out.println("Números sorteados: ");
        mostrarLista();
        System.out.println();
        int soma = 0;
        // for-each, diferente do for tradicional
        // usado quando quero usar TODOS os itens da lista
        for (int i : listaAleatorios) {
            soma += i;
        }
        System.out.println("A soma de todos os números é: " + soma);
    }

    public void sair() {
        System.out.println("Obrigado por jogar, " + nome);
    }

}
