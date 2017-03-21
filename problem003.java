import java.util.List;
import java.util.ArrayList;

class Factorer {
  public static List<Long> factorsForNumber(long number) {
    List<Long> factors = new ArrayList<>();
    long startFactor = 2;
    while (startFactor < number) {
      for (long x = startFactor; x <= number; x++) {
        if ((number % x) == 0) {
          number /= x;
          factors.add(x);
          startFactor = x;
          break;
        }
      }
    }
    return factors;
  }

  public static long largestFactorForNumber(long number) {
    if (number < 0) {
      number *= -1;
    }
    if (number == 1L) {
      return 1L;
    }

    long factor = 2;
    while (factor < number) {
      for (long x = factor; x <= number; x++) {
        if ((number % x) == 0) {
          number /= x;
          factor = x;
          break;
        }
      }
    }
    return factor;
  }
}

public class problem003 {
  public static void main(String[] args) {
    if (args[0].equals("-a")) {
      for (Long factor : Factorer.factorsForNumber(Long.parseLong(args[1]))) {
        System.out.println(factor);
      }
      return;
    }
    System.out.println(Factorer.largestFactorForNumber(Long.parseLong(args[0])));
  }
}