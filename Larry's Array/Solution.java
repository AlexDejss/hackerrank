import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i+1];
                    int j = i;
                    while(j >= 0 && temp < arr[j]){
                        arr[j+1] = arr[j];
                        j--;
                        count++;
                    }
                    if(j==-1) j++;
                    if(temp > arr[j])
                        arr[j+1] = temp;
                    else
                        arr[j] = temp;
                }

            }
            System.out.println(count%2 == 0 ? "YES" : "NO");
        }
    }

}
