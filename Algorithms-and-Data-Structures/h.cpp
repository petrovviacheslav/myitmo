//
// Created by petrovviacheslav on 17.02.25.
//

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, k;
  cin >> n >> k;
  vector<int> prices(n);

  for (int i = 0; i < n; i++) {
    cin >> prices[i];
  }

  sort(prices.begin(), prices.end());

  int answer = 0;
  for (int i = 0; i < n; i++) {
    if ((n - i) % k == 0) {
      continue;
    }
    answer += prices[i];
  }

  cout << answer << endl;

  return 0;
}