public class OOne{
	public static void test(int n){

		printf("First element of array = "+arr[0]);
		
		for (int i = 0; i < arr.length/2; i++)
		{
			System.out.println(arr[i]);
		}

		for (int i = 0; i < 100; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
//O(n)

void printFirstItemThenFirstHalfThenSayHi100Times(int arr[], int size)
{
    printf("First element of array = %d\n",arr[0]);
	
    for (int i = 0; i < size/2; i++)
    {
        printf("%d\n", arr[i]);
    }

    for (int i = 0; i < 100; i++)
    {
        printf("Hi\n");
    }
}