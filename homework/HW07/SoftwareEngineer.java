// I worked on this alone.

/**
* A class representing a SoftwareEngineer Object. Extends TenXer and
* implements the comparable interface specifying the type to be TenXer.
* @author Christopher Messina
* @version 1.4
*/
public class SoftwareEngineer extends TenXer implements Comparable<TenXer> {
    private int githubStars;
    private boolean knowsJava;

    /**
    * The class's only constructor. Calls on TenXer's constructor.
    * @param name a String representing the name of this SoftwareEngineer
    * @param salary an int representing the annual salary
    * @param yearsExperience an int number of years of experience
    * @param githubStars an int number of Github Stars
    * @param knowsJava a boolean if the Engineer knows Java or not
    */
    public SoftwareEngineer(String name, int salary, int yearsExperience,
        int githubStars, boolean knowsJava) {
        super(name, salary, yearsExperience);
        this.githubStars = githubStars;
        this.knowsJava = knowsJava;
    }

    /**
    * Compares two SoftwareEngineers. Overrides TenXer's compareTo method.
    * @param other a TenXer object
    * @return Returns 1 if this has more Github Stars(higher weight) or
    *         knows Java(lower weight) over the other TenXer. Compares
    *         the class names using String's compareTo method if other
    *         is not a SoftwareEngineer.
    */
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof SoftwareEngineer) {
            SoftwareEngineer sOther = (SoftwareEngineer) other;
            if (this.getGithubStars() > sOther.getGithubStars()) {
                return 1;
            } else if (this.getGithubStars() < sOther.getGithubStars()) {
                return -1;
            } else {
                if (this.getKnowsJava() && !(sOther.getKnowsJava())) {
                    return 1;
                } else if (!(this.getKnowsJava()) && sOther.getKnowsJava()) {
                    return -1;
                } else {
                    return super.compareTo(sOther);
                }
            }
        } else {
            return getClass().getCanonicalName().compareTo(
            other.getClass().getCanonicalName());
        }
    }

    /**
    * Give a string representation of the SoftwareEngineer. Overrides
    * TenXer's toString. Calls on TenXer's toString method.
    * @return a String extending the String from Tenxer's toString
    *         adding the number of Github Stars and if they know Java.
    */
    @Override
    public String toString() {
        if (this.getKnowsJava()) {
            return super.toString() + "\n\tGithub Stars: "
                + this.getGithubStars() + "\n\tKnows Java: Yes!";
        } else {
            return super.toString() + "\n\tGithub Stars: "
                + this.getGithubStars() + "\n\tKnows Java: No";
        }
    }


    /**
    * Determines if two SoftwareEngineers are the same. Overrides
    * TenXer's equals(). Calls on TenXer's equals().
    * @param obj a SoftwareEngineer object
    * @return a boolean stating if the objects are equal
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof SoftwareEngineer)) {
            return false;
        }
        SoftwareEngineer s = (SoftwareEngineer) obj;
        boolean a = this.getGithubStars() == s.getGithubStars();
        boolean b = this.getKnowsJava() == s.getKnowsJava();
        return super.equals(s) && a && b;
    }

    /**
    * Getter method for private data githubStars.
    * @return an int Github Stars
    */
    public int getGithubStars() {
        return githubStars;
    }

    /**
    * Getter method for private data knowsJava.
    * @return a boolean representing if this knows Java
    */
    public boolean getKnowsJava() {
        return knowsJava;
    }
}