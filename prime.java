import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;

class PrimeChecker {

    public static BigInteger sqrt(BigInteger n) {
	BigInteger a = BigInteger.ONE;
	BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8"))
				      .toString());
	while (b.compareTo(a) >= 0) {
	    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
	    if (mid.multiply(mid).compareTo(n) > 0)
		b = mid.subtract(BigInteger.ONE);
	    else
		a = mid.add(BigInteger.ONE);
	}
	return a.subtract(BigInteger.ONE);
    }

    public static boolean isPrime(BigInteger n) {

	BigInteger two = new BigInteger("2");

	if (n.equals(BigInteger.ONE)) {
	    return false;
	} else if (n.equals(two)) {
	    return true;
	} else if (n.mod(two).equals(BigInteger.ZERO)) {
	    return false; // even
	}
		
	LinkedList<BigInteger> list = new LinkedList<>();

	for (BigInteger i = BigInteger.valueOf(3); 
	     i.compareTo(sqrt(n).add(BigInteger.ONE)) < 0; i = i.add(two)) {
	    if(n.mod(i).equals(BigInteger.ZERO)) {
		list.add(i);
	    }
	}

	return list.isEmpty();
    }

    public static void main(String[] args) {
	BigInteger big = new BigInteger("1125899906842679");
	BigInteger little = new BigInteger("1");
	BigInteger one = new BigInteger("1");

	long startTime = System.currentTimeMillis();
	System.out.println(isPrime(big));
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	System.out.println("Running Time: " + totalTime + " msecs");
    }
}
