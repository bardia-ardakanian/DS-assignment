#include <iostream>
#include <queue>
#include <utility>
#include <string.h>

using namespace std;

int main() {
	
	int n, m;
	std::cin >> n >> m;
	
	// Essentials
	bool visited[n][m];
	int matrix[n][m];
	queue< pair<int, int> > q;
	
	// Initialize matrix with '-1'
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			matrix[i][j] = -1;
			visited[i][j] = false;
		}
	
	for (int i = 0; i < n; i++) {
		
		string line;
		std::cin >> line;
		
		for (int j = 0; j < line.size(); j++) {
			switch(line[j]) {
				case 'M':
					q.push(make_pair(i, j));
					visited[i][j] = true;
					matrix[i][j] = 0;
					break;
					
				case 'X':
					visited[i][j] = true;
					break;
			}
		}
	}
	
	// BFS
	while (!q.empty()) {
		
		pair<int, int> node = q.front();
		q.pop();

		pair<int, int> dirs[4] { make_pair(node.first - 1, node.second), make_pair(node.first + 1, node.second), make_pair(node.first, node.second - 1), make_pair(node.first, node.second + 1) };
		
		for (int i = 0; i < 4; i++) {
			int x = dirs[i].first;
			int y = dirs[i].second;
			
			if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
				matrix[x][y] = matrix[node.first][node.second] + 1;		// Increment length
				q.push(make_pair(x, y));
				visited[x][y] = true;
			}
		}
		
	}
	
	// Print
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			std::cout << matrix[i][j] << ' ';
		std::cout << endl;
	}
}
