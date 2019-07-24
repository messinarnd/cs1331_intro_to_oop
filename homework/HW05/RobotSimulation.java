import java.util.Scanner;
import java.util.LinkedList;

/**
 * This class is the driver for the Robot Revolution homework.
 * After creating the other classes and implementing all the methods,
 * you should be able to run this file and test the simulation.
 *
 * There is code in this file that you haven't seen before.
 * Don't worry, you don't need to understand how this works!
 * This is just to give you a simulation so you can run and test your code.
 *
 * @author Walker Powell
 * @version 1.0
 */
public class RobotSimulation {
    // ***************************************************
    // ****          DO NOT MODIFY THIS FILE          ****
    // ***************************************************

    /**
     * Creates and adds 4 unique robots to a list to be used for testing.
     *
     * @param args command line input
     */
    public static void main(String[] args) {
        LinkedList<Robot> list = new LinkedList<>();

        GovernmentRobot robot1 = new GovernmentRobot("AIDA", 14, true);
        ChefRobot robot2 = new ChefRobot("Goddard", "dog food", 3,
            new String[] {"dog food"});
        RestaurantChefRobot robot3 = new RestaurantChefRobot("Nobu", "sushi",
            295, new String[] {"tuna roll", "california roll",
                "dragon roll", "spring roll"}, 12);
        PersonalChefRobot robot4 = new PersonalChefRobot("PC5280",
            "mac 'n cheese", 121, new String[] {"mac 'n chesse",
                "spaghettios", "tacos"}, false);

        list.add(robot1);
        list.add(robot2);
        list.add(robot3);
        list.add(robot4);

        menu(list);
    }

