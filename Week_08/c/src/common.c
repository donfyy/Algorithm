void swap(int *a, int *b) {
    int c = *a;
    *a = *b;
    *b = c;
}

void printArray(int* arr, int n) {
    for (int i = 0; i < n; i++)
        printf("%d,", arr[i]);
    printf("\n");
}

