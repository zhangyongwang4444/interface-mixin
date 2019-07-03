package com.github.hcsp.polymorphism;

public class Main {
    interface 会跑 {
        void 跑();
    }

    interface 会游泳 {
        void 游泳();
    }

    abstract static class 能跑 implements 会跑 {
        String name;

        能跑(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void 跑() {
            System.out.println("跑啊跑啊跑");
        }
    }

    static class 猫 extends 能跑 {
        猫() {
            super("小花猫");
        }
    }


    abstract static class 能游泳 implements 会游泳 {
        String name;

        public 能游泳(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void 游泳() {
            System.out.println("游啊游啊游");
        }
    }

    static class 鱼 extends 能游泳 {
        鱼() {
            super("鱼");
        }
    }

    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    static class 乌龟 implements 会跑, 会游泳 {
        @Override
        public void 跑() {
            System.out.println("乌龟跑啊跑啊跑");
        }

        @Override
        public void 游泳() {
            System.out.println("乌龟游啊游啊游");
        }
    }

    public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
