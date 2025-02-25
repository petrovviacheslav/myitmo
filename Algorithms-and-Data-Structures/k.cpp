#include <iostream>
#include <map>
#include <vector>
#include <utility>
using namespace std;

int main() {
  int n, m, action;
  cin >> n >> m;

  // номер запроса + начало и конец выделенной памяти на него
  map<int, vector<pair<int, int>>> map_lol;
  vector<pair<int, int>> free_slots;

  free_slots.push_back(make_pair(1, n));
  while (m--) {
    cin >> action;

    while () {
    }
  }

  return 0;
}