#include <deque>
#include <iostream>
#include <set>
#include <vector>
using namespace std;

int main() {
  int n, k;
  cin >> n >> k;

  deque<int> window;
  multiset<int> minSet;

  vector<int> nums(n);
  for (int i = 0; i < n; i++) {
    cin >> nums[i];
  }

  for (int i = 0; i < n; i++) {
    window.push_back(nums[i]);
    minSet.insert(nums[i]);

    if (i >= k - 1) {
      cout << *minSet.begin() << " ";

      minSet.erase(minSet.find(window.front()));
      window.pop_front();
    }
  }
  cout << endl;

  return 0;
}