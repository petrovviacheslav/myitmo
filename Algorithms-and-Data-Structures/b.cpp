#include <algorithm>
#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
  string str;
  cin >> str;
  int n = str.size();
  int count_upper = -1, count_lower = -1;
  stack<pair<int, char>> stack_letters;
  vector<int> positions(n / 2);

  for (int i = 0; i < n; ++i) {
    if (isupper(str[i]))
      count_upper++;
    else
      count_lower++;

    if (!stack_letters.empty() && stack_letters.top().second == str[i] + 32) {
      // текущий - большой
      positions[count_upper] = stack_letters.top().first + 1;
      stack_letters.pop();
    } else if (!stack_letters.empty() && stack_letters.top().second == str[i] - 32) {
      // текущий - маленький
      positions[stack_letters.top().first] = count_lower + 1;
      stack_letters.pop();
    } else {
      if (isupper(str[i]))
        stack_letters.emplace(count_upper, str[i]);
      else
        stack_letters.emplace(count_lower, str[i]);
    }
  }

  if (stack_letters.empty()) {
    cout << "Possible" << endl;
    for (int pos : positions)
      cout << pos << " ";
  } else
    cout << "Impossible";
  cout << endl;

  return 0;
}