#include <stdio.h>
#include <uthash.h>

#define DEF_DICT_CLEAR(M)                       \
void M ## _clear() {                            \
    struct dict_##M* current_##M;               \
    struct dict_##M* tmp;                       \
    HASH_ITER(hh, ##M, current_##M, tmp) {      \
        HASH_DEL(##M, current_##M);             \
        free(current_##M);                      \
    }                                           \
}

#define INT_DICT(M, T)                          \
struct dict_##M {                               \
    int key;                                    \
    T value;                                    \
    UT_hash_handle hh;                          \
};                                              \
struct dict_##M* ##M = NULL;                    \
void M ## _put(const int key, const T value) {  \
    struct dict_##M* s;                         \
    HASH_FIND_INT(##M, &key, s);                \
    if (s == NULL) {                            \
        s = malloc(sizeof(struct dict_##M));    \
        s->key = key;                           \
        HASH_ADD_INT(##M, key, s);              \
    }                                           \
    s->value = value;                           \
}                                               \
T* M ## _get(const int key) {                   \
    struct dict_##M* s;                         \
    HASH_FIND_INT(##M, &key, s);                \
    if (s == NULL)                              \
        return NULL;                            \
    else                                        \
        return &(s->value);                     \
}                                               \
void M ## _remove(const int key) {              \
    struct dict_##M* s;                         \
    HASH_FIND_INT(##M, &key, s);                \
    if (s != NULL) {                            \
        HASH_DEL(##M, s);                       \
        free(s);                                \
    }                                           \
}                                               \
DEF_DICT_CLEAR(M);                              \
void M ## _print(const char* fmt) {             \
    struct dict_##M *s;                         \
    printf("{");                                \
    for(s = ##M; s != NULL; s = (struct dict_##M*)(s->hh.next)) { \
        printf("%d => ", s->key);                                 \
        printf(fmt, s->value);                                    \
        printf(", ");                                             \
    }                                                             \
    printf("}");                                                  \
}

#define MAKE_ARRAY(returnSize, T, ...) ({  \
    const T tmp[] = { ##__VA_ARGS__ };     \
    const int bytes = sizeof(tmp),         \
              n = bytes / sizeof(T);       \
    *returnSize = n;                       \
    T* r = malloc(bytes);                  \
    for (int i = 0; i < n; ++i)            \
        *(r + i) = tmp[i];                 \
    r;                                     \
})

#define INT_ARRAY(returnSize, ...) MAKE_ARRAY(returnSize, int, ##__VA_ARGS__)
#define ERROR(fmt, ...) fprintf(stderr, fmt, ##__VA_ARGS__)

INT_DICT(m, int);
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* result = NULL;
    for (int i = 0; i < numsSize; ++i) {
        const int num = *(nums + i);
        const int* ptr_j = m_get(target - num);
        if (ptr_j != NULL) {
            const int j = *ptr_j;
            result = INT_ARRAY(returnSize, j, i);
            break;
        }
        m_put(num, i);
    }
    if (result == NULL)
        ERROR("No match value for %s, %d!", nums, target);
    m_clear();
    return result;
}
