object Solution {
    def isMatch(s: String, p: String): Boolean = {
        s match {
            case p.r() => true
            case _ => false
        }
    }
}
