#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct time
{
    int hours ;
    int minutes ;
    int seconds;
}time ;

time split_time(long long seconds) ;

int main()
{
    long long total_seconds ;
    printf("The seconds since midnight :");
    scanf("%lld" , &total_seconds) ;
    time total_time =  split_time(total_seconds) ;
    printf("The time : %ih %im %is" , total_time.hours , total_time.minutes , total_time.seconds) ;
}

time split_time(long long seconds)
{
    time the_time ;
    the_time.hours = seconds / 3600 ;
    the_time.minutes = seconds / 60 - the_time.hours*60 ;
    the_time.seconds = seconds - the_time.hours * 3600 - the_time.minutes * 60 ;
    return the_time ;

}
