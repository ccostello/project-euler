import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Factorer {
  public static List<Integer> factorsForNumber(int number) {
    List<Integer> factors = new ArrayList<Integer>();

    if (number == 1) {
      return Collections.singletonList(new Integer(1));
    }

    for (int i = 2; i < number; i++) {
      if ((number % i) == 0) {
        factors.add(i);
        factors.addAll(factorsForNumber(number / i));
      }
    }
    return factors;
  }
}

public class problem003 {
  public static void main(String[] args) {
    for (Integer i : Factorer.factorsForNumber(1048576)) {
      System.out.println(i);
    }
  }
}