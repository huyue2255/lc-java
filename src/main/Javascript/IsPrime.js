/**
 * Created by yuehu on 4/12/19.
 */

function isPrime(n){
    var divisor = 2;

    while (n > divisor){
        if(n % divisor == 0){
            return false;
        }
        else
            divisor++;
    }
    return true;
}
