@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
/*
Года, оканчивающиеся на цифру 1 (1, 21, 31 и т.д.), должны записываться как 1 год, 21 год и т.д.
Года, оканчивающиеся на цифры 2, 3, 4 (2, 22, 32, 3, 23, 4, 24 и т.д.), должны записываться как 2 года, 22 года, 3 года, 44 года и т.д.
Все остальные года должны записываться со словом лет: 5 лет, 10 лет, 69 лет, 667 лет и т.д.
Исключением являются года 11, 12, 13, 14, 111, 913, 2012 и т.д.
 */
    var yearsWordForm = "лет"
    val lastDigit = age % 10
    if (age % 100 !in (11..14)) {
        when (lastDigit) {
            1 -> yearsWordForm = "год"
            2, 3, 4 -> yearsWordForm = "года"
        }
    }
    return "${age.toString()} $yearsWordForm"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val halfDistance = (s1 + s2 + s3) / 2
    return when {
        halfDistance <= s1 -> halfDistance / v1
        halfDistance <= s1 + s2 -> t1 + (halfDistance - s1) / v2
        halfDistance <= s1 + s2 + s3 -> t1 + t2 + (halfDistance - s1 - s2) / v3
        else -> Double.NaN
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    val rook1Threat = if ((rookX1 == kingX) || (rookY1 == kingY)) 1 else 0
    val rook2Threat = if ((rookX2 == kingX) || (rookY2 == kingY)) 2 else 0
    return rook1Threat + rook2Threat
}


/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    /*
    По определению углового коэффициента имеем, что k = (y-y0)/(x-x0)
    слон на диагонали от короля, если k = 1 или k = -1
    */
    val k = if (bishopX != kingX) (bishopY - kingY) / (bishopX - kingX) else 0
    val rookCanThreat = if (rookX == kingX || rookY == kingY) 1 else 0
    val bishopCanThreat = if (k == 1 || k == -1) 2 else 0
    return rookCanThreat + bishopCanThreat
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ((a < b + c) && (b < a + c) && (c < a + b)) {
        if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a))
            return 1 // прямоугольный - сумма квадратов двух сторон равна квадрату третьей
        else if ((a * a > b * b + c * c) || (b * b > a * a + c * c) || (c * c > b * b + a * a))
            return 2 // тупоугольный (сумма квадратов двух сторон меньше квадрата третьей)
        return 0 // остроугольный
    }
    return -1 // не треугольник - любая сторона должна быть меньше суммы других
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    /*
      пересечения нет:
      левый край cd правее ab (т.е. c > b)
      или
      правый край cd левее ab (т.е. d < a)
    */
    if ((c > b) || (d < a)) return -1 else {
        // пересечение есть:
        // AB левее CD (a <= c)
        if (a <= c) {
            return if (b <= d) b - c else d - c
        } else {
            // CD левее AB
            return if (d <= b) d - a else b - a
        }
    }

}
