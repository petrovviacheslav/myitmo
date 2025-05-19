#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  string line;
  vector<string> nums;
  while (cin >> line) {
    nums.push_back(line);
  }

  sort(nums.begin(), nums.end(), [](const string& a, const string& b) { return a + b > b + a; });

  for (const auto& num : nums) {
    cout << num;
  }
  return 0;
}