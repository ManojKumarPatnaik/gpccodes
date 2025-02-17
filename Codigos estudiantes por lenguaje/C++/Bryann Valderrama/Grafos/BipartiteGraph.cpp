#include <cstdlib>
#include <bits/stdc++.h>
using namespace std;
const int V = 4;

bool isBipartite(int G[V][V], int src)
{
    int colorArr[V];
    memset(colorArr, -1, sizeof colorArr);
    colorArr[src] = 1;
    deque<int> q;
    q.push_back(src);
    while (!q.empty())
    {
        int u = q.front();
        q.erase(q.begin());
        if (G[u][u] == 1)
        {
            return false;
        }
        for (int v = 0; v < V; v++)
        {
            if (G[u][v] == 1 && colorArr[v] == -1)
            {
                colorArr[v] = 1 - colorArr[u];
                q.push_back(v);
            }
            else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
            {
                return false;
            }
        }
    }
    return true;
}

int main(int argc, char const *argv[])
{
    int G[V][V] = {{0, 1, 0, 1},
                   {1, 0, 1, 0},
                   {0, 1, 0, 1},
                   {1, 0, 1, 0}};

    if (isBipartite(G, 0))
    {
        cout << "Es Bipartito" << endl;
    }
    else
    {
        cout << "No es Bipartito" << endl;
    }
    return 0;
}
