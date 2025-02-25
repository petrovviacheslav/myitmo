//
// Created by petrovviacheslav on 18.02.25.
//

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {
  string s;
  cin >> s;
  string line;
  vector<int> values(26);
  for (int i = 0; i < 26; ++i) {
    cin >> values[i];
  }

  map<char, int> map_of_letter;
  auto compare = [values](const char& a, const char& b) {
    return values[static_cast<int>(a) - 97] < values[static_cast<int>(b) - 97];
  };
  vector<char> double_letter;

  for (char c : s) {
    if (map_of_letter.find(c) == map_of_letter.end()) {
      map_of_letter[c] = 1;
    } else
      map_of_letter[c] += 1;
  }

  string result;
  for (const auto& pair : map_of_letter) {
    if (pair.second > 1) {
      double_letter.push_back(pair.first);
      map_of_letter[pair.first] -= 2;
    }

    result.append(pair.second, pair.first);
  }

  sort(double_letter.begin(), double_letter.end(), compare);

  for (const char c : double_letter) {
    result.insert(0, 1, c);
    result += c;
  }

  cout << result << endl;
  return 0;
}