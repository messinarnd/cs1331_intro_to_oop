// I worked with Choukri Nyon

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
* A class representing a listSongs Object. Allows you to search
* for a specified song.
* @author Christopher Messina
* @version 1.0
*/
public class ListSongs {

    /**
     * Given the path to a directory and a Scanner that has been initalized to
     * read from the directory's contents.txt file, returns a 2-dimensional
     * String array of length 2 representing the contents of the directory.
     * The first inner array contains the paths of each file in the directory,
     * while the second inner array contains the paths to each sub-directory.
     *
     * @param baseDir the path to the directory to get the contents of
     * @param contentsScanner a Scanner that has been initialized to read from
     *        the directory's contents.txt file.
     * @return the paths of the files and sub-directories contained in baseDir
     */
    private static String[][] parseContentsFile(String baseDir,
        Scanner contentsScanner) {

        String[] files = new String[0];
        String[] dirs = new String[0];

        if (contentsScanner.hasNextLine()) {
            String line = contentsScanner.nextLine();
            if (line.split("files: ").length > 1) {
                files = line.split("files: ")[1].split(", ");
            }
        }

        if (contentsScanner.hasNextLine()) {
            String line = contentsScanner.nextLine();
            if (line.split("dirs: ").length > 1) {
                dirs = line.split("dirs: ")[1].split(", ");
            }
        }

        for (int i = 0; i < files.length; i++) {
            files[i] = baseDir + "/" + files[i];
        }

        for (int i = 0; i < dirs.length; i++) {
            dirs[i] = baseDir + "/" + dirs[i];
        }

        return new String[][] {files, dirs};
    }

    /**
    * Checks if the correct number of arguments are given and
    * throws an exception if there aren't enough.
    * @param myArgs a String array of your arguments
    */
    private static void validateArguments(String[] myArgs) {
        if (myArgs.length == 0) {
            MissingArgumentException e = new MissingArgumentException();
            throw e;
        } else if (myArgs.length == 1) {
            MissingArgumentException e = new MissingArgumentException(1,
                "artist or genre");
            throw e;
        } else if (myArgs.length == 2) {
            if (myArgs[1].equals("artist")) {
                MissingArgumentException e = new MissingArgumentException(2,
                    "artist name");
                throw e;
            } else {
                MissingArgumentException e = new MissingArgumentException(2,
                    "genre name");
                throw e;
            }
        }

        if (!(myArgs[1].equals("genre") || myArgs[1].equals("artist"))) {
            String msg = "Invalid argument at position 1: expected "
                + "\"genre\" or \"artist\" but got \"" + myArgs[1] + "\".";
            IllegalArgumentException e = new IllegalArgumentException(msg);
            throw e;
        }
    }

    /**
    * Given an attribute of either artist or genre, the name of the attribute,
    * and a scanner that has already been initialized to read through a song
    * file,
    * returns a String of all the songs that match the given criteria.
    * @param aOrG "artist" or "genre" attribute
    * @param name the name of the artist/genre being searched
    * @param songScanner the scanner used to scan song files
    * @return a String of the songs matching the given criteria
    */
    private static String parseSongFile(String aOrG, String name,
        Scanner songScanner) {
        String songName = songScanner.nextLine();
        String artistName = songScanner.nextLine();
        String genreName = songScanner.nextLine();
        String[] songName1 = songName.split(": ");
        String[] artistName1 = artistName.split(": ");
        String[] genreName1 = genreName.split(": ");


        if (artistName1[1].equals(name) || genreName1[1].equals(name)) {
            return songName1[1] + " by " + artistName1[1] + "\n";
        } else {
            return "";
        }
    }

    /**
    * Finds songs matching the criteria (artist or genre) that the user inputs.
    * @param dir the path of the directory to search given as a string
    * @param aOrG "artist" or "genre" attribute
    * @param name the name of the artist/genre
    * @return a String of all the matches
    */
    private static String findSongs(String dir, String aOrG,
        String name) throws MissingContentsFileException {
        File myDir = new File(dir);
        String[] myFiles = myDir.list();

        String conFileDir;
        File conFile;
        Scanner contentsScanner;
        String[][] dirContents;
        conFileDir = dir + "/contents.txt";
        conFile = new File(conFileDir);
        try {
            contentsScanner = new Scanner(conFile);
        } catch (FileNotFoundException e) {
            MissingContentsFileException ex = new
                MissingContentsFileException(dir);
            throw ex;
        }

        dirContents = parseContentsFile(dir, contentsScanner);
        String matches = new String();
        Scanner fileScanner;
        File thisFile;
        String fn;
        for (int i = 0; i < dirContents[0].length; i++) {
            try {
                fn = dirContents[0][i];
                thisFile = new File(fn);
                fileScanner = new Scanner(thisFile);
                matches = matches + parseSongFile(aOrG, name, fileScanner);
            } catch (FileNotFoundException e) {
                fn = dirContents[0][i];
                System.out.println("File not found: " + fn + "\n");
            }
        }

        String s = new String();
        for (int i = 0; i < dirContents[1].length; i++) {
            s = findSongs(dirContents[1][i], aOrG, name);
        }
        return matches + s;
    }

    /**
    * The main method for ListSongs.
    * @param args The command line arguments given by the user
    */
    public static void main(String[] args) {
        validateArguments(args);

        String songs = new String();
        try {
            songs = findSongs(args[0], args[1], args[2]);
            if (args[1].equals("artist")) {
                if (songs.isEmpty()) {
                    NoSuchArtistException exc = new
                        NoSuchArtistException(args[2], args[0]);
                    throw exc;
                }
            } else if (args[1].equals("genre")) {
                if (songs.isEmpty()) {
                    NoSuchGenreException exc = new
                        NoSuchGenreException(args[2], args[0]);
                    throw exc;
                }
            }

            System.out.println(songs);
        } catch (MissingContentsFileException e) {
            System.out.println("MissingContentsFileException: "
                + e.getMessage());
        }


    }
}