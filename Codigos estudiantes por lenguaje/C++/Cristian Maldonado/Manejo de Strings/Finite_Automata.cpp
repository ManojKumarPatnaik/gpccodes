#include <iostream>
#include <string.h>
#define FAST ios_base::sync_with_stdio(false);cin.tie(NULL);
#define MAX_V 1000

using namespace std;

const int NO_OF_CHARS = 256;

int getNextState(char pat[], int M, int state, int x){
    if(state < M && x == pat[state]){
        return state + 1;
    }
    int ns, i;
    for(ns = state; ns > 0; ns--){
        if(pat[ns - 1] == x){
            for(i = 0; i < ns - 1; i++){
                if(pat[i] != pat[state - ns + 1 + i]){
                    break;
                }
            }
            if(i == ns - 1){
                return ns;
            }
        }
    }
    return 0;
}

void computeTF(char pat[], int M, int TF[][NO_OF_CHARS]) {
    int state, x;
    for (state = 0; state <= M; state++) {
        for (x = 0; x < NO_OF_CHARS; x++) {
            TF[state][x] = getNextState(pat, M, state, x);
        }
    }
}

void searchAutmata(char pat[], char txt[], int M, int N){
   int TF[M+1][NO_OF_CHARS];
   computeTF(pat, M, TF);
   int i, state = 0;
   for(i = 0; i < N; i++){
    state = TF[state][txt[i]];
    if(state == M){
        cout << "Patron encontrado en el indice: "<<(i - M + 1)<<endl;
        }
    }
}

int main()
{
    FAST
    char txt[MAX_V];
    char pat[MAX_V];
    gets(txt);
    gets(pat);
    searchAutmata(pat,txt, strlen(pat), strlen(txt));
    return 0;
}
