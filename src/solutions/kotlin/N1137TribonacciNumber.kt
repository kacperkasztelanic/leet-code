package solutions.kotlin

object N1137TribonacciNumber {

    fun tribonacci(n: Int): Int {
        tailrec fun tribonacci(a: Int, b: Int, c: Int, n: Int): Int = when (n) {
            0 -> a
            1 -> b
            2 -> c
            else -> tribonacci(b, c, a + b + c, n - 1)
        }

        return tribonacci(0, 1, 1, n)
    }

    fun tribonacci2(n: Int): Int {
        return if (n == 0) 0
        else if (n == 1 || n == 2) 1
        else tribonacci2(n - 1) + tribonacci2(n - 2) + tribonacci2(n - 3)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assert(tribonacci(4) == 4)
        assert(tribonacci(25) == 1389537)
        assert(tribonacci(37) == 2082876103)
    }
}