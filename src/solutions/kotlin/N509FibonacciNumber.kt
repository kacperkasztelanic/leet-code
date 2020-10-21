package solutions.kotlin

object N509FibonacciNumber {

    fun fib(n: Int): Int {
        tailrec fun fib(a: Int, b: Int, n: Int): Int =
                if (n > 0) fib(b, a + b, n - 1)
                else a

        return fib(0, 1, n)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assert(fib(2) == 1)
        assert(fib(3) == 2)
        assert(fib(4) == 3)
    }
}