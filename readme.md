## 삼성 SW 공채 & 이코테 & 백준 문제풀이

정답 처리 받은 코드만 등록
   
<br/>

+) 2022/11/19 <br/>
Python 코드 구조를 다음과 같이 짜도록 하자 -> 타입 힌트, 함수형 구조 
(https://github.com/rivercity310/Samsung_Software_Test/blob/main/Python/beginner/01_Sorting/boj_2108.py)

<br/>

+) 2022/11/25 <br/>
앞으로 Java 코드는 점진적으로 Kotlin으로 대체할 예정 (공부중...)

<br/>

---

### 소스코드 보기 (Click) 
[<img src="https://img.shields.io/badge/C++-123456?style=flat&logo=Cplusplus&logoColor=white"/>](https://github.com/rivercity310/Samsung_Software_Test/tree/main/Cpp) [<img src="https://img.shields.io/badge/Java-red?style=flat&logo=OpenJDK&logoColor=white"/>](https://github.com/rivercity310/Samsung_Software_Test/tree/main/Java) [<img src="https://img.shields.io/badge/Python-blue?style=flat&logo=Python&logoColor=white"/>](https://github.com/rivercity310/Samsung_Software_Test/tree/main/Python) [<img src="https://img.shields.io/badge/Kotlin-3b5998?style=flat&logo=Kotlin&logoColor=white"/>](https://github.com/rivercity310/software_test/tree/main/Kotlin/src/main/kotlin)
---
<br/>

## [ Beginner ]  

<br/>

### 1. Sorting
- 버블정렬
- 선택정렬 & 응용문제
- 삽입정렬과 셸정렬(삽입정렬의 응용)
- 병합정렬과 퀵정렬
- 계수정렬
- [알고리즘 수업 - 병합 정렬 1](https://www.acmicpc.net/problem/24060) 
- [좌표압축](https://www.acmicpc.net/problem/18870)
- [통계학](https://www.acmicpc.net/problem/2108) 

<br/><br/>

### 2. Greedy
- 거스름돈 문제
- 카드게임
- 큰 수의 법칙
- 1이 될 때까지
- [회의실 배정](https://www.acmicpc.net/problem/1931)
- [주유소](https://www.acmicpc.net/problem/13305)

<br/><br/>

### 3. Binary Search
- 재귀 or 반복으로 구현된 이진탐색
- lower bound & upper bound
- 부품 찾기
- 떡볶이 떡 자르기
- [랜선 자르기](https://www.acmicpc.net/problem/1654)
- [나무 자르기](https://www.acmicpc.net/problem/2805)
- [공유기 설치](https://www.acmicpc.net/problem/2110)
- [K번째 수](https://www.acmicpc.net/problem/1300)     

<br/><br/>

### 4. Graph Search (BFS / DFS)
- 미로탈출 (BFS를 이용한 최단거리 사방탐색 -> 가중치가 1인 경우)
- [미로탐색](https://www.acmicpc.net/problem/2178)
- [알고리즘 수업 - 너비 우선 탐색 2](https://www.acmicpc.net/problem/24445)
- [나이트의 이동](https://www.acmicpc.net/problem/7562)    *
- [토마토](https://www.acmicpc.net/problem/7576)           *

<br/><br/>

### 5. Shortest Path
- 전보 (다익스트라 기본문제)
- 간단한 플로이드 워셜 알고리즘 구현
- [최소비용 구하기](https://www.acmicpc.net/problem/1916)
- [최단경로](https://www.acmicpc.net/problem/1753)
- [숨바꼭질3](https://www.acmicpc.net/problem/13549)

<br/><br/>

### 6. Minimum Spanning Tree
- Kruskal 알고리즘으로 MST 구현

<br/><br/>

### 7. Tree
- [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
- [완전 이진 트리](https://www.acmicpc.net/problem/9934)


<br/><br/>

### 8. Divide & Conquer
- [쿼드트리](https://www.acmicpc.net/problem/1992)
- [색종이 만들기](https://www.acmicpc.net/problem/2630)
- [종이의 개수](https://www.acmicpc.net/problem/1780)
- [곱셈](https://www.acmicpc.net/problem/1629): 지수법칙과 모듈로 성질에 대해 알아두자!

<br/><br/>

### 9. Dynamic Programming

<br/><br/>

### Others

#### [행렬 곱셈](https://www.acmicpc.net/problem/2740)

<br/>

#### [괄호의 값](https://www.acmicpc.net/problem/2504)
- 스택을 이용한 문제

<br/>

#### [체스판 다시 칠하기](https://www.acmicpc.net/problem/1018)
- 모든 경우의 수를 탐색하는 브루트 포스(무차별 대입) 방식

<br/>

#### [참외밭](https://www.acmicpc.net/problem/2477)
- 미해결


<br/><br/>

--- 

## [ Intermediate ]
<br/>

#### [가운데를 말해요](https://www.acmicpc.net/problem/1655) <br/>
- 힙을 이용해서 매번 들어오는 데이터에 대한 중앙값을 구하는 문제

<br/>

#### [운동](https://www.acmicpc.net/problem/1956)
- Floyd-Warshall 알고리즘을 이용해서 사이클을 이루는 최단거리를 구할 수 있다.
- 간단하게 구현 가능하지만 생각치 못한 응용이라 중급자에 추가

<br/>

#### [트리의 지름](https://www.acmicpc.net/problem/1167)
- dfs or dijkstra를 이용해서 트리의 지름을 구해보자
- C++에서는 dfs, Python에서는 dijkstra를 통해 구현해보았다.

<br/>

#### [나머지 합](https://www.acmicpc.net/problem/10986)
- 두 부분합의 차이는 곧 특정 구간의 합이 되므로, 부분합을 M으로 나눈 나머지가 같은 그룹에서 두 부분합 A,B를 뽑으면, 그 두 부분합이 나타내는 연속된 구간의 합(B-A)을 M으로 나눈 나머지는 0

<br/>

#### [행렬 제곱](https://www.acmicpc.net/problem/10830)
- 범위가 지나치게 커서 까다로웠던 분할정복 문제, 단순 분할정복 방법과 dp를 이용한 분할정복 방법으로 풀어보았다.
- C++ 풀이에서는 행렬의 곱셈을 간단하게 나타내기 위해 연산자 오버로딩을 사용하였다.
- 메모할 범위가 너무 크다면 맵을 이용한 dp를 떠올리자

---

## [ Expert ] 
- 추후 작성 예정


---