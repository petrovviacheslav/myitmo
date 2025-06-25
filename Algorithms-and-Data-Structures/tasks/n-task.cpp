#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void dfs(int cur_node, vector<pair<int, vector<int>>>& pb, int& answer) {
  if (pb[cur_node].first == 0) {
    pb[cur_node].first = 1;
    for (int next_node : pb[cur_node].second) {
      if (pb[next_node].first != -1) {
        answer += pb[next_node].first;
      }
      if (pb[next_node].first == 0) {
        dfs(next_node, pb, answer);
      }
    }
    pb[cur_node].first = -1;
  }
}

int main() {
  int n, value, answer = 0;
  cin >> n;

  vector<pair<int, vector<int>>> piggy_bank(n);

  for (int i = 0; i < n; i++) {
    cin >> value;
    piggy_bank[--value].second.push_back(i);
  }

  for (int i = 0; i < n; i++) {
    if (piggy_bank[i].first == 0) {
      dfs(i, piggy_bank, answer);
    }
  }

  cout << answer << endl;

  return 0;
}