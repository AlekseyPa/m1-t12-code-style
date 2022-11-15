import java.util.Scanner;

class CalculateDeposit {
    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);

        return calculatePercent(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return calculatePercent(amount + amount * 0.06 * depositPeriod);
    }

    double calculatePercent(double value) {
        double scale = Math.pow(10, 2);

        return Math.round(value * scale) / scale;
    }

    void calculationContribution() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outVar = 0;

        if (action == 1) {
            outVar = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            outVar = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }

    public static void main(String[] args) {
        CalculateDeposit calculateDeposit = new CalculateDeposit();
        calculateDeposit.calculationContribution();
    }
}
