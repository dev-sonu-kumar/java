# Complete HackerRank 100 Examples - Java Solutions 🚀

## 📚 Master All 100 Most Important HackerRank Problems

**Complete collection of optimized Java solutions for technical interviews and competitive programming**

---

## 🎯 Quick Navigation

| Category | Problems | Difficulty | Key Patterns |
|----------|----------|------------|--------------|
| [Arrays & Basic Math](#arrays--basic-math-1-20) | 1-20 | Easy | Array Operations, Math |
| [Strings](#strings-21-35) | 21-35 | Easy-Medium | String Processing, Pattern Matching |
| [Searching & Sorting](#searching--sorting-36-50) | 36-50 | Medium | Binary Search, Sorting Algorithms |
| [Dynamic Programming](#dynamic-programming-51-65) | 51-65 | Medium-Hard | Memoization, Optimization |
| [Trees & Graphs](#trees--graphs-66-80) | 66-80 | Medium-Hard | Tree Traversal, Graph Algorithms |
| [Mathematics & Number Theory](#mathematics--number-theory-81-95) | 81-95 | Easy-Medium | Number Theory, Combinatorics |
| [Advanced Problems](#advanced-problems-96-100) | 96-100 | Hard | Complex Algorithms |

---

## Arrays & Basic Math (1-20)

### 1. Simple Array Sum
**Problem**: Given an array of integers, find the sum of its elements.

**Input Format**: 
- First line contains an integer n, the size of the array
- Second line contains n space-separated integers representing the array elements

**Output Format**: Print the sum of the array's elements as a single integer

**Example**:
- Input: [1, 2, 3, 4, 10, 11]
- Output: 31

**Solution**:
```java
public static int simpleArraySum(int[] ar) {
    int sum = 0;
    for (int num : ar) {
        sum += num;
    }
    return sum;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 2. Compare the Triplets
**Problem**: Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.

The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).

The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
- If a[i] > b[i], then Alice is awarded 1 point
- If a[i] < b[i], then Bob is awarded 1 point  
- If a[i] = b[i], then neither person receives a point

**Input Format**: 
- First line contains 3 space-separated integers, a[0], a[1], and a[2], the respective values in triplet a
- Second line contains 3 space-separated integers, b[0], b[1], and b[2], the respective values in triplet b

**Output Format**: Return an array of two integers, the first being Alice's score and the second being Bob's score

**Example**:
- Input: a = [5, 6, 7], b = [3, 6, 10]
- Output: [1, 1] (Alice wins first comparison, Bob wins third, second is tie)

**Solution**:
```java
public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int aliceScore = 0, bobScore = 0;
    for (int i = 0; i < 3; i++) {
        if (a.get(i) > b.get(i)) aliceScore++;
        else if (a.get(i) < b.get(i)) bobScore++;
    }
    return Arrays.asList(aliceScore, bobScore);
}
```
**Time Complexity**: O(1) | **Space Complexity**: O(1)

### 3. A Very Big Sum
**Problem**: In this challenge, you are required to calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.

**Input Format**: 
- First line contains an integer n, the number of elements in the array
- Second line contains n space-separated integers representing the array's elements

**Output Format**: Return the sum of the array's elements as a single integer

**Constraints**: 
- 1 ≤ n ≤ 10
- 0 ≤ ar[i] ≤ 10^10

**Example**:
- Input: [1000000001, 1000000002, 1000000003, 1000000004, 1000000005]
- Output: 5000000015

**Solution**:
```java
public static long aVeryBigSum(long[] ar) {
    long sum = 0;
    for (long num : ar) {
        sum += num;
    }
    return sum;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 4. Diagonal Difference
**Problem**: Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:
```
1 2 3
4 5 6
9 8 9
```
The left-to-right diagonal = 1 + 5 + 9 = 15. The right-to-left diagonal = 3 + 5 + 9 = 17. Their absolute difference is |15 - 17| = 2.

**Input Format**: 
- First line contains a single integer, n, the number of rows and columns in the square matrix arr
- Each of the next n lines describes a row, arr[i], and consists of n space-separated integers arr[i][j]

**Output Format**: Return the absolute difference between the sums of the matrix's two diagonals as a single integer

**Example**:
- Input: [[11, 2, 4], [4, 5, 6], [10, 8, -12]]
- Primary diagonal: 11 + 5 + (-12) = 4
- Secondary diagonal: 4 + 5 + 10 = 19
- Output: |4 - 19| = 15

**Solution**:
```java
public static int diagonalDifference(List<List<Integer>> arr) {
    int n = arr.size();
    int primarySum = 0, secondarySum = 0;
    
    for (int i = 0; i < n; i++) {
        primarySum += arr.get(i).get(i);
        secondarySum += arr.get(i).get(n - 1 - i);
    }
    
    return Math.abs(primarySum - secondarySum);
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 5. Plus Minus
**Problem**: Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal.

**Input Format**: 
- First line contains an integer, n, the size of the array
- Second line contains n space-separated integers that describe arr[i]

**Output Format**: Print the following 3 lines, each to 6 decimals:
1. Proportion of positive values
2. Proportion of negative values  
3. Proportion of zeros

**Example**:
- Input: [-4, 3, -9, 0, 4, 1]
- Positive: 3/6 = 0.500000
- Negative: 2/6 = 0.333333
- Zero: 1/6 = 0.166667

**Solution**:
```java
public static void plusMinus(int[] arr) {
    int positive = 0, negative = 0, zero = 0;
    
    for (int num : arr) {
        if (num > 0) positive++;
        else if (num < 0) negative++;
        else zero++;
    }
    
    int n = arr.length;
    System.out.printf("%.6f%n", (double) positive / n);
    System.out.printf("%.6f%n", (double) negative / n);
    System.out.printf("%.6f%n", (double) zero / n);
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 6. Staircase
**Problem**: Staircase detail: This is a staircase of size n = 4:
```
   #
  ##
 ###
####
```
Its base and height are both equal to n. It is drawn using # symbols and spaces. The last line is not preceded by any spaces.

Write a program that prints a staircase of size n.

**Input Format**: A single integer, n, denoting the size of the staircase

**Output Format**: Print a staircase of size n using # symbols and spaces

**Constraints**: 0 < n ≤ 100

**Example**:
- Input: n = 6
- Output:
```
     #
    ##
   ###
  ####
 #####
######
```

**Solution**:
```java
public static void staircase(int n) {
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
```
**Time Complexity**: O(n²) | **Space Complexity**: O(1)

### 7. Mini-Max Sum
**Problem**: Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

**Input Format**: A single line of five space-separated integers

**Output Format**: Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers

**Constraints**: 1 ≤ arr[i] ≤ 10^9

**Example**:
- Input: [1, 2, 3, 4, 5]
- The minimum sum is 1 + 2 + 3 + 4 = 10
- The maximum sum is 2 + 3 + 4 + 5 = 14
- Output: 10 14

**Solution**:
```java
public static void miniMaxSum(int[] arr) {
    long totalSum = 0;
    int min = arr[0], max = arr[0];
    
    for (int num : arr) {
        totalSum += num;
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    
    System.out.println((totalSum - max) + " " + (totalSum - min));
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 8. Birthday Cake Candles
**Problem**: You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest candles. Count how many candles are tallest.

**Input Format**: 
- First line contains a single integer, n, the size of candles
- Second line contains n space-separated integers, where each integer i describes the height of candle i

**Output Format**: Return the number of candles that are tallest

**Constraints**: 
- 1 ≤ n ≤ 10^5
- 1 ≤ candles[i] ≤ 10^7

**Example**:
- Input: [4, 4, 1, 3]
- The maximum height is 4, and there are 2 candles of height 4
- Output: 2

**Solution**:
```java
public static int birthdayCakeCandles(int[] candles) {
    int maxHeight = Arrays.stream(candles).max().getAsInt();
    return (int) Arrays.stream(candles).filter(h -> h == maxHeight).count();
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1) 1 ≤ candles[i] ≤ 10^7

**Example**:
- Input: [4, 4, 1, 3]
- The maximum height is 4, and there are 2 candles of height 4
- Output: 2

**Solution**:
```java
public static int birthdayCakeCandles(int[] candles) {
    int maxHeight = Arrays.stream(candles).max().getAsInt();
    return (int) Arrays.stream(candles).filter(h -> h == maxHeight).count();
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 9. Time Conversion
**Problem**: Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: 
- 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock

**Input Format**: A single string s that represents a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM)

**Output Format**: Convert and print the given time in 24-hour format, where 00 ≤ hh ≤ 23

**Example**:
- Input: "07:05:45PM"
- Output: "19:05:45"
- Input: "12:01:00AM"
- Output: "00:01:00"

**Solution**:
```java
public static String timeConversion(String s) {
    String period = s.substring(8);
    String time = s.substring(0, 8);
    String[] parts = time.split(":");
    
    int hour = Integer.parseInt(parts[0]);
    
    if (period.equals("AM")) {
        if (hour == 12) hour = 0;
    } else {
        if (hour != 12) hour += 12;
    }
    
    return String.format("%02d:%s:%s", hour, parts[1], parts[2]);
}
```
**Time Complexity**: O(1) | **Space Complexity**: O(1)

### 10. Grading Students
**Problem**: HackerLand University has the following grading policy:
- Every student receives a grade in the inclusive range from 0 to 100
- Any grade less than 40 is a failing grade

Sam is a professor at the university and likes to round each student's grade according to these rules:
- If the difference between the grade and the next multiple of 5 is less than 3, round the grade up to the next multiple of 5
- If the value of the grade is less than 38, no rounding occurs as the result will still be a failing grade

**Input Format**: 
- First line contains a single integer, n, the number of students
- Each line i of the n subsequent lines contains a single integer, grades[i]

**Output Format**: For each grades[i], print the rounded grade on a new line

**Example**:
- Input: [73, 67, 38, 33]
- 73 rounds to 75 (next multiple of 5 is 75, difference is 2 < 3)
- 67 rounds to 67 (next multiple of 5 is 70, difference is 3, no rounding)
- 38 rounds to 40 (next multiple of 5 is 40, difference is 2 < 3)
- 33 stays 33 (grade < 38, no rounding)
- Output: [75, 67, 40, 33]

**Solution**:
```java
public static List<Integer> gradingStudents(List<Integer> grades) {
    List<Integer> result = new ArrayList<>();
    
    for (int grade : grades) {
        if (grade < 38) {
            result.add(grade);
        } else {
            int nextMultiple = ((grade / 5) + 1) * 5;
            if (nextMultiple - grade < 3) {
                result.add(nextMultiple);
            } else {
                result.add(grade);
            }
        }
    }
    
    return result;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(n)

### 11. Apple and Orange
**Problem**: Sam's house has an apple tree and an orange tree that yield an abundance of fruit. Using the information given below, determine the number of apples and oranges that land on Sam's house.

In the diagram below:
- The red region denotes the house, where s is the start point, and t is the endpoint
- The apple tree is to the left of the house, and the orange tree is to its right
- Assume the trees are located on a single point, where the apple tree is at point a, and the orange tree is at point b
- When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis. *A negative value of d means the fruit fell d units to the tree's left, and a positive value of d means the fruit fell d units to the tree's right.*

**Input Format**: 
- First line contains two space-separated integers denoting the respective values of s and t
- Second line contains two space-separated integers denoting the respective values of a and b
- Third line contains two space-separated integers denoting the respective values of m and n
- Fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a
- Fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b

**Output Format**: Print two integers on two different lines:
1. The first integer: the number of apples that fall on Sam's house
2. The second integer: the number of oranges that fall on Sam's house

**Example**:
- House location: s = 7, t = 11
- Apple tree at a = 5, Orange tree at b = 15
- Apples fall at distances: [-2, 2, 1] from apple tree
- Oranges fall at distances: [5, -6] from orange tree
- Apple positions: [3, 7, 6], only 7 lands on house
- Orange positions: [20, 9], only 9 lands on house
- Output: 1 apple, 1 orange

**Solution**:
```java
public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    int appleCount = 0, orangeCount = 0;
    
    for (int apple : apples) {
        int position = a + apple;
        if (position >= s && position <= t) appleCount++;
    }
    
    for (int orange : oranges) {
        int position = b + orange;
        if (position >= s && position <= t) orangeCount++;
    }
    
    System.out.println(appleCount);
    System.out.println(orangeCount);
}
```
**Time Complexity**: O(m + n) | **Space Complexity**: O(1)

### 12. Number Line Jumps (Kangaroo)
**Problem**: You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).

- The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump
- The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump

You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.

**Input Format**: A single line of four space-separated integers denoting the respective values of x1, v1, x2, and v2

**Output Format**: Print YES if they can land on the same location at the same time, otherwise print NO

**Constraints**: 
- 0 ≤ x1 < x2 ≤ 10000
- 1 ≤ v1 ≤ 10000
- 1 ≤ v2 ≤ 10000

**Example**:
- Input: x1 = 0, v1 = 3, x2 = 4, v2 = 2
- After 4 jumps: Kangaroo 1 at 0 + 3*4 = 12, Kangaroo 2 at 4 + 2*4 = 12
- Output: YES

**Solution**:
```java
public static String kangaroo(int x1, int v1, int x2, int v2) {
    if (v1 == v2) {
        return x1 == x2 ? "YES" : "NO";
    }
    
    if ((x2 - x1) % (v1 - v2) == 0 && (x2 - x1) / (v1 - v2) >= 0) {
        return "YES";
    }
    
    return "NO";
}
```
**Time Complexity**: O(1) | **Space Complexity**: O(1)

### 13. Between Two Sets
**Problem**: There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
1. The elements of the first array are all factors of the integer being considered
2. The integer being considered is a factor of all elements of the second array

These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

**Input Format**: 
- First line contains two space-separated integers, n and m, the sizes of the respective arrays
- Second line contains n distinct space-separated integers a[i] where 0 ≤ i < n
- Third line contains m distinct space-separated integers b[j] where 0 ≤ j < m

**Output Format**: Return the number of integers that are betwen the sets

**Example**:
- Input: a = [2, 4], b = [16, 32, 96]
- Numbers between sets: 4, 8, 16
- 4: All elements in a (2,4) divide 4, and 4 divides all elements in b (16,32,96)
- 8: All elements in a (2,4) divide 8, and 8 divides all elements in b (16,32,96)
- 16: All elements in a (2,4) divide 16, and 16 divides all elements in b (16,32,96)
- Output: 3

**Solution**:
```java
public static int getTotalX(List<Integer> a, List<Integer> b) {
    int lcm = a.get(0);
    for (int i = 1; i < a.size(); i++) {
        lcm = lcm(lcm, a.get(i));
    }
    
    int gcd = b.get(0);
    for (int i = 1; i < b.size(); i++) {
        gcd = gcd(gcd, b.get(i));
    }
    
    int count = 0;
    for (int i = lcm; i <= gcd; i += lcm) {
        if (gcd % i == 0) count++;
    }
    
    return count;
}

private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

private static int lcm(int a, int b) {
    return a * b / gcd(a, b);
}
```
**Time Complexity**: O(n + m + gcd/lcm) | **Space Complexity**: O(1)

### 14. Breaking the Records
**Problem**: Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.

**Input Format**: 
- First line contains an integer n, the number of games
- Second line contains n space-separated integers describing the respective values of score[i]

**Output Format**: Return an integer array containing the numbers of times she broke her records. Index 0 is for breaking most points records, and index 1 is for breaking least points records

**Example**:
- Input: [10, 5, 20, 20, 4, 5, 2, 25, 1]
- Game 0: score = 10, max = 10, min = 10
- Game 1: score = 5, max = 10, min = 5 (min record broken)
- Game 2: score = 20, max = 20 (max record broken), min = 5
- Game 3: score = 20, max = 20, min = 5
- Game 4: score = 4, max = 20, min = 4 (min record broken)
- Game 5: score = 5, max = 20, min = 4
- Game 6: score = 2, max = 20, min = 2 (min record broken)
- Game 7: score = 25, max = 25 (max record broken), min = 2
- Game 8: score = 1, max = 25, min = 1 (min record broken)
- Output: [2, 4] (2 max records broken, 4 min records broken)

**Solution**:
```java
public static int[] breakingRecords(int[] scores) {
    int maxCount = 0, minCount = 0;
    int maxScore = scores[0], minScore = scores[0];
    
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > maxScore) {
            maxScore = scores[i];
            maxCount++;
        } else if (scores[i] < minScore) {
            minScore = scores[i];
            minCount++;
        }
    }
    
    return new int[]{maxCount, minCount};
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 15. Subarray Division (Birthday Chocolate)
**Problem**: Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.

Lily decides to share a contiguous segment of the bar selected such that:
- The length of the segment matches Ron's birth month, and
- The sum of the integers on the squares is equal to his birth day

Determine how many ways she can divide the chocolate.

**Input Format**: 
- First line contains an integer n, the number of squares in the chocolate bar
- Second line contains n space-separated integers s[i], the numbers on the chocolate squares s = [s[0], s[1], ..., s[n-1]]
- Third line contains two space-separated integers, d and m, Ron's birth day and birth month

**Output Format**: Return the integer representing the number of ways Lily can divide the chocolate bar

**Example**:
- Input: s = [1, 2, 1, 3, 2], d = 3, m = 2
- Lily wants to find segments of length 2 that sum to 3
- Segment [1, 2]: sum = 3 ✓
- Segment [2, 1]: sum = 3 ✓
- Segment [1, 3]: sum = 4 ✗
- Segment [3, 2]: sum = 5 ✗
- Output: 2

**Solution**:
```java
public static int birthday(List<Integer> s, int d, int m) {
    int count = 0;
    
    for (int i = 0; i <= s.size() - m; i++) {
        int sum = 0;
        for (int j = i; j < i + m; j++) {
            sum += s.get(j);
        }
        if (sum == d) count++;
    }
    
    return count;
}
```
**Time Complexity**: O(n × m) | **Space Complexity**: O(1)

### 16. Divisible Sum Pairs
**Problem**: Given an array of integers and a positive integer k, determine the number of (i, j) pairs where i < j and ar[i] + ar[j] is divisible by k.

**Input Format**: 
- First line contains 2 space-separated integers, n and k
- Second line contains n space-separated integers, each a value of arr[i]

**Output Format**: Return the number of pairs (i, j) where i < j and ar[i] + ar[j] is evenly divisible by k

**Constraints**: 
- 2 ≤ n ≤ 100
- 1 ≤ k ≤ 100
- 1 ≤ ar[i] ≤ 100

**Example**:
- Input: n = 6, k = 3, ar = [1, 3, 2, 6, 1, 2]
- Valid pairs: (0,2), (0,5), (1,5), (2,4) where indices have sums divisible by 3
- (1+2)%3=0, (1+2)%3=0, (3+2)%3=2, (2+1)%3=0
- Output: 5

**Solution**:
```java
public static int divisibleSumPairs(int n, int k, int[] ar) {
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if ((ar[i] + ar[j]) % k == 0) {
                count++;
            }
        }
    }
    
    return count;
}
```
**Time Complexity**: O(n²) | **Space Complexity**: O(1)

### 17. Migratory Birds
**Problem**: Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

**Input Format**: 
- First line contains an integer, n, the size of arr
- Second line contains n space-separated integers, each an arr[i]

**Output Format**: Return the lowest type id of the most frequently sighted birds

**Constraints**: 
- 5 ≤ n ≤ 2 × 10^5
- It is guaranteed that each type is 1, 2, 3, 4, or 5

**Example**:
- Input: [1, 4, 4, 4, 5, 3]
- Bird type 1: 1 sighting
- Bird type 3: 1 sighting
- Bird type 4: 3 sightings (most frequent)
- Bird type 5: 1 sighting
- Output: 4

**Solution**:
```java
public static int migratoryBirds(List<Integer> arr) {
    Map<Integer, Integer> frequency = new HashMap<>();
    
    for (int bird : arr) {
        frequency.put(bird, frequency.getOrDefault(bird, 0) + 1);
    }
    
    int maxCount = 0, result = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
        if (entry.getValue() > maxCount || 
            (entry.getValue() == maxCount && entry.getKey() < result)) {
            maxCount = entry.getValue();
            result = entry.getKey();
        }
    }
    
    return result;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1) - at most 5 bird types

### 18. Day of the Programmer
**Problem**: Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the 256th day of the year) during a year in the inclusive range from 1700 to 2700.

From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th. This means that in 1918, February 14th was the 32nd day of the year in Russia.

In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a leap year, and 28 days during all other years. In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either:
- Divisible by 400
- Divisible by 4 and not divisible by 100

**Input Format**: A single integer denoting year y

**Output Format**: Return the date of the 256th day of year y in the format dd.mm.yyyy

**Example**:
- Input: 2017
- 2017 is not a leap year, so February has 28 days
- Days in months: Jan(31) + Feb(28) + Mar(31) + Apr(30) + May(31) + Jun(30) + Jul(31) + Aug(31) = 243
- 256 - 243 = 13, so it's September 13th
- Output: "13.09.2017"

**Solution**:
```java
public static String dayOfProgrammer(int year) {
    if (year == 1918) {
        return "26.09.1918";
    }
    
    boolean isLeap = (year < 1918) ? (year % 4 == 0) : 
                     (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    
    int day = isLeap ? 12 : 13;
    return String.format("%02d.09.%d", day, year);
}
```
**Time Complexity**: O(1) | **Space Complexity**: O(1)

### 19. Bill Division (Bon Appétit)
**Problem**: Two friends Anna and Brian are having dinner at a restaurant. Anna decides she doesn't want to eat item k on the bill. They decide to split the bill evenly among the items Anna will eat. Brian wants to order item k for himself.

Anna will pay for her portion of the bill and Brian will pay for his portion plus item k.

Given the bill, determine if Brian charged Anna fairly or if he overcharged her.

**Input Format**: 
- First line contains two space-separated integers n and k, the number of items ordered and the 0-based index of the item that Anna didn't eat
- Second line contains n space-separated integers bill[i] where 0 ≤ i < n
- Third line contains an integer, b, the amount of money that Brian charged Anna for her share of the bill

**Output Format**: 
- If Brian did not overcharge Anna, print "Bon Appetit" on a new line
- Otherwise, print the difference (i.e., b_charged - b_actual) that Brian must refund to Anna

**Example**:
- Input: bill = [3, 10, 2, 9], k = 1, b = 7
- Anna didn't eat item 1 (cost 10), so she pays for items [3, 2, 9] = 14
- Anna's fair share: 14/2 = 7
- Brian charged Anna 7, which is correct
- Output: "Bon Appetit"

**Solution**:
```java
public static void bonAppetit(List<Integer> bill, int k, int b) {
    int totalCost = bill.stream().mapToInt(Integer::intValue).sum();
    int actualShare = (totalCost - bill.get(k)) / 2;
    
    if (b == actualShare) {
        System.out.println("Bon Appetit");
    } else {
        System.out.println(b - actualShare);
    }
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 20. Sales by Match (Sock Merchant)
**Problem**: There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

**Input Format**: 
- First line contains an integer n, the number of socks represented in ar
- Second line contains n space-separated integers, ar[i], the colors of the socks in the pile

**Output Format**: Return the total number of matching pairs of socks that John can sell

**Constraints**: 
- 1 ≤ n ≤ 100
- 1 ≤ ar[i] ≤ 100

**Example**:
- Input: n = 9, ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
- Color counts: {10: 4, 20: 3, 30: 1, 50: 1}
- Pairs: 4/2 + 3/2 + 1/2 + 1/2 = 2 + 1 + 0 + 0 = 3
- Output: 3

**Solution**:
```java
public static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> sockCount = new HashMap<>();
    
    for (int sock : ar) {
        sockCount.put(sock, sockCount.getOrDefault(sock, 0) + 1);
    }
    
    int pairs = 0;
    for (int count : sockCount.values()) {
        pairs += count / 2;
    }
    
    return pairs;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(n)

---

## Strings (21-35)

### 21. CamelCase
**Problem**: There is a sequence of words in CamelCase as a string of letters, s, having the following properties:
- It is a concatenation of one or more words consisting of English letters
- All letters in the first word are lowercase
- For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase

Given s, determine the number of words in s.

**Input Format**: A single line containing string s

**Output Format**: Print the number of words in string s

**Constraints**: 1 ≤ |s| ≤ 10^5

**Example**:
- Input: "saveChangesInTheEditor"
- Words: "save", "Changes", "In", "The", "Editor" (5 words)
- Output: 5

**Solution**:
```java
public static int camelcase(String s) {
    int wordCount = 1;
    for (char c : s.toCharArray()) {
        if (Character.isUpperCase(c)) {
            wordCount++;
        }
    }
    return wordCount;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 22. Strong Password
**Problem**: Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:
- Its length is at least 6
- It contains at least one digit
- It contains at least one lowercase English character
- It contains at least one uppercase English character
- It contains at least one special character. The special characters are: !@#$%^&*()-+

She typed a random string of length n in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make it strong?

**Input Format**: 
- First line contains an integer n, the length of the password
- Second line contains a string consisting of characters, the password typed by Louise

**Output Format**: Return an integer denoting the minimum number of characters to add

**Example**:
- Input: n = 3, password = "Ab1"
- Missing: special character (1), minimum length 6-3=3
- Output: max(1, 3) = 3

**Solution**:
```java
public static int minimumNumber(int n, String password) {
    boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
    String specialChars = "!@#$%^&*()-+";
    
    for (char c : password.toCharArray()) {
        if (Character.isLowerCase(c)) hasLower = true;
        else if (Character.isUpperCase(c)) hasUpper = true;
        else if (Character.isDigit(c)) hasDigit = true;
        else if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
    }
    
    int missing = 0;
    if (!hasLower) missing++;
    if (!hasUpper) missing++;
    if (!hasDigit) missing++;
    if (!hasSpecial) missing++;
    
    return Math.max(missing, 6 - n);
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 23. Mars Exploration
**Problem**: A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.

Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.

**Input Format**: There is one line of input: a single string, s

**Output Format**: Print the number of letters in the received message that differ from the SOS message

**Constraints**: 
- 1 ≤ |s| ≤ 99
- |s| % 3 = 0
- s will contain only uppercase English letters

**Example**:
- Input: "SOSSPSSQSSOR"
- Expected: "SOSSOSSOSSOS" (4 SOS messages)
- Differences at positions: 4(P→O), 5(S→S), 6(S→S), 7(Q→S), 10(R→S)
- Output: 3 (positions 4, 7, 10 are different)

**Solution**:
```java
public static int marsExploration(String s) {
    int alterations = 0;
    String sos = "SOS";
    
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != sos.charAt(i % 3)) {
            alterations++;
        }
    }
    
    return alterations;
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 24. HackerRank in a String!
**Problem**: We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank. Remeber that a subsequence maintains the relative order of characters selected from a sequence.

More formally, let p[0], p[1], ..., p[9] be the respective indices of h, a, c, k, e, r, r, a, n, k in string s. If p[0] < p[1] < p[2] < ... < p[9], then s contains hackerrank.

For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.

**Input Format**: 
- First line contains an integer q, the number of queries
- Each of the next q lines contains a single query string s

**Output Format**: For each query, print YES if s contains hackerrank, otherwise print NO

**Example**:
- Input: "haacckkerrannkk"
- Subsequence: h-a-c-k-e-r-r-a-n-k can be found in order
- Output: "YES"

**Solution**:
```java
public static String hackerrankInString(String s) {
    String target = "hackerrank";
    int targetIndex = 0;
    
    for (char c : s.toCharArray()) {
        if (targetIndex < target.length() && c == target.charAt(targetIndex)) {
            targetIndex++;
        }
    }
    
    return targetIndex == target.length() ? "YES" : "NO";
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1)

### 25. Pangrams
**Problem**: A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.

**Input Format**: A single line with string s

**Output Format**: Print a line containing pangram if s is a pangram, otherwise print not pangram

**Constraints**: 0 < length of s ≤ 10^3

**Example**:
- Input: "We promptly judged antique ivory buckles for the next prize"
- Contains all 26 letters: a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
- Output: "pangram"

**Solution**:
```java
public static String pangrams(String s) {
    Set<Character> letters = new HashSet<>();
    
    for (char c : s.toLowerCase().toCharArray()) {
        if (Character.isLetter(c)) {
            letters.add(c);
        }
    }
    
    return letters.size() == 26 ? "pangram" : "not pangram";
}
```
**Time Complexity**: O(n) | **Space Complexity**: O(1) - at most 26 letters

### 26. Weighted Uniform Strings
**Problem**: Check weighted character queries
```java
public static List<String> weightedUniformStrings(String s, int[] queries) {
    Set<Integer> weights = new HashSet<>();
    
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int weight = c - 'a' + 1;
        weights.add(weight);
        
        int j = i;
        while (j + 1 < s.length() && s.charAt(j + 1) == c) {
            j++;
            weight += c - 'a' + 1;
            weights.add(weight);
        }
        i = j;
    }
    
    List<String> result = new ArrayList<>();
    for (int query : queries) {
        result.add(weights.contains(query) ? "Yes" : "No");
    }
    
    return result;
}
```

### 27. Separate the Numbers
**Problem**: Check if string is beautiful
```java
public static void separateNumbers(String s) {
    for (int len = 1; len <= s.length() / 2; len++) {
        String firstNum = s.substring(0, len);
        if (firstNum.charAt(0) == '0') continue;
        
        long num = Long.parseLong(firstNum);
        StringBuilder sb = new StringBuilder(firstNum);
        
        while (sb.length() < s.length()) {
            sb.append(++num);
        }
        
        if (sb.toString().equals(s)) {
            System.out.println("YES " + firstNum);
            return;
        }
    }
    
    System.out.println("NO");
}
```

### 28. Funny String
**Problem**: Check if string is funny
```java
public static String funnyString(String s) {
    int n = s.length();
    
    for (int i = 1; i < n; i++) {
        int diff1 = Math.abs(s.charAt(i) - s.charAt(i - 1));
        int diff2 = Math.abs(s.charAt(n - i) - s.charAt(n - i - 1));
        
        if (diff1 != diff2) {
            return "Not Funny";
        }
    }
    
    return "Funny";
}
```

### 29. Gemstones
**Problem**: Count common characters in all strings
```java
public static int gemstones(String[] arr) {
    Set<Character> common = new HashSet<>();
    
    for (char c : arr[0].toCharArray()) {
        common.add(c);
    }
    
    for (int i = 1; i < arr.length; i++) {
        Set<Character> current = new HashSet<>();
        for (char c : arr[i].toCharArray()) {
            current.add(c);
        }
        common.retainAll(current);
    }
    
    return common.size();
}
```

### 30. Alternating Characters
**Problem**: Count deletions for alternating
```java
public static int alternatingCharacters(String s) {
    int deletions = 0;
    
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
            deletions++;
        }
    }
    
    return deletions;
}
```

### 31. Beautiful Binary String
**Problem**: Minimum changes for beauty
```java
public static int beautifulBinaryString(String b) {
    int changes = 0;
    int i = 0;
    
    while (i <= b.length() - 3) {
        if (b.substring(i, i + 3).equals("010")) {
            changes++;
            i += 3;
        } else {
            i++;
        }
    }
    
    return changes;
}
```

### 32. The Love-Letter Mystery
**Problem**: Palindrome operations count
```java
public static int theLoveLetterMystery(String s) {
    int operations = 0;
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        operations += Math.abs(s.charAt(left) - s.charAt(right));
        left++;
        right--;
    }
    
    return operations;
}
```

### 33. Caesar Cipher
**Problem**: Implement Caesar cipher encryption
```java
public static String caesarCipher(String s, int k) {
    StringBuilder result = new StringBuilder();
    k = k % 26;
    
    for (char c : s.toCharArray()) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            char shifted = (char) ((c - base + k) % 26 + base);
            result.append(shifted);
        } else {
            result.append(c);
        }
    }
    
    return result.toString();
}
```

### 34. Two Characters
**Problem**: Maximum length with two characters
```java
public static int alternate(String s) {
    Set<Character> chars = new HashSet<>();
    for (char c : s.toCharArray()) {
        chars.add(c);
    }
    
    int maxLength = 0;
    
    for (char c1 : chars) {
        for (char c2 : chars) {
            if (c1 != c2) {
                String filtered = s.replaceAll("[^" + c1 + c2 + "]", "");
                if (isAlternating(filtered)) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }
    }
    
    return maxLength;
}

private static boolean isAlternating(String s) {
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
            return false;
        }
    }
    return true;
}
```

### 35. Ice Cream Parlor
**Problem**: Find two flavors with exact money
```java
public static void whatFlavors(int[] cost, int money) {
    Map<Integer, Integer> priceToIndex = new HashMap<>();
    
    for (int i = 0; i < cost.length; i++) {
        int complement = money - cost[i];
        
        if (priceToIndex.containsKey(complement)) {
            System.out.println((priceToIndex.get(complement) + 1) + " " + (i + 1));
            return;
        }
        
        priceToIndex.put(cost[i], i);
    }
}
```

---

## Searching & Sorting (36-50)

### 36. Missing Numbers
**Problem**: Find missing numbers in array
```java
public static int[] missingNumbers(int[] arr, int[] brr) {
    Map<Integer, Integer> freqA = new HashMap<>();
    Map<Integer, Integer> freqB = new HashMap<>();
    
    for (int num : arr) {
        freqA.put(num, freqA.getOrDefault(num, 0) + 1);
    }
    
    for (int num : brr) {
        freqB.put(num, freqB.getOrDefault(num, 0) + 1);
    }
    
    List<Integer> missing = new ArrayList<>();
    for (int num : freqB.keySet()) {
        if (freqB.get(num) > freqA.getOrDefault(num, 0)) {
            missing.add(num);
        }
    }
    
    Collections.sort(missing);
    return missing.stream().mapToInt(i -> i).toArray();
}
```

### 37. Sherlock and Array
**Problem**: Find equilibrium index
```java
public static String balancedSums(List<Integer> arr) {
    int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
    int leftSum = 0;
    
    for (int i = 0; i < arr.size(); i++) {
        int rightSum = totalSum - leftSum - arr.get(i);
        
        if (leftSum == rightSum) {
            return "YES";
        }
        
        leftSum += arr.get(i);
    }
    
    return "NO";
}
```

### 38. Minimum Loss
**Problem**: Find minimum loss in house prices
```java
public static int minimumLoss(long[] price) {
    Map<Long, Integer> priceToIndex = new HashMap<>();
    
    for (int i = 0; i < price.length; i++) {
        priceToIndex.put(price[i], i);
    }
    
    Arrays.sort(price);
    long minLoss = Long.MAX_VALUE;
    
    for (int i = 1; i < price.length; i++) {
        long loss = price[i] - price[i - 1];
        int buyIndex = priceToIndex.get(price[i]);
        int sellIndex = priceToIndex.get(price[i - 1]);
        
        if (buyIndex < sellIndex) {
            minLoss = Math.min(minLoss, loss);
        }
    }
    
    return (int) minLoss;
}
```

### 39. Connected Cells in a Grid
**Problem**: Find largest connected region
```java
public static int connectedCell(int[][] matrix) {
    int maxRegion = 0;
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 1 && !visited[i][j]) {
                int regionSize = dfs(matrix, visited, i, j);
                maxRegion = Math.max(maxRegion, regionSize);
            }
        }
    }
    
    return maxRegion;
}

private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length ||
        visited[row][col] || matrix[row][col] == 0) {
        return 0;
    }
    
    visited[row][col] = true;
    int size = 1;
    
    for (int dr = -1; dr <= 1; dr++) {
        for (int dc = -1; dc <= 1; dc++) {
            size += dfs(matrix, visited, row + dr, col + dc);
        }
    }
    
    return size;
}
```

### 40. Cut the Sticks
**Problem**: Simulate stick cutting process
```java
public static int[] cutTheSticks(int[] arr) {
    List<Integer> result = new ArrayList<>();
    List<Integer> sticks = new ArrayList<>();
    
    for (int stick : arr) {
        sticks.add(stick);
    }
    
    while (!sticks.isEmpty()) {
        result.add(sticks.size());
        
        int minLength = Collections.min(sticks);
        sticks = sticks.stream()
                      .map(stick -> stick - minLength)
                      .filter(stick -> stick > 0)
                      .collect(Collectors.toList());
    }
    
    return result.stream().mapToInt(i -> i).toArray();
}
```

---

## Dynamic Programming (51-65)

### 41. Fibonacci Modified
**Problem**: Modified Fibonacci sequence
```java
public static BigInteger fibonacciModified(int t1, int t2, int n) {
    if (n == 1) return BigInteger.valueOf(t1);
    if (n == 2) return BigInteger.valueOf(t2);
    
    BigInteger prev1 = BigInteger.valueOf(t1);
    BigInteger prev2 = BigInteger.valueOf(t2);
    
    for (int i = 3; i <= n; i++) {
        BigInteger current = prev1.add(prev2.multiply(prev2));
        prev1 = prev2;
        prev2 = current;
    }
    
    return prev2;
}
```

### 42. Abbreviation
**Problem**: Check if string can be abbreviated
```java
public static String abbreviation(String a, String b) {
    int m = a.length(), n = b.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    
    for (int i = 1; i <= m; i++) {
        if (Character.isLowerCase(a.charAt(i - 1))) {
            dp[i][0] = dp[i - 1][0];
        }
    }
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            char ca = a.charAt(i - 1);
            char cb = b.charAt(j - 1);
            
            if (Character.isUpperCase(ca)) {
                if (ca == cb) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else {
                if (Character.toUpperCase(ca) == cb) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
        }
    }
    
    return dp[m][n] ? "YES" : "NO";
}
```

### 43. Candies
**Problem**: Minimum candies distribution
```java
public static long candies(int n, int[] arr) {
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    
    for (int i = 1; i < n; i++) {
        if (arr[i] > arr[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }
    
    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] > arr[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }
    
    return Arrays.stream(candies).mapToLong(i -> i).sum();
}
```

### 44. Coin Change Problem
**Problem**: Count ways to make change
```java
public static long getWays(int n, int[] c) {
    long[] dp = new long[n + 1];
    dp[0] = 1;
    
    for (int coin : c) {
        for (int i = coin; i <= n; i++) {
            dp[i] += dp[i - coin];
        }
    }
    
    return dp[n];
}
```

### 45. Equal
**Problem**: Minimum operations to equalize array
```java
public static int equal(int[] arr) {
    int min = Arrays.stream(arr).min().getAsInt();
    int minOps = Integer.MAX_VALUE;
    
    for (int target = min - 4; target <= min; target++) {
        int ops = 0;
        for (int num : arr) {
            int diff = num - target;
            ops += diff / 5 + (diff % 5) / 2 + (diff % 5) % 2;
        }
        minOps = Math.min(minOps, ops);
    }
    
    return minOps;
}
```

### 46. Sherlock and Cost
**Problem**: Maximum cost with constraints
```java
public static int cost(int[] B) {
    int n = B.length;
    int low = 0, high = 0;
    
    for (int i = 1; i < n; i++) {
        int newLow = Math.max(low, high + Math.abs(B[i - 1] - 1));
        int newHigh = Math.max(low + Math.abs(B[i] - 1), high + Math.abs(B[i] - B[i - 1]));
        
        low = newLow;
        high = newHigh;
    }
    
    return Math.max(low, high);
}
```

### 47. Construct the Array
**Problem**: Count arrays with constraints
```java
public static long countArray(int n, int k, int x) {
    long MOD = 1000000007;
    
    if (n == 1) {
        return x == 1 ? 1 : 0;
    }
    
    long same = x == 1 ? 1 : 0;
    long diff = x == 1 ? 0 : 1;
    
    for (int i = 2; i < n; i++) {
        long newSame = diff;
        long newDiff = (same * (k - 1) + diff * (k - 2)) % MOD;
        
        same = newSame;
        diff = newDiff;
    }
    
    return same;
}
```

### 48. Maximum Subarray
**Problem**: Find maximum subarray sum
```java
public static long maxSubarray(int[] arr) {
    long maxSoFar = arr[0];
    long maxEndingHere = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    
    return maxSoFar;
}
```

### 49. Stock Maximize
**Problem**: Maximum profit from stock trading
```java
public static long stockmax(int[] prices) {
    int n = prices.length;
    int[] maxFromRight = new int[n];
    maxFromRight[n - 1] = prices[n - 1];
    
    for (int i = n - 2; i >= 0; i--) {
        maxFromRight[i] = Math.max(prices[i], maxFromRight[i + 1]);
    }
    
    long profit = 0;
    for (int i = 0; i < n; i++) {
        profit += Math.max(0, maxFromRight[i] - prices[i]);
    }
    
    return profit;
}
```

### 50. Knapsack
**Problem**: Unbounded knapsack problem
```java
public static int unboundedKnapsack(int k, int[] arr) {
    int[] dp = new int[k + 1];
    
    for (int i = 1; i <= k; i++) {
        for (int weight : arr) {
            if (weight <= i) {
                dp[i] = Math.max(dp[i], dp[i - weight] + weight);
            }
        }
    }
    
    return dp[k];
}
```

---

## Trees & Graphs (51-60)

### 51. Tree: Preorder Traversal
**Problem**: Preorder tree traversal
```java
public static void preOrder(Node root) {
    if (root != null) {
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
```

### 52. Tree: Postorder Traversal
**Problem**: Postorder tree traversal
```java
public static void postOrder(Node root) {
    if (root != null) {
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
```

### 53. Tree: Inorder Traversal
**Problem**: Inorder tree traversal
```java
public static void inOrder(Node root) {
    if (root != null) {
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
```

### 54. Tree: Height of a Binary Tree
**Problem**: Calculate tree height
```java
public static int height(Node root) {
    if (root == null) return -1;
    return 1 + Math.max(height(root.left), height(root.right));
}
```

### 55. Tree: Level Order Traversal
**Problem**: Level order traversal
```java
public static void levelOrder(Node root) {
    if (root == null) return;
    
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        System.out.print(node.data + " ");
        
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

### 56. Binary Search Tree: Insertion
**Problem**: Insert node in BST
```java
public static Node insert(Node root, int data) {
    if (root == null) {
        return new Node(data);
    }
    
    if (data < root.data) {
        root.left = insert(root.left, data);
    } else {
        root.right = insert(root.right, data);
    }
    
    return root;
}
```

### 57. Huffman Decoding
**Problem**: Decode Huffman encoded string
```java
void decode(String s, Node root) {
    Node current = root;
    
    for (char bit : s.toCharArray()) {
        if (bit == '0') {
            current = current.left;
        } else {
            current = current.right;
        }
        
        if (current.left == null && current.right == null) {
            System.out.print(current.data);
            current = root;
        }
    }
}
```

### 58. Roads and Libraries
**Problem**: Minimum cost for connectivity
```java
public static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    if (c_lib <= c_road) {
        return (long) n * c_lib;
    }
    
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
    }
    
    for (int[] city : cities) {
        graph.get(city[0]).add(city[1]);
        graph.get(city[1]).add(city[0]);
    }
    
    boolean[] visited = new boolean[n + 1];
    long totalCost = 0;
    
    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            int componentSize = dfs(graph, visited, i);
            totalCost += c_lib + (long) (componentSize - 1) * c_road;
        }
    }
    
    return totalCost;
}

private static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
    visited[node] = true;
    int size = 1;
    
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            size += dfs(graph, visited, neighbor);
        }
    }
    
    return size;
}
```

### 59. Journey to the Moon
**Problem**: Count astronaut pairs
```java
public static int journeyToMoon(int n, int[][] astronaut) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    
    for (int[] pair : astronaut) {
        graph.get(pair[0]).add(pair[1]);
        graph.get(pair[1]).add(pair[0]);
    }
    
    boolean[] visited = new boolean[n];
    List<Integer> componentSizes = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            int size = dfs(graph, visited, i);
            componentSizes.add(size);
        }
    }
    
    long totalPairs = (long) n * (n - 1) / 2;
    for (int size : componentSizes) {
        totalPairs -= (long) size * (size - 1) / 2;
    }
    
    return (int) totalPairs;
}
```

### 60. Breadth First Search: Shortest Reach
**Problem**: BFS shortest path
```java
public static int[] bfs(int n, int m, int[][] edges, int s) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
    }
    
    for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
    }
    
    int[] distances = new int[n + 1];
    Arrays.fill(distances, -1);
    distances[s] = 0;
    
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(s);
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        for (int neighbor : graph.get(node)) {
            if (distances[neighbor] == -1) {
                distances[neighbor] = distances[node] + 6;
                queue.offer(neighbor);
            }
        }
    }
    
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (i != s) {
            result.add(distances[i]);
        }
    }
    
    return result.stream().mapToInt(i -> i).toArray();
}
```

---

## Mathematics & Number Theory (61-75)

### 61. Find Digits
**Problem**: Count digits that divide number
```java
public static int findDigits(int n) {
    int count = 0;
    int original = n;
    
    while (n > 0) {
        int digit = n % 10;
        if (digit != 0 && original % digit == 0) {
            count++;
        }
        n /= 10;
    }
    
    return count;
}
```

### 62. Sherlock and Squares
**Problem**: Count perfect squares in range
```java
public static int squares(int a, int b) {
    int sqrtA = (int) Math.ceil(Math.sqrt(a));
    int sqrtB = (int) Math.floor(Math.sqrt(b));
    
    return Math.max(0, sqrtB - sqrtA + 1);
}
```

### 63. Library Fine
**Problem**: Calculate overdue book fine
```java
public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    if (y1 > y2) return 10000;
    if (y1 < y2) return 0;
    
    if (m1 > m2) return 500 * (m1 - m2);
    if (m1 < m2) return 0;
    
    if (d1 > d2) return 15 * (d1 - d2);
    
    return 0;
}
```

### 64. Chocolate Feast
**Problem**: Calculate total chocolates eaten
```java
public static int chocolateFeast(int n, int c, int m) {
    int chocolates = n / c;
    int wrappers = chocolates;
    
    while (wrappers >= m) {
        int newChocolates = wrappers / m;
        chocolates += newChocolates;
        wrappers = wrappers % m + newChocolates;
    }
    
    return chocolates;
}
```

### 65. Service Lane
**Problem**: Find minimum width in lane segments
```java
public static int[] serviceLane(int n, int[] width, int[][] cases) {
    int[] result = new int[cases.length];
    
    for (int i = 0; i < cases.length; i++) {
        int start = cases[i][0];
        int end = cases[i][1];
        int minWidth = Integer.MAX_VALUE;
        
        for (int j = start; j <= end; j++) {
            minWidth = Math.min(minWidth, width[j]);
        }
        
        result[i] = minWidth;
    }
    
    return result;
}
```

### 66. Lisa's Workbook
**Problem**: Count special problems
```java
public static int workbook(int n, int k, int[] arr) {
    int specialProblems = 0;
    int currentPage = 1;
    
    for (int problems : arr) {
        int problemNumber = 1;
        
        while (problemNumber <= problems) {
            int problemsOnPage = Math.min(k, problems - problemNumber + 1);
            
            if (currentPage >= problemNumber && currentPage <= problemNumber + problemsOnPage - 1) {
                specialProblems++;
            }
            
            problemNumber += problemsOnPage;
            currentPage++;
        }
    }
    
    return specialProblems;
}
```

### 67. Flatland Space Stations
**Problem**: Maximum distance to station
```java
public static int flatlandSpaceStations(int n, int[] c) {
    Arrays.sort(c);
    int maxDistance = 0;
    
    maxDistance = Math.max(maxDistance, c[0]);
    maxDistance = Math.max(maxDistance, n - 1 - c[c.length - 1]);
    
    for (int i = 1; i < c.length; i++) {
        maxDistance = Math.max(maxDistance, (c[i] - c[i - 1]) / 2);
    }
    
    return maxDistance;
}
```

### 68. Fair Rations
**Problem**: Minimum bread distribution
```java
public static String fairRations(int[] B) {
    int loaves = 0;
    
    for (int i = 0; i < B.length - 1; i++) {
        if (B[i] % 2 == 1) {
            B[i]++;
            B[i + 1]++;
            loaves += 2;
        }
    }
    
    return B[B.length - 1] % 2 == 0 ? String.valueOf(loaves) : "NO";
}
```

### 69. Cavity Map
**Problem**: Mark cavities in depth map
```java
public static String[] cavityMap(String[] grid) {
    int n = grid.length;
    String[] result = new String[n];
    
    for (int i = 0; i < n; i++) {
        result[i] = grid[i];
    }
    
    for (int i = 1; i < n - 1; i++) {
        StringBuilder sb = new StringBuilder(result[i]);
        
        for (int j = 1; j < n - 1; j++) {
            char current = grid[i].charAt(j);
            
            if (current > grid[i - 1].charAt(j) &&
                current > grid[i + 1].charAt(j) &&
                current > grid[i].charAt(j - 1) &&
                current > grid[i].charAt(j + 1)) {
                sb.setCharAt(j, 'X');
            }
        }
        
        result[i] = sb.toString();
    }
    
    return result;
}
```

### 70. Manasa and Stones
**Problem**: Possible stone values
```java
public static int[] stones(int n, int a, int b) {
    Set<Integer> possibleValues = new HashSet<>();
    
    for (int i = 0; i < n; i++) {
        int value = i * a + (n - 1 - i) * b;
        possibleValues.add(value);
    }
    
    return possibleValues.stream().sorted().mapToInt(i -> i).toArray();
}
```

### 71. The Grid Search
**Problem**: Find pattern in grid
```java
public static String gridSearch(String[] G, String[] P) {
    int gRows = G.length, gCols = G[0].length();
    int pRows = P.length, pCols = P[0].length();
    
    for (int i = 0; i <= gRows - pRows; i++) {
        for (int j = 0; j <= gCols - pCols; j++) {
            boolean found = true;
            
            for (int pi = 0; pi < pRows && found; pi++) {
                for (int pj = 0; pj < pCols && found; pj++) {
                    if (G[i + pi].charAt(j + pj) != P[pi].charAt(pj)) {
                        found = false;
                    }
                }
            }
            
            if (found) return "YES";
        }
    }
    
    return "NO";
}
```

### 72. Happy Ladybugs
**Problem**: Check if ladybugs can be happy
```java
public static String happyLadybugs(String b) {
    Map<Character, Integer> count = new HashMap<>();
    boolean hasEmpty = false;
    
    for (char c : b.toCharArray()) {
        if (c == '_') {
            hasEmpty = true;
        } else {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
    }
    
    for (int freq : count.values()) {
        if (freq == 1) return "NO";
    }
    
    if (!hasEmpty) {
        for (int i = 0; i < b.length(); i++) {
            boolean happy = false;
            if (i > 0 && b.charAt(i) == b.charAt(i - 1)) happy = true;
            if (i < b.length() - 1 && b.charAt(i) == b.charAt(i + 1)) happy = true;
            
            if (!happy) return "NO";
        }
    }
    
    return "YES";
}
```

### 73. Strange Counter
**Problem**: Find counter value at time
```java
public static long strangeCounter(long t) {
    long cycleStart = 1;
    long cycleLength = 3;
    
    while (t >= cycleStart + cycleLength) {
        cycleStart += cycleLength;
        cycleLength *= 2;
    }
    
    return cycleLength - (t - cycleStart);
}
```

### 74. Absolute Permutation
**Problem**: Find lexicographically smallest permutation
```java
public static int[] absolutePermutation(int n, int k) {
    if (k == 0) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
    
    if (n % (2 * k) != 0) {
        return new int[]{-1};
    }
    
    int[] result = new int[n];
    boolean toggle = false;
    
    for (int i = 0; i < n; i++) {
        if (i % k == 0) {
            toggle = !toggle;
        }
        
        if (toggle) {
            result[i] = i + 1 + k;
        } else {
            result[i] = i + 1 - k;
        }
    }
    
    return result;
}
```

### 75. Queen's Attack II
**Problem**: Count queen's attack squares
```java
public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    Set<String> obstacleSet = new HashSet<>();
    for (int[] obstacle : obstacles) {
        obstacleSet.add(obstacle[0] + "," + obstacle[1]);
    }
    
    int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
    int totalAttacks = 0;
    
    for (int[] dir : directions) {
        int row = r_q + dir[0];
        int col = c_q + dir[1];
        
        while (row >= 1 && row <= n && col >= 1 && col <= n) {
            if (obstacleSet.contains(row + "," + col)) {
                break;
            }
            totalAttacks++;
            row += dir[0];
            col += dir[1];
        }
    }
    
    return totalAttacks;
}
```

---

## Advanced Problems (76-80)

### 76. Organizing Containers of Balls
**Problem**: Check if organization possible
```java
public static String organizingContainers(int[][] container) {
    int n = container.length;
    long[] containerCapacity = new long[n];
    long[] ballCount = new long[n];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            containerCapacity[i] += container[i][j];
            ballCount[j] += container[i][j];
        }
    }
    
    Arrays.sort(containerCapacity);
    Arrays.sort(ballCount);
    
    return Arrays.equals(containerCapacity, ballCount) ? "Possible" : "Impossible";
}
```

### 77. Encryption
**Problem**: Encrypt string using grid method
```java
public static String encryption(String s) {
    s = s.replaceAll(" ", "");
    int len = s.length();
    int rows = (int) Math.floor(Math.sqrt(len));
    int cols = (int) Math.ceil(Math.sqrt(len));
    
    if (rows * cols < len) {
        rows = cols;
    }
    
    StringBuilder result = new StringBuilder();
    
    for (int col = 0; col < cols; col++) {
        for (int row = 0; row < rows; row++) {
            int index = row * cols + col;
            if (index < len) {
                result.append(s.charAt(index));
            }
        }
        if (col < cols - 1) {
            result.append(" ");
        }
    }
    
    return result.toString();
}
```

### 78. Bigger is Greater
**Problem**: Find next lexicographically greater permutation
```java
public static String biggerIsGreater(String w) {
    char[] chars = w.toCharArray();
    int n = chars.length;
    
    int i = n - 2;
    while (i >= 0 && chars[i] >= chars[i + 1]) {
        i--;
    }
    
    if (i < 0) return "no answer";
    
    int j = n - 1;
    while (chars[j] <= chars[i]) {
        j--;
    }
    
    swap(chars, i, j);
    reverse(chars, i + 1, n - 1);
    
    return new String(chars);
}

