import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// 1048576
// 2, 524288
//    2, 262144
//       2, 131072
//          2, 65536
//             2, 32768
//                2, 16384
//                   2, 8192
//                      2, 4096
//                         2, 2048
// ...

class CompositeNumber {
  private long number;
  private CompositeNumber left;
  private CompositeNumber right;
  private boolean factored;

  public CompositeNumber(long number) {
    this.number = number;
  }

  public CompositeNumber getLeft() {
    return left;
  }

  public CompositeNumber getRight() {
    return right;
  }

  public long getValue() {
    return number;
  }

  public boolean factored() {
    return factored;
  }

  public boolean isPrime() {
    return (factored() && getLeft() == null && getRight() == null);
  }

  public void factor() {
    if (number == 1)
      return;

    for (long i = 2; i < number; i++) {
      if ((number % i) == 0) {
        this.left = new CompositeNumber(i);
        this.right = new CompositeNumber(number/i);
        this.left.factor();
        this.right.factor();
        break;
      }
    }

    factored = true;
  }

  public List<Long> getFactors() {
    List<Long> factors = new ArrayList<Long>();
    if (getLeft().isPrime()) {
      factors.add(getLeft().getValue());
    } else {
      factors.addAll(getLeft().getFactors());
    }

    if (getRight().isPrime()) {
      factors.add(getRight().getValue());
    } else {
      factors.addAll(getRight().getFactors());
    }

    return factors;
  }

  // Now here's the implementation-specific bit. We always put the largest of the two factors on the right of the tree.
  public long largestFactor() {
    if (isPrime()) {
      return getValue();
    }
    return getRight().largestFactor();
  }
}

class Factorer {
  public static List<Long> factorsForNumber(long number) {
    CompositeNumber composite = new CompositeNumber(number);
    composite.factor();
    return composite.getFactors();
  }

  public static long largestFactorForNumber(long number) {
    CompositeNumber compositeNumber = new CompositeNumber(number);
    compositeNumber.factor();
    return compositeNumber.largestFactor();
  }
}

public class problem003 {
  public static void main(String[] args) {
    System.out.println(Factorer.largestFactorForNumber(Long.parseLong(args[0])));
  }
}