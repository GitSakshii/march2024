//       2.Problem statement
//        Bob lives with his wife in a city named Berland. Bob is a good husband,
//        so he goes out with his wife every Friday to ‘Arcade’ mall.
//
//        ‘Arcade’ is a very famous mall in Berland. It has a very unique
//        transportation method between shops. Since the shops in the mall are laying
//        in a straight line, you can jump on a very advanced trampoline from the shop i, and land in any shop
//        between (i) to (i+Arr[i]), where Arr[i] is a constant given for each shop.
//
//        There are N shops in the mall, numbered from 0 to N-1. Bob's wife starts her shopping journey from
//        shop 0 and ends it in shop N-1. As the mall is very crowded on Fridays, unfortunately,
//        Bob gets lost from his wife. So he wants to know, what is the minimum number of trampoline
//        jumps from shop 0 he has to make in order to reach shop N-1 and see his wife again.
//        If it is impossible to reach the last shop, return -1.

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class minimumJumps {

    static int min_trampoline_jumps(int N, int[] Arr) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0}); // {shop index, jumps}
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentShop = current[0];
            int jumps = current[1];

            if (currentShop == N - 1) {
                return jumps;
            }

            for (int i = currentShop + 1; i < Math.min(N, currentShop + 1 + Arr[currentShop]); i++) {
                if (!visited.contains(i)) {
                    queue.offer(new int[]{i, jumps + 1});
                    visited.add(i);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of shops
            int[] Arr = new int[N]; // Array of trampoline ranges
            for (int i = 0; i < N; i++) {
                Arr[i] = scanner.nextInt();
            }
            System.out.println(min_trampoline_jumps(N, Arr));
        }
        scanner.close();
    }
}
