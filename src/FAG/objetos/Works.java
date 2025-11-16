package FAG.objetos;

import java.util.Scanner;

public class Works {

    private String workName;
    private String workAddress;
    private String workStartDate;
    private String workResponsible; 
    private double workPrice;

    static Scanner scan = new Scanner(System.in);

    public Works() {
    }

    public Works(String workName, String workAddress, String workStartDate, String workResponsible, double workPrice) {
        setWorkName(workName);
        setWorkAddress(workAddress);
        setWorkStartDate(workStartDate);
        setWorkResponsible(workResponsible);
        setWorkPrice(workPrice);
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        if (workName != null && !workName.isBlank()) {
            this.workName = workName;
        } else {
            System.out.println("Nome da obra inválido!");
            System.out.print("Informe o nome da obra: ");
            setWorkName(scan.nextLine());
        }
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        if (workAddress != null && !workAddress.isBlank()) {
            this.workAddress = workAddress;
        } else {
            System.out.println("Endereço da obra inválido!");
            System.out.print("Informe o endereço da obra: ");
            setWorkAddress(scan.nextLine());
        }
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        if (workStartDate != null && !workStartDate.isBlank()) {
            this.workStartDate = workStartDate;
        } else {
            System.out.println("Data de início da obra inválida!");
            System.out.print("Informe a data de início no formato dd/mm/aaaa: ");
            setWorkStartDate(scan.nextLine());
        }
    }

    public double getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(double workPrice) {
        this.workPrice = workPrice;
    }

    public String getWorkResponsible() {
        return workResponsible;
    }

    public void setWorkResponsible(String workResponsible) {
        if (workResponsible != null && !workResponsible.isBlank()) {
            this.workResponsible = workResponsible;
        } else {
            System.out.println("Responsável inválido!");
            System.out.print("Informe o nome do responsável: ");
            setWorkResponsible(scan.nextLine());
        }
    }

    public void workInfo() {
        System.out.println("\n===== Dados da Obra =====");
        System.out.println("Nome da Obra: " + workName);
        System.out.println("Endereço: " + workAddress);
        System.out.println("Data de Início: " + workStartDate);
        System.out.println("Responsável: " + workResponsible);
        System.out.printf("Valor da Obra: R$ %.2f%n", workPrice);
        System.out.println("============================\n");
    }
}
