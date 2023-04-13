package test;

import symboltable.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<String, String> table = new SymbolTable<>();
        table.add("江苏","南京");
        table.add("浙江","杭州");
        String zj = table.get("浙江");
        System.out.println(zj);
        table.delete("浙江");
        String zj1 = table.get("浙江");
        System.out.println(zj1);
    }
}
