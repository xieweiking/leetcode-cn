defmodule Solution do
    @spec is_match(s :: String.t, p :: String.t) :: boolean
    def is_match(s, p) do
        {:ok, cp} = Regex.compile("^#{p}$")
        String.match?(s, cp)
    end
end