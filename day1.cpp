class Solution {
public:
    bool isUgly(int n) {
        if (n < 0)
            return false;
        while (n > 1) {
            if (n % 2 == 0)
                n = n / 2;
            else if (n % 3 == 0)
                n = n / 3;
            else if (n % 5 == 0)
                n = n / 5;
            else
                break;
        }
        return (n == 1);
    }
};

class Solution {
  public:
    long long reversedBits(long long x) {
        // code here
        long long sum = 0;
        long long k = pow(2, 31);
        while(x!=0){
            int bit = x%2;
            sum = sum+t*bit;
            x = x/2;
            k=k/2;
        }
        return sum;
}
};
