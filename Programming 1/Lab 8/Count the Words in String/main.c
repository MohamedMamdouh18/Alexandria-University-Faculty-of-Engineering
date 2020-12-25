#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
    char string[256] ;
    fgets(string, 256 , stdin) ;
    int words ;
    if(isdigit(string[0]) || isalpha(string[0]))
        {
            words = 1 ;
        }
    else if(isblank(string[0]))
        {
            words = 0;
        }
    for(int i = 0 ; i < strlen(string) - 1  ; i ++)
    {
        if((isdigit(string[i + 1]) || isalpha(string[i + 1])) && (isblank(string[i])))
        {
            words ++ ;
        }
    }
    printf("%i words" , words) ;
}
