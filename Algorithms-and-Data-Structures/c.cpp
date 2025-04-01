#include <iostream>
#include <map>
#include <queue>
#include <string>
#include <vector>
using namespace std;

bool isInteger(const string& str) {
  if (str.empty())
    return false;

  size_t start = 0;
  if (str[0] == '-' || str[0] == '+')
    start = 1;

  for (size_t i = start; i < str.length(); ++i) {
    if (!isdigit(str[i])) {
      return false;
    }
  }
  return true;
}


int main() {
  map<string, vector<int>> map_of_vars;

  string line;
  vector<queue<string>> blocks;
  blocks.emplace_back();

  while (cin >> line) {
    if (line[0] == '{') {
      blocks.emplace_back();
    } else if (line[0] == '}') {
      queue<string> block_vars = blocks.back();
      blocks.pop_back();

      while (!block_vars.empty()) {
        map_of_vars[block_vars.front()].pop_back();
        block_vars.pop();
      }
    } else {
      string to_var = line.substr(0, line.find('='));
      string from_var = line.substr(line.find('=') + 1);
      blocks.back().push(to_var);

      if (isInteger(from_var)) {
        map_of_vars[to_var].push_back(stoi(from_var));
      } else {
        if (map_of_vars.find(from_var) == map_of_vars.end()) {
          cout << 0 << endl;
          map_of_vars[to_var].push_back(0);
        } else {
          cout << map_of_vars[from_var].back() << endl;
          map_of_vars[to_var].push_back(map_of_vars[from_var].back());
        }
      }
    }
  }
}