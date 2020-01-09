char * convert(char * s, int numRows){
    const int sLen = strlen(s);
    if (sLen <= 2 || numRows == 1)
        return s;
    const int colsPerPad = numRows - 1,
              charsPerPad = colsPerPad - 1 + numRows,
              lastRow = colsPerPad;
    char* result = malloc((sLen + 1) * sizeof(char));
    result[sLen] = '\0';
    for (int r = 0, k = 0; r < numRows; ++r)
        for (int i = r; i < sLen; i += charsPerPad) {
            result[k++] = s[i];
            if (r != 0 && r != lastRow) {
                const int j = i + charsPerPad - 2 * r;
                if (j < sLen)
                    result[k++] = s[j];
            }
        }
    return result;
}
