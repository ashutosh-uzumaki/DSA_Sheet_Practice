# DP Tier-1 Interview Revision Notes

This file is the GitHub revision sheet for the DP problems we have
completed.

## Roadmap

### Completed

-   0/1 Knapsack
-   Unbounded Knapsack
    -   Coin Change I
    -   Coin Change II
    -   Rod Cutting
    -   Perfect Squares
-   String DP
    -   LCS
    -   Palindrome DP / LPS / Partition / Min Cut
    -   Edit Distance
    -   Wildcard Matching: parked
    -   Regular Expression Matching: parked
-   LIS Family
    -   LIS O(n²)
    -   LIS O(n log n)
    -   Maximum Sum Increasing Subsequence
    -   Number of LIS
    -   Longest Bitonic Subsequence
    -   Largest Divisible Subset
    -   Russian Doll Envelopes

### Next

1.  Grid DP
2.  Interval DP
3.  Graphs

### Deferred

-   Tree DP
-   Bitmask DP
-   Digit DP
-   Other advanced/specialized DP

### Printing / Reconstruction Backlog

-   Print LIS in O(n log n)
-   Print all LIS
-   Print LCS
-   Print Shortest Common Supersequence
-   Reconstruct Edit Distance operations
-   Reconstruct selected Knapsack items
-   Reconstruct subset/partition choices
-   Reconstruct Coin Change choices
-   Reconstruct Grid paths
-   Reconstruct Interval DP choices
-   Other DP reconstruction problems

------------------------------------------------------------------------

# 1. 0/1 Knapsack

## State

`helper(idx, capacity)` = maximum value using items from `idx` onward
with remaining capacity.

## Recurrence

``` text
take = val[idx] + helper(idx + 1, capacity - wt[idx])
skip = helper(idx + 1, capacity)
answer = max(take, skip)
```

## Recognition

The item cannot be reused, so `take` moves to `idx + 1`.

## Memo State

``` text
memo[idx][capacity]
```

Code: `knapsack_01` (Recursive, Memorization, Tabulation)

------------------------------------------------------------------------

# 2. Unbounded Knapsack

## Recognition

If the same item can be used repeatedly:

``` text
take -> idx
skip -> idx + 1
```

The key difference from 0/1 Knapsack is that `take` does NOT advance
`idx`.

Code: `knapsack_unbounded` (Memorization, Tabulation)

------------------------------------------------------------------------

# 3. Coin Change I - Minimum Coins

## State

`helper(idx, amount)` = minimum coins needed using coins from `idx`
onward.

## Recurrence

``` text
take = 1 + helper(idx, amount - coins[idx])
skip = helper(idx + 1, amount)
answer = min(take, skip)
```

## Base Cases

``` java
if (amount == 0) return 0;
if (idx == coins.length) return INF;
```

## Important

For minimization, impossible states need a large value:

``` java
private static final int INF = 1_000_000;
```

Never use `0` for an impossible minimum state.

Code: `coin_change_minimum` (Memorization, Tabulation)

------------------------------------------------------------------------

# 4. Coin Change II - Number of Combinations

## State

`helper(idx, amount)` = number of combinations.

## Base Cases

``` java
if (amount == 0) return 1;
if (idx == coins.length) return 0;
```

`amount == 0` returns `1` because reaching zero represents one valid
combination.

## Recurrence

``` text
take = helper(idx, amount - coins[idx])
skip = helper(idx + 1, amount)
answer = take + skip
```

Code: `coin_change_combinations` (Memorization, Tabulation)

------------------------------------------------------------------------

# 5. Rod Cutting

Rod lengths are `1..n`, where piece length at index `idx` is `idx + 1`.

## Recognition

The same piece length can be used multiple times, so this is Unbounded
Knapsack.

## State

`helper(idx, remainingLength)`

## Recurrence

``` text
cut =
    price[idx] +
    helper(idx, remainingLength - (idx + 1))

doNotCut =
    helper(idx + 1, remainingLength)

answer = max(cut, doNotCut)
```

## Memoization

``` text
memo[idx][remainingLength]
```

Code: `rod_cutting` (Memorization, Tabulation)

------------------------------------------------------------------------

# 6. Perfect Squares

## State

`helper(n)` = minimum number of perfect squares needed to form `n`.

## Recurrence

Try every square:

``` text
take = 1 + helper(n - i*i)
answer = min(answer, take)
```

for:

``` text
1 <= i*i <= n
```

## Base Case

``` java
if (n == 0) return 0;
```

## Clean Memoized Java

``` java
class Solution {
    private static final int INF = 1_000_000;

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int min = INF;

        for (int i = 1; i * i <= n; i++) {
            int take = 1 + helper(n - i * i, memo);
            min = Math.min(min, take);
        }

        return memo[n] = min;
    }
}
```

