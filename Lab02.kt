import Person
import Student
import java.time.LocalTime
fun calcProm(num: List<Int>): Double{
    val sum = num.reduce{acc, n -> acc + n}
    val prom = sum.toDouble()/num.size
    return prom
}
//Funcion PerformOperation compacta
fun performOperation(a: Int, b: Int, op: (Int,Int) -> Int): Int = op(a,b)

fun createStudent(p: Person): Student{
    val percop = p.copy()
    val studentId = LocalTime.now().nano
    val stustr = studentId.toString()
    return Student(percop.name, percop.age, percop.gender, stustr)
}

fun main(){
    //Ejercicio 1 calcular promedio usando reduce
    var seguir = true
    var studentlist = mutableListOf<Student>()
    while(seguir){
    println("\n\t[1]\t\tCalcular promedio\n\t[2]\t\tFiltrar numeros impares\n\t[3]\t\tComprobar si es palindromo\n\t[4]\t\tRecibir un saludo por nombre\n\t[5]\t\tSuma de 2 numeros enteros\n\t[6]\t\tIngrese un estudiante\n\t[7]\t\tTerminar programa") 
    val opcion = readLine()
        if(opcion == "1"){
            println("\n¿Cuantos numeros desea insertar en la lista?")
            val cant = readLine()
            try{
                val cantfor = cant?.toInt() ?: 0
                val numeros = mutableListOf<Int>()
                for(i in 1..cantfor){ 
                println("\tIngrese el numero: ")
                var n =  readLine()?.toInt() ?: 0
                numeros.add(n)
                }
                println("\nEl promedio es: ")
                println(calcProm(numeros))
            }catch(ex: Exception){
                println("Por favor ingrese datos numericos")
            }
        }else if(opcion == "2"){
            try{
                println("\n¿Cuantos numeros desea ingresar en la lista?")
                val cant = readLine()?.toInt() ?:0
                val numin = mutableListOf<Int>()
                for(i in 1..cant){
                    println("\tIngrese el numero: ")
                    var num = readLine()?.toInt() ?: 0
                    numin.add(num)
                }
                val impar = numin.filter{imp -> imp % 2 != 0}
                println("Los numeros impares son: $impar")
            }catch(e: Exception){
                println("Por favor ingrese numeros enteros")
            }
        }else if(opcion == "3"){
            println("\nIngrese la palabra: ")
            val pal = readLine()?.trim() ?: ""
            var contador = 0
            for(i in pal.indices){
                if(pal[i] == pal[(pal.length-1) - i]){
                   contador = contador + 1 
                }
            }
            if(contador == pal.length){
                    println("\nSi es un palindromo")
                }else{
                    println("\nNo es un palindromo")
                }
        }else if(opcion == "4"){
            var cont = true
            val listnombre = mutableListOf<String>()
            while(cont){
                println("\nIngrese un nombre: ")
                val nombre = readLine()?.trim() ?: ""
                listnombre.add(nombre)
                val SalNom = listnombre.map {"¡Hola, $it!"}
                println("\n¿Desea continuar ingresando nombres?[S/n]")
                val c = readLine()
                if(c == "S"){
                    println(SalNom)
                }else{
                    println(SalNom)
                    cont = false
                }
            }
        }else if(opcion == "5"){
            //Debido a que realice el ejercicio como un menú de consola la funcion ira fuera del menú
            //En esta parte solo se ejecuta
            try{
                println("\nIngrese el valor de a: ")
                val x = readLine()?.toInt() ?: 0
                println("\nIngrese el valor de b: ")
                val y = readLine()?.toInt() ?: 0
                val suma: (Int, Int) -> Int = { ax , by -> ax + by }
                println("\nEl resultado de $x + $y es:")
                println(performOperation(x,y,suma))
            }catch(e: Exception){
                println("\n\t***Por favor ingrese numeros enteros***")
            }
        }else if(opcion == "6"){
            println("\nIngrese los datos de la persona\nNombre:  ")
            val name = readLine()
            println("Edad: ")
            val age = readLine()?.toInt() ?: 0
            println("Genero: ")
            val gender = readLine()
            if(name != null && gender != null){
                val person = Person(name,age,gender)
                val student = createStudent(person)
                studentlist.add(student)
                println(studentlist)
            }else{
                println("No es posible si no se ingresa ningún alumno")
            }
            }else if(opcion == "7"){
            seguir = false
        }else{
            println("Opcion no disponible")
        }
    }
}
