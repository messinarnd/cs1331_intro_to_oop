// I worked on this alone.

import java.util.Scanner;
import java.util.Random;
//NOTE: YOU ARE NOT ALLOWED TO USE THE ARRAYS CLASS:
import java.util.Arrays;

/**
 * A driver for running the Star Trek simulation
 *
 * @author Chase Lewis and Christopher Messina
 * @version 1.0
 */
public class StarTrekSim {
    /**
    * A random number generator.
    */
    private static Random randGen = new Random();
    /**
    * An AstronomicalObject array.
    */
    private AstronomicalObject[] detected;


    /**
     * The only constructor for the StarTrekSim class.
     * DO NOT EDIT
     */
    public StarTrekSim() {
        detected = new AstronomicalObject[]{};
    }

    /**
     * The main method for running the Star Trek game.
     * DO NOT EDIT.
     *
     * @param args The arguments passed in when the file is run from terminal
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StarTrekSim game = new StarTrekSim();

        printStarTrek();
        System.out.println(""
            + "Welcome to Star Trek Explorer. As the captain of the U.S.S \n"
            + "Compiler, it is your mission to explore strange new worlds;\n"
            + "to seek out new life and new civilizations; to boldly go\n"
            + "where no one has gone before.");

        game.newSystem();
        int input = 0;
        while (input != 7) {
            System.out.println("\nWould you like to:");
            System.out.println("1. List all detected objects");
            System.out.println("2. Observe all detected objects");
            System.out.println("3. Warp to a new system");
            System.out.println("4. Attack");
            System.out.println("5. Embark");
            System.out.println("6. Scan");
            System.out.println("7. Quit");
            System.out.println("Please enter one of the options above:");

            input = scan.nextInt();
            while (input < 1 || input > 7) {
                System.out.println("Please enter a number 1-6");
                input = scan.nextInt();
            }

            System.out.println();

            if (input == 1) {
                game.listObjects();
            } else if (input == 2) {
                game.observe();
            } else if (input == 3) {
                game.newSystem();
            } else if (input == 4) {
                game.attack();
            } else if (input == 5) {
                game.embark();
            } else {
                game.scan();
            }
        }
    }

    /**
     * A method for printing out each object in the detected array. Functions
     * by calling each object's toString() method implicitly (hint)
     * DO NOT EDIT!
     */
    private void listObjects() {
        for (AstronomicalObject obj: detected) {
            System.out.println(obj);
        }
    }

    /**
    * A method for describing each object in the detected array. Calls
    * the observed() method in the AstronomicalObject class.
    */
    private void observe() {
        //YOUR CODE HERE: Print the result of the observed() method on each
        //object in the detected array.
        for (int i = 0; i < detected.length; i++) {
            String s = detected[i].observed();
            System.out.println(s);
        }
    }

    /**
    * A method for attacking a random object that implements the Attackable
    * interface. Calls on each object's attacked() method.
    */
    private void attack() {
        //YOUR CODE HERE: Randomly select an Attackable object from the detected
        //array and attack it
        int attObjCount = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Attackable) {
                attObjCount++;
            }
        }
        int[] ndx = new int[attObjCount];
        int index = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Attackable) {
                ndx[index] = i;
                index++;
            }
        }

        Random rand = new Random();
        int r = rand.nextInt(attObjCount);
        int a = ndx[r];
        String s = ((Attackable) detected[a]).attacked();
        System.out.println(s);
    }

    /**
    * A method for attempting to board a random object that implements the
    * Embarkable interface. Calls on each object's boarded() method.
    */
    private void embark() {
        //YOUR CODE HERE: Randomly select an Embarkable object from the detected
        //array and board it
        int embObjCount = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Embarkable) {
                embObjCount++;
            }
        }
        int[] ndx = new int[embObjCount];
        int index = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Embarkable) {
                ndx[index] = i;
                index++;
            }
        }

        Random rand = new Random();
        int r = rand.nextInt(embObjCount);
        int a = ndx[r];
        String s =  ((Embarkable) detected[a]).boarded();
        System.out.println(s);
    }

    /**
    * A method for scanning a random object that implements the Scannable
    * interface. Calls on each object's scanned() method.
    */
    private void scan() {
        //YOUR CODE HERE: Randomly select a Scannable object from the detected
        //array and scan it
        int scnObjCount = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Scannable) {
                scnObjCount++;
            }
        }
        int[] ndx = new int[scnObjCount];
        int index = 0;
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Scannable) {
                ndx[index] = i;
                index++;
            }
        }

        Random rand = new Random();
        int r = rand.nextInt(scnObjCount);
        int a = ndx[r];
        String s =  ((Scannable) detected[a]).scanned();
        System.out.println(s);
    }

    //NOTE: DON'T CHANGE ANY CODE PAST THIS LINE!!!!!

    /**
     * A method which prints out "Star Trek" in ASCII
     * DO NOT EDIT!
     */
    private static void printStarTrek() {
        System.out.println(""
            + "=================================="
            + "================================\n"
            + "     ______ _______ ______ ______   "
            + " _______ ______  ______ __  __\n"
            + "    / __  //__  __// __  // __  /   "
            + "/__  __// __  / / ____// / / /\n"
            + "   / / /_/   / /  / /_/ // /_/ /     "
            + " / /  / /_/ / / /__  / //'/'\n"
            + "   _\\ \\     / /  / __  //   __/    "
            + "  / /  /   __/ / __ / /  '/'\n"
            + " / /_/ /   / /  / / / // /\\ \\     "
            + "  / /  / /\\ \\  / /___ / /\\ \\\n"
            + "/_____/   /_/  /_/ /_//_/  \\_\\    "
            + " /_/  /_/  \\_\\/_____//_/  \\_\\"
            + "\n================================="
            + "================================\n");
    }

    /**
     * A method for generating a new system. It prints out a status message and
     * randomly generates a new array of objects.
     * DO NOT EDIT!
     */
    private void newSystem() {
        System.out.printf("\nAfter traveling at Warp %.1f ",
            randGen.nextDouble() * 10);
        System.out.printf("for %d days, you arrive at a new system.\n",
            randGen.nextInt(8) + 2);
        System.out.println("Your sensors detect a few objects in the near"
            + " vicinity.");
        System.out.println("What are your orders, Captain?\n");

        detected = new AstronomicalObject[randGen.nextInt(4) + 4];
        for (int i = 4; i < detected.length; i++) {
            int select = randGen.nextInt(4);
            if (select == 0) {
                detected[i] = new Planet();
            } else if (select == 1) {
                detected[i] = new Star();
            } else if (select == 2) {
                detected[i] = new Asteroid();
            } else {
                detected[i] = new Spaceship();
            }
        }
        detected[0] = new Planet();
        detected[1] = new Star();
        detected[2] = new Asteroid();
        detected[3] = new Spaceship();
        //If you are getting an error from this line, make sure you have
        //implemented the Comparable interface!!!
        Arrays.sort(detected);
    }
}
