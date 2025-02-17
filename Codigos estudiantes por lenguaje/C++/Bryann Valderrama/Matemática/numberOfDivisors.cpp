#include <cstdlib>
#include <bits/stdc++.h>
using namespace std;

int divisors(int x)
{
    int nDiv = 1;
    for (int p = 2; p * p <= x; p++)
    {
        int cnt = 0;
        while (x % p == 0)
        {
            cnt++;
            x /= p;
        }
        nDiv *= cnt + 1;
    }
    if (x > 1)
    {
        nDiv *= 2;
    }
    return nDiv;
}

int main(int argc, char const *argv[])
{
    cout << divisors(123456) << endl;
    return 0;
}