## Lesson

Do not force every problem into an `(idx, amount)` state. Here only `n`
changes, so one-dimensional memoization is enough.

Code: `partition_dp/perfect_squares` (Memorization, Tabulation)

------------------------------------------------------------------------

# 7. String DP

Completed core topics included:

-   LCS
-   Palindrome DP
-   Longest Palindromic Subsequence
-   Palindrome Partitioning
-   Minimum Cut
-   Edit Distance
-   Other standard string DP variations

Parked:

-   Wildcard Matching
-   Regular Expression Matching

## Generic String DP

Usually identify:

``` text
i = position in string 1
j = position in string 2
```

Then define exactly what `helper(i, j)` means before writing the
recurrence.

Code:

-   `lcs` (Memorization, Tabulation)
-   `edit_distance` (Memorization, Tabulation)
-   `palindrome_dp/largest_palindrome` (LPS Memo/Tabulation, Count Palindromic Substrings)
-   `palindrome_dp/min_partition` (Palindrome Partitioning Min Cuts: Memorization, Tabulation)

------------------------------------------------------------------------

# 8. LIS - Longest Increasing Subsequence

## State

``` text
dp[i] = length of LIS ending at i
```

## Recurrence

For every `j < i`:

``` java
if (nums[j] < nums[i]) {
    dp[i] = Math.max(dp[i], dp[j] + 1);
}
```

## Initialization

``` java
dp[i] = 1;
```

## Final Answer

``` text
max(dp[i])
```

## O(n²) Java

``` java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int maxLis = 1;

        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }

            maxLis = Math.max(maxLis, lis[i]);
        }

        return maxLis;
    }
}
```

Code: `lis` (Recursive, Tabulation, BinarySearch, Reconstruction)

------------------------------------------------------------------------

# 9. Maximum Sum Increasing Subsequence

## State

``` text
sum[i] = maximum sum of an increasing subsequence ending at i
```

## Recurrence

``` java
if (arr[j] < arr[i]) {
    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
}
```

## Important Difference

LIS:

``` text
dp[i] = max(dp[i], dp[j] + 1)
```

Maximum Sum IS:

``` text
sum[i] = max(sum[i], sum[j] + arr[i])
```

## Java

``` java
class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int[] sum = new int[n];
        int maxSum = arr[0];

        for (int i = 0; i < n; i++) {
            sum[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, sum[i]);
        }

        return maxSum;
    }
}
```

Code: `max_sum_increasing_subsequence` (Tabulation)

------------------------------------------------------------------------

# 10. Number of LIS

Two states:

``` text
lis[i]   = best length ending at i
count[i] = number of ways to achieve that length ending at i
```

Initialize:

``` java
lis[i] = 1;
count[i] = 1;
```

For valid predecessor `nums[j] < nums[i]`:

``` java
int cand = lis[j] + 1;

if (cand > lis[i]) {
    lis[i] = cand;
    count[i] = count[j];
} else if (cand == lis[i]) {
    count[i] += count[j];
}
```

### Mental Rule

``` text
BETTER -> REPLACE
EQUAL  -> ADD
```

Final answer:

``` text
maxLen = max(lis[i])
total = sum(count[i]) where lis[i] == maxLen
```

## Java

``` java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];
        int[] count = new int[n];

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int cand = lis[j] + 1;

                    if (cand > lis[i]) {
                        lis[i] = cand;
                        count[i] = count[j];
                    } else if (cand == lis[i]) {
                        count[i] += count[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, lis[i]);
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            if (lis[i] == maxLen) {
                total += count[i];
            }
        }

        return total;
    }
}
```

Code: `count_lis`

------------------------------------------------------------------------

# 11. Print One LIS - Reconstruction

Parked as a reconstruction problem, but the core technique is:

``` text
parent[i] = previous index chosen for i
```

Initialize:

``` java
parent[i] = -1;
```

Update only when a better predecessor is found:

``` java
if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
    dp[i] = dp[j] + 1;
    parent[i] = j;
}
```

Track `maxIdx`, then:

``` java
while (maxIdx != -1) {
    result.add(nums[maxIdx]);
    maxIdx = parent[maxIdx];
}

Collections.reverse(result);
```

Code: `lis/LongestIncreasingSubsequenceReconstruction`

------------------------------------------------------------------------

# 12. LIS O(n log n)

Maintain:

``` text
tails[k] = smallest possible tail value
           for an increasing subsequence of length k + 1
```

`tails` is not necessarily the actual LIS.

For each `x`:

> Find the first position where `tails[pos] >= x`.

This is lower bound.

If no position exists, append.

Otherwise replace.

## Java

``` java
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int x : nums) {
            int pos = Collections.binarySearch(tails, x);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == tails.size()) {
                tails.add(x);
            } else {
                tails.set(pos, x);
            }
        }

        return tails.size();
    }
}
```

