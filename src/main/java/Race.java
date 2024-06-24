import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Race {
    Car winner;

    Scanner scanner = new Scanner(System.in);

    ArrayList<Car> cars = new ArrayList<>();

    public void calculateWinner(ArrayList<Car> cars) {
        winner = cars.get(0);
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car element = iterator.next();
            if (element.speed >= winner.speed) {
                winner = element;
            }
        }
    }

    public void contestStart() {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        System.out.println("Введите команду ");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                carInput();
            } else if (command == 2) {
                calculateWinner(cars);
                System.out.println("Побеждает тачка:" + winner.name + " со скоростью " + winner.speed);
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
            System.out.println("Введите скорость > 0 но =< 250");
            Integer speed = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите название тачилы");
            String name = scanner.nextLine();

            if (speed <= 0) {
                System.out.println(
                        "Вы ввели отрицательную скорость.Введите скорость > 0 но =< 250"
                );
            } else if (speed > 250) {
                System.out.println(
                        "Вы ввели слишком большую скорость. Введите скорость > 0 но =< 250"
                );
            } else {
                Car car = new Car(speed, name);
                cars.add(car);
                System.out.println("Тачка успешно создана!");
                break;
            }
        }
    }
}
