import java.util.*;
class Solution {
    public int strongPasswordChecker(String password) {
      Comparator<Integer> customComparator = (a, b) -> {
            int remainderA = a % 3;
            int remainderB = b % 3;
            return remainderA == remainderB ? a - b : remainderA - remainderB;
        };

        boolean lowercase = true, uppercase = true, digit = true;
        int replacementsRequired = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);
        int length = password.length();
        int offSet = (length > 20) ? length - 20 : (length < 6) ? 6 - length : 0;
        int score = 0;
        char prevChar = '@';
        int repeatCount = 1;

        for (char c : password.toCharArray()) {
            if (lowercase && Character.isLowerCase(c)) { lowercase = false; replacementsRequired--; }
            if (uppercase && Character.isUpperCase(c)) { uppercase = false; replacementsRequired--; }
            if (digit && Character.isDigit(c)) { digit = false; replacementsRequired--; }

            if (c == prevChar) {
                repeatCount++;
            } else {
                if (repeatCount >= 3) pq.add(repeatCount);
                repeatCount = 1;
            }
            prevChar = c;
        }
        if (repeatCount >= 3) pq.add(repeatCount);

        if (length < 6) {
          while (!pq.isEmpty() && offSet > 0 && replacementsRequired > 0) {
              int queuedRepeatCount = pq.poll();
              offSet--;
              replacementsRequired--;
              score++;
              queuedRepeatCount -= 3;
              if (queuedRepeatCount > 2) {
                pq.add(queuedRepeatCount);
              }
            }
        }

        while (offSet > 0 && !pq.isEmpty()) {
          int polled = pq.poll();
          polled--;
          if (polled > 2) {
            pq.add(polled);
          }
          offSet--;
          score++;
        }

        if (length < 6) {
          int diff = Math.min(replacementsRequired, offSet);
          replacementsRequired -= diff;
          offSet -= diff;
          score += diff;
        }

        while (!pq.isEmpty()) {
          int queuedRepeatCount = pq.poll();
          if (replacementsRequired > 0) {
            int repeatActions = Math.min(replacementsRequired, queuedRepeatCount / 3);
            queuedRepeatCount -= 3 * repeatActions;
            score += repeatActions;
            replacementsRequired -= repeatActions;
          }
          if (replacementsRequired == 0) {
            if (offSet > queuedRepeatCount) {
              score += queuedRepeatCount;
              offSet -= queuedRepeatCount;
            } else {
              score += offSet;
              queuedRepeatCount -= offSet;
              offSet = 0;
            }
            if (queuedRepeatCount > 2) {
              score += queuedRepeatCount / 3;
            }
          }
        }

        score += offSet;
        score += replacementsRequired;
        return score;
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj =  new Solution();
    System.out.println(obj.strongPasswordChecker("..."));
  }
}