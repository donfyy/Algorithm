#include "./../lib/uthash.h"
#include <stdio.h>

struct hash_entry
{
    int key; /* we'll use this field as the key */
    int idx;
    UT_hash_handle hh; /* makes this structure hashable */
};

typedef struct hash_entry *hash_ptr;

hash_ptr find(hash_ptr table, int key)
{
    if (!table)
        return NULL;
    hash_ptr s;
    HASH_FIND_INT(table, &key, s);
    return s;
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    int b, *ret = NULL;
    hash_ptr e, table = NULL;
    for (int i = 0; i < numsSize; i++)
    {
        b = target - nums[i];
        e = find(table, b);
        if (e)
        {
            ret = malloc(sizeof(int) * 2);
            *returnSize = 2;
            ret[0] = e->idx;
            ret[1] = i;
            return ret;
        }
        e = malloc(sizeof(struct hash_entry));
        e->key = nums[i];
        e->idx = i;
        HASH_ADD_INT(table, key, e);
    }
    *returnSize = 0;
    return ret;
}

int main(int argc, char const *argv[])
{
    printf("Tow sum : Hello world!");
    return 0;
}
