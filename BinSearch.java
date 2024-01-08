import java.util.*;
public class BinSearch{
    public static int BinarySearch(int a[], int n , int key){
        int lb = 0;
        int ub = n-1;
        int k = key;
        while(lb<=ub){
            int mid  = (lb + ub)/2;
            if(a[mid] == k){
                return mid;
            }
            else if(a[mid] > k){
                ub = mid -1;
            }
            else{
                lb = mid + 1;
            }
        }
        
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the array elements:");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("enter the element to search:");
        int key = sc.nextInt();
        int r = BinarySearch(a , n , key);
        if(r == -1){
            System.out.println(key + "not found.");
        }
        else{
            System.out.println("posistion of the element:"+r);
        }
        

    }
}