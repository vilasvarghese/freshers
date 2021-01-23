public class DropLessSignificant{
	public static void test(int n){

		printf("First element of array = "+arr[0]);
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				System.out.println(arr[i] + arr[j]);
			}
		}
	}
}
//O(n^2)

void printAllNumbersThenAllPairSums(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d\n", arr[i]);
    }

    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            printf("%d\n", arr[i] + arr[j]);
        }
    }
}