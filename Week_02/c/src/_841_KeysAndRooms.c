bool canVisitAllRooms(int** rooms, int roomsSize, int* roomsColSize){
    int visited[roomsSize];
    memset(visited, 0, sizeof(visited));
    int count = 0;
    dfs(rooms, roomsColSize, 0, visited, &count);
    return count == roomsSize;
}

void dfs(int **rooms, int *roomsColSize, int u, int visited[], int *count) {
    if (visited[u]) return;
    visited[u] = 1;
    (*count)++;
    for (int i = 0; i < roomsColSize[u]; i++) {
        dfs(rooms, roomsColSize, rooms[u][i], visited, count);
    }
}

bool canVisitAllRoomsBfs(int** rooms, int roomsSize, int* roomsColSize){
    int visited[roomsSize], queue[roomsSize];
    memset(visited, 0, sizeof(visited));
    int left = 0, right = 1, num = 1;
    visited[0] = true;
    queue[0] = 0;
    while (left < right) {
        int u = queue[left++];
        for (int i = 0; i < roomsColSize[u]; i++) {
            int v = rooms[u][i];
            if (!visited[v]) {
                visited[v] = true;
                queue[right++] = v;
                if (++num == roomsSize) return true;
            }
        }
    }
    return roomsSize == num;
}
