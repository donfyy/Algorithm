import java.util.ArrayList;

public class _306_AdditivieNumber {
    ArrayList<Long> path = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0);
    }

    boolean dfs(String num, int start) {
        if (start == num.length() && path.size() > 2) {
            return true;
        }

        long curr = 0;
        for (int end = start + 1; end <= num.length(); end++) {
            curr = curr * 10 + num.charAt(end - 1) - '0';

            if (path.size() < 2 || curr == path.get(path.size() - 1) + path.get(path.size() - 2)) {
                path.add(curr);

                if (dfs(num, end)) {
                    return true;
                }

                path.remove(path.size() - 1);
            }

            if (curr == 0) {
                break;
            }

            if (path.size() >= 2 && curr > path.get(path.size() - 1) + path.get(path.size() - 2)) {
                break;
            }

            if (end - start > num.length() / 2) {
                break;
            }
        }
        return false;
    }
}
