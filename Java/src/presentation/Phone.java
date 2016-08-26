/**
 * 
 */
package presentation;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

/**
 * @author Dan
 *
 */
public class Phone {

/******************************************************************************
 *  Compilation:  javac PhoneNumber.java
 *  Execution:    java PhoneNumber
 *  
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  Last updated: Tue Jun 28 21:27:28 EDT 2016.
 *  
 *  Immutable data type for US phone numbers.
 *
 ******************************************************************************/
	Pattern p = Pattern.compile("(*)*-*");
	Matcher m = p.matcher("(407)614-4228");
	boolean b = m.matches();
	
    private final int countryCode;   // country code - default 1 = US
	private final int areaCode;   // area code (3 digits)
    private final int exchange;   // exchange  (3 digits)
    private final int localLine;    // direct dial local line (4 digits)
    private final int extension;    // internal extension

    public Phone(int areaCode, int exchange, int localLine) {
        this.countryCode = 1;
        this.areaCode = areaCode;
        this.exchange = exchange;
        this.localLine  = localLine;
        this.extension = 0;
    }

    public Phone(int countryCode, int areaCode, int exchange, int localLine) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.exchange = exchange;
        this.localLine  = localLine;
        this.extension = 0;
    }
    public Phone(int countryCode, int areaCode, int exchange, int localLine, int extension) {
        this.countryCode = countryCode;
    	this.areaCode = areaCode;
        this.exchange = exchange;
        this.localLine  = localLine;
        this.extension = extension;
    }

    // how you're supposed to implement equals
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Phone that = (Phone) y;
        return (this.areaCode == that.areaCode) 
        		&& (this.exchange == that.exchange) 
        		&& (this.localLine == that.localLine);
    }

    // 0 for padding with leading 0s
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, exchange, localLine);
    }

    // satisfies the hashCode contract
    public int hashCode() {
        return 10007 * (areaCode + 1009 * exchange) + localLine;
    }

    public static void main(String[] args) {
        Phone a = new Phone(609, 258, 4455);
        Phone b = new Phone(609, 876, 5309);
        Phone c = new Phone(609, 203, 5309);
        Phone d = new Phone(215, 876, 5309);
        Phone e = new Phone(609, 876, 5309);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("b == b:      " + (b == b));
        System.out.println("b == e:      " + (b == e));
        System.out.println("b.equals(b): " + (b.equals(b)));
        System.out.println("b.equals(e): " + (b.equals(e)));
    }

}
