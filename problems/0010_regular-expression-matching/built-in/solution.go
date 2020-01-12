import "regexp"

func isMatch(s string, p string) bool {
    return regexp.MustCompile("^" + p + "$").FindStringSubmatch(s) != nil
}
