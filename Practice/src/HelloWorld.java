import java.util.Scanner;
public  class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dieu xi ga: ");
        int n = sc.nextInt();
        System.out.print("So dau loc de tao nen mot dieu xi ga moi la ");
        int k = sc.nextInt();
        int ans = n;
        int x = n%k;
        System.out.println("Jack co tong cong "+ans+" dieu xi ga");
        daulocthua(n,k);
    }
    public static int daulocthua(int a, int b){
        if (a==1){
            return 1;
        } else {
            return daulocthua(a-1,b);
        }
    }
}