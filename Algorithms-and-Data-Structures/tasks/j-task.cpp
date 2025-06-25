#include <deque>
#include <iostream>
using namespace std;

int main() {
  deque<int> goblins_right_half, goblins_left_half;

  int n, new_goblin;
  string action;
  cin >> n;

  while (n--) {
    cin >> action;
    if (action == "*") {
      cin >> new_goblin;
      goblins_right_half.push_front(new_goblin);
    } else if (action == "+") {
      cin >> new_goblin;
      goblins_right_half.push_back(new_goblin);
    } else {
      cout << goblins_left_half.front() << endl;
      goblins_left_half.pop_front();
    }

    while (goblins_left_half.size() < goblins_right_half.size()) {
      goblins_left_half.push_back(goblins_right_half.front());
      goblins_right_half.pop_front();
    }
  }

  return 0;
}