// I worked on this alone.

/**
* A class representing a Cfo Object. Extends TenXer and
* implements the comparable interface specifying the type to be TenXer.
* @author Christopher Messina
* @version 1.3
*/
public class Cfo extends TenXer implements Comparable<TenXer> {
    private int moneySkills;

    /**
    * The class's only constructor. Calls on TenXer's constructor.
    * @param name a String representing the name of this SoftwareEngineer
    * @param salary an int representing the annual salary
    * @param yearsExperience an int number of years of experience
    * @param moneySkills an int number of skills with money
    */
    public Cfo(String name, int salary, int yearsExperience, int moneySkills) {
        super(name, salary, yearsExperience);
        this.moneySkills = moneySkills;
    }

    /**
    * Compares two Cfos. Overrides TenXer's compareTo method.
    * @param other a TenXer object
    * @return Returns 1 if this has more money skills over the other TenXer.
    *         Compares the class names using String's compareTo method if other
    *         is not a Cfo.
    */
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof Cfo) {
            Cfo cOther = (Cfo) other;
            if (this.getMoneySkills() > cOther.getMoneySkills()) {
                return 1;
            } else if (this.getMoneySkills() < cOther.getMoneySkills()) {
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
    * Give a string representation of the Cfo. Overrides
    * TenXer's toString. Calls on TenXer's toString method.
    * @return a String extending the String from Tenxer's toString
    *         adding the number of money skills.
    */
    @Override
    public String toString() {
        return super.toString() + "\n\tMoney Skills: " + this.getMoneySkills();
    }

    /**
    * Determines if two Cfos are the same. Overrides
    * TenXer's equals(). Calls on TenXer's equals().
    * @param obj a Cfo object
    * @return a boolean stating if the objects are equal
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Cfo)) {
            return false;
        }
        Cfo c = (Cfo) obj;
        boolean a = this.getMoneySkills() == c.getMoneySkills();

        return super.equals(c) && a;
    }

    /**
    * Getter method for private data moneySkills.
    * @return an int moneySkills
    */
    public int getMoneySkills() {
        return moneySkills;
    }
}