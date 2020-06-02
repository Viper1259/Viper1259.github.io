~~~
layout: single
title:  "Approximating the value of Pi"
date:   2020-06-02 17:23:22 +0900
categories: jekyll update
~~~

### 오일러 곱셈 공식을 이용한 파이의 근사치 구하기.

오일러 곱셈 공식 : ![오일러 공식](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99DCBF465CF3F3542F)

1부터 1씩 커지는 수의 역수를 더한 것은 파이 제곱 나누기 6이 된다는 공식이다.

즉, 무한급수를 한 것에 6을 곱한 다음, 그 수에 루트를 씌워주면 원주율이 나온다.

정확성을 위해 10만번을 반복한다고 할 때 코드는

~~~c
#include <stdio.h> //오일러 곱셈 공식 
#include <math.h>
 
int main()
{
    double pi=0.0,num=1.0;
    
    while(num<1000000)
    {
        pi+=1.0/pow(num,2.0);	//1씩 커지는 수의 제곱의 역수를 더한 것
        num+=1.0;		//계산횟수 증가()
    }
    
    printf("%.10f",sqrt(6*pi));		//파이의 값 출력.
 } 
~~~

이 된다.

코드 실행 결과 pi 는 3.1415916987의 근사치가 나온다.