package br.gestao.projetosa3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Equipe> equipes = new ArrayList<>();
    private static List<Projeto> projetos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Cadastrar Equipe");
            System.out.println("4 - Listar Equipes");
            System.out.println("5 - Cadastrar Projeto");
            System.out.println("6 - Listar Projetos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarUsuario(sc);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    cadastrarEquipe(sc);
                    break;
                case 4:
                    listarEquipes();
                    break;
                case 5:
                    cadastrarProjeto(sc);
                    break;
                case 6:
                    listarProjetos();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // ===== MÉTODOS =====

    private static void cadastrarUsuario(Scanner sc) {
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.print("Nome completo: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Cargo (Administrador/Gerente/Colaborador): ");
        String cargo = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = new Usuario(nome, cpf, email, cargo, login, senha);
        usuarios.add(usuario);

        System.out.println("✅ Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\n--- Lista de Usuários ---");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }
    }

    private static void cadastrarEquipe(Scanner sc) {
        System.out.println("\n--- Cadastro de Equipe ---");
        System.out.print("Nome da equipe: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        Equipe equipe = new Equipe(nome, descricao);

        System.out.println("Adicionar membros à equipe? (s/n)");
        String resposta = sc.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            listarUsuarios();
            if (!usuarios.isEmpty()) {
                System.out.print("Digite o login do usuário que deseja adicionar: ");
                String login = sc.nextLine();
                for (Usuario u : usuarios) {
                    if (u.toString().contains(login)) {
                        equipe.adicionarMembro(u);
                        System.out.println("Membro adicionado!");
                        break;
                    }
                }
            }
        }

        equipes.add(equipe);
        System.out.println("✅ Equipe cadastrada com sucesso!");
    }

    private static void listarEquipes() {
        System.out.println("\n--- Lista de Equipes ---");
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada.");
        } else {
            for (Equipe e : equipes) {
                System.out.println(e);
            }
        }
    }

    private static void cadastrarProjeto(Scanner sc) {
        System.out.println("\n--- Cadastro de Projeto ---");
        System.out.print("Nome do projeto: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Status (Planejado/Em andamento/Concluído/Cancelado): ");
        String status = sc.nextLine();

        System.out.println("Escolha o gerente responsável (digite o login):");
        listarUsuarios();
        Usuario gerente = null;
        if (!usuarios.isEmpty()) {
            String login = sc.nextLine();
            for (Usuario u : usuarios) {
                if (u.toString().contains(login) && u.getCargo().equalsIgnoreCase("Gerente")) {
                    gerente = u;
                    break;
                }
            }
        }

        if (gerente == null) {
            System.out.println("⚠ Nenhum gerente válido selecionado. Projeto não cadastrado.");
            return;
        }

        Projeto projeto = new Projeto(nome, descricao, new Date(), new Date(), status, gerente);
        projetos.add(projeto);

        System.out.println("✅ Projeto cadastrado com sucesso!");
    }

    private static void listarProjetos() {
        System.out.println("\n--- Lista de Projetos ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
        } else {
            for (Projeto p : projetos) {
                System.out.println(p);
            }
        }
    }
