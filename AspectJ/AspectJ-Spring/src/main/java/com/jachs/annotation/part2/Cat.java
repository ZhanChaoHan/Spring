package com.jachs.annotation.part2;


/**
 * @author zhanchaohan
 * 
 */
public class Cat extends Animal implements Jump{
    
    private static final String CATNAME="tom";
    public String name="toms";
    private int age;
    public int as=54;
    
    private int aaas=12;
    
    public Cat () {
        super ();
    }
    
    public Cat ( String name ) {
        super ();
        this.name = name;
    }

    private Cat ( String name, int age,boolean ls ) {
        super ();
        this.name = name;
        this.age = age;
    }

    public Cat ( String name, int age ) {
        super ();
        this.name = name;
        this.age = age;
    }

    private void sleep() {
        System.out.println (CATNAME+"睡了"  );
    }
    public void sinp(String name) {
        System.out.println (CATNAME+"sinp\t\t"+name  );
    }
    @Override
    protected void run () {
        System.out.println ( CATNAME+"一只猫在跑" );
    }

    @Override
    public void eatSomeThing () {
        System.out.println ( CATNAME+"一只猫吃了鱼" );
    }

    @Override
    public void jumpSomeWhere () {
        System.out.println ( CATNAME+"一只猫跳树上" );
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public static String getCatname () {
        return CATNAME;
    }
   
}
