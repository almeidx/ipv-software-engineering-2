package com.es2.blackboxpartitioning;

import java.util.Random;

public class Die {
    public static final int DEFAULT_SIDES = 6;
    private int numSides;
    private int result;

    /**
     * Default constructor.
     * pre: none
     * post: getNumSides() = DEFAULT_SIDES = 6, getResult() = 1
     */
    public Die() {
        this.numSides = DEFAULT_SIDES;
        this.result = 1;
    }

    /**
     * Create a Die with numSides sides
     * Parameters:
     * numSides - specifies the number of sides of the die
     * pre: numSides > 1 && numSides <=6
     * post: getNumSides() = numSides, getResult() = 1
     * Throws:
     * java.lang.AssertionError - if the preconditions are not met
     */
    public Die(int numSides) throws AssertionError {
        assert numSides > 1 && numSides <= 6 : "Number of sides must be between 2 and 6";
        this.numSides = numSides;
        this.result = 1;
    }

    /**
     * Create a Die with numSides and top side and result set to result
     * Parameters:
     * numSides - specifies the number of sides of the die
     * result - specifies the current result of the die, indicated by the top side
     * pre: numSides > 1, 1 <= result <= numSides
     * post: getNumSides() = numSides, getResult() = 1
     * AssertionError exception will be generated if the preconditions are not met
     */
    public Die(int numSides, int result) throws AssertionError {
        assert numSides > 1 : "Number of sides must be greater than 1";
        assert result >= 1 && result <= numSides : "Result must be between 1 and the number of sides";
        this.numSides = numSides;
        this.result = result;
    }

    /**
     * Roll this Die. Every side has an equal chance of being the new result
     * pre: none
     * post: 1 <= getResult() <= getNumSides()
     * Returns:
     * the result of the Die after the roll Code to generate a new number randomly
     *  Random ourRandNumGen = new Random();
     *  ....
     *  iMyResult = ourRandNumGen.nextInt(iMyNumSides) + 1;
     */
    public int roll() {
        Random rand = new Random();
        this.result = rand.nextInt(numSides) + 1;
        return this.result;
    }

    /**
     * Determines how many sides this Die has
     * pre: none
     * post: return how many sides this Die has
     * Returns:
     * the number of sides on this Die
     */
    public int getNumSides() {
        return this.numSides;
    }

    /**
     * Get the current result or top number of this Die
     * pre: none
     * post: return the number on top of this Die
     * Returns:
     * Returns the current result of this Die
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Returns a String containing information about this Die
     * pre: none
     * post: return a String with information about the current state of this Die
     * Overrides:
     * toString in class java.lang.Object
     */
    public String toString() {
        return "Die with " + numSides + " sides, current result is " + result;
    }
}
