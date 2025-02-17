#include <bits/stdc++.h>
#include <cstdlib>

using namespace std;

int shellSort(int arr[], int n){
    for(int gap = n / 2; gap > 0; gap /=2){
        for(int i = gap; i < n; i++){
            int temp = arr[i];
            int j;
            for(j = i; j >= gap &&arr[j - gap] > temp; j -=gap){
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
    return 0;
}

int main()
{
    string entrada;
    getline(cin, entrada);
    string intermediate;
    stringstream check(entrada);
    vector <int> vec;
    while(getline(check, intermediate, ' ')){
        vec.push_back(atoi(intermediate.c_str()));
    }
    int arr[vec.size()];
    for(int i = 0; i < vec.size(); i++){
        arr[i] = vec[i];
    }
    shellSort(arr, sizeof(arr)/ sizeof(arr[0]));
    for(int i = 0; i < vec.size(); i++){
        cout << arr[i] <<" ";
    }
    cout<<endl;
    return 0;
}