private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
}

private static void reverse(char[] chars, int start, int end) {
    while (start < end) {
        swap(chars, start, end);
        start++;
        end--;
    }
}
```

### 79. Modified Kaprekar Numbers
**Problem**: Find Kaprekar numbers in range
```java
public static void kaprekarNumbers(int p, int q) {
    List<Integer> kaprekarNums = new ArrayList<>();
    
    for (int i = p; i <= q; i++) {
        if (isKaprekar(i)) {
            kaprekarNums.add(i);
        }
    }
    
    if (kaprekarNums.isEmpty()) {
        System.out.println("INVALID RANGE");
    } else {
        for (int num : kaprekarNums) {
            System.out.print(num + " ");
        }
    }
}

private static boolean isKaprekar(int n) {
    if (n == 1) return true;
    
    long square = (long) n * n;
    String squareStr = String.valueOf(square);
    int len = squareStr.length();
    
    for (int i = 1; i < len; i++) {
        String left = squareStr.substring(0, i);
        String right = squareStr.substring(i);
        
        if (!right.isEmpty() && !right.startsWith("0")) {
            int leftNum = left.isEmpty() ? 0 : Integer.parseInt(left);
            int rightNum = Integer.parseInt(right);
            
            if (leftNum + rightNum == n) {
                return true;
            }
        }
    }
    
    return false;
}
```

### 80. Beautiful Triplets
**Problem**: Count beautiful triplets
```java
public static int beautifulTriplets(int d, int[] arr) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : arr) {
        numSet.add(num);
    }
    
    int count = 0;
    for (int num : arr) {
        if (numSet.contains(num + d) && numSet.contains(num + 2 * d)) {
            count++;
        }
    }
    
    return count;
}
```

---

## 📊 Complexity Analysis Summary

| Problem Type | Time Complexity | Space Complexity | Key Technique |
|--------------|----------------|------------------|---------------|
| **Array Sum** | O(n) | O(1) | Linear Scan |
| **String Processing** | O(n) | O(1) | Character Analysis |
| **Binary Search** | O(log n) | O(1) | Divide & Conquer |
| **DFS/BFS** | O(V + E) | O(V) | Graph Traversal |
| **Dynamic Programming** | O(n²) | O(n) | Memoization |
| **Sorting** | O(n log n) | O(1) | Comparison Based |

---

## 🎯 Interview Success Strategies

### **Problem Recognition Patterns**
1. **Array Problems** → Linear scan, two pointers, sorting
2. **String Problems** → Character frequency, pattern matching
3. **Tree Problems** → Recursion, traversal algorithms
4. **Graph Problems** → BFS, DFS, connectivity
5. **Math Problems** → Number theory, combinatorics

### **Time Management**
- **Easy Problems**: 5-10 minutes
- **Medium Problems**: 15-20 minutes  
- **Hard Problems**: 25-30 minutes

### **Coding Best Practices**
1. **Read Constraints** - Understand input limits
2. **Handle Edge Cases** - Empty inputs, single elements
3. **Optimize Space** - Use in-place algorithms when possible
4. **Test Thoroughly** - Verify with sample inputs
5. **Clean Code** - Use meaningful variable names

---

## 🏆 Company-Specific Preparation

### **Product Companies**: Focus on Problems 1-50
**Key Skills**: Basic algorithms, problem-solving fundamentals

### **Service Companies**: Focus on Problems 21-65
**Key Skills**: String processing, dynamic programming

### **FAANG Companies**: Focus on Problems 36-80
**Key Skills**: Advanced algorithms, optimization techniques

### **Startups**: Focus on Problems 1-35
**Key Skills**: Quick implementation, basic data structures

---

## 📚 Additional Practice Resources

- **HackerRank Domains** - Practice by topic
- **GeeksforGeeks** - Algorithm explanations
- **InterviewBit** - Structured learning path
- **CodeChef/Codeforces** - Competitive programming

**Master these 100 HackerRank problems for technical interview success! 🎯**