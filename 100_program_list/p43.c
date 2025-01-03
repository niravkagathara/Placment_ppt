#include <unordered_map>
#include <stdio.h>
#include <stdlib.h>

// Function to find the number of pairs whose sum equals K
int countPairsWithSumK(int arr[], int N, int K) {
    std::unordered_map<int, int> freq_map;  // To store frequency of elements
    int count = 0;

    // Traverse the array
    for (int i = 0; i < N; i++) {
        int complement = K - arr[i];

        // If the complement is already in the map, it means we have found pairs
        if (freq_map.find(complement) != freq_map.end()) {
            count += freq_map[complement];  // Add the frequency of the complement
        }

        // Add the current element to the map
        freq_map[arr[i]]++;
    }

    return count;
}

int main() {
    int arr[] = {1, 5, 7, 1};
    int N = sizeof(arr) / sizeof(arr[0]);
    int K = 6;

    int result = countPairsWithSumK(arr, N, K);
    printf("Number of pairs with sum %d: %d\n", K, result);

    return 0;
}
// Given an array of N integers, and an integer K, find the number of pairs of elements in the
// array whose sum is equal to K.
// e.g.
// Input:
// N = 4, K = 6
// arr[] = {1, 5, 7, 1}
// Output: 2
// Explanation:
// arr[0] + arr[1] = 1 + 5 = 6
// and arr[1] + arr[3] = 5 + 1 = 6