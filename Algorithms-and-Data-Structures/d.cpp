//
// Created by petrovviacheslav on 17.02.25.
//
#include <iostream>
using namespace std;

int main() {
  int a, b, c, d;
  long k;
  cin >> a >> b >> c >> d >> k;

  if (b * a - c >= d)
    cout << d << endl;
  else if (b * a - c <= 0)
    cout << 0 << endl;
  else if (b * a - c == a)
    cout << a << endl;
  else {
    long i = 1;
    while (i <= k) {
      a = b * a - c;
      if (a >= d) {
        a = d;
        break;
      }
      if (a <= 0) {
        a = 0;
        break;
      }

      i++;
    }
    cout << a << endl;
  }

  return 0;
}