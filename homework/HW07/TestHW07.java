public class TestHW07 {
    public static void main(String[] args) {
        TenXer[] test;

        // // 1 - Cfos
        // System.out.println("\n1. Two Cfos");
        // TenXer gunther = new Cfo("gunther", 120000, 5, 50);
        // TenXer marcel = new Cfo("marcel", 120000, 5, 90);
        // test = new TenXer[]{gunther, marcel};
        // SiliconValley.printSortPrint(test);

        // // 2 - Ceos
        // System.out.println("\n2. Two Ceos");
        // TenXer pheobe = new Ceo("Pheobe", 500000, 12, 3);
        // TenXer joey = new Ceo("Joey", 500000, 8, 3);
        // test = new TenXer[]{pheobe, joey};
        // SiliconValley.printSortPrint(test);

        // // 3 - Software Engineers
        // System.out.println("\n3. Two SoftwareEngineers");
        // TenXer ross = new SoftwareEngineer("Ross", 80000, 10, 15, false);
        // TenXer rachel = new SoftwareEngineer("Rachel", 100000, 7, 15, true);
        // test = new TenXer[]{ross, rachel};
        // SiliconValley.printSortPrint(test);

        // // 4 - Cfo and Ceo
        // System.out.println("\n4. A Cfo and Ceo");
        // TenXer chandler = new Cfo("Chandler", 65000, 12, 50);
        // TenXer monica = new Ceo("Monica", 80000, 16, 2);
        // test = new TenXer[]{chandler, monica};
        // SiliconValley.printSortPrint(test);

        // // 5 - TenXer[]
        // System.out.println("\n5. Array of randomly generated TenXers");
        // test = SiliconValley.createTenXers(8);
        // Sorting.mergeSort(test);
        // for (TenXer t : test) {
        //    System.out.println(t);
        // }

        // 6 - My own array
        System.out.println("\n6. My own array.");
        TenXer chris = new Ceo("Chris", 700000, 10, 1);
        TenXer jake = new Ceo("Jake", 500000, 10, 1);
        TenXer justin = new Ceo("Justin", 700000, 10, 1);
        TenXer trey = new Ceo("Trey", 700000, 8, 1);
        TenXer josh = new Ceo("Josh", 700000, 8, 0);
        test = new TenXer[]{chris, jake, justin, trey, josh};
        SiliconValley.printSortPrint(test);
        System.out.println("Should be: Josh, Jake, Justin, Chris, Trey");

        Integer[] arr = new Integer[]{1, 2, 9, 0, 7, 5, 0, 6, 4, 8};
        Sorting.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}