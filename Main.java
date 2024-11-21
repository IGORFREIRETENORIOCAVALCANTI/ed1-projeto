import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Sistema de Gerenciamento de Clínica Médica");
            System.out.println("2. Sistema de Gerenciamento de Eventos");
            System.out.println("3. Sistema de Gerenciamento de Restaurante");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch(opcao) {
                case 1:
                    executarSistema("casoum.Main");
                    break;
                case 2:
                    executarSistema("casodois.Main");
                    break;
                case 3:
                    executarSistema("casotres.Main");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void executarSistema(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Method mainMethod = clazz.getMethod("main", String[].class);
            String[] params = null;
            mainMethod.invoke(null, (Object) params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
