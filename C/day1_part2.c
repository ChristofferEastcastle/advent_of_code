#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE * fp = fopen("test.txt", "r");

    if (fp != NULL) {
        char line[6];
        int counter = 0, n = 0, x, i = 1, j = -1, sum_1 = 0, sum_2 = 0, prev = 0, first = -1;
        int numbers[2000];
        while ((fgets(line, sizeof line, fp)) != NULL) {
            x = atoi(line);
            
            sum_1 += x;
            if (j != -1) {
                sum_2 += x;
            }
            
            if (j == 3) {
                if (sum_2 > prev) counter++;
                prev = sum_2;
                sum_2 = x;
                j = 1;
            }
            if (i == 2) {
                j = 1;
                sum_2 += x;
            }
            if (i == 3) {

                sum_1 = x;
                prev = sum_1;
                i = 1;
            } else {
                i++;
            }
            j++;
            printf("prev: %d\n", prev);
        }
        printf("%d\n", counter);
    }

    return 0;
}