package FAG.objetos;

import java.util.Scanner;

public class Users {

    static Scanner scan = new Scanner(System.in);

    private String fullName;
    private String position;
    private String phone;
    private String address;
    private double wage;

    public Users() {
    }

    public Users(String fullName, String position, String phone, String address, double wage) {
        setFullName(fullName);
        setPosition(position);
        setPhone(phone);
        setAddress(address);
        setWage(wage);
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.isBlank()) {
            this.fullName = fullName;
        } else {
            System.out.println("Nome de usuário inválido!");
            System.out.print("Informe o nome do usuário: ");
            setFullName(scan.nextLine());
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position != null && !position.isBlank()) {
            this.position = position;
        } else {
            System.out.println("Cargo inválido!");
            System.out.print("Informe o cargo do usuário: ");
            setPosition(scan.nextLine());
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null) {
            this.phone = phone;
        } else {
            System.out.println("Telefone inválido!");
            System.out.print("Informe o telefone do usuário: ");
            setPhone(scan.nextLine());
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isBlank()) {
            this.address = address;
        } else {
            System.out.println("Endereço inválido!");
            System.out.print("Informe o endereço do usuário: ");
            setAddress(scan.nextLine());
        }
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        if (wage > 0) {
            this.wage = wage;
        } else {
            System.out.println("Salário inválido! Deve ser maior que zero.");
            System.out.print("Informe o salário do usuário: ");
            setWage(Double.parseDouble(scan.nextLine()));
        }
    }



    public void userInfo() {
        System.out.println("\n===== Dados do Usuário =====");
        System.out.println("Nome completo: " + fullName);
        System.out.println("Cargo: " + position);
        System.out.println("Telefone: " + phone);
        System.out.println("Endereço: " + address);
        System.out.printf("Salário: R$ %.2f%n", wage);
        System.out.println("============================\n");
    }
}
