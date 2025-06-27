import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
      int n = queue1.length;
      int[] arr = new int[n * 2];
      long sum1 = 0, sum2 = 0;

      for (int i = 0; i < n; i++) {
          arr[i] = queue1[i];
          arr[i + n] = queue2[i];
          sum1 += queue1[i];
          sum2 += queue2[i];
      }
      
      long sum = sum1 + sum2;
      if (sum %2 == 1) return -1;
      
      long half = sum / 2;

      int left = 0, right = n;
      int count = 0;

      while (left < 2 * n && right < 2 * n) {
          if (sum1 == half) return count;

          if (sum1 > half) {
              sum1 -= arr[left];
              left++;
          } else {
              sum1 += arr[right];
              right++;
          }

          count++;

          if (count > n * 3) break;
      }

      return -1;
  }
}