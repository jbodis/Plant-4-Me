import java.util.*;

import javax.lang.model.util.ElementScanner14;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean app = true;2
        int answer;

        ArrayList<Plant> allPlants;

        while (app != false) {
            allPlants = readData();

            System.out.println("❀ Hello there and welcome to Plant 4 Me ❀");
            scanner.nextLine();
            System.out.println(
                    "❊ We would like you to take this quiz, so we can figure out whats the best plant for you! ❊");
            scanner.nextLine();
            allPlants = personalityQuiz(allPlants);

            if (allPlants.isEmpty()) {
                System.out.println("❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ");
                System.out.println("LOL i dont think any plant would work for you");
                System.out.println("❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ");
            } else {
                System.out.println("❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ");
                System.out.println("These are some suggestions for plants!");
                for (int i = 0; i < allPlants.size(); i++) {
                    System.out.println(allPlants.get(i).toString());
                }

                System.out.println("❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ");
            }
            System.out.println("Press 1 if you want to leave and 2 if you want to stay");
            answer = scanner.nextInt();
            if (answer == 1) {
                app = false;
                break;
            }
        }
    }

    public static ArrayList<Plant> readData() {

        ArrayList<Plant> allPlants = new ArrayList<Plant>();

        try {
            File file = new File("database.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                String[] data = temp.split(", ");
                allPlants.add(new Plant(data[0], data[1], data[2]));
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("something broke :( " + e);
        }

        return allPlants;
    }

    public static ArrayList<Plant> personalityQuiz(ArrayList<Plant> plants) {
        Scanner scanner = new Scanner(System.in);
        int type = 0;
        String value = "";

        System.out.println("⚘ Overwaterer vs Underwaterer vs Perfectwaterer ⚘");
        System.out.println("1. Suppa busy, I will forget all the time ");
        System.out.println("2. I love my plant babys, I will always give them water");
        System.out.println("3. I am right in the middle ");
        System.out.println("4. I'm not sure");
        int choice = scanner.nextInt();
        if (choice == 2) {
            value = "high";
        } else if (choice == 3) {
            value = "mid";
        } else {
            value = "low";
        }

        plants = removePlants(plants, value, 1);

        System.out.println("⚘ Do you live like a vampire? ⚘");
        System.out.println("1. I really do, there is no availabe light in my home");
        System.out.println("2. My home would kill a vampire, tons of natural light! ");
        System.out.println("3. Lots of areas where it is part shade");
        choice = scanner.nextInt();

        if (choice == 2) {
            value = "high";
        } else if (choice == 3) {
            value = "mid";
        } else {
            value = "low";
        }

        plants = removePlants(plants, value, 2);

        return plants;
    }

    public static ArrayList<Plant> removePlants(ArrayList<Plant> plants, String value, int type) {
        int i = 0;
        while (i < plants.size()) {
            if (type == 1) {
                if (!plants.get(i).getWaterLevel().equals(value)) {
                    plants.remove(i);
                } else {
                    i++;
                }
            } else {
                if (!plants.get(i).getLightLevel().equals(value)) {
                    plants.remove(i);
                } else {
                    i++;
                }
            }
        }
        return plants;
    }
}
