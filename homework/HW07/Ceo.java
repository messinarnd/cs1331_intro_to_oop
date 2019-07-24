//I worked on this alone.

/**
* A class representing a Cfo Object. Extends TenXer and
* implements the comparable interface specifying the type to be TenXer.
* @author Christopher Messina
* @version 1.2
*/
public class Ceo extends TenXer implements Comparable<TenXer> {
    private int numStartups;

    /**
    * The class's only constructor. Calls on TenXer's constructor.
    * @param name a String representing the name of this SoftwareEngineer
    * @param salary an int representing the annual salary
    * @param yearsExperience an int number of years of experience
    * @param numStartups an int number of startups
    */
    public Ceo(String name, int salary, int yearsExperience, int numStartups) {
        super(name, salary, yearsExperience);
        this.numStartups = numStartups;
    }

    /**
    * Compares two Ceos. Overrides TenXer's compareTo method.
    * @param other a TenXer object
    * @return Returns 1 if this has less number of startups over the other
    *         TenXer. Calls TenXer's compareTo if number of startups is the
    *         same. Compares the class names using String's compareTo method
    *         if other
    *         is not a Ceo.
    */
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof Ceo) {
            Ceo cOther = (Ceo) other;
            if (this.getNumStartups() < cOther.getNumStartups()) {
                return 1;
            } else if (this.getNumStartups() > cOther.getNumStartups()) {
                return -1;
            } else {
                return super.compareTo(cOther);
            }
        } else {
            return getClass().getCanonicalName().compareTo(
            other.getClass().getCanonicalName());
        }
    }

    /**
    * Give a string representation of the Ceo. Overrides
    * TenXer's toString. Calls on TenXer's toString method.
    * @return a String extending the String from Tenxer's toString
    *         adding the number of startups.
    */
    @Override
    public String toString() {
        return super.toString() + "\n\tNumber of startups: "
            + this.getNumStartups();
    }

    /**
    * Determines if two Ceos are the same. Overrides
    * TenXer's equals(). Calls on TenXer's equals().
    * @param obj a Ceo object
    * @return a boolean stating if the objects are equal
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Ceo)) {
            return false;
        }
        Ceo c = (Ceo) obj;
        boolean a = this.getNumStartups() == c.getNumStartups();

        return super.equals(c) && a;
    }

    /**
    * Getter for private data numStartups.
    * @return an int number of startups
    */
    public int getNumStartups() {
        return numStartups;
    }
}