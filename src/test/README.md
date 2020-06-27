---
layout:	single
title: "README"
date:	2020-06-27 15:11:34 +0900
categories: jekyll update

---



  1~32에서 무작위로 8개를 뽑아서 초기 후보해 집단을 생성한다.

초기 후보해 집단을 선택연산과 교차연산 돌연변이 연산을 거친 후 나온 x값을 
f(x)=  ![이차식](https://ifh.cc/g/MmFxvI.png)  에 넣습니다.

도출된 y값에 nextGaussian() 함수를 이용해 평균이 0이고 표준편차가 1인 그래프에서 실수형 문자들을 무작위로 생성해서 더하면 오차가 생기게 됩니다.

기존 y 값에서 무작위 난수를 뺀 값을 y(hat)이라고 하면 절댓값으로 구하기 위해서 sqrt()함수를 사용해 ![루트](https://ifh.cc/g/GQdV6Z.png)   을 적합도로 계산합니다.  적합도가 크면 클 수록 최적의 해에 가까워집니다. 총 100번의 루프를 돌린 후, 아래에서부터 적합도가 큰 순서대로 16개의 데이터를 데이터의 산점도에 표기했습니다.



<img src="https://ifh.cc/g/aQ0kUC.png" alt="그래프" style="zoom:67%;" />
