package cse214hw1;

public class ArrayUtils {
//    private static <T> void rotateOneRightInt(int[] a){
//        int x = a[a.length-1];
//        for(int i = a.length-2; i>=0; i--){
//            a[i+1] = a[i];
//        }
//        a[0] = x;
//    }
//    private static <T> void rotateOneRightChar(char[] a){
//        char x = a[a.length-1];
//        for(int i = a.length-2; i>=0; i--){
//            a[i+1] = a[i];
//        }
//        a[0] = x;
//    }
    private static <T> void rotateOneLeftInt(int[] a){
        int x = a[0];
        for(int i = 1; i<a.length; i++){
            a[i-1] = a[i];
        }
        a[a.length-1] = x;
    }
    private static <T> void rotateOneLeftChar(char[] a){
        char x = a[0];
        for(int i = 1; i<a.length; i++){
            a[i-1] = a[i];
        }
        a[a.length-1] = x;
    }

    //#1 Array Rotation int
    public static void rotate(int[] a, int r){
        for(int i =r; i<a.length; i++){
            rotateOneLeftInt(a);
        }
    }
    //#2 Array Rotation char
    public static void rotate(char[] a, int r) {
        for(int i =r; i<a.length; i++){
            rotateOneLeftChar(a);
        }
    }

    //#3 Array merge
    public static int[] merge(int[] a, int[] b){
        int c[] = new int[a.length + b.length];
        for(int i = 0; i<a.length; i++){
            c[i] = a[i];
        }
        for(int i = 0, j=a.length; i<b.length; i++,j++){
            c[j] = b[i];
        }
        return c;
    }

}