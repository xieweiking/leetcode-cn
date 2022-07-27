-spec is_match(S :: unicode:unicode_binary(), P :: unicode:unicode_binary()) -> boolean().
is_match(S, P) ->
    H = <<"^"/utf8>>,
    T = <<"$"/utf8>>,
    case re:run(S, <<H/bytes, P/bytes, T/bytes>>) of
        {match, Captured} -> true;
        nomatch -> false
    end.