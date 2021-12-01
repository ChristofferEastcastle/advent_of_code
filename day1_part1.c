#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE * fp = fopen("input.txt", "r");

    if (fp != NULL) {
        char line[6];
        int counter = 0, n = 0, x;

        while ((fgets(line, sizeof line, fp)) != NULL) {
            x = atoi(line);
            if (n != 0 && x > n) counter++;
            
            n = x;
        }
        printf("%d\n", counter);
    }

    return 0;
}