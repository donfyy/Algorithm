/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *partitionLabels(char *S, int *returnSize)
{
    int last[26] = {0}, n = strlen(S), i;
    for (i = 0; i < n; i++)
    {
        last[S[i] - 'a'] = i;
    }
    int l = 0, r = 0, *ret = malloc(sizeof(int) * n);
    *returnSize = 0;
    for (i = 0; i < n; i++)
    {
        r = fmax(r, last[S[i] - 'a']);
        if (i == r)
        {
            ret[(*returnSize)++] = r - l + 1;
            l = r + 1;
        }
    }
    return ret;
}