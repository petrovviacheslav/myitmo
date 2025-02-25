//
// Created by petrovviacheslav on 18.02.25.
//

#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, k;
  cin >> n >> k;
  vector<int> stalls(n);

  for (int i = 0; i < n; ++i)
    cin >> stalls[i];

  int left = 0, right = stalls[n - 1] - stalls[0];

  while (left < right) {
    int middle = left + (right - left) / 2;
    int count_cows = 1, cur_stall = stalls[0];

    for (int i = 0; i < n; ++i) {
      if (stalls[i] - cur_stall > middle) {
        cur_stall = stalls[i];
        count_cows++;
      }
    }

    if (count_cows < k)
      right = middle;
    else
      left = middle + 1;
  }

  cout << left << endl;
  return 0;
}