class Solution {
        public int findPeakElement(int[] arr) {
                int len = arr.length;
                int left = 0;
                int right = len - 1;

                if (len == 1 || arr[0] > arr[1])
                        return 0;
                if (arr[len - 2] < arr[right])
                        return right;

                int mid = 0;

                while (left <= right) {
                        mid = left + (right - left) / 2;

                        if (mid != 0 && mid != len - 1 && (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) return mid;

                        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid])
                                right = mid - 1;
                        else if (mid + 1 < len && arr[mid] < arr[mid + 1])
                                left = mid + 1;

                }

                return mid;

        }
}
