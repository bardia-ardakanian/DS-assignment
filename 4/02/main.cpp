#include<iostream>
#include<cstdlib>
#include<string>
#include<cstdio>
#include<map>
#include<utility>
using namespace std;

// string generateKey(int x, int y, int nx, int ny)
// {
//     string res = "";
//     // N, E
//     if(nx > x || ny > y)
//     {
//         res.append(to_string(x));
//         res.append(to_string(y));
//         res.append(to_string(nx));
//         res.append(to_string(ny));
//     }
//     else
//     {
//         res.append(to_string(nx));
//         res.append(to_string(ny));
//         res.append(to_string(x));
//         res.append(to_string(y));
//     }
//     return res;
// }

pair<pair<int, int>, pair<int, int>> makePair(int x, int y, int nx, int ny)
{
    pair<pair<int, int>, pair<int, int>> key;
    // N, E
    if(nx > x || ny > y)
    {
        key = make_pair(make_pair(x,y),make_pair(nx, ny));
    }
    else
    {
        key = make_pair(make_pair(nx, ny),make_pair(x,y));
    }
    return key;
}

int main()
{
    int n;
    cin >> n;

    int x=0, y=0, time=0; //start location
    string path; //N-W-S-E
    map<pair<pair<int, int>, pair<int, int>>, bool> hashMap;

    for (int i = 0; i < n; i++)
    {
        time = 0; //reset time
        hashMap.clear();
        cin >> path;

        int length = path.size();
        for (int j = 0; j < length; j++)
        {
            char c = path[j];
            if (c == 'N')
            {
                // string key = generateKey(x, y, x, y+1);
                pair<pair<int, int>, pair<int, int>> key = makePair(x, y, x, y+1);
                if (!hashMap[key])
                {
                    time += 5;
                    hashMap[key] = true;
                }
                else
                {
                    time += 1;
                }
                y++;
            }
            else if (c == 'S')
            {
                // string key = generateKey(x, y, x, y-1);
                pair<pair<int, int>, pair<int, int>> key = makePair(x, y, x, y-1);
                if (!hashMap[key])
                {
                    time += 5;
                    hashMap[key] = true;
                }
                else
                {
                    time += 1;
                }
                y--;
            }
            else if (c == 'E')
            {
                // string key = generateKey(x, y, x+1, y);
                pair<pair<int, int>, pair<int, int>> key = makePair(x, y, x+1, y);
                if (!hashMap[key])
                {
                    time += 5;
                    hashMap[key] = true;
                }
                else
                {
                    time += 1;
                }
                x++;
            }
            else if (c == 'W')
            {
                // string key = generateKey(x, y, x-1, y);
                pair<pair<int, int>, pair<int, int>> key = makePair(x, y, x-1, y);
                if (!hashMap[key])
                {
                    time += 5;
                    hashMap[key] = true;
                }
                else
                {
                    time += 1;
                }
                x--;
            }
        }

        // for (const auto& x : hashMap) {
        //     std::cout << x.first << ": " << x.second << "\n";
        // }
        cout << time << '\n';
    }
    
}