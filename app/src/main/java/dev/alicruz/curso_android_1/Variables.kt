package dev.alicruz.curso_android_1


val name:String = "Ali Cruz";

fun main(){
    print("Hola")

    val age:Int = 35;

    val example:Long = 50;

    val floatExample:Float = 3.1416F;

    println(age + example);

    var stringName:String = "Ali C";
    var pais:String = "México";

    println("Nombre: $stringName Origen: $pais");

    var existeFile:Boolean = false;

    println("Existe =  $existeFile");

    println("Name $name");

    println("Llamar a una funcion");

    miFuncion()
    printEdad(35);

    printEdad(35)

    suma(10, 15);


    returnFunc("hi");



    val diasSemana = arrayOf("Lunes", "Marter");

    println("Dias ${diasSemana.size}");



}

fun miFuncion() {
    println("Hola desde una funcion");
}

fun printEdad(edad:Int) {
    println("Mi edad es $edad");
}


fun suma(num1:Int, num2:Int) {
    println("Suma $num1 + $num2");
}

fun returnFunc(saludo:String):Int {
    var recibido:String = saludo;
    return 1000;
}

