#include <uthash.h>;

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

#define STR_DICT(M, LEN, T)                      \
struct dict_##M {                                \
    char key[LEN];                               \
    T value;                                     \
    UT_hash_handle hh;                           \
};                                               \
struct dict_##M* ##M = NULL;                     \
void M ## _put(const char* key, const T value) { \
    struct dict_##M* s;                          \
    HASH_FIND_STR(##M, key, s);                  \
    if (s == NULL) {                             \
        s = malloc(sizeof(struct dict_##M));     \
        s->key = key;                            \
        HASH_ADD_STR(##M, key, s);               \
    }                                            \
    s->value = value;                            \
}                                                \
T* M ## _get(const char* key) {                  \
    struct dict_##M* s;                          \
    HASH_FIND_STR(##M, key, s);                  \
    if (s == NULL)                               \
        return NULL;                             \
    else                                         \
        return &(s->value);                      \
}                                                \
void M ## _remove(const char* key) {             \
    struct dict_##M* s;                          \
    HASH_FIND_STR(##M, key, s);                  \
    if (s != NULL) {                             \
        HASH_DEL(##M, s);                        \
        free(s);                                 \
    }                                            \
}                                                \
DEF_DICT_CLEAR(M);                               \
void M ## _print(const char* fmt) {              \
    struct dict_##M *s;                          \
    printf("{");                                 \
    for(s = ##M; s != NULL; s = (struct dict_##M*)(s->hh.next)) { \
        printf("%s => ", s->key);                                 \
        printf(fmt, s->value);                                    \
        printf(", ");                                             \
    }                                                             \
    printf("}");                                                  \
}

