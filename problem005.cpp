#include <iostream>
#include <list>
#include <map>
#include <stdexcept>
#include <cmath>

using namespace std;

class factor_reducer {
  int value;
  map<int, int> factor_counts;

public:
  factor_reducer(int max) {
    value = max;
  }

  void factor_and_collect(void) {
    for (int i = 0; i <= value; i++) {

      list<int> factors;
      factor(i, factors);
      update_factor_counts(factors);
    }
  }

  int least_common_multiple() {
    int multiple = 1;
    for (map<int, int>::iterator it = factor_counts.begin(); it != factor_counts.end(); ++it) {
      multiple *= pow((long double)it->first, it->second);
    }
    return multiple;
  }

private:
  void update_factor_counts(list<int> factors) {
    map<int, int> these_counts;
    for (list<int>::iterator it = factors.begin(); it != factors.end(); ++it) {
      these_counts[*it]++;
    }
    for (map<int, int>::iterator it = these_counts.begin(); it != these_counts.end(); ++it) {
      if (factor_counts[it->first] < it->second) {
        factor_counts[it->first] = it->second;
      }
    }
  }

  static void factor(int term, list<int> &factors) {
    if (term == 1) {
      return;
    }
    for (int i = 2; i <= term; i++) {
      if ((term % i) == 0) {
        int quotient = term / i;
        factors.push_back(i);
        factor(quotient, factors);
        break;
      }
    }
  }
};

int
main(int argc, char **argv)
{
  factor_reducer fr(atoi(argv[1]));
  fr.factor_and_collect();
  cout << fr.least_common_multiple() << endl;
}