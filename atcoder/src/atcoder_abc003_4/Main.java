package atcoder_abc003_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] array = br.readLine().split(" ");

      int n = Integer.parseInt(array[0]);
      
      System.out.println(n);
    }
  }
}