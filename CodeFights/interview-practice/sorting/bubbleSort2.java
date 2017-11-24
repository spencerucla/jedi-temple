public class bubbleSort2 {
    public static int[] bubbleSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length-1-i; j++) {
                if (items[j] > items[j + 1]) {
                    swap(items, j, j + 1);
                }
            }
        }
        return items;
    }

    private static void swap(int[] items, int firstIndex, int secondIndex) {
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
        System.out.println(intArrayToString(arr));
        System.out.println(intArrayToString(bubbleSort(arr)));
    }

    private static String intArrayToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + ", ";
        }
        return str.substring(0, str.length()-2) + "]";
    }
}
