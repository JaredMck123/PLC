#include <stdio.h>
#include <time.h>


void twoDSubscript() {

    int x[1000][1000];

    for(int i = 0; i < 1000; i++) {
        for(int j = 0; j < 1000; j++) {
            x[i][j] = 1;
        }
    }
}

void twoDPointer() {
    int x[1000][1000];
    int *ptr = &x[0][0];
  
    for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < 1000; j++) {
            *(ptr + i * 1000 + j) = 2;
        }
    }
}
int main() {

    clock_t t;
    t = clock();
    printf("Timer starts\n");
    twoDSubscript();
    printf("Timer ends \n");
    t = clock() - t;
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // calculate the elapsed time
    printf("The program took %f seconds to execute\n", time_taken);


    t = clock();
    printf("Timer starts\n");
    twoDPointer();
    printf("Timer ends \n");
    t = clock() - t;
    time_taken = ((double)t)/CLOCKS_PER_SEC; // calculate the elapsed time
    printf("The program took %f seconds to execute\n", time_taken);
    return 0;
}