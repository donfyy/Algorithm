bool judgeCircle(char * moves){
    int n = strlen(moves), x = 0, y = 0;
    for (int i = 0; i < n; i++) {
        switch(moves[i]) {
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
        }
    }
    return !x && !y;
}