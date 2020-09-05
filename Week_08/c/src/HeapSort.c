#include <stdio.h>
#include "common.c"

void heapifyDownIterative(int *arr, int n, int i);
void heapSortIterative(int *arr, int n);
void heapifyDownRecursive(int *arr, int n, int i);
void heapSortRecursive(int *arr, int n);
int main(int argc, char const *argv[])
{
    int n = 6;
    int arr1[] = {1, 5, 3, 2, 6, 4};
    int arr2[] = {1, 5, 3, 2, 6, 4};
    heapSortIterative(arr1, n);
    heapSortRecursive(arr2, n);
    printArray(arr1, n);
    printArray(arr2, n);
    return 0;
}

void heapSortIterative(int *arr, int n)
{
    int i, tmp;
    for (i = (n >> 1) - 1; i >= 0; i--)
        heapifyDownIterative(arr, n, i);

    for (i = n - 1; i > 0; i--)
    {
        swap(arr, arr + i);
        heapifyDownIterative(arr, i, 0);
    }
}

void heapifyDownIterative(int *arr, int n, int i)
{
    int half = n >> 1, c, r;
    int v = arr[i];
    while (i < half)
    {
        c = (i << 1) + 1;
        r = c + 1;
        if (r < n && arr[r] > arr[c])
            c = r;
        if (arr[c] <= v)
            break;
        arr[i] = arr[c];
        i = c;
    }
    arr[i] = v;
}

void heapSortRecursive(int *arr, int n)
{
    int i;
    for (i = (n >> 1) - 1; i >= 0; i--)
        heapifyDownRecursive(arr, n, i);
    for (i = n - 1; i > 0; i--)
    {
        swap(arr, arr + i);
        heapifyDownRecursive(arr, i, 0);
    }
}
void heapifyDownRecursive(int *arr, int n, int i)
{
    int half = n >> 1;
    if (i >= half)
        return;
    int c = (i << 1) + 1;
    int r = c + 1;
    if (r < n && arr[r] > arr[c])
        c = r;
    if (arr[c] > arr[i])
    {
        swap(arr + c, arr + i);
        heapifyDownRecursive(arr, n, c);
    }
}
