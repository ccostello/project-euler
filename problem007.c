#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool
is_prime(int num)
{
  for (int i = 2; i < num; i++) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}

int
main(int argc, char **argv)
{
  int pcount = 0;
  int find = atoi(argv[1]);
  bool values[500000]; // maybe this is enough? true for composite
  for (int i = 2; i < sizeof(values); i++) {
    if (values[i]) {
      // already marked composite
      continue;
    }
    if (is_prime(i)) {
      if (++pcount == find) {
        printf("found %dth prime = %d\n", find, i);
        break;
      }
      for (int j = 2; i * j < sizeof(values); j++) {
        values[i * j] = true;
      }
    }
  }
}