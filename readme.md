## 기업 코테 & 백준 & 프로그래머스 문제풀이 모음집

## Comments

---

### 1. Sorting
- [알고리즘 수업 - 병합 정렬 1](https://www.acmicpc.net/problem/24060)
- [좌표압축](https://www.acmicpc.net/problem/18870)
- [통계학](https://www.acmicpc.net/problem/2108)

<br/>

### 2. Greedy
- [회의실 배정](https://www.acmicpc.net/problem/1931)
- [주유소](https://www.acmicpc.net/problem/13305)

<br/>

### 3. Binary Search
- [랜선 자르기](https://www.acmicpc.net/problem/1654)
- [나무 자르기](https://www.acmicpc.net/problem/2805)
- [공유기 설치](https://www.acmicpc.net/problem/2110)
- [K번째 수](https://www.acmicpc.net/problem/1300)

<br/>

### 4. Graph Search (BFS / DFS)
- [미로탐색](https://www.acmicpc.net/problem/2178)
- [알고리즘 수업 - 너비 우선 탐색 2](https://www.acmicpc.net/problem/24445)
- [나이트의 이동](https://www.acmicpc.net/problem/7562)
- [토마토](https://www.acmicpc.net/problem/7576)
- [토마토 3차원](https://www.acmicpc.net/problem/7569)
- [뱀과 사다리 게임](https://www.acmicpc.net/problem/16928)

<br/>

### 5. Shortest Path
- [최소비용 구하기](https://www.acmicpc.net/problem/1916)
- [최단경로](https://www.acmicpc.net/problem/1753)
- [숨바꼭질3](https://www.acmicpc.net/problem/13549)
- [특정한 최단 경로](https://www.acmicpc.net/problem/1504)

<br/>

### 6. Minimum Spanning Tree
- Kruskal 알고리즘으로 MST 구현

<br/>

### 7. Tree
- [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
- [완전 이진 트리](https://www.acmicpc.net/problem/9934)
- [트리 순회](https://www.acmicpc.net/problem/1991)
- [나무 탈출](https://www.acmicpc.net/problem/15900)
- [전화번호 목록](https://www.acmicpc.net/problem/5052)

<br/>

### 8. Divide & Conquer
- [쿼드트리](https://www.acmicpc.net/problem/1992)
- [색종이 만들기](https://www.acmicpc.net/problem/2630)
- [종이의 개수](https://www.acmicpc.net/problem/1780)
- [곱셈](https://www.acmicpc.net/problem/1629)

<br/>

### 9. Dynamic Programming
- [신나는 함수 실행](https://www.acmicpc.net/problem/9184)
- [파도반 수열](https://www.acmicpc.net/problem/9461)
- [01타일](https://www.acmicpc.net/problem/1904)
- [포도주 시식](https://www.acmicpc.net/problem/2156)
- [연속합](https://www.acmicpc.net/problem/1912) *
- [정수 삼각형](https://www.acmicpc.net/problem/1932)
- [이항 계수2](https://www.acmicpc.net/problem/11051)

<br/>

### 10. Back-Tracking
- [N과 M (1, 2, 3)](https://www.acmicpc.net/problem/15651)
- [N-Queen](https://www.acmicpc.net/problem/9663)
- [스도쿠](https://www.acmicpc.net/problem/2580)
- [연산자 끼워넣기](https://www.acmicpc.net/problem/14888)
- [스타트와 링크](https://www.acmicpc.net/problem/14889)

<br/>

### Others
- [행렬 곱셈](https://www.acmicpc.net/problem/2740)
- [괄호의 값](https://www.acmicpc.net/problem/2504)
- [체스판 다시 칠하기](https://www.acmicpc.net/problem/1018)
- [참외밭](https://www.acmicpc.net/problem/2477)
- [어린 왕자](https://www.acmicpc.net/problem/1004)
- [GCD 합](https://www.acmicpc.net/problem/9613)

--- 

#### [가운데를 말해요](https://www.acmicpc.net/problem/1655)
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

<br/>

#### [미확인 도착지](https://www.acmicpc.net/problem/9370)
- 다익스트라 알고리즘을 이용하여, 특정 간선을 지나간 경우를 탐색
- 출발지 -> 도착지의 최단거리와 출발지 -> 특정간선 -> 도착지의 최단 거리가 같다면, 반드시 특정간선을 지나간다.

<br/>

#### [문제집](https://www.acmicpc.net/problem/1766)
- 위상정렬에 특정 조건을 추가한 문제

---
