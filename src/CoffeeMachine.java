import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine mrCoffee = new Machine();
        String choice;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            System.out.print("> ");
            choice = scanner.next();

            if (choice.equals("buy")) {
                CoffeeMachine.buyCoffee(mrCoffee);
            } else if (choice.equals("fill")) {
                CoffeeMachine.fillCoffee(mrCoffee);
            } else if (choice.equals("take")) {
                CoffeeMachine.takeMoney(mrCoffee);
            } else if (choice.equals("remaining")) {
                CoffeeMachine.printCoffeeMachine(mrCoffee);
            } else if (!choice.equals("exit")){
                System.out.println("Unknown action");
            }
        } while (!choice.equals("exit"));

    }

    public static void printCoffeeMachine(Machine mrCoffee) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(mrCoffee.getWater() + " of water");
        System.out.println(mrCoffee.getMilk() + " of milk");
        System.out.println(mrCoffee.getBeans() + " of coffee beans");
        System.out.println(mrCoffee.getCups() + " of disposable cups");
        System.out.println(mrCoffee.getMoney() + " of money");
        System.out.println("");
    }

    public static Machine buyCoffee(Machine mrCoffee) {
        Scanner scanner = new Scanner(System.in);
        String enough = "\nI have enough resources, making you a coffee!\n";
        System.out.println("");
        System.out.println("What do you want to buy? 1 -> espresso, 2 -> latte, 3 -> cappuccino, back -> back to main menu:");
        System.out.print("> ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": {
                if (isOutOfResources(mrCoffee.getWater(),mrCoffee.getMilk(),mrCoffee.getBeans(),mrCoffee.getCups(),choice)) {
                    break;
                } else {
                    mrCoffee.makeEspresso();
                    System.out.println(enough);
                    break;
                }
            } case "2": {
                if (isOutOfResources(mrCoffee.getWater(),mrCoffee.getMilk(),mrCoffee.getBeans(),mrCoffee.getCups(),choice)) {
                    break;
                } else {
                    mrCoffee.makeLatte();
                    System.out.println(enough);
                    break;
                }
            } case "3": {
                if (isOutOfResources(mrCoffee.getWater(),mrCoffee.getMilk(),mrCoffee.getBeans(),mrCoffee.getCups(),choice)) {
                    break;
                } else {
                    mrCoffee.makeCappuccino();
                    System.out.println(enough);
                    break;
                }
            } case "back": {
                System.out.println("");
                break;
            }
        }
        return mrCoffee;
    }

    public static Machine fillCoffee(Machine mrCoffee) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        mrCoffee.setWater(mrCoffee.getWater() + scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        mrCoffee.setMilk(mrCoffee.getMilk() + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        mrCoffee.setBeans(mrCoffee.getBeans() + scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        mrCoffee.setCups(mrCoffee.getCups() + scanner.nextInt());

        System.out.println();
        return mrCoffee;

    }

    public static Machine takeMoney(Machine mrCoffee) {
        System.out.println("");
        System.out.println("I gave you $" + mrCoffee.getMoney());
        System.out.println("");
        mrCoffee.setMoney(0);
        return mrCoffee;
    }

    public static boolean isOutOfResources(int water, int milk, int beans, int cups, String option){
        String noWater = "\nSorry, not enough water!\n";
        String noMilk = "\nSorry, not enough milk!\n";
        String noBeans = "\nSorry, not enough coffee beans!\n";
        if (cups - 1 < 0){
            System.out.println("\nSorry, not enough disposable cups!\n");
            return true;
        } else {
            switch (option) {
                case "1":
                    if (water - 250 < 0) {
                        System.out.println(noWater);
                        return true;
                    }
                    if (beans - 16 < 0) {
                        System.out.println(noBeans);
                        return true;
                    }
                    break;
                case "2":
                    if (water - 350 < 0) {
                        System.out.println(noWater);
                        return true;
                    }
                    if(milk - 75 < 0){
                        System.out.println(noMilk);
                        return true;
                    }
                    if (beans - 20 < 0) {
                        System.out.println(noBeans);
                        return true;
                    }
                    break;
                case "3":
                    if (water - 200 < 0) {
                        System.out.println(noWater);
                        return true;
                    }
                    if(milk - 100 < 0){
                        System.out.println(noMilk);
                        return true;
                    }
                    if (beans - 12 < 0) {
                        System.out.println(noBeans);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static class Machine {
        private int water;
        private int milk;
        private int beans;
        private int cups;
        private int money;

        Machine() {
            water = 400;
            milk = 540;
            beans = 120;
            cups = 9;
            money = 550;
        }

        public void makeEspresso() {
            this.water -= 250;
            this.beans -= 16;
            this.cups -= 1;
            this.money += 4;
        }

        public void makeLatte() {
            this.water -= 350;
            this.milk -= 75;
            this.beans -= 20;
            this.cups -= 1;
            this.money += 7;
        }

        public void makeCappuccino() {
            this.water -= 200;
            this.milk -= 100;
            this.beans -= 12;
            this.cups -= 1;
            this.money += 6;
        }

        public int getWater() {
            return water;
        }

        public void setWater(int water) {
            this.water = water;
        }

        public int getMilk() {
            return milk;
        }

        public void setMilk(int milk) {
            this.milk = milk;
        }

        public int getBeans() {
            return beans;
        }

        public void setBeans(int beans) {
            this.beans = beans;
        }

        public int getCups() {
            return cups;
        }

        public void setCups(int cups) {
            this.cups = cups;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

    }
}
