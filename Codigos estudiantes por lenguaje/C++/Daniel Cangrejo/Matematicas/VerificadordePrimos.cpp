#include<bits/stdc++.h>
#include<cstdlib>
using namespace std;
bool isPrime(int x){
    if(x<2){
        return false;
    }
    if(x==2){
        return true;
    }
    for(int i=2;i*i<=x;i++){
        if(x%i==0){
            return false;
        }
    }
    return true;
}
int main() {
    int n=23;
    cout<<(isPrime(n)?"Es Primo":"No es primo")<<endl;
    return 0;
}
