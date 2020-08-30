char * reverseWords(char * s){
    char * i = s, * j = s;
    while (*i) {
        while (*j && *j != ' ') j++;
        char * l = i, * r = j - 1;
        while (l < r) {
            char t = *l;
            *l = *r;
            *r = t;
            l++;
            r--;
        }
        i = *j ? ++j : j;
    }
    return s;
}