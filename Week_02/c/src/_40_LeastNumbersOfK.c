#include <stdio.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *getLeastNumbers(int *arr, int arrSize, int k, int *returnSize)
{
    if (arr == NULL || k < 1 || arrSize < 1)
    {
        *returnSize = 0;
        return NULL;
    }
    if (k >= arrSize)
    {
        *returnSize = arrSize;
        return arr;
    }

    int start = 0, end = arrSize - 1, idx;
    idx = partition(arr, start, end);
    while (idx != k - 1)
    {
        if (idx < k - 1)
        {
            start = idx + 1;
        }
        else
        {
            end = idx - 1;
        }
        idx = partition(arr, start, end);
    }
    int *ret = malloc(k * sizeof(int));
    for (idx = 0; idx < k; idx++)
    {
        ret[idx] = arr[idx];
    }
    *returnSize = k;
    return ret;
}

int partition(int *arr, int start, int end)
{
    if (start >= end)
        return end;
    int pivot = arr[end], i, j = start - 1;
    for (i = start; i < end; i++)
    {
        if (arr[i] < pivot)
            swap(arr, i, ++j);
    }
    swap(arr, ++j, end);
    return j;
}

void swap(int *arr, int i, int j)
{
    if (i != j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}