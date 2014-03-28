#include <stdio.h>

/*
 * 1 2 3 5 8 13 21 34 55 79 89 144 233 377 610
 * 2 8 34 144 610
 * 10 44 188 798
 * So the sum would be: F2 + F5 + F8 + F11 + ...
 */

int 
fib(int n)
{
  static int solutions[30];

  if (n <= 1)
    return (n);
  
  if (n < 30) {
    if (!solutions[n])
      solutions[n] = fib(n-1) + fib(n-2);

    return (solutions[n]);
  }
  
  return (fib(n-1) + fib(n-2));
}

int
main(void)
{
  /* I don't know how to figure out the value of a fibonacci number near X,
   * so I have to iterate. */
  int sum = 0;
  for (int i = 3; sum < 4000000; i += 3) {
    sum += fib(i);
  }
  printf("%d\n", sum);
}