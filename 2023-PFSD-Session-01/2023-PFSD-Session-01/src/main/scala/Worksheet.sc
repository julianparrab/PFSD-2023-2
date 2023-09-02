import eci.edu.co.functions.{Currying, HigherOrderFunctions, PureFunctions}


HigherOrderFunctions.applyFunc(4, PureFunctions.square)

HigherOrderFunctions.applyFunc(4, PureFunctions.sum2)

HigherOrderFunctions.mathOperation("+")(5, 6)
HigherOrderFunctions.mathOperation("-")(3, 1)
HigherOrderFunctions.mathOperation("@")(9, 7)

//val mult = HigherOrderFunctions.mathOperation("*")
//mult(5,2)

Currying.sumNotCurried(1, 2, 3)
val curriedFunc1 = Currying.sumCurried(1)
val curriedFunc2 = curriedFunc1(2)
val curriedFunc3 = curriedFunc2(3)


val totalCurry = Currying.sumCurried(5) (6) (4)




HigherOrderFunctions.applyFunc(5, x => x - 2)

