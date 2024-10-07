import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Livro {
        public String title;
        public String autor;
        public int year;
        public String gender;

        public Livro(String title, String autor, int year, String gender) {
            this.title = title;
            this.autor = autor;
            this.year = year;
            this.gender = gender;
        }

        public String gettitle() {
            return title;
        }

        public void settitle(String title) {
            this.title = title;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getyear() {
            return year;
        }

        public void setyear(int year) {
            this.year = year;
        }

        public String getgender() {
            return gender;
        }

        public void setgender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "titulo: " + title + "/ Autor: " + autor + "/ ano: " + year + "/ genero: " + gender;
        }
    }

    public static class Biblioteca {
        private List<Livro> booklist;

        public Biblioteca() {
            booklist = new ArrayList<>();
        }

        public void adicionarLivro(Livro livro) {
            booklist.add(livro);
            System.out.println("Livro adicionado!");
        }

        public void listarLivros() {
            if (booklist.isEmpty()) {
                System.out.println("Nenhum livro encontrado.");
            } else {
                System.out.println("Lista de Livros:");
                for (int i = 0; i < booklist.size(); i++) {
                    System.out.println(booklist.get(i).toString());
                }
            }
        }

        public void buscarLivroPortitle(String title) {
            boolean encontrado = false;
            for (Livro livro : booklist) {
                if (livro.gettitle().equalsIgnoreCase(title)) {
                    System.out.println(livro.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum livro encontrado com o título: " + title);
            }
        }

        public void removerLivroPortitle(String title) {
            boolean removido = booklist.removeIf(livro -> livro.gettitle().equalsIgnoreCase(title));
            if (removido) {
                System.out.println("Livro removido com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com o título: " + title);
            }
        }
    }

    private Biblioteca biblioteca;
    private Scanner scanner;

    public Main() {
        biblioteca = new Biblioteca();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Livros!");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Listar Livros");
        System.out.println("3. Buscar Livro por titulo");
        System.out.println("4. Remover Livro por titulo");
        System.out.println("5. Sair");
        System.out.print("Opcao: ");
    }
    
    public void projeto() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    buscarLivroPortitle();
                    break;
                case 4:
                    removerLivroPortitle();
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    public void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String title = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o ano de publicação: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o genero do livro: ");
        String gender = scanner.nextLine();

        Livro livro = new Livro(title, autor, year, gender);
        biblioteca.adicionarLivro(livro);
    }

    public void listarLivros() {
        biblioteca.listarLivros();
    }

    public void buscarLivroPortitle() {
        System.out.print("Digite o titulo do livro que deseja buscar: ");
        String title = scanner.nextLine();
        biblioteca.buscarLivroPortitle(title);
    }

    public void removerLivroPortitle() {
        System.out.print("Digite o titulo do livro que deseja remover: ");
        String title = scanner.nextLine();
        biblioteca.removerLivroPortitle(title);
    }

    public static void main(String[] args) {
        Main run = new Main();
        run.projeto();
    }
}
