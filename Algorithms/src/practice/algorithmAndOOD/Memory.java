package practice.algorithmAndOOD;

public class Memory {

    public static void main(String[] args) { // Line 1. stack created for main()
        int i = 1; // Line 2. store in stack
        Object obj = new Object(); // Line 3. object in heap, stack contains reference for it
        Memory mem = new Memory(); // Line 4. same as 3
        mem.foo(obj); // Line 5. a block in the top of stack created for foo()
    } // Line 9. free all the memory

    private void foo(Object param) { // Line 6. new reference to object is created in foo() block
        String str = param.toString(); // Line 7. it goes in String pool in heap, reference created in stack
        System.out.println(str);
    } // Line 8. stack memory for foo() is free
}