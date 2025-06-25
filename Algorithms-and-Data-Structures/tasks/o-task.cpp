#include <algorithm>
#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

bool dfs(int cur_student, vector<vector<int>>& exchange, int* group_stud, const bool flag) {
  group_stud[cur_student] = flag;
  for (const auto other_student : exchange[cur_student]) {
    if (group_stud[other_student] == -1 && !dfs(other_student, exchange, group_stud, !flag)) {
      return false;
    }
    if (group_stud[other_student] == group_stud[cur_student])
      return false;
  }
  return true;
}

int main() {
  int N, M;
  cin >> N >> M;

  vector<vector<int>> exchange(N);
  int group_stud[100];
  memset(group_stud, -1, sizeof(group_stud));

  int s1, s2;
  for (int i = 0; i < M; i++) {
    cin >> s1 >> s2;
    s1--;
    s2--;
    exchange[s1].push_back(s2);
    exchange[s2].push_back(s1);
  }

  for (int i = 0; i < N; i++) {
    if (group_stud[i] == -1)
      if (!dfs(i, exchange, group_stud, true)) {
        cout << "NO" << endl;
        return 0;
      }
  }

  cout << "YES" << endl;
  return 0;
}