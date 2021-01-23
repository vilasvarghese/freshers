public class OOne{
	public static void test(int n){
		for (int i =0; i < n; i++)(
			for (int j=0; j < n; j++){
				System.out.println(i + j);
			}
		}
	}
}

//O(n^2) or On complex
																								
void printAllPossibleOrderedPairs(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            printf("%d = %d\n", arr[i], arr[j]);
        }
     }
}																																