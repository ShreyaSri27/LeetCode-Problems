class Solution {
        public int findMin(int[] arr) {

                int len = arr.length;

                if (arr[0] <= arr[len - 1])
                        return arr[0];

                int left = 0;
                int right = arr.length - 1;
                int mid = 0;

                while (left <= right) {
                        // System.out.print("\nleft: "+ left + " left val: " + arr[left]);
                        // System.out.print("|| right: "+ right + " right val: "  + arr[right]);
                        // System.out.print("|| mid: "+ mid + " mid: val: " + arr[mid]);
                        
                        mid = left + (right - left) / 2;

                        int prev_mid = (mid - 1 + len) % len;
                        int next_mid = (mid + 1) % len;
                        
                        // System.out.print("prev: " + prev_mid);
                        // System.out.print("next: " + next_mid); 

                        if (arr[mid] <= arr[prev_mid] && arr[mid] <= arr[next_mid])
                                return arr[mid];

//                         int prev_start = (left - 1 + len) % len;
//                         int next_start = (left + 1) % len;

//                         if (arr[left] <= prev_start && arr[left] <= next_start)
//                                 return arr[left];

//                         int prev_end = (right - 1 + len) % len;
//                         int next_end = (right + 1) % len;

//                         if (arr[right] <= prev_end && arr[right] <= next_end)
//                                 return arr[right];

                        if (arr[0] <= arr[mid])
                                left = mid + 1;
                        else if (arr[mid] <= arr[len - 1])
                                right = mid - 1;
                }

                return arr[mid];
        }
}
