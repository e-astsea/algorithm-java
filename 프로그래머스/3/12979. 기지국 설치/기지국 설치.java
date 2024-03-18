class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;

        int location=1;
         while (location <= n) {
            if (index < stations.length && location >= stations[index] - w) {
                location = stations[index] + w + 1;
                index++;
            } else {
                location += 2 * w + 1;
                answer++;
            }
        }

        return answer;
    }
}