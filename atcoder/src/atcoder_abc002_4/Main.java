package atcoder_abc002_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] array = br.readLine().split(" ");

      int n = Integer.parseInt(array[0]);

      HumanMap map = new HumanMap(n);

      String str = null;
      for(int i =0;i<Integer.parseInt(array[1]);i++) {
    	str = br.readLine();
        map.put(str);
      }
      System.out.println(map.max());
    }
  }

  private static class HumanMap {
    private final int[] map;
    private final int size;
    private final int[] key;

    public HumanMap(int n) {
      map = new int[n];
      key = new int[n];
      for (int i = 0; i < n; i++) {
        map[i] = 1 << i;
      }

      size = n;

    }

    public void put(String str) {
      String[] array = str.split(" ");
      this.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    public void put(int a, int b) {
      map[a - 1] |= (1 << (b - 1));
      map[b - 1] |= (1 << (a - 1));
    }

    public int max() {
      int max = 1;

      for (int line : map) {
        if (Integer.bitCount(line) > max) {
          for (int filter = Integer.lowestOneBit(line); filter <= line; filter++) {
            int combination = filter & line;
            if (combination > 0 && Integer.bitCount(combination) > max) {
              int keySize = setKey(combination);
              int value = combination;
              for (int k = 0; k < keySize; k++) {
                value &= map[key[k]];
              }
              max = Math.max(Integer.bitCount(value), max);
            }
          }
        }
      }
      return max;
    }

    private int setKey(int line) {
      int index = 0;
      for (int i = 0; i < size; i++) {
        if ((line & (1 << i)) > 0) {
          key[index++] = i;
        }
      }
      return index;
    }
  }
}