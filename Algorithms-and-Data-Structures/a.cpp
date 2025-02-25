//
// Created by petrovviacheslav on 17.02.25.
//

#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  int left = 1, right = 1;
  int possibly_left = 1;
  int prev_value = 0, prev_prev_value = 0, curr_value;

  for (int i = 1; i <= n; i++) {
    cin >> curr_value;

    if (i > 2 && curr_value == prev_value && prev_value == prev_prev_value) {
      if (i - 1 - possibly_left > right - left) {
        right = i - 1;
        left = possibly_left;
      }

      possibly_left = i - 1;
    }

    prev_prev_value = prev_value;
    prev_value = curr_value;
  }

  if (n - possibly_left > right - left) {
    right = n;
    left = possibly_left;
  }

  cout << left << " " << right << endl;
  return 0;
}