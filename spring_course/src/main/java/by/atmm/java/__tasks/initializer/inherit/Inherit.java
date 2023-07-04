package by.atmm.java.__tasks.initializer.inherit;

/**
 * The initialization order is:
 * [1]. Static Fields of Base Class;
 * [2]. Static base class initialization block;
 * [3]. Static fields of the derived class;
 * [4]. Static derivative class initialization block;
 * [5]. Fields (Global variables) of base class;
 * [6]. Non-static block initialization of the base class;
 * [7]. Base class constructor [if the parent does not have a constructor without arguments, the code will result in a compilation error];
 * [8]. Fields (Global variables)  derived class;
 * [9]. Non-static block of derivative class initialization;
 * [10]. Derivative constructor;
 */

class Base {

    //[1] transient переменные и статические поля не сериализуются
    private static Base instance = new Base("))(("); //BASE = 0 //
    public static int _baseStaticInsect = 111; //сокрыто, доступ Base._baseStaticBase
    private static final int DELTA = 2;
    private static int BASE = 3;

    //[2]
    static {
        System.out.println("[static instance class initializer] " + Inherit.class.getSimpleName());
    }

    //[5]
    private int i = 5;
    protected int j; //mod:protected-internal
    int x;
    int internal; //mod:package
    public int iInc;

    //[6]
    {
        System.out.println("[instance class initializer] " + this.getClass().getSimpleName());
    }


    //[7]
    //private недоступен  из вне, нельзя создать без рефлексии
    //если у нет конструктора без аргументов или он приватный, то код приведёт к ошибке компиляции];
    public Base() {
        System.out.println("[constructor] " + this.getClass().getSimpleName());
        x = BASE + DELTA;
    }

    //[7]
    public Base(String data) {
        this();
        System.out.println("[constructor] (String)" + this.getClass().getSimpleName());
        System.out.println(data);

    }

    static int printInit(String s) {
        return -1;
    }
}

public class Inherit extends Base {

    //[3]
    public static int _baseStaticBase = 222;
    public static int _baseStaticInherit = 4;

    //[4]
    static {
        System.out.println("[static class initializer] " + Inherit.class.getSimpleName());
    }

    //[8]
    private int internal;

    public int Integnal() { //getInternal
        return this.internal;
    }

    private boolean internalFlag;

    public boolean isInternalFlag() {
        return internalFlag;
    }

    //[9]
    {
        System.out.println("[instance class initializer] Inherit " + this.getClass().getSimpleName());
    }
}