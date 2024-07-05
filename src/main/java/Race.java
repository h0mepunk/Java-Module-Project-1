import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Race {
    Car winner;

    Scanner scanner = new Scanner(System.in);

    ArrayList<Car> cars = new ArrayList<>();

    public void calculateWinner(ArrayList<Car> cars) {
        winner = cars.get(0);
        for(Car car: cars) {
            if (car.getSpeed() >= winner.getSpeed()) {
                winner = car;
            }
        }
    }

    public void contestStart() {

        System.out.println("Введите команду ");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                carInput();
            } else if (command == 2) {
                calculateWinner(cars);
                System.out.println("Побеждает тачка:" + winner.getName() + " со скоростью " + winner.getSpeed());
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет");
            }
        }
    }

    public void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Добавить тачку");
        System.out.println("2 - Узнать победителя гонки");
        System.out.println("0 - Выход");
    }

    public void carInput() {
        while (true) {
            Integer speed = inputSpeed();
            String name = inputName();
            Car car = new Car(speed, name);
            cars.add(car);
            System.out.println("Тачка успешно создана!");
            break;
        }
    }

    private String inputName() {
        System.out.println("Введите название тачилы");
        return scanner.nextLine();
    }

    private Integer inputSpeed() {
        Integer speed;
        while(true) {
            speed = scanSpeed();
            if (checkSpeed(speed)) {
                break;
            } else {
                speed = inputSpeed();
                break;
            }
        }
        return speed;
    }

    private Boolean checkSpeed(Integer speed) {
        Boolean isCorrect;
        if (speed <= 0) {
            System.out.println(
                    "Вы ввели отрицательную скорость.Введите скорость > 0 но =< 250"
            );
            isCorrect = false;
        } else if (speed > 250) {
            System.out.println(
                    "Вы ввели слишком большую скорость. Введите скорость > 0 но =< 250"
            );
            isCorrect = false;
        } else {
            isCorrect = true;
        }
        return isCorrect;
    }

    private Integer scanSpeed() {
        Integer speed;
        System.out.println("Введите скорость > 0 но =< 250");
        while (true) {
            try {
                speed = scanner.nextInt();
                scanner.nextLine(); // очищаем буфер
                if (speed > 0 && speed <= 250) {
                    break; // выход из цикла при корректном вводе
                } else {
                    System.out.println("Введите скорость в пределах > 0 но =< 250");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверные данные. Введите скорость > 0 но =< 250 как целое число");
                scanner.nextLine(); // очищаем буфер
            }
        }
        return speed;
    }
}
