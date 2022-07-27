(define/contract (is-match s p) (-> string? string? boolean?)
    (regexp-match-exact? p s)
)