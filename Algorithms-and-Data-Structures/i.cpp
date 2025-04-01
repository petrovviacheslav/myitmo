#include <iostream>
#include <set>
#include <vector>

using namespace std;

int main() {
  int n, k, p, num_car;
  int result = 0;
  cin >> n >> k >> p;

  vector<int> cars, car_used_last_index, ptr_this_car_will_use;
  car_used_last_index.push_back(-1);
  set<int> cur_possible_steps;

  for (int i = 0; i < max(n, p); i++) {
    if (i < p)
      ptr_this_car_will_use.push_back(500001);
    if (i < n)
      car_used_last_index.push_back(-1);
  }

  for (int i = 0; i < p; i++) {
    cin >> num_car;
    if (car_used_last_index[num_car] != -1)
      ptr_this_car_will_use[car_used_last_index[num_car]] = i;
    car_used_last_index[num_car] = i;
  }

  for (int i = 0; i < p; i++) {
    if (!cur_possible_steps.count(i)) {
      if (static_cast<int>(cur_possible_steps.size()) == k)
        cur_possible_steps.erase(--cur_possible_steps.end());
      result++;
    } else
      cur_possible_steps.erase(i);
    cur_possible_steps.insert(ptr_this_car_will_use[i]);
  }

  cout << result << endl;
  return 0;
}