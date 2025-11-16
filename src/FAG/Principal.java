package FAG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FAG.objetos.Users;
import FAG.objetos.Works;

public class Principal {

    static List<Users> Funcionarios = new ArrayList<>();
    static List<Works> Obras = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        populateUser();
        populateWork();
        menu();
    }


    public static void populateUser() {
        Funcionarios.add(new Users("Jose", "Mestre de Obras", "(45)9 9999-9999", "Rua Um, N° 356 - Centro", 8000));
        Funcionarios.add(new Users("Fabricio", "Engenheiro", "(45)9 9141-1452", "Rua Dois, N° 146 - Jardim Italia", 16000));
        Funcionarios.add(new Users("Rodolfo", "Mestre de Obras", "(45)9 9829-9248", "Rua Tres, N° 52 - Bom Jesus", 2500));
    }

    public static void populateWork() {
        Obras.add(new Works("Predio1", "Rua Um, N° 582 - Centro", "10/10/2023", "Jose", 893592));
        Obras.add(new Works("Predio2", "Rua Dois, N° 056 - Ouro Verde", "21/12/2024", "Fabricio", 691254));
        Obras.add(new Works("Predio3", "Rua Tres, N° 951 - Novo Horizonte", "05/03/2025", "Rodolfo", 9514230));
    }


    public static void menu() {

        int option = -1;

        do {
            System.out.println("===== Menu =====");
            System.out.println("(1) Funcionarios");
            System.out.println("(2) Obras");
            System.out.println("(0) Sair");
            System.out.println("================");
            System.out.print("Escolha uma opcao: ");

            option = scan.nextInt();

            if (option == 1) {

                System.out.println("\n===== Menu Funcionarios =====");
                System.out.println("(1) Listar Funcionarios");
                System.out.println("(2) Cadastrar Funcionarios");
                System.out.println("(3) Atualizar Funcionario");
                System.out.println("(4) Deletar Funcionario");
                System.out.println("(0) Voltar");
                System.out.println("================");
                System.out.print("Escolha uma opcao: ");
                option = scan.nextInt();

            } else if (option == 2) {

                System.out.println("\n===== Menu Obras =====");
                System.out.println("(5) Listar Obras");
                System.out.println("(6) Cadastrar Obra");
                System.out.println("(7) Atualizar Obra");
                System.out.println("(8) Deletar Obra");
                System.out.println("(0) Voltar");
                System.out.println("================");
                System.out.print("Escolha uma opcao: ");
                option = scan.nextInt();

            } else if (option == 0) {
                System.out.println("Logout efetuado com sucesso! Até logo 👋");
                return;
            } else {
                System.out.println("Opcao Invalida!");
            }

            scan.nextLine();
            optionValidate(option);

        } while (option != 0);
    }


    public static void optionValidate(int option) {

        if (option == 1) {
            listUsers();
        } else if (option == 2) {
            newUser();
        } else if (option == 3) {
            updateUser();
        } else if (option == 4) {
            deleteUser();
        } else if (option == 5) {
            listWorks();
        } else if (option == 6) {
            newWork();
        } else if (option == 7) {
            updateWork();
        } else if (option == 8) {
            deleteWork();
        } else if (option == 0) {
            menu();
        } else {
            System.out.println("Opcao invalida, favor tente novamente!");
        }
    }


    public static void listUsers() {
        for (int i = 0; i < Funcionarios.size(); i++) {
            System.out.printf("ID: %d", i + 1);
            Funcionarios.get(i).userInfo();
        }
    }

    public static void newUser() {

        Users newUser = new Users();

        System.out.println("===== Novo Funcionario =====");

        System.out.print("Informe o nome do usuário: ");
        newUser.setFullName(scan.nextLine());

        System.out.print("Informe o cargo do usuário: ");
        newUser.setPosition(scan.nextLine());

        System.out.print("Informe o telefone do usuário: ");
        newUser.setPhone(scan.nextLine());

        System.out.print("Informe o endereço do usuário: ");
        newUser.setAddress(scan.nextLine());

        System.out.print("Informe o salário do usuário: ");
        newUser.setWage(scan.nextDouble());

        System.out.println("\n==================================");
        System.out.println("== Usuario cadastrado com Sucesso! ==");
        System.out.println("==================================\n");

        Funcionarios.add(newUser);
    }

    public static void updateUser() {

        int option = -1;

        listUsers();

        System.out.println("===== Atualizar Funcionario =====");
        System.out.print("Informe o ID do usuário: ");

        int ID = scan.nextInt() - 1;
        scan.nextLine();

        System.out.println("\n================");
        System.out.println("(1) Atualizar Cargo");
        System.out.println("(2) Atualizar Telefone");
        System.out.println("(3) Atualizar Endereco");
        System.out.println("(4) Atualizar Salario");
        System.out.println("(0) Voltar");
        System.out.println("================");
        System.out.print("Escolha uma opcao: ");
        option = scan.nextInt();
        scan.nextLine();

        if (option == 1) {
            System.out.print("Informe o cargo do usuário: ");
            Funcionarios.get(ID).setPosition(scan.nextLine());
        } else if (option == 2) {
            System.out.print("Informe o telefone do usuário: ");
            Funcionarios.get(ID).setPhone(scan.nextLine());
        } else if (option == 3) {
            System.out.print("Informe o endereço do usuário: ");
            Funcionarios.get(ID).setAddress(scan.nextLine());
        } else if (option == 4) {
            System.out.print("Informe o salário do usuário: ");
            Funcionarios.get(ID).setWage(scan.nextDouble());
        } else if (option == 0) {
            menu();
        } else {
            System.out.println("Opcao invalida, favor tente novamente!");
        }

        System.out.println("\n==================================");
        System.out.println("== Usuario atualizado com Sucesso! ==");
        System.out.println("==================================\n");
    }

    public static void deleteUser() {

        int option = -1;

        listUsers();

        System.out.println("===== Deletar Funcionario =====");
        System.out.print("Informe o ID do usuário: ");

        int ID = scan.nextInt() - 1;
        scan.nextLine();

        System.out.println("\n= Realmente deseja deletar o Usuario ? =");
        System.out.println("(1) Deletar");
        System.out.println("(0) Voltar");
        System.out.println("================");
        System.out.print("Escolha uma opcao: ");

        option = scan.nextInt();
        scan.nextLine();

        if (option == 1) {
            Funcionarios.remove(ID);

            System.out.println("\n==================================");
            System.out.println("== Usuario Deletado com Sucesso! ==");
            System.out.println("==================================\n");
        }
    }

    
    public static void listWorks() {
        for (int i = 0; i < Obras.size(); i++) {
            System.out.printf("ID: %d", i + 1);
            Obras.get(i).workInfo();
        }
    }

    public static void newWork() {

        Works newWork = new Works();
        int ID;

        System.out.println("===== Nova Obra =====");

        System.out.print("Informe o nome da obra: ");
        newWork.setWorkName(scan.nextLine());

        System.out.print("Informe o endereço da obra: ");
        newWork.setWorkAddress(scan.nextLine());

        System.out.print("Informe a data de início no formato dd/mm/aaaa: ");
        newWork.setWorkStartDate(scan.nextLine());

        System.out.print("Informe o valor da obra: ");
        newWork.setWorkPrice(scan.nextDouble());
        scan.nextLine();

        listUsers();

        System.out.print("ID Do Responsavel Pela Obra: ");
        ID = scan.nextInt() - 1;
        scan.nextLine();

        if (ID < 0 || ID >= Funcionarios.size()) {
            System.out.println("ID do Responsável inválido!");
            return;
        }

        String name = Funcionarios.get(ID).getFullName();
        newWork.setWorkResponsible(name);

        Obras.add(newWork);

        System.out.println("\n==================================");
        System.out.println("== Obra cadastrada com Sucesso! ==");
        System.out.println("==================================\n");
    }

    public static void updateWork() {

        int option = -1;

        listWorks();

        System.out.println("===== Atualizar Obra =====");
        System.out.print("Informe o ID da obra: ");

        int ID = scan.nextInt() - 1;
        scan.nextLine();

        if (ID < 0 || ID >= Obras.size()) {
            System.out.println("ID inválido!");
            return;
        }

        Works work = Obras.get(ID);

        System.out.println("\n================");
        System.out.println("(1) Atualizar Responsável");
        System.out.println("(2) Atualizar Valor");
        System.out.println("(0) Voltar");
        System.out.println("================");
        System.out.print("Escolha uma opção: ");

        option = scan.nextInt();
        scan.nextLine();

        if (option == 1) {

            listUsers();

            System.out.print("Informe o ID do responsável: ");
            int newRespID = scan.nextInt()-1;
            scan.nextLine();

            if (newRespID < 0 || newRespID >= Funcionarios.size()) {
                System.out.println("Responsável inválido!");
                return;
            }

            String name = Funcionarios.get(newRespID).getFullName();
            work.setWorkResponsible(name);

        } else if (option == 2) {

            System.out.print("Informe o novo valor da obra: R$ ");
            double newPrice = scan.nextDouble();
            scan.nextLine();

            work.setWorkPrice(newPrice);

        } else if (option == 0) {
            menu();
            return;
        } else {
            System.out.println("Opção inválida, tente novamente!");
            return;
        }

        System.out.println("\n==================================");
        System.out.println("== Obra atualizada com Sucesso! ==");
        System.out.println("==================================\n");
    }

    public static void deleteWork() {

        int option = -1;

        listWorks();

        System.out.println("===== Deletar Obra =====");
        System.out.print("Informe o ID da obra: ");

        int ID = scan.nextInt() - 1;
        scan.nextLine();

        System.out.println("\n= Realmente deseja deletar essa obra ? =");
        System.out.println("(1) Deletar");
        System.out.println("(0) Voltar");
        System.out.println("================");
        System.out.print("Escolha uma opcao: ");

        option = scan.nextInt();
        scan.nextLine();

        if (option == 1) {

            Obras.remove(ID);

            System.out.println("\n==================================");
            System.out.println("== Obra Deletado com Sucesso! ==");
            System.out.println("==================================\n");
        }
    }

}
