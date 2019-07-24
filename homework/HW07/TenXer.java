// I worked on this alone.

/**
* An abstract superclass representing a TenXer object. Implements
* the comparable interface specifying the type to be TenXer.
* @author Christopher Messina
* @version 1.1
*/
public abstract class TenXer implements Comparable<TenXer> {
    /**
    * Protected instance String repesenting this name.
    */
    protected String name;
    /**
    * Protected instance int representing this annual salary.
    */
    protected int annualSalary;
    /**
    * Protected instance int representing the years of experience.
    */
    protected int yearsExperience;

    /**
    * The class's only constructor.
    * @param name a String representing the name of this SoftwareEngineer
    * @param salary an int representing the annual salary
    * @param yearsExperience an int number of years of experience
    */
    public TenXer(String name, int salary, int yearsExperience) {
        this.name = name;
        this.annualSalary = salary;
        this.yearsExperience = yearsExperience;
    }

    /**
    * Overrides Object's toString method.
    * @return a string representing the name, salary,
    *         years of experience, and the type of employee
    */
    @Override
    public String toString() {
        String s = this.getClass().getCanonicalName();
        return name + " - " + s + "\n\tYears of Exp: "
            + yearsExperience + "\n\tSalary: "
            + annualSalary;
    }

    /**
    * Overrides Object's equals method.
    * @param obj an TenXer object
    * @return a boolean representing if the two TenXers are the same
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof TenXer)) {
            return false;
        }
        TenXer t = (TenXer) obj;
        boolean a = this.getName().equals(t.getName());
        boolean b = this.getAnnualSalary() == t.getAnnualSalary();
        boolean c = this.getYearsExperience() == t.getYearsExperience();

        return a && b && c;
    }

    /**
    * Compares two TenXers. Overrides Object's compareTo method.
    * @param other a TenXer object
    * @return Returns 1 if this has more years of experience(highest weight) or
    *         a lower salary than the other TenXer. If these are the same,
    *         calls on String's compareTo to compare the names.
    *         Compares the class names using String's compareTo method if other
    *         is not a TenXer.
    */
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof TenXer) {
            if (this.getYearsExperience() > other.getYearsExperience()) {
                return 1;
            } else if (this.getYearsExperience() < other.getYearsExperience()) {
                return -1;
            } else {
                if (this.getAnnualSalary() < other.getAnnualSalary()) {
                    return 1;
                } else if (this.getAnnualSalary() > other.getAnnualSalary()) {
                    return -1;
                } else {
                    return this.getName().compareToIgnoreCase(other.getName());
                }
            }
        } else {
            return getClass().getCanonicalName().compareTo(
                other.getClass().getCanonicalName());
        }
    }

    /**
    * Getter for the name data.
    * @return a String name
    */
    public String getName() {
        return name;
    }

    /**
    * Getter for the annualSalary data.
    * @return an int annualSalary
    */
    public int getAnnualSalary() {
        return annualSalary;
    }

    /**
    * Getter for the yearsExperience data.
    * @return an int yearsExperience
    */
    public int getYearsExperience() {
        return yearsExperience;
    }
}