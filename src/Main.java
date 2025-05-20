import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        String name = "";

        while (name.trim().isEmpty()) {
            System.out.println("Qual é o nome do titular da conta?");
            name = read.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Nome inválido! Por favor, digite um nome válido para a conta.");
            }
        } // trim - retira os espaços -- isEmpty - se está vazio

        String menuAccount = """
                Qual é o tipo da sua conta? Digite o número
                
                    1 - Corrente
                    2 - Salário
                    
                """;

        int account = 0;
        String accountType = "";

        while (account != 1 && account != 2){

            System.out.println(menuAccount);
            account = read.nextInt();

            switch (account){
                case 1:
                    accountType = "Conta Corrente";
                    break;

                case 2:
                    accountType = "Conta salário";
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break; // return finaliza o programa - break apenas sai do switch.
            }

        }

        System.out.println("Quanto você tem na sua conta?");
        double balance = read.nextDouble();

        System.out.println("""
                **************************************************
                
                Titular da conta: %s
                Tipo de conta: %s
                Saldo atual: %.2f
                
                **************************************************
                """.formatted(name,accountType,balance));

        int option = 0;

        String menu = """
                Digite um número: 
                
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair
                """;

        while (option != 4){

            System.out.println(menu);
            option = read.nextInt();

            if (option == 1){

                System.out.println("Você tem "+balance+" de saldo");

            } else if (option == 2) {

                double value = 0;
                System.out.println("Qual valor você deseja tranferir?");

                value = read.nextDouble();

                if (value > balance){
                    System.out.println("Não há saldo para realizar a transferência!!");
                }else {
                    balance -= value;

                    System.out.println("Você transferiu %.2f reais e agora o seu saldo é de %.2f reais."
                            .formatted(value, balance));
                }

            } else if (option == 3) {

                System.out.println("Qual é o valor que você irá receber?");
                double value = read.nextDouble();
                balance += value;
                System.out.println("Você recebeu %.2f reais e seu novo saldo é de %.2f".formatted(value,balance));
                
            }else if (option != 4){
                System.out.println("Opção inválida!! Escolha um número do menu");
            }

        }

    }
}