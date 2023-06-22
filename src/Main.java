import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] arr = new int[m][n];

        int start = 1;
        int end = n;

        for (int k = 0; k < Math.min(m, n) / 2; k++) {
            for (int j = k; j < end; j++)
                arr[k][j] = start;
            start++;
            for (int i = k + 1; i < m - k; i++)
                arr[i][end - 1] = start;
            start++;
            for (int j = end - 2; j >= k; j--)
                arr[m - k - 1][j] = start;
            start++;
            for (int i = m - k - 2; i > k; i--)
                arr[i][k] = start;
            start++;
            end--;
        }

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(arr[i][j] + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Массив успешно сохранён в файл output.txt");
    }
} 