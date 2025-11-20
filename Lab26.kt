class CurriedCalculator {

    // Curried add: takes 'a', returns a function that adds 'a' to input 'b'
    fun add(a: Int): (Int) -> Int = { b -> a + b }

    // Curried multiply: takes 'a', returns a function that multiplies input 'b' by 'a'
    fun multiply(a: Int): (Int) -> Int = { b -> a * b }

    // Curried power: takes 'a', returns a function b ↦ b^a
    fun power(a: Int): (Int) -> Int = { b -> Math.pow(b.toDouble(), a.toDouble()).toInt() }

    // Solve equation: a + b * c^2 using only the curried functions
    fun equationSolver(a: Int, b: Int, c: Int): Int {
        val addA = add(a)
        val multB = multiply(b)
        val pow2 = power(2)

        val cSquared = pow2(c)
        val bTimesCSq = multB(cSquared)

        return addA(bTimesCSq)
    }
}

fun main() {
    val calculator = CurriedCalculator()

    val add100 = calculator.add(100)
    println("add100(20) = ${add100(20)}")   // 120

    val mult10 = calculator.multiply(10)
    println("mult10(20) = ${mult10(20)}")   // 200

    val pow2 = calculator.power(2)
    println("pow2(10) = ${pow2(10)}")       // 100

    println("equationSolver(2,3,4) = ${calculator.equationSolver(2,3,4)}") // 50
}
