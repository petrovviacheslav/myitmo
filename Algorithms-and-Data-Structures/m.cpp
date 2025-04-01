#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
  int N, M, start_x, start_y, finish_x, finish_y;
  cin >> N >> M >> start_x >> start_y >> finish_x >> finish_y;
  --start_x;
  --start_y;
  --finish_x;
  --finish_y;

  if (start_x == finish_x && start_y == finish_y) {
    cout << 0 << endl;
    return 0;
  }

  vector<string> lines_of_map(N);
  for (int i = 0; i < N; i++)
    cin >> lines_of_map[i];

  vector<vector<int>> cost(N, vector<int>(M, -1));
  vector<vector<char>> letter_of_step(N, vector<char>(M, ' '));
  const int step_x[] = {-1, 0, 1, 0};
  const int step_y[] = {0, 1, 0, -1};
  char descr_of_step[] = {'N', 'E', 'S', 'W'};

  queue<pair<int, int>> queue_of_coords;
  queue_of_coords.emplace(start_x, start_y);
  cost[start_x][start_y] = 0;

  while (!queue_of_coords.empty()) {
    const auto [old_x, old_y] = queue_of_coords.front();
    queue_of_coords.pop();

    for (int i = 0; i < 4; i++) {
      const int curr_x = old_x + step_x[i];
      const int curr_y = old_y + step_y[i];

      if (curr_x >= 0 && curr_x < N) {
        if (curr_y >= 0 && curr_y < M && lines_of_map[curr_x][curr_y] != '#') {
          const int next_cost = cost[old_x][old_y] + (lines_of_map[curr_x][curr_y] == '.' ? 1 : 2);
          if (next_cost < cost[curr_x][curr_y] || cost[curr_x][curr_y] == -1) {
            cost[curr_x][curr_y] = next_cost;
            letter_of_step[curr_x][curr_y] = descr_of_step[i];
            if (curr_x != finish_x || curr_y != finish_y) {
              queue_of_coords.emplace(curr_x, curr_y);
            }
          }
        }
      }
    }
  }

  if (cost[finish_x][finish_y] == -1) {
    cout << -1 << endl;
  } else {
    string answer;
    int curr_x = finish_x, curr_y = finish_y;
    while (curr_x != start_x || curr_y != start_y) {
      const char curr_step = letter_of_step[curr_x][curr_y];
      answer += curr_step;
      if (curr_step == 'S') {
        curr_x--;
      } else if (curr_step == 'N') {
        curr_x++;
      } else if (curr_step == 'W') {
        curr_y++;
      } else if (curr_step == 'E') {
        curr_y--;
      }
    }

    reverse(answer.begin(), answer.end());
    cout << cost[finish_x][finish_y] << endl;
    cout << answer << endl;
  }

  return 0;
}