## Complexity

``` text
Time: O(n log n)
Space: O(n)
```

Code: `lis/LongestIncreasingSubsequenceBinarySearch`

------------------------------------------------------------------------

# 13. Longest Bitonic Subsequence

A valid sequence is:

``` text
increasing -> peak -> decreasing
```

For the problem version used, purely increasing or purely decreasing
arrays return `0`.

## States

``` text
lis[i] = LIS ending at i

lds[i] = LDS starting at i
```

## LIS

``` java
for (int i = 0; i < n; i++) {
    lis[i] = 1;

    for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
            lis[i] = Math.max(lis[i], lis[j] + 1);
        }
    }
}
```

## LDS

Must look to the right:

``` java
for (int i = n - 1; i >= 0; i--) {
    lds[i] = 1;

    for (int j = i + 1; j < n; j++) {
        if (nums[j] < nums[i]) {
            lds[i] = Math.max(lds[i], lds[j] + 1);
        }
    }
}
```

## Combine

``` java
if (lis[i] > 1 && lds[i] > 1) {
    answer = Math.max(
        answer,
        lis[i] + lds[i] - 1
    );
}
```

The `-1` removes the peak counted twice.

Code: `longest_bitonic_subsequence` (Tabulation)

------------------------------------------------------------------------

# 14. Largest Divisible Subset

## Why Sort?

It is a **subset**, so original order does not matter.

Sorting creates:

``` text
small -> large
```

and lets us use an LIS-like DP.

## State

``` text
dp[i] = largest divisible subset size ending at i
```

## Transition

``` java
if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
    dp[i] = dp[j] + 1;
    parent[i] = j;
}
```

## Java

``` java
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }

        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        Collections.reverse(result);
        return result;
    }
}
```

Code: `largest_divisible_subset`

------------------------------------------------------------------------

# 15. Russian Doll Envelopes

## Transformation

``` text
2D nesting
    ↓
sort width ascending
    ↓
height descending for equal width
    ↓
LIS on heights
```

## Why descending height for equal widths?

Equal widths cannot be nested.

Example:

``` text
[5,4]
[5,3]
```

Descending heights prevents the height LIS from selecting both.

## Sort

``` java
Arrays.sort(envelopes, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(b[1], a[1]);
    }

    return Integer.compare(a[0], b[0]);
});
```

## O(n log n)

``` java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        List<Integer> tails = new ArrayList<>();

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int pos = Collections.binarySearch(
                tails,
                height
            );

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == tails.size()) {
                tails.add(height);
            } else {
                tails.set(pos, height);
            }
        }

        return tails.size();
    }
}
```

## Complexity

``` text
Time: O(n log n)
Space: O(n)
```

Code: `russian_doll_envelopes`

------------------------------------------------------------------------

# 16. Recognition Patterns

## Pattern A - Take / Skip

Typical Knapsack:

``` text
take
skip
```

Ask:

> Can I reuse the current item?

-   No -\> `idx + 1` after take
-   Yes -\> keep `idx` after take

## Pattern B - Minimum

Use:

``` text
INF
```

for impossible paths.

``` text
answer = min(...)
```

## Pattern C - Counting

Define what represents one valid way.

Common base:

``` text
target == 0 -> 1
```

## Pattern D - LIS

Ask:

> Can I define the best answer ending at i?

Then inspect:

``` text
j < i
```

## Pattern E - Optimization + Counting

``` text
better -> replace count
equal  -> add count
```

## Pattern F - Reconstruction

Store the choice:

``` text
parent[i]
```

Then backtrack.

## Pattern G - Two-Sided DP

Bitonic:

``` text
left DP + right DP
```

## Pattern H - 2D -\> LIS

Russian Doll:

``` text
sort one dimension
tie-break the other
run LIS
```

------------------------------------------------------------------------

# 17. Standard DP Derivation Checklist

For every new DP problem:

1.  Make a tiny example.
2.  Enumerate the possibilities by hand.
3.  Ask what information is needed to make the future independent of the
    past.
4.  Define the state.
5.  Derive the recurrence.
6.  Derive the base cases.
7.  Identify recursion direction.
8.  Write plain recursion.
9.  Identify repeated states.
10. Add memoization.
11. Only then move to tabulation when we decide to cover it.
12. Record the recognition pattern and common trap.

Never start by memorizing a table.

------------------------------------------------------------------------

# 18. Current Next Steps

``` text
NEXT:
    Grid DP

THEN:
    Interval DP

THEN:
    Graphs

DEFER:
    Tree DP
    Bitmask DP
    Digit DP
    Advanced DP

FINAL DP CONSOLIDATION:
    Printing / reconstruction problems
```
