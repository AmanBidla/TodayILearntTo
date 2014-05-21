   public static void maximumContSubSeq(int[] a) {
        int sum[] = new int[a.length]; // Sum at every element
        sum[0] = a[0];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
            if (max < sum[i])
                max = sum[i];
        }
        System.out.println(max);
    }
}
