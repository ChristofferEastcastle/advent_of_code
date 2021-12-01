#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE * fp = fopen("test.txt", "r");

    if (fp != NULL) {
        char line[6];
        int counter = 0, n = 0, x, i = 0, sum_1 = 0, sum_2 = 0, sum_3 = 0;
        int numbers[2000];
        while ((fgets(line, sizeof line, fp)) != NULL) {
            x = atoi(line);
            if (i % 4 == 0) {
                if (sum_2 > sum_1) counter++;
            }
            sum_1 += x;

            if (i % 4 >= 1) {
                sum_2 += x;
            }
            if (i % 4 >= 2) {
                sum_3 += x;
            }

            if (i % 4 >= 3) {

            }
            i++;
            
        }
        printf("%d\n", counter);
    }

    return 0;
}