/**
 * @autor Kunakbaev Artem
 */
public class Main {
    public static void main(String[] args) {

        Sort.bubleSort(new MyArray(100000).getMyArray());
        Sort.selectSort(new MyArray(100000).getMyArray());
        Sort.insertSort(new MyArray(100000).getMyArray());
    }
}

