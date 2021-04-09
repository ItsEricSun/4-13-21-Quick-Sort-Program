import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSort {
	static Scanner sc;
	
	public static void main(String[] args) throws InputMismatchException {
		int[] unsorted;
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("How many integers do you want to input? (1-10)");
				int count = sc.nextInt();
				if(count < 1 || count > 10) {
					System.out.println("Make sure input isn't less than 1 or greater than 10");
					continue;
				}
				unsorted = new int[count];
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		for(int i = 0; i < unsorted.length; i++) {
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.print(i + 1 + ": ");
					int input = sc.nextInt();
					unsorted[i] = input;
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is an integer");
				}
			}
		}
		int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
		sort(sorted, 0, sorted.length - 1);
		System.out.print("Unsorted:");
		for(int i = 0; i < unsorted.length; i++) {
			System.out.print(" " + unsorted[i]);
		}
		System.out.print("\nSorted:  ");
		for(int i = 0; i < sorted.length; i++) {
			System.out.print(" " + sorted[i]);
		}
		sc.close();
		System.out.println("\nProgram ended");
		return;
	}
	
	public static void sort(int arr[], int low, int high) { 
        if(low < high) { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

	public static int partition(int arr[], int low, int high) { 
        int pivot = arr[low];  
        int i = (high + 1); 
        for(int j=high; j>low; j--) { 
            if(arr[j] <= pivot) { 
                i--; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i-1]; 
        arr[i-1] = arr[low]; 
        arr[low] = temp; 
        return i-1; 
    } 
}
