// p19.c
#include <stdio.h>
#include <stdlib.h>

void insertionSort(float arr[], int n) {
    for (int i = 1; i < n; i++) {
        float key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void bucketSort(float arr[], int n) {
    // Create n empty buckets
    float **buckets = (float **)malloc(n * sizeof(float *));
    int *bucketCount = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        buckets[i] = (float *)malloc(n * sizeof(float));
        bucketCount[i] = 0;
    }

    // Distributing elements into buckets
    for (int i = 0; i < n; i++) {
        int bucketIndex = n * arr[i]; // Assuming arr[i] is in range [0, 1)
        buckets[bucketIndex][bucketCount[bucketIndex]++] = arr[i];
    }

    // Sorting individual buckets
    for (int i = 0; i < n; i++) {
        insertionSort(buckets[i], bucketCount[i]);
    }

    // Merging buckets
    int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < bucketCount[i]; j++) {
            arr[index++] = buckets[i][j];
        }
    }

    // Freeing memory
    for (int i = 0; i < n; i++) {
        free(buckets[i]);
    }
    free(buckets);
    free(bucketCount);
}

int main() {
    float arr[] = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.55, 0.88, 0.12};
    int n = sizeof(arr) / sizeof(arr[0]);
    bucketSort(arr, n);

    // Print sorted array
    printf("Sorted array: \n");
    for (int i = 0; i < n; i++) {
        printf("%f ", arr[i]);
    }
    printf("\n");
    
    return 0;
}