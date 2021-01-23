public class OOne{
	public static fibonacci(int num)
	{
		if (num <= 1) return num;
		return fibonacci(num - 2) + fibonacci(num - 1);
	}
}

//O(2^n) or On complex
																								
int fibonacci(int num)
{
    if (num <= 1) return num;
    return fibonacci(num - 2) + fibonacci(num - 1);
}