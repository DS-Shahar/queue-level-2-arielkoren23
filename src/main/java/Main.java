class Main 
{
  public static void main(String[] args) 
  {
    System.out.println("Hello World!");
  }
  
  public static Queue<Integer> runLengths(Queue<Character> q)
  {
    Queue<Integer> res = new Queue<>();
    if (q.isEmpty())
        return res;

    char ch = q.remove();
    int count = 1;
    while (!q.isEmpty())
    {
        char x = q.remove();

        if (x == ch)
        {
            count++;
        }
        else
        {
            res.insert(count);
            ch = x;
            count = 1;
        }
    }
    res.insert(count);
    return res;
  }

  public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2)
{
    Queue<Integer> res = new Queue<>();

    while (!q1.isEmpty() && !q2.isEmpty())
    {
        if (q1.head() <= q2.head())
            res.insert(q1.remove());
        else
            res.insert(q2.remove());
    }

    while (!q1.isEmpty())
        res.insert(q1.remove());

    while (!q2.isEmpty())
        res.insert(q2.remove());

    return res;
}

  public static int sumLongestEvenRun(Queue<Integer> q)
{
    int maxLen = 0;
    int maxSum = 0;

    int len = 0;
    int sum = 0;

    while (!q.isEmpty())
    {
        int x = q.remove();

        if (x % 2 == 0)
        {
            len++;
            sum += x;
        }
        else
        {
            if (len > maxLen)
            {
                maxLen = len;
                maxSum = sum;
            }
            len = 0;
            sum = 0;
        }
    }

    if (len > maxLen)
        maxSum = sum;

    return maxSum;
}

  public static int getMax(Queue<Integer> q)
	{
	    q.insert(null);
	    int max = 0;
	    while(q.head() != null)
	    {
	        int x = q.remove();
	        if(x>max)
	        {
	            max = x;
	        }
	        q.insert(x);
	    }
	    q.remove();
	    return max;
	}
	
	public static int numDigit(int x)
	{
	    return (int)Math.log10(x)+1;
	}
	
	public static int retDigit(int num, int p)
	{
	    int l = numDigit(num);
	    if(p>=l)
	    {
	        return 0; 
	    }
	    for(int i=0; i<=l; i++)
	    {
	       if(p!=0)
	       {
	          num = num/10;
	          p--; 
	       }
	       
	    }
	    return num%10;
	}

	public static boolean ex2(Queue<String> q)
{
    Queue<String> t = new Queue<>();

    while (!q.isEmpty())
    {
        String x = q.remove();

        if (isIn(x, t))
        {
            q.insert(x);
            while (!t.isEmpty())
                q.insert(t.remove());
            return true;
        }

        t.insert(x);
    }

    while (!t.isEmpty())
        q.insert(t.remove());

    return false;
}
	
  
}