    /**
     * Displays tbe list of options a user can take while interacting with the
     * simulation.
     *
     * @param list a list of robots existing in the simulation
     */
    private static void menu(LinkedList<Robot> list) {
        Scanner input = new Scanner(System.in);
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.println("Welcome to the Robot Simulator v1.0!");
            System.out.println();
            System.out.println("Which option would you like?");
            System.out.println("0. List the robots");
            System.out.println("1. Add a robot");
            System.out.println("2. Take robot action");
            System.out.println("3. Exit\n");

            int userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                listRobots(list);
                System.out.println();
            } else if (userInput == 1) {
                addRobot(list, userInput, input);
            } else if (userInput == 2) {
                takeRobotAction(list, userInput, input);
            } else if (userInput == 3) {
                isPlaying = false;
            }
        }
    }

    /**
     * Prints out all of the robots in the list.
     *
     * @param list a list of robots existing in the simulation
     */
    private static void listRobots(LinkedList<Robot> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }

    /**
     * Allows a user to create a robot and adds it to the list.
     *
     * @param list a list of robots existing in the simulation
     * @param userInput the user's previous input
     * @param input the Scanner object to take in additional user input
     */
    private static void addRobot(LinkedList<Robot> list, int userInput,
        Scanner input) {
        System.out.println("Which type of robot would you like "
            + "to add?");
        System.out.println("0. Government");
        System.out.println("1. Chef");
        System.out.println("2. PersonalChef");
        System.out.println("3. RestaurantChef");
        System.out.println();

        userInput = input.nextInt();
        input.nextLine();
        System.out.println();

        if (userInput == 0) {   // Government
            System.out.println("Please enter their name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter how many projects they "
                + "have completed.");
            int numProjects = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter whether they have "
                + "security clearance (y/n).");
            boolean hasSecurityClearance =
                input.nextLine().trim().charAt(0) == 'y'
                ? true : false;
            System.out.println();

            list.add(new GovernmentRobot(name, numProjects,
                    hasSecurityClearance));
        } else if (userInput == 1) {    // Chef
            System.out.println("Please enter their name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter their best dish.");
            String bestDish = input.nextLine();
            System.out.println();
            System.out.println("Please enter the number of "
                + "meals they have served.");
            int mealsServed = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter all the items on their "
                + "menu, separated by commas "
                + "(ex: pasta, bread, ham).");
            String menuResponse = input.nextLine();
            String[] menu = menuResponse.split(",");
            for (int i = 0; i < menu.length; i++) {
                menu[i] = menu[i].trim();
            }
            System.out.println();

            list.add(new ChefRobot(name, bestDish, mealsServed, menu));
        } else if (userInput == 2) {    // PersonalChef
            System.out.println("Please enter their name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter their best dish.");
            String bestDish = input.nextLine();
            System.out.println();
            System.out.println("Please enter the number of "
                + "meals they have served.");
            int mealsServed = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter all the items on their "
                + "menu, separated by commas "
                + "(ex: pasta, bread, ham).");
            String menuResponse = input.nextLine();
            String[] menu = menuResponse.split(",");
            for (int i = 0; i < menu.length; i++) {
                menu[i] = menu[i].trim();
            }
            System.out.println();
            System.out.println("Please enter whether they can "
                + "host guests (y/n).");
            boolean canHostGuests =
                input.nextLine().trim().charAt(0) == 'y'
                ? true : false;
            System.out.println();

            list.add(new PersonalChefRobot(name, bestDish,
                mealsServed, menu, canHostGuests));
        } else if (userInput == 3) {    // RestaurantChef
            System.out.println("Please enter their name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter their best dish.");
            String bestDish = input.nextLine();
            System.out.println();
            System.out.println("Please enter the number of "
                + "meals they have served.");
            int mealsServed = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter all the items on their "
                + "menu, separated by commas "
                + "(ex: pasta, bread, ham).");
            String menuResponse = input.nextLine();
            String[] menu = menuResponse.split(",");
            for (int i = 0; i < menu.length; i++) {
                menu[i] = menu[i].trim();
            }
            System.out.println();
            System.out.println("Please enter the number of "
                + "celebrities they have met.");
            int celebritiesMet = input.nextInt();
            input.nextLine();
            System.out.println();

            list.add(new RestaurantChefRobot(name, bestDish,
                mealsServed, menu, celebritiesMet));
        }
    }

    /**
     * Allows the user to select a robot and perform an action.
     *
     * @param list a list of robots existing in the simulation
     * @param userInput the user's previous input
     * @param input the Scanner object to take in additional user input
     */
    public static void takeRobotAction(LinkedList<Robot> list, int userInput,
        Scanner input) {
        System.out.println("Which robot would you like to control?");
        listRobots(list);
        System.out.println();

        userInput = input.nextInt();
        input.nextLine();
        System.out.println();

        Robot selectedRobot = list.get(userInput);
        if (selectedRobot instanceof RestaurantChefRobot) {
            System.out.println("What action would you like "
                + "to perform?");
            System.out.println("0. See best dish");
            System.out.println("1. See number of meals served");
            System.out.println("2. Serve meal");
            System.out.println("3. View the number of celebrities met");
            System.out.println();

            userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                String bestDish = ((RestaurantChefRobot) selectedRobot)
                    .getBestDish();
                System.out.println(selectedRobot.getName()
                    + "'s best dish is " + bestDish + ".");
                System.out.println();
            } else if (userInput == 1) {
                int mealsServed = ((RestaurantChefRobot) selectedRobot)
                    .getMealsServed();
                System.out.println(selectedRobot.getName()
                    + " has served " + mealsServed + " meals.");
                System.out.println();
            } else if (userInput == 2) {
                String meal = ((RestaurantChefRobot) selectedRobot)
                    .serveMeal();
                System.out.println(selectedRobot.getName()
                    + " served " + meal + ".");
                System.out.println();
            } else if (userInput == 3) {
                int celebs = ((RestaurantChefRobot) selectedRobot)
                        .getCelebritiesMet();
                System.out.println(selectedRobot.getName()
                    + " has met " + celebs + " celebrities!");
                System.out.println();
            }
        } else if (selectedRobot instanceof PersonalChefRobot) {
            System.out.println("What action would you like "
                + "to perform?");
            System.out.println("0. See best dish");
            System.out.println("1. See number of meals served");
            System.out.println("2. Serve meal");
            System.out.println("3. Check if it can host guests");
            System.out.println();

            userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                String bestDish =
                    ((PersonalChefRobot) selectedRobot).getBestDish();
                System.out.println(selectedRobot.getName()
                    + "'s best dish is " + bestDish + ".");
                System.out.println();
            } else if (userInput == 1) {
                int mealsServed =
                    ((PersonalChefRobot) selectedRobot)
                        .getMealsServed();
                System.out.println(selectedRobot.getName()
                    + " has served " + mealsServed + " meals.");
                System.out.println();
            } else if (userInput == 2) {
                String meal =
                    ((PersonalChefRobot) selectedRobot).serveMeal();
                System.out.println(selectedRobot.getName()
                    + " served " + meal + ".");
                System.out.println();
            } else if (userInput == 3) {
                boolean canHostGuests =
                    ((PersonalChefRobot) selectedRobot)
                    .getCanHostGuests();
                System.out.println(selectedRobot.getName()
                    + (canHostGuests ? " can" : " cannot")
                    + " host guests.");
                System.out.println();
            }
        } else if (selectedRobot instanceof ChefRobot) {
            System.out.println("What action would you like "
                + "to perform?");
            System.out.println("0. See best dish");
            System.out.println("1. See number of meals served");
            System.out.println("2. Serve meal");
            System.out.println();

            userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                String bestDish = ((ChefRobot) selectedRobot)
                    .getBestDish();
                System.out.println(selectedRobot.getName()
                    + "'s best dish is " + bestDish + ".");
                System.out.println();
            } else if (userInput == 1) {
                int mealsServed = ((ChefRobot) selectedRobot)
                    .getMealsServed();
                System.out.println(selectedRobot.getName()
                    + " has served " + mealsServed + " meals.");
                System.out.println();
            } else if (userInput == 2) {
                String meal = ((ChefRobot) selectedRobot)
                    .serveMeal();
                System.out.println(selectedRobot.getName()
                    + " served " + meal + ".");
                System.out.println();
            }
        } else if (selectedRobot instanceof GovernmentRobot) {
            System.out.println("What action would you like "
                + "to perform?");
            System.out.println("0. See number of projects completed");
            System.out.println();

            userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                int projectCount = ((GovernmentRobot) selectedRobot)
                    .getProjectCount();
                System.out.println(projectCount
                    + " projects have been completed.");
                System.out.println();
            }
        }
        System.out.println();
    }
